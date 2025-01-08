package com.example.projet_tp_dam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityUpdate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_update);

        Intent intent = getIntent();

        String moduleId = intent.getStringExtra("moduleId");
        String moduleName = intent.getStringExtra("moduleName");
        String moduleCoef = intent.getStringExtra("moduleCoef");
        EditText editName = findViewById(R.id.moduleUp);
        EditText editCoef = findViewById(R.id.moduleCoefUp);
        editName.setText(moduleName);
        editCoef.setText(moduleCoef);

        Button btn = findViewById(R.id.btnUp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editName.getText().toString().length() == 0)
                    Toast.makeText(MainActivityUpdate.this, "fill the name", Toast.LENGTH_SHORT).show();
                if(editCoef.getText().toString().length() == 0)
                    Toast.makeText(MainActivityUpdate.this, "fill the coefficient", Toast.LENGTH_SHORT).show();
                else{
                    DatabaseHandler db = new DatabaseHandler(MainActivityUpdate.this);
                    db.updateModule(Integer.parseInt(moduleId),editName.getText().toString(),Integer.parseInt(editCoef.getText().toString()));

                    Intent intent = new Intent(getBaseContext() , MainActivity2.class );
                    startActivity(intent);

                }

            }
        });



    }
}