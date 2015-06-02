package com.herokuapp.ezhao.medications;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends Activity {
    private List<Medication> medications;
    @InjectView(R.id.vpFragments) public ViewPager vpFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);
        FragmentManager fm = getFragmentManager();

        // Get all the medications
        Medication aspirin = new Medication("Aspirin", "81 mg", "1 daily", "severe stomach pain, bloody vomit, vomit that looks like coffee grounds, blood in urine, blood in stool, skin rash, hives, intense itching, swelling of the face, swollen face, swollen eyelids, ringing in ears, severe dizziness, drowsiness, wheezing, upset stomach, heartburn", "diabetes");
        Medication insulin = new Medication("Insulin glargine", "28 u", "daily", "itching, hives, swelling of face, swollen face, swelling of hands, swollen hands, swelling of mouth, swollen mouth, swelling of throat, swollen throat, tingling of mouth, tingling of throat, chest tightness, trouble breathing, anxiety, confusion, restlessness, mood change, mental change, blurred vision, change in vision, fast heartbeat, pounding heartbeat, irregular heartbeat, increased sweating, problems with walking, slurred speech, tingling in your hands, tingling in your feet, tingling in your lips, tingling your tongue, tremors, nightmares, trouble sleeping, redness of skin at injectiong point, pain of skin at injectiong point, itching of skin at injectiong point, burning of skin at injectiong point, swelling of skin at injectiong point, lump under skin at injectiong point, rash", "diabetes");
        Medication losartan = new Medication("Losartan", "100 mg", "1 daily", "itching, hives, swelling of face, swollen face, swelling of hands, swollen hands, swelling of mouth, swollen mouth, swelling of throat, swollen throat, tingling of mouth, tingling of throat, chest tightness, trouble breathing, change in how often you urinate, chest pain, confusion, body wekness, shortness of breath, numbness in hands, numbness in feet, numbness in lips, tingling in hands, tingling in feet, tingling in lips, fast heartbeat, slow heartbeat, uneven heartbeat, rapid weight gain, swelling in ankles, swelling in feet, diarrhea, dry cough, stuffy nose, runny nose, sore throat", "hypertension");
        medications = new ArrayList<>();
        medications.add(aspirin);
        medications.add(insulin);
        medications.add(losartan);

        // Set adapter
        MedicationPagerAdapter medicationPagerAdapter = new MedicationPagerAdapter(fm, medications);
        vpFragments.setAdapter(medicationPagerAdapter);
        vpFragments.setClipToPadding(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
