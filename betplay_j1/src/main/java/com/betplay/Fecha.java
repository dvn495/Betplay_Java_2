package com.betplay;

public class Fecha {
    String equipo_local;
    String equipo_visitante;
    int marcador_equipo1 = 0;
    int marcador_equipo2 = 0;

    public Fecha() {
        
    }

    public Fecha(String equipo_local, String equipo_visitante, int marcador_equipo1, int marcador_equipo2) {
        this.equipo_local = equipo_local;
        this.equipo_visitante = equipo_visitante;
        this.marcador_equipo1 = marcador_equipo1;
        this.marcador_equipo2 = marcador_equipo2;
    }

    public String getEquipo_local() {
        return equipo_local;
    }

    public void setEquipo_local(String equipo_local) {
        this.equipo_local = equipo_local;
    }

    public String getEquipo_visitante() {
        return equipo_visitante;
    }

    public void setEquipo_visitante(String equipo_visitante) {
        this.equipo_visitante = equipo_visitante;
    }
    
    public int getMarcador_equipo1() {
        return marcador_equipo1;
    }

    public void setMarcador_equipo1(int marcador_equipo1) {
        this.marcador_equipo1 = marcador_equipo1;
    }

    public int getMarcador_equipo2() {
        return marcador_equipo2;
    }
    
    public void setMarcador_equipo2(int marcador_equipo2) {
        this.marcador_equipo2 = marcador_equipo2;
    }

    
}
