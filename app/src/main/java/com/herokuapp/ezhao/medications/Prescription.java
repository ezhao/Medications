package com.herokuapp.ezhao.medications;

import java.util.Date;

public class Prescription {
    private Medication medication;
    private Date start;
    private Date end;

    public Prescription(Medication medication, Date start, Date end) {
        this.medication = medication;
        this.start = start;
        this.end = end;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
