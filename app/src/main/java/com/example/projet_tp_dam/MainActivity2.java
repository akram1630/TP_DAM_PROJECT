package com.example.projet_tp_dam;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

         EditText moduleName = findViewById(R.id.moduleName);
         EditText moduleCoef = findViewById(R.id.moduleCoefficient);
        CheckBox tdCheck = findViewById(R.id.tdChek);
        CheckBox tpCheck = findViewById(R.id.tpChek);
        Button addButtom = findViewById(R.id.addButton);
        EditText poidsExam = findViewById(R.id.modulePoidsExam);
        EditText poidsTrav = findViewById(R.id.modulePoidsTraveaux);


        DatabaseHandler db = new DatabaseHandler(this);
        Log.d("Insert: ", "Inserting ..");
        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Module> modules = db.getAllModule();

        addButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(moduleName.getText().toString().length() == 0)
                    Toast.makeText(MainActivity2.this, "fill the name", Toast.LENGTH_SHORT).show();
                if(moduleCoef.getText().toString().length() == 0)
                    Toast.makeText(MainActivity2.this, "fill the coefficient", Toast.LENGTH_SHORT).show();
                if(poidsExam.getText().toString().length() == 0)
                    Toast.makeText(MainActivity2.this, "fill poids Exam", Toast.LENGTH_SHORT).show();
                if(poidsTrav.getText().toString().length() == 0)
                    Toast.makeText(MainActivity2.this, "fill poids Travaux", Toast.LENGTH_SHORT).show();
                else{
                    db.addModule(
                            new Module(
                                    moduleName.getText().toString(),
                                    Integer.parseInt(moduleCoef.getText().toString()),
                                    Integer.parseInt(poidsExam.getText().toString()),
                                    Integer.parseInt(poidsTrav.getText().toString())
                            ));
                    Intent intent = new Intent(getBaseContext() , MainActivity2.class );
                    startActivity(intent);

                }

            }
        });

        tdCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tdCheck.isChecked() || tpCheck.isChecked()){
                    poidsExam.setText("");
                    poidsTrav.setText("");
                }
                else{
                    poidsExam.setText("100");
                    poidsTrav.setText("0");
                }
            }
        });

        tpCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tdCheck.isChecked() || tpCheck.isChecked()){
                    poidsExam.setText("");
                    poidsTrav.setText("");
                }
                else{
                    poidsExam.setText("100");
                    poidsTrav.setText("0");
                }
            }
        });


        Button  btn = findViewById(R.id.goButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext() , MainActivity.class );
                startActivity(intent);
            }
        });




        ListView listView = findViewById(R.id.listCrud);

        //create data
        ArrayList<Module> arrayList = new ArrayList<>();
        //type image in drawable is int
        for(Module m : modules)
            arrayList.add(m);



        //making custom adapter design pattren
        CrudAdapter personAdapter = new CrudAdapter(this,R.layout.module_crud,arrayList);

        listView.setAdapter(personAdapter);

    }
}