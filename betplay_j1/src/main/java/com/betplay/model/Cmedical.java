package com.betplay.model;

import java.util.ArrayList;
import java.util.Scanner;

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

    public static void registrarMedicos(Scanner sc, ArrayList<Equipo> equipos, ArrayList<Cmedical> cmedics){
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

        System.out.println("\n Ingrese el nombre del Fisioterapeuta: \n-----------------------------------");
        String physiotherapistName = sc.nextLine();
        System.out.println("\n Ingrese el nombre del Medico: \n-----------------------------------");
        String doctorName = sc.nextLine();

        Cmedical myMedics = new Cmedical (teamIndex.getName(), physiotherapistName, doctorName);
        cmedics.add(myMedics);

    }

    
}
