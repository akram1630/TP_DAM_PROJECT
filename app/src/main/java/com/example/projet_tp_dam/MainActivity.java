package com.example.projet_tp_dam;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
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
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private ListView listView;
    private TextView totalSumTextView;
    private ArrayList<Module> rowDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DatabaseHandler db = new DatabaseHandler(this);
        Log.d("Insert: ", "Inserting ..");
        db.addModule(new Module("AKRAAAAAAAAM",4,40,60));
        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Module> modules = db.getAllModule();
        //int s= db.getContactsCount();
        //Log.d("Number", String.valueOf(s));
        /*ListView list = (ListView)findViewById(R.id.maliste);
        ArrayAdapter<String> tableau = new ArrayAdapter<String>(
                this, R.layout.montexte);
        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
                    cn.getPhoneNumber();
            // Writing Contacts to log
            tableau.add(log);
            Log.d("Name: ", log);
        }
        list.setAdapter(tableau);
        */
        listView = findViewById(R.id.listView);
        totalSumTextView = findViewById(R.id.semester);

        // Initialize data for 4 rows
        rowDataList = new ArrayList<>();
        //for (int i = 0; i < 4; i++) {
            rowDataList.add(modules.get(0)) ;
            rowDataList.add(new Module("algo",4,40,60));
            rowDataList.add(new Module("algebre",4,40,60));
            rowDataList.add(new Module("analyse",4,40,60));
        //}
        int sumCoefficient=0    ;
        for(Module m : rowDataList)
            sumCoefficient += m.getCoefficient();
        // Set up adapter with total sum listener
        int finalSumCoefficient = sumCoefficient;
        ModuleAdapter adapter = new ModuleAdapter(this, rowDataList, totalSum   -> {
            totalSumTextView.setText("Total Sum: " + totalSum/ finalSumCoefficient+"----"+finalSumCoefficient);
        });

        Button  btn = findViewById(R.id.goCrud);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext() , MainActivity2.class );
                startActivity(intent);
            }
        });












        // Declare a variable to store the totalCoef
        // Use a mutable container to store the latest totalCoef

// Set the adapter for the listView
        listView.setAdapter(adapter);



        /*
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
        EditText editTextTd = findViewById(R.id.noteTd);

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