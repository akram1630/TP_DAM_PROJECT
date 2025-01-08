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
       // db.addModule(new Module("AKRAAAAAAAAM",4,40,60));
        Log.d("Reading: ", "Reading all contacts..");
        List<Module> modules = db.getAllModule();

        listView = findViewById(R.id.listView);
        totalSumTextView = findViewById(R.id.semester);

        rowDataList = new ArrayList<>();
        for(Module m : modules)
            rowDataList.add(m);

        int sumCoefficient=0    ;
        for(Module m : rowDataList)
            sumCoefficient += m.getCoefficient();

        int finalSumCoefficient = sumCoefficient;
        ModuleAdapter adapter = new ModuleAdapter(this, rowDataList, totalSum   -> {
            totalSumTextView.setText("Total Sum: " + String.format("%.2f",totalSum/ finalSumCoefficient) );
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





    }
}