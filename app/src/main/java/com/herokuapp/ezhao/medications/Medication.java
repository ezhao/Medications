package com.herokuapp.ezhao.medications;

import java.io.Serializable;

public class Medication implements Serializable {
    public String name;
    public String dosage;
    public String instructions;
    public String sideEffects;
    public String condition;

    public Medication(String name, String dosage, String instructions, String sideEffects, String condition) {
        this.name = name;
        this.dosage = dosage;
        this.instructions = instructions;
        this.sideEffects = sideEffects;
        this.condition = condition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
