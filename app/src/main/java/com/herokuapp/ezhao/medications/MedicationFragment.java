package com.herokuapp.ezhao.medications;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MedicationFragment extends Fragment {
    private Medication medication;
    @InjectView(R.id.tvMedicationName) public TextView tvMedicationName;
    @InjectView(R.id.tvDosage) public TextView tvDosage;
    @InjectView(R.id.tvInstructions) public TextView tvInstructions;
    @InjectView(R.id.tvSideEffects) public TextView tvSideEffects;

    public static MedicationFragment newInstance(Medication medication) {
        MedicationFragment medicationFragment = new MedicationFragment();
        Bundle args = new Bundle();
        args.putSerializable("medication", medication);
        medicationFragment.setArguments(args);
        return medicationFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        medication = (Medication) getArguments().getSerializable("medication");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medication, container, false);
        ButterKnife.inject(this, view);

        if (medication != null) {
            tvMedicationName.setText(medication.getName());
            tvDosage.setText(medication.getDosage());
            tvInstructions.setText(medication.getInstructions());
            tvSideEffects.setText(medication.getSideEffects());
        }

        return view;
    }
}
