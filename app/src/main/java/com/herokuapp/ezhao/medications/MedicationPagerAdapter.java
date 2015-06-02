package com.herokuapp.ezhao.medications;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;

import java.util.List;

public class MedicationPagerAdapter extends FragmentStatePagerAdapter {
    private List<Medication> medications;

    public MedicationPagerAdapter(FragmentManager fm, List<Medication> medications) {
        super(fm);
        this.medications = medications;
    }

    @Override
    public Fragment getItem(int position) {
        Medication medication = medications.get(position);
        return MedicationFragment.newInstance(medication);
    }

    @Override
    public int getCount() {
        return medications.size();
    }

    @Override
    public float getPageWidth(int position) {
        return 0.93f;
    }
}
