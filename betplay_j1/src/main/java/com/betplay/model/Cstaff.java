package com.betplay.model;

import java.util.ArrayList;
import java.util.Scanner;

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

    public static void registrarStaff(Scanner sc, ArrayList<Equipo> equipos, ArrayList<Cstaff> cstaffs){
        if (equipos.isEmpty()){
            System.out.println("No hay equipos registrados");
            sc.nextLine();
            return;
        }
        for (int i = 0; i < equipos.size(); i++ ){
            System.out.println((i+1)+ ". "+ equipos.get(i).getName());
        }
        int teamSearch = Integer.parseInt(sc.nextLine());
        Equipo teamIndex = equipos.get(teamSearch -1);

        System.out.println("\n Ingrese el nombre del Director tecnico: \n-----------------------------------");
        String coachName = sc.nextLine();
        System.out.println("\n Ingrese el nombre del Asistente Tecnico: \n-----------------------------------");
        String assistantName = sc.nextLine();
        System.out.println("\n Ingrese el nombre del Preparador fisico: \n-----------------------------------");
        String trainerName = sc.nextLine();

        Cstaff myStaff = new Cstaff (teamIndex.getName(), coachName, assistantName, trainerName);
        cstaffs.add(myStaff);

    }

}
