package com.betplay.model;

public class Equipo {
    private String name;
    private int partidos_jugados;
    private int partidos_ganados;
    private int partidos_perdidos;
    private int partidos_empatados;
    private int goles_favor;
    private int goles_contra;
    private int total_puntos;

    public Equipo() {
        
    }

    public Equipo(String name) {
        this.name = name;
    }

    public Equipo(int partidos_jugados, int partidos_ganados, int partidos_perdidos,int partidos_empatados, int goles_favor, int goles_contra, int total_puntos) {
        this.partidos_jugados = partidos_jugados;
        this.partidos_ganados = partidos_ganados;
        this.partidos_perdidos = partidos_perdidos;
        this.partidos_empatados = partidos_empatados;
        this.goles_favor = goles_favor;
        this.goles_contra = goles_contra;
        this.total_puntos = total_puntos;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getPartidos_jugados() {
        return partidos_jugados;
    }

    public void setPartidos_jugados(int partidos_jugados) {
        this.partidos_jugados = partidos_jugados;
    }

    public int getPartidos_ganados() {
        return partidos_ganados;
    }

    public void setPartidos_ganados(int partidos_ganados) {
        this.partidos_ganados = partidos_ganados;
    }

    public int getPartidos_perdidos() {
        return partidos_perdidos;
    }

    public void setPartidos_perdidos(int partidos_perdidos) {
        this.partidos_perdidos = partidos_perdidos;
    }

    public int getPartidos_empatados() {
        return partidos_empatados;
    }

    public void setPartidos_empatados(int partidos_empatados) {
        this.partidos_empatados = partidos_empatados;
    }

    public int getGoles_favor() {
        return goles_favor;
    }

    public void setGoles_favor(int goles_favor) {
        this.goles_favor = goles_favor;
    }

    public int getGoles_contra() {
        return goles_contra;
    }

    public void setGoles_contra(int goles_contra) {
        this.goles_contra = goles_contra;
    }

    public int getTotal_puntos() {
        return total_puntos;
    }

    public void setTotal_puntos(int total_puntos) {
        this.total_puntos = total_puntos;
    }
        
}
