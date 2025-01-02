package com.example.projet_tp_dam;

import android.os.Bundle;
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

public class MainActivity2 extends AppCompatActivity {


/*
        EditText moduleName = findViewById(R.id.moduleName);
        CheckBox tdCheck = findViewById(R.id.tdChek);
        CheckBox tpCheck = findViewById(R.id.tpChek);
        Button addButtom = findViewById(R.id.addButton);
        TextView textView = findViewById(R.id.tdText);
        EditText poidsExam = findViewById(R.id.modulePoidsExam);
        EditText poidsTrav = findViewById(R.id.modulePoidsTraveaux);
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        ListView listView = findViewById(R.id.listCrud);

        //create data
        ArrayList<Module> arrayList = new ArrayList<>();
        //type image in drawable is int
        arrayList.add(new Module( "benrahma" , 1,5,5));
        arrayList.add(new Module( "benrahma" , 1,5,5));
        arrayList.add(new Module( "benrahma" , 1,5,5));


        //making custom adapter design pattren
        CrudAdapter personAdapter = new CrudAdapter(this,R.layout.module_crud,arrayList);

        listView.setAdapter(personAdapter);

    }
}