package com.herokuapp.ezhao.medications;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MedicationListFragment extends Fragment {
    private List<Medication> medications;
    MedicationArrayAdapter medicationArrayAdapter;
    @InjectView(R.id.lvMedications) public ListView lvMedications;

    public static MedicationListFragment newInstance() {
        return new MedicationListFragment();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medication_list, container, false);
        ButterKnife.inject(this, view);
        if (medications != null) {
            createList();
        }
        final MainActivity mainActivity = (MainActivity) getActivity();
        lvMedications.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mainActivity.launchMedicationCard(medicationArrayAdapter.getItem(position));
            }
        });
        return view;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
        if (getActivity() != null) {
            createList();
        }

    }

    public void createList() {
        medicationArrayAdapter = new MedicationArrayAdapter(getActivity(), medications);
        lvMedications.setAdapter(medicationArrayAdapter);
    }
}
