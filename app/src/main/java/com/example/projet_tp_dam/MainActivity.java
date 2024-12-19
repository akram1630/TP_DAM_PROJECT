package com.example.projet_tp_dam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        EditText moduleName = findViewById(R.id.moduleName);
        CheckBox tdCheck = findViewById(R.id.tdChek);
        CheckBox tpCheck = findViewById(R.id.tpChek);
        Button addButtom = findViewById(R.id.addButton);
        TextView textView = findViewById(R.id.tdText);
        EditText poidsExam = findViewById(R.id.modulePoidsExam);
        EditText poidsTrav = findViewById(R.id.modulePoidsTraveaux);
*/
        ListView listView = findViewById(R.id.listView);

        //create data
        ArrayList<Module> arrayList = new ArrayList<>();
        //type image in drawable is int
        arrayList.add(new Module( "benrahma" , 10.0,20.0));
        arrayList.add(new Module("mahrez" ,  10.0,20.0));
        arrayList.add(new Module( "benrahma" , 10.0,20.0));
        arrayList.add(new Module("mahrez" ,  10.0,20.0));
        arrayList.add(new Module( "benrahma" , 10.0,20.0));
        arrayList.add(new Module("mahrez" ,  10.0,20.0));
        arrayList.add(new Module( "benrahma" , 10.0,20.0));
        arrayList.add(new Module("mahrez" ,  10.0,20.0));
        arrayList.add(new Module( "benrahma" , 10.0,20.0));
        arrayList.add(new Module("mahrez" ,  10.0,20.0));
        arrayList.add(new Module( "benrahma" , 10.0,20.0));
        arrayList.add(new Module("mahrez" ,  10.0,20.0));
        arrayList.add(new Module(  "bounedja7" ,  10.0,20.0));

        //making custom adapter design pattren
        ModuleAdapter moduleAdapter = new ModuleAdapter(this,R.layout.row_module,arrayList);

        listView.setAdapter(moduleAdapter);
/*
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
*/

    }
}