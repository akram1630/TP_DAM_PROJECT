package com.example.projet_tp_dam;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Locale;
                                   //for realTime
public class ModuleAdapter extends BaseAdapter {

    private Context mContext;
    //private int mResource;
    private ArrayList<Module> rowDataList;
    private TotalSumListener listener; // Listener for total sum updates




    public ModuleAdapter(Context context, ArrayList<Module> rowDataList, TotalSumListener listener ) {
        this.mContext = context;
        this.rowDataList = rowDataList;
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return rowDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return rowDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {

            convertView = LayoutInflater.from(mContext).inflate(R.layout.row_module, parent, false);
            holder = new ViewHolder();
            holder.editTextTd = convertView.findViewById(R.id.noteTd);
            holder.editTextTp= convertView.findViewById(R.id.noteTp);
            holder.editTextControl = convertView.findViewById(R.id.noteControl);
            holder.sumTextView = convertView.findViewById(R.id.moduleTotal);
            holder.nameModule = convertView.findViewById(R.id.moduleNameCalc);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Module module = rowDataList.get(position);




        holder.nameModule.setText(module.getName());
        holder.editTextTd.setText(String.valueOf(module.getNoteTd()));
        holder.editTextTp.setText(String.valueOf(module.getNoteTp()));
        holder.editTextControl.setText(String.valueOf(module.getNoteControl()));
        holder.sumTextView.setText("Sum: " + (module.getNoteTd() + module.getNoteTp()+ module.getNoteControl())  );


        holder.editTextTd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {

                    double value = Double.parseDouble(s.toString()) *0.2;

                    module.setNoteTd(value);
                } catch (NumberFormatException e) {
                    module.setNoteTd(0);
                }
                updateSum(holder, module);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });


        holder.editTextTp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    double value = Double.parseDouble(s.toString())*0.2;
                    module.setNoteTp(value);
                } catch (NumberFormatException e) {
                    module.setNoteTp(0);
                }
                updateSum(holder, module);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        holder.editTextControl.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    double value = Double.parseDouble(s.toString())*0.6;
                    module.setNoteControl(value);
                } catch (NumberFormatException e) {
                    module.setNoteControl(0);
                }
                updateSum(holder, module);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });



        return convertView;
    }

////////////////////////////////////////////////////////////////////////////

    public interface TotalSumListener {
        void onTotalSumUpdated(double totalSum);
    }
    private double calculateTotalSum() {
        double totalSum = 0;
        for (Module module : rowDataList) {
            totalSum +=( module.getNoteTd() + module.getNoteTp() + module.getNoteControl()) * module.getCoefficient();
        }
        //return totalSum/4;
        return totalSum ;
    }

    private void updateSum(ViewHolder holder, Module module) {
        double ModuleSum = module.getNoteTd() + module.getNoteTp() + module.getNoteControl();
        holder.sumTextView.setText("Sum: " + String.format("%.2f",ModuleSum));
        listener.onTotalSumUpdated(calculateTotalSum());
    }

    private static class ViewHolder {
        EditText editTextTd, editTextTp, editTextControl;
        TextView nameModule , sumTextView;
    }
//////////////////////////////////////////////////////////



}


































