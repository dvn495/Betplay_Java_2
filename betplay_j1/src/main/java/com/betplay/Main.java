
package com.betplay;


import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.betplay.model.Equipo;
import com.betplay.model.Player;
import com.betplay.model.Cstaff;
import com.betplay.model.Cmedical;

public class Main {

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Error al limpiar la pantalla: " + e.getMessage());
        }
    } 

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Equipo> equipos = new ArrayList<Equipo>();
        ArrayList<Fecha> fechas = new ArrayList<Fecha>();
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Cstaff> cstaffs = new ArrayList<Cstaff>();
        ArrayList<Cmedical> cmedics = new ArrayList<Cmedical>();

        boolean isActive = true;

        while (isActive) {

            clearScreen();

            System.out.println("---LIGA BETPLAY---");
            System.out.println("\n 1. REGISTRAR UN EQUIPO\n\n 2. REGISTRAR UNA FECHA\n\n 3. REPORTES DE EQUIPOS\n\n 4. REGISTRAR JUGADOR\n\n 5. REGISTRAR CUERPO TECNICO\n\n 6. REGISTRAR CUERPO MEDICO\n\n 7. DETENER LA EJECUCION\n");


            try {

                int election = (Integer.parseInt(sc.nextLine()));


                switch (election) {

                    case 1 ->{

                        boolean isActiveTeams = true;
            
                        while (isActiveTeams) {
        
                            clearScreen();
        
                            Equipo myEquipo = new Equipo();
        
                            System.out.println("MENU REGISTRO EQUIPO\n  NOMBRE DEL EQUIPO: ");
                            myEquipo.setName(sc.nextLine());
                            myEquipo.setPartidos_jugados(0);
                            myEquipo.setPartidos_ganados(0);
                            myEquipo.setPartidos_perdidos(0);
                            myEquipo.setPartidos_empatados(0);
                            myEquipo.setGoles_favor(0);
                            myEquipo.setGoles_contra(0);
                            myEquipo.setTotal_puntos(0);
                            equipos.add(myEquipo);
                            System.out.println("\nEQUIPO REGISTRADO EXITOSAMENTE\n Presione cualquier tecla para continuar...");
                            sc.nextLine();
        
                            boolean isActiveTeamsSelection = true;
        
                            while (isActiveTeamsSelection) {
                                clearScreen();
                                System.out.println("¿DESEA REGISTRAR OTRO EQUIPO?\n 1. SI\n 2. NO");
                                String electionTeams = sc.nextLine();
                                
                                try {
                                    int option = Integer.parseInt(electionTeams);
                                    
                                    switch (option) {
                                        case 1 -> {
                                            isActiveTeams = true;
                                            isActiveTeamsSelection = false;
                                        }
                                        case 2 -> {
                                            isActiveTeams = false;
                                            isActiveTeamsSelection = false;
                                        }
                                        default -> {
                                            System.out.println("OPCION NO VALIDA\n Presione cualquier tecla para continuar...");
                                            sc.nextLine();
                                        }
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Por favor, ingrese un número válido.\n Presione cualquier tecla para continuar...");
                                    sc.nextLine();
                                }
                            }
                        }  
                    }

                    case 2 -> {
                        clearScreen();
                        if (equipos.size() >= 2) {

                            boolean isActiveDate = true;

                            Fecha myfecha = new Fecha();
                            

                            while (isActiveDate) {

                                System.out.println("--GESTOR PARTIDO--\n Escoga los equipos participantes (su numero de posicion en la lista)\n \n  Equipo LocaL:");
                                for (int i = 0; i < equipos.size(); i++ ){
                                    System.out.println((i+1)+ ". "+ equipos.get(i).getName());
                                }
                                int teamSearchLocal = Integer.parseInt(sc.nextLine());
                                Equipo localTeam = equipos.get(teamSearchLocal -1);
                                myfecha.setEquipo_local(localTeam.getName());
                                System.out.println("\n Goles anotador por "+ myfecha.getEquipo_local());
                                int localTeamGoals = Integer.parseInt(sc.nextLine());
                                myfecha.setMarcador_equipo1(localTeamGoals);
                                
                                System.out.println("Presione cualquier tecla para continuar...");
                                sc.nextLine();
                                
                                boolean isActiveVisit = true;
                                int visitTeamGoals = 0;
                                Equipo visitTeam = equipos.get(teamSearchLocal -1);

                                while (isActiveVisit){
                                    clearScreen();
                                    System.out.println("--GESTOR PARTIDO--\n Escoga los equipos participantes (su numero de posicion en la lista)\n\n  Equipo Visitante:");
                                    for (int i = 0; i < equipos.size(); i++ ){
                                        System.out.println((i+1)+ ". "+ equipos.get(i).getName());
                                    }

                                    int teamSearchVisit = Integer.parseInt(sc.nextLine());

                                    if (teamSearchVisit == teamSearchLocal) {
                                        System.out.println("El equipo local no puede ser el mismo que el equipo visitante.\n Presione cualquier tecla para continuar...");
                                        sc.nextLine();
                                    } else  {
                                        visitTeam = equipos.get(teamSearchVisit -1);
                                        myfecha.setEquipo_visitante(visitTeam.getName());
                                        System.out.println("\n Goles anotador por "+ myfecha.getEquipo_visitante());
                                        visitTeamGoals = Integer.parseInt(sc.nextLine());
                                        myfecha.setMarcador_equipo2(visitTeamGoals);
                                        isActiveVisit = false;
                                    }  
                                }

                                fechas.add(myfecha);
                                
                                System.out.println("Presione cualquier tecla para continuar...");
                                sc.nextLine();
                                clearScreen();

                                localTeam.setPartidos_jugados(+1);
                                localTeam.setGoles_favor(+localTeamGoals);
                                localTeam.setGoles_contra(+visitTeamGoals);

                                visitTeam.setPartidos_jugados(+1);
                                visitTeam.setGoles_favor(+visitTeamGoals);
                                visitTeam.setGoles_contra(+localTeamGoals);

                                if (localTeamGoals > visitTeamGoals) {
                                    localTeam.setPartidos_ganados(+1);
                                    visitTeam.setPartidos_perdidos(+1);
                                    localTeam.setTotal_puntos(+3);
                                } else if (localTeamGoals < visitTeamGoals) {
                                    localTeam.setPartidos_perdidos(+1);
                                    visitTeam.setPartidos_ganados(+1);
                                    visitTeam.setTotal_puntos(+3);
                                } else if (localTeamGoals == visitTeamGoals) {
                                    localTeam.setPartidos_empatados(+1);
                                    visitTeam.setPartidos_empatados(+1);
                                    localTeam.setTotal_puntos(+1);
                                    visitTeam.setTotal_puntos(+1);
                                }

                                

                                System.out.println("¿Desea registrar otra fecha? [1]si [2]no");
                                String electionDate = sc.nextLine();
                                try {
                                    int option = Integer.parseInt(electionDate);
                                    
                                    switch (option) {
                                        case 1 -> {
                                            isActiveDate = true;
                                        }
                                        case 2 -> {
                                            isActiveDate = false;
                                        }
                                        default -> {
                                            System.out.println("OPCION NO VALIDA\n Presione cualquier tecla para continuar...");
                                            sc.nextLine();
                                        }
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Por favor, ingrese un número válido.\n Presione cualquier tecla para continuar...");
                                    sc.nextLine();
                                }

                            }
                        } else {
                            System.out.println("NO HAY SUFICIENTES EQUIPOS REGISTRADOS\n Presione cualquier tecla para continuar...");
                            sc.nextLine();
                        }

                    }

                    case 3 -> {
                        clearScreen();
                        
                        String mostGoalsTeam = "";
                        String mostPointsTeam = "";
                        String mostWinsTeam = "";
                        int maxGoals = 0;
                        int maxPoints = 0;
                        int maxWins = 0;
                        int totalGoals = 0;
                        float averageGoals = 0;

                        for (Equipo equipo : equipos){
                            if(equipo.getGoles_favor() > maxGoals){
                                maxGoals = equipo.getGoles_favor();
                                mostGoalsTeam = equipo.getName();
                            } 
                            if(equipo.getTotal_puntos() > maxPoints){
                                maxPoints = equipo.getTotal_puntos();
                                mostPointsTeam = equipo.getName();
                            }
                            if(equipo.getPartidos_ganados() > maxWins){
                                maxWins = equipo.getPartidos_ganados();
                                mostWinsTeam = equipo.getName();
                            }

                            totalGoals += equipo.getGoles_favor();
                        }
                        averageGoals = totalGoals / equipos.size();

                        String reportes = MessageFormat.format("""
                                                               --EQUIPO CON MAS GOLES--    :     {0}
                                                               --EQUIPO CON MAS PUNTOS--   :     {1}
                                                               --EQUIPO CON MAS VICTORIAS--:     {2}
                                                               --TOTAL GOLES ANOTADOS--    :     {3}
                                                               --PROMEDIO GOLES ANOTADOS-- :     {4}
                                                               """,mostGoalsTeam, mostPointsTeam, mostWinsTeam, totalGoals, averageGoals);

                        System.out.println(reportes);
                        sc.nextLine();
                    }

                    case 4 -> {
                        clearScreen();
                        Player.registrarJugador(sc, equipos, players);
                    }

                    case 5 -> {
                        clearScreen();
                        Cstaff.registrarStaff(sc, equipos, cstaffs);
                    }

                    case 6 -> {
                        clearScreen();
                        Cmedical.registrarMedicos(sc, equipos, cmedics);
                    }

                    case 7 -> {
                        break;
                    }

                    default -> {
                        System.out.println("OPCION NO VALIDA\n Presione cualquier tecla para continuar...");
                        sc.nextLine();
                    }
                }
                
            }   catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.\n Presione cualquier tecla para continuar...");
                sc.nextLine();
            }        
        }
    }
}
