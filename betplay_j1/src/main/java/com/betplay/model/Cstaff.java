package com.betplay.model;

public class Cstaff extends Equipo {
    private String coach;
    private String coachAssistant;
    private String physicalTrainer;

    public Cstaff() {
    }

    public Cstaff(String coach, String coachAssistant, String physicalTrainer, String name) {
        super(name);
        this.coach = coach;
        this.coachAssistant = coachAssistant;
        this.physicalTrainer = physicalTrainer;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getCoachAssistant() {
        return coachAssistant;
    }

    public void setCoachAssistant(String coachAssistant) {
        this.coachAssistant = coachAssistant;
    }

    public String getPhysicalTrainer() {
        return physicalTrainer;
    }

    public void setPhysicalTrainer(String physicalTrainer) {
        this.physicalTrainer = physicalTrainer;
    }

}
