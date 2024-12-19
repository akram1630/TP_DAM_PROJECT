package com.example.projet_tp_dam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ModuleAdapter extends ArrayAdapter<Module> {

    private Context mContext;
    private int mResource;



    public ModuleAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Module> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource , parent , false);

        EditText editTextTd = convertView.findViewById(R.id.noteTd);
        EditText editTextTp = convertView.findViewById(R.id.noteTp);
        EditText editTextControl = convertView.findViewById(R.id.noteControl);
        TextView textViewName = convertView.findViewById(R.id.moduleNameCalc);
        TextView textViewTotal= convertView.findViewById(R.id.moduleTotal);


        String TD = String.valueOf(getItem(position).getNoteTd());
        editTextTd.setText(TD);

        String Tp = String.valueOf(getItem(position).getNoteTp());
        editTextTp.setText(Tp);

        String Control = String.valueOf(getItem(position).getNoteControl());
        editTextControl.setText(Control);

        String moyenne = String.valueOf(getItem(position).getMoyenne());
        textViewTotal.setText(moyenne);

        textViewName.setText(getItem(position).getName());


        return convertView;
    }
}
