package com.betplay.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Equipo{
    private String playerName;
    private int dorsal;
    private String position;
    private String nacionality;
    private String dateEntry;
    private int goals;
    private int redCards;
    private int yellowCards;

    public Player() {

    }

    public Player(String name, String playerName, int dorsal, String position, String nacionality, String dateEntry,
            int goals, int redCards, int yellowCards) {
        super(name);
        this.playerName = playerName;
        this.dorsal = dorsal;
        this.position = position;
        this.nacionality = nacionality;
        this.dateEntry = dateEntry;
        this.goals = goals;
        this.redCards = redCards;
        this.yellowCards = yellowCards;
    }

    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public int getDorsal() {
        return dorsal;
    }
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getNacionality() {
        return nacionality;
    }
    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }
    public String getDateEntry() {
        return dateEntry;
    }
    public void setDateEntry(String dateEntry) {
        this.dateEntry = dateEntry;
    }
    public int getGoals() {
        return goals;
    }
    public void setGoals(int goals) {
        this.goals = goals;
    }
    public int getRedCards() {
        return redCards;
    }
    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }
    public int getYellowCards() {
        return yellowCards;
    }
    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public static void registrarJugador(Scanner sc, ArrayList<Equipo> equipos, ArrayList<Player> players){
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

        System.out.println("\n Ingrese el Nombre del Jugador: \n-----------------------------------");
        String playerName = sc.nextLine();
        System.out.println("\n Ingrese el dorsal del jugador: \n-----------------------------------");
        int playerDorsal = Integer.parseInt(sc.nextLine());
        System.out.println("\n Ingrese la posición del jugador: \n-----------------------------------");
        String playerPosition = sc.nextLine();
        System.out.println("\n Ingrese la nacionalidad del jugador: \n-----------------------------------");
        String playerNacionality = sc.nextLine();
        System.out.println("\n Ingrese la fecha de entrada del jugador: \n-----------------------------------");
        String playerDateEntry = sc.nextLine();
        int playerGoals = 0;
        if (teamIndex.getGoles_favor() == 0){
            System.out.println("Este equipo no tiene goles registrados\n \n Presione cualquier tecla para continuar...\n-----------------------------------");
            sc.nextLine();
        } else {
            boolean isActive = true;
            while (isActive) {
                System.out.println("\n Ingrese los goles anotados por el jugador: \n \nLimite de goles del equipo: " + teamIndex.getGoles_favor());
                playerGoals = Integer.parseInt(sc.nextLine());
                if (playerGoals > teamIndex.getGoles_favor() ){
                    System.out.println("El limite de goles del equipo es: " + teamIndex.getGoles_favor());
                    System.out.println("\n Presione cualquier tecla para continuar...\n-----------------------------------");
                    sc.nextLine();
                } else  {
                    isActive = false;
                }
            }
            
        }
        
        System.out.println("\n Ingrese las cartas rojas del jugador: \n-----------------------------------");
        int playerRedCards = Integer.parseInt(sc.nextLine());
        System.out.println("\n .Ingrese las cartas amarillas del jugador: \n-----------------------------------");
        int playerYellowCards = Integer.parseInt(sc.nextLine());

        Player myPlayer = new Player(teamIndex.getName(), playerName, playerDorsal, playerPosition, playerNacionality, playerDateEntry, playerGoals, playerRedCards, playerYellowCards);
        players.add(myPlayer);

    }
}
