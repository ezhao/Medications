package com.herokuapp.ezhao.medications;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MedicationArrayAdapter extends ArrayAdapter<Medication>{
    public MedicationArrayAdapter(Context context, List<Medication> medications) {
        super(context, 0, medications);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Medication medication = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_medication, parent, false);
        }

        TextView tvMedicationName = (TextView) convertView.findViewById(R.id.tvMedicationName);
        TextView tvCondition = (TextView) convertView.findViewById(R.id.tvCondition);
        TextView tvDosage = (TextView) convertView.findViewById(R.id.tvDosage);
        TextView tvInstructions = (TextView) convertView.findViewById(R.id.tvInstructions);

        tvMedicationName.setText(medication.getName());
        tvCondition.setText(medication.getCondition());
        tvDosage.setText(medication.getDosage());
        tvInstructions.setText(medication.getInstructions());

        return convertView;
    }
}
