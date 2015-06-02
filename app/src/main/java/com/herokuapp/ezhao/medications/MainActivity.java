package com.herokuapp.ezhao.medications;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends Activity {
    private List<Medication> medications;

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
        Medication albuterol = new Medication("Albuterol HFA", "2 puffs", "q4h prn", "itching, hives, swelling of face, swelling of hands, swelling of mouth, swelling of throat, tingling of mouth, tingling of throat, chest tightness, trouble breathing, chest pain, shortness of breath, dry mouth, increased thirst, muscle cramps, nausea, vomiting shakiness, trembling, tremors, fast pulse, racing heartbeat, fast heartbeat, pounding heartbeat, uneven heartbeat, cough, hives, swelling, rash, redness of the skin, lightheadedness, fainting, seizuresm skin rash, trouble sleeping", "asthma");
        Medication beclomethasone = new Medication("Beclomethasone", "2 puffs", "1 bid", "dry throat, dry mouth, irritated throat, cough, difficult speech, painful speech, skin rash, increased trouble breathing, white spots in mouth, sores in mouth, swelling in face, swollen face, swollen lower legs, swelling in lower legs, swollen ankles, swelling in ankles, vision problems, persistent cold, infection, muscle weakness", "asthma");
        Medication citalopram = new Medication("Citalopram", "20 mg", "1 daily", "itching, hives, swelling of face, swollen face, swelling of hands, swollen hands, swelling of mouth, swollen mouth, swelling of throat, swollen throat, tingling of mouth, tingling of throat, chest tightness, trouble breathing, aggression, anxiety, anger, hostility, chest pain, fast heartbeat, pounding heartbeat, uneven heartbeat, headache, trouble concentrating, memory problems, weakness, unsteadiness, lightheadedness, dizziness, fainting, trouble sleeping, increased energy, racing thoughts, severe confusion, sweating, nausea, vomiting, diarrhea, unusual behaviour, thoughts of hurting yourself or others, bleeding, bruising, dry mouth, problems with sex, sleepiness, drowsiness, loss of appetite, weight loss", "depression");
        Medication gabapentin = new Medication("Gabapentin", "600 mg", "1 bid", "itching, hives, swelling of face, swollen face, swelling of hands, swollen hands, swelling of mouth, swollen mouth, swelling of throat, swollen throat, tingling of mouth, tingling of throat, chest tightness, trouble breathing, behaviour problems, hostility, restlessness, trouble concentrating, moodiness, blistered skin, pelling skin, red skin rash, blood in urine, back pain, side pain, climsiness, problems with coordination, shakiness, tremors, depression, thoughts of hurting yourself, extreme tiredness, fatigue, fever, cough, exhaustion, sneezing, sore throat, stuffy nose, body aches, rapid weight gain, swelling in ankles, swelling in feet, swollen lymph glands, tender lymph glands, uncontrolled eye movements, bleeding, bruising, yellow skin, yellow eyes, dizziness, headache, sleepiness, drowsiness, weakness", "neuropathic pain");
        medications = new ArrayList<>();
        medications.add(aspirin);
        medications.add(insulin);
        medications.add(losartan);
        medications.add(albuterol);
        medications.add(beclomethasone);
        medications.add(citalopram);
        medications.add(gabapentin);

        // Set adapter (listview)
        MedicationListFragment medicationListFragment = MedicationListFragment.newInstance();
        fm.beginTransaction().replace(R.id.flFragment, medicationListFragment).commit();
        medicationListFragment.setMedications(medications);
    }

    public void launchMedicationCard(Medication medication) {
        MedicationFragment medicationFragment = MedicationFragment.newInstance(medication);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.flFragment, medicationFragment);
        ft.addToBackStack("medication_card");
        ft.commit();
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
