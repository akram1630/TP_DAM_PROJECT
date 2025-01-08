package com.example.projet_tp_dam;


import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CrudAdapter extends ArrayAdapter<Module> {

    private Context mContext;
    private int mResource;



    public CrudAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Module> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource , parent , false);


        TextView txtName = convertView.findViewById(R.id.txtName);

        TextView txtDes = convertView.findViewById(R.id.coefId);

        Button btnDelete = convertView.findViewById(R.id.deleteId);
        Button btnUpdate = convertView.findViewById(R.id.updateId);


        txtName.setText(""+getItem(position).getName());

        txtDes.setText(""+getItem(position).getCoefficient());

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Module m = getItem(position);
                DatabaseHandler db = new DatabaseHandler(mContext);
                db.deleteModule(m.getId());
                // Remove the item from the list and update the adapter
                remove(m);
                notifyDataSetChanged();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MainActivityUpdate.class);
                Module m = getItem(position);

                intent.putExtra("moduleId", String.valueOf( m.getId() ));
                intent.putExtra("moduleName", String.valueOf( m.getName() ));
                intent.putExtra("moduleCoef", String.valueOf( m.getCoefficient() ));

                if (!(mContext instanceof android.app.Activity)) {
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                }

                mContext.startActivity(intent);
            }
        });

        return convertView;
    }
}
