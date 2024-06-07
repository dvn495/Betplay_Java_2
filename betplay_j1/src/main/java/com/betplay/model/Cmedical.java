package com.betplay.model;

public class Cmedical extends Equipo{
    private String physiotherapist;
    private String doctor;

    public Cmedical() {
    }

    public Cmedical(String name, String physiotherapist, String doctor) {
        super(name);
        this.physiotherapist = physiotherapist;
        this.doctor = doctor;
    }

    public String getPhysiotherapist() {
        return physiotherapist;
    }

    public void setPhysiotherapist(String physiotherapist) {
        this.physiotherapist = physiotherapist;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    
}
