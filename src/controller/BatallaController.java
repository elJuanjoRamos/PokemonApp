/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.*;
import java.util.Random;
import java.util.Scanner;
import menu.Menu;

/**
 *
 * @author Juan José Ramos
 */
public class BatallaController {

    public static BatallaController instancia;

    //Instancias
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();

    Batalla[] batalla = new Batalla[1000];
        
    
    Pokemon[] pokemonJugador1 = new Pokemon[2];
    Pokemon[] pokemonJugador2 = new Pokemon[2];

    //Variables
    int vidaActual = 0;
    int nuevaVida = 0;
    int contadorJugador1 = 0;
    int contadorJugador2 = 0;
    int cantidadGolpesPokemon1 = 0;
    int cantidadGolpesPokemon2 = 0;
    int ataquesRecibidosPokemon1 = 0;
    int ataquesRecibidosPokemon2 = 0;
    int cantidadGolpesPokemon3 = 0;
    int cantidadGolpesPokemon4 = 0;
    int ataquesRecibidosPokemon3 = 0;
    int ataquesRecibidosPokemon4 = 0;
    int contadorPokemon1 = 0;
    int contadorPokemon2 = 0;
    int contadorPokemon3 = 0;
    int contadorPokemon4 = 0;
    String mejorPokemon1 = "";
    String mejorPokemon2 = "";
    String mejorPokemon3= "";
    String mejorPokemon4 = "";
    Pokemon atacado = new Pokemon();
    Pokemon atacante = new Pokemon();
    Boolean turno = false;

    private BatallaController() {
    }

    public static BatallaController getInstancia() {
        if (instancia == null) {
            instancia = new BatallaController();
        }
        return instancia;
    }

    public void AgregarBatalla(String jugador1, String jugador2, Pokemon[] pokemonJugador1, Pokemon[] pokemonJugador2, String ganador, int cantidadGolpesPokemon1,
            int cantidadGolpesPokemon2, int ataquesRecibidosPokemon1, int ataquesRecibidosPokemon2, int cantidadGolpesPokemon3, int cantidadGolpesPokemon4,
            int ataquesRecibidosPokemon3, int ataquesRecibidosPokemon4, int contadorJugador1, int contadorJugador2) {

        for (int i = 0; i < batalla.length; i++) {
            if (batalla[i] == null) {
                batalla[i] = new Batalla(i+1, jugador1, jugador2, pokemonJugador1, pokemonJugador2, ganador, cantidadGolpesPokemon1,
                        cantidadGolpesPokemon2, ataquesRecibidosPokemon1, ataquesRecibidosPokemon2, cantidadGolpesPokemon3, cantidadGolpesPokemon4,
                        ataquesRecibidosPokemon3, ataquesRecibidosPokemon4, contadorJugador1, contadorJugador2);
                break;
            }
        }
    }

    public void MostrarDatosBatalla() {
                System.out.format("╔═════════════════════════════════════════════════╗%n");
                System.out.format("║                        Registro  de Partidas realizadas                     ║%n");
                System.out.format("╚═════════════════════════════════════════════════╝%n");
                System.out.println("");
                System.out.println("*Golpes: Numero de ataques que hizo un pokemon");
                System.out.println("*Daños: Numero de ataques recibidos por un pokemon");
                
        for (int i = 0; i < batalla.length; i++) {
            if (batalla[i] != null) {
                System.out.println("");
                String leftAlignFormat = "| %-10s %-20s |    |  %-5s | %-20s |%n";
                
                
                System.out.format("╔══════════════════╗%n");
                System.out.format("║ Datos de Batalla No."+ batalla[i].getId() +"      ║%n");
                System.out.format("╚══════════════════╝%n");
                System.out.format("+-----------------------------------------------------------------------------+%n");
                System.out.format("|   Jugador1:"  + batalla[i].getJugador1()  + "                   | vs |    Jugador 2:"+ batalla[i].getJugador2() +"                    |%n");
                System.out.format("+-----------------------------------------------------------------------------+%n");
                System.out.format(leftAlignFormat, "Turnos J1: ", batalla[i].getTurnoJugador1(), "Turnos J2: ", batalla[i].getTurnoJugador2());
                System.out.format(leftAlignFormat, "Equipo Pok.", "", "Equipo Pok.", "");
                
                
                
                System.out.format(leftAlignFormat, "Nombre P1: ", batalla[i].getPokemonJugador1()[0].getNombre()+ " ", "Nombre P1: ", batalla[i].getPokemonJugador2()[0].getNombre() );
                System.out.format(leftAlignFormat, "Golpes P1: ", batalla[i].getAtaquesPokemon1()+ " ", "Golpes P1: ", batalla[i].getAtaquesPokemon3());
                System.out.format(leftAlignFormat, "Daños  P1: ", batalla[i].getGolpesPokemon1()+ " ", "Daños  P1: ", batalla[i].getGolpesPokemon3() );
                
                
                System.out.format(leftAlignFormat, "Nombre P2: ", batalla[i].getPokemonJugador1()[1].getNombre()+ " ", "Nombre P2: ", batalla[i].getPokemonJugador2()[1].getNombre() );
                System.out.format(leftAlignFormat, "Goples P2: ", batalla[i].getAtaquesPokemon2()+ " ", "Golpes P2: ", batalla[i].getAtaquesPokemon4());
                System.out.format(leftAlignFormat, "Daños  P2: ", batalla[i].getGolpesPokemon2()+ " ", "Daños  P2: ", batalla[i].getGolpesPokemon4() );
                            
                
                System.out.format("+-----------------------------------------------------------------------------+%n");
                System.out.format("+                                 Ganador "+ batalla[i].getGanador()  +"                                 +%n");
                System.out.format("+-----------------------------------------------------------------------------+%n");
                
              
            }

        }
    }

    public void GenerarBatalla(Pokemon[] pokemonPlayer1, Pokemon[] pokemonPlayer2, String jugador1, String jugador2) {

        pokemonJugador1 = pokemonPlayer1;
        pokemonJugador2 = pokemonPlayer2;
        mostrarPokesJugadores(jugador1, jugador2);

        if (turno == true) {
            if (pokemonJugador1[0].getPuntosVida() == 0 && pokemonJugador1[1].getPuntosVida() == 0) {
                System.out.println("");
                System.out.println("");
                System.out.println("Partida Terminada, el ganador es: " + jugador2);
                System.out.println("");
                System.out.println("");
                AgregarBatalla(jugador1, jugador2, pokemonJugador1, pokemonJugador2, jugador2, cantidadGolpesPokemon1, 
                                cantidadGolpesPokemon2, cantidadGolpesPokemon3, cantidadGolpesPokemon4, ataquesRecibidosPokemon1, 
                                ataquesRecibidosPokemon2, ataquesRecibidosPokemon3, ataquesRecibidosPokemon4, contadorJugador1, contadorJugador2);
                Menu.getInstance().MainMenu();
                return;
            } else {
                System.out.println("");
                System.out.println("");
                System.out.println("Turno de " + jugador1);
                System.out.println("-----------------------");
                System.out.println("");
                String nombreAtacante = "";
                int ataquePokemon = 0;
                Pokemon temp = null;
                Pokemon pokemonAtacado = null;
                System.out.print("Seleccione el Id de uno de tus pokemon para que ataque:");
                String atacante = scanner.nextLine();
                if (esNumero(atacante)) {
                    for (int i = 0; i < pokemonJugador1.length; i++) {

                        if (pokemonJugador1[i].getId() == Integer.parseInt(atacante)) {
                            temp = pokemonJugador1[i];
                            nombreAtacante = pokemonJugador1[i].getNombre();
                            ataquePokemon = pokemonJugador1[i].getPuntosAtaque();
                            if (i == 0) {
                                cantidadGolpesPokemon1 += 1;
                                contadorPokemon1 += 1;
                            } else {
                                cantidadGolpesPokemon2 += 1;
                                contadorPokemon1 += 1;
                            }
                        }
                    }
                    if (temp != null) {
                        
                        if (temp.getPuntosVida() > 0) {
                            System.out.println("");
                            System.out.println("");
                            System.out.println("Pokemon que va a atacar es " + nombreAtacante);
                            System.out.println("");
                            System.out.println("");
                            System.out.print("Seleccione el pokemon de " + jugador2 + " al que desea atacar: ");
                            String atacado = scanner.nextLine();
                            atacado = Menu.getInstance().eliminarEspacios(atacado);
                            if (esNumero(atacado)) {
                                for (int j = 0; j < pokemonJugador2.length; j++) {
                                    if (pokemonJugador2[j].getId() == Integer.parseInt(atacado)) {
                                        pokemonAtacado = pokemonJugador2[j];
                                        if (j == 0) {
                                            ataquesRecibidosPokemon2 += 1;
                                            
                                        } else {
                                            ataquesRecibidosPokemon3 += 1;
                                        }

                                    }
                                }
                                if (pokemonAtacado != null) {
                                    if (pokemonAtacado.getPuntosVida() > 0) {

                                        if (pokemonAtacado.getPuntosVida() != 0) {
                                            if (pokemonAtacado.getPuntosVida() > ataquePokemon) {
                                                int nuevaVida = pokemonAtacado.getPuntosVida() - ataquePokemon;
                                                pokemonAtacado.setPuntosVida(nuevaVida);
                                                for (int i = 0; i < pokemonJugador2.length; i++) {
                                                    if (pokemonJugador2[i].getId() == pokemonAtacado.getId()) {
                                                        pokemonJugador2[i] = pokemonAtacado;
                                                        
                                                    }
                                                }
                                            } else {
                                                pokemonAtacado.setPuntosVida(0);
                                                pokemonAtacado.setEstado(false);
                                                for (int i = 0; i < pokemonJugador2.length; i++) {
                                                    if (pokemonJugador2[i].getId() == pokemonAtacado.getId()) {
                                                        pokemonJugador2[i] = pokemonAtacado;
                                                    }
                                                }
                                            }
                                        }
                                        System.out.println("El pokemon Atacado es" + pokemonAtacado.getNombre());
                                        System.out.println("");
                                        System.out.println("");
                                        String texto = "El " + nombreAtacante + " de " + jugador1 + " hizo " + ataquePokemon + " de daño al " + pokemonAtacado.getNombre() + " de " + jugador2;
                                        Menu.getInstance().setTimeout(texto, 2500);
                                        System.out.println("");
                                        System.out.println("");

                                        contadorJugador1 = contadorJugador1 + 1;

                                        turno = !turno;
                                        GenerarBatalla(pokemonJugador1, pokemonJugador2, jugador1, jugador2);

                                    } else {
                                        System.out.println("");
                                        Menu.getInstance().setTimeout("\u26A0" + "Este pokemon ya está debilitado, no puede ser atacado", 2500);
                                        System.out.println();
                                        GenerarBatalla(pokemonJugador1, pokemonJugador2, jugador1, jugador2);
                                    }

                                } else {
                                    System.out.println("");
                                    Menu.getInstance().setTimeout("\u26A0" + "No se encontro el pokemon para atacar, por favor introduzca un dato valido", 2500);
                                    System.out.println();
                                    GenerarBatalla(pokemonJugador1, pokemonJugador2, jugador1, jugador2);
                                }

                            } else {
                                System.out.println("");
                                Menu.getInstance().setTimeout("\u26A0" + "No se encuentran coincidencias, por favor introduzca un dato valido", 2500);
                                System.out.println();
                                GenerarBatalla(pokemonJugador1, pokemonJugador2, jugador1, jugador2);
                            }

                        } else {
                            System.out.println("");
                            Menu.getInstance().setTimeout("\u26A0" + "Este pokemon ya esta debilitado, no puede atacar", 2500);
                            System.out.println();
                            GenerarBatalla(pokemonJugador1, pokemonJugador2, jugador1, jugador2);
                        }

                    } else {
                        System.out.println("");
                        Menu.getInstance().setTimeout("\u26A0" + "No se encuentran coincidencias, por favor introduzca un dato valido", 2500);
                        System.out.println();
                        GenerarBatalla(pokemonJugador1, pokemonJugador2, jugador1, jugador2);
                    }
                } else {
                    System.out.println("");
                    Menu.getInstance().setTimeout("\u26A0" + "No se encuentran coincidencias, por favor introduzca un dato valido", 2500);
                    System.out.println();
                    GenerarBatalla(pokemonJugador1, pokemonJugador2, jugador1, jugador2);
                }

            }

        } else if (turno == false) {

            if (pokemonJugador2[0].getPuntosVida() == 0 && pokemonJugador2[1].getPuntosVida() == 0) {
                System.out.println("");
                System.out.println("");
                System.out.println("Partida Terminada, el ganador es: " + jugador1);
                System.out.println("");
                System.out.println("");
                AgregarBatalla(jugador1, jugador2, pokemonJugador1, pokemonJugador2, jugador1, cantidadGolpesPokemon1, 
                                cantidadGolpesPokemon2, cantidadGolpesPokemon3, cantidadGolpesPokemon4, ataquesRecibidosPokemon1, 
                                ataquesRecibidosPokemon2, ataquesRecibidosPokemon3, ataquesRecibidosPokemon4, contadorJugador1, contadorJugador2);
                Menu.getInstance().MainMenu();
                return;
            } else {
                System.out.println("");
                System.out.println("");
                System.out.println("Turno de " + jugador2);
                System.out.println("-----------------------");
                System.out.println("");
                String nombreAtacante1 = "";
                int ataquePokemon1 = 0;
                Pokemon temp1 = null;
                Pokemon pokemonAtacado1 = null;

                System.out.print("Seleccione el Id de uno de tus pokemon para que ataque:");
                String atacante = scanner.nextLine();
                if (esNumero(atacante)) {
                    for (int i = 0; i < pokemonJugador2.length; i++) {
                        if (pokemonJugador2[i].getId() == Integer.parseInt(atacante)) {
                            temp1 = pokemonJugador2[i];
                            nombreAtacante1 = pokemonJugador2[i].getNombre();
                            ataquePokemon1 = pokemonJugador2[i].getPuntosAtaque();
                            if (i == 0) {
                                cantidadGolpesPokemon3 += 1; 
                                contadorPokemon3 += 1;
                            } else {
                                cantidadGolpesPokemon4 += 1;
                                contadorPokemon4 += 1;
                            }
                        }
                    }
                    if (temp1 != null) {
                        
                        if (temp1.getPuntosVida() > 0) {
                            System.out.println("");
                            System.out.println("");
                            System.out.println("Pokemon que va a atacar es " + nombreAtacante1);
                            System.out.println("");
                            System.out.println("");
                            System.out.print("Seleccione el pokemon de " + jugador1 + " al que desea atacar: ");
                            String atacado = scanner.nextLine();
                            atacado = Menu.getInstance().eliminarEspacios(atacado);
                            if (esNumero(atacado)) {
                                for (int j = 0; j < pokemonJugador1.length; j++) {
                                    if (pokemonJugador1[j].getId() == Integer.parseInt(atacado)) {
                                        pokemonAtacado1 = pokemonJugador1[j];
                                        if (j == 0) {
                                            ataquesRecibidosPokemon1 += 1; 
                                        } else {
                                            ataquesRecibidosPokemon2 += 1;
                                        }
                                    }
                                }

                                if (pokemonAtacado1 != null) {
                                    if (pokemonAtacado1.getPuntosVida() >0 ) {
                                        if (pokemonAtacado1.getPuntosVida() != 0) {
                                        if (pokemonAtacado1.getPuntosVida() > ataquePokemon1) {
                                            int nuevaVida = pokemonAtacado1.getPuntosVida() - ataquePokemon1;
                                            pokemonAtacado1.setPuntosVida(nuevaVida);
                                            for (int i = 0; i < pokemonJugador1.length; i++) {
                                                if (pokemonJugador1[i].getId() == pokemonAtacado1.getId()) {
                                                    pokemonJugador1[i] = pokemonAtacado1;
                                                }
                                            }
                                        } else {
                                            pokemonAtacado1.setPuntosVida(0);
                                            pokemonAtacado1.setEstado(false);
                                            for (int i = 0; i < pokemonJugador1.length; i++) {
                                                if (pokemonJugador1[i].getId() == pokemonAtacado1.getId()) {
                                                    pokemonJugador1[i] = pokemonAtacado1;
                                                }
                                            }
                                        }
                                    }

                                    System.out.println("El pokemon Atacado es" + pokemonAtacado1.getNombre());

                                    System.out.println("");
                                    System.out.println("");
                                    String texto = "El " + nombreAtacante1 + " de " + jugador2 + " hizo " + ataquePokemon1 + " de daño al " + pokemonAtacado1.getNombre() + " de " + jugador1;
                                    Menu.getInstance().setTimeout(texto, 2500);
                                    System.out.println("");
                                    System.out.println("");
                                    contadorJugador2 = contadorJugador2 + 1;
                                    turno = !turno;
                                    GenerarBatalla(pokemonJugador1, pokemonJugador2, jugador1, jugador2);
                                    } else {
                                         System.out.println("");
                                         Menu.getInstance().setTimeout("\u26A0" + "Este pokemon ya esta debilitado, no puede ser atacado", 2500);
                                         System.out.println();
                                         GenerarBatalla(pokemonJugador1, pokemonJugador2, jugador1, jugador2);
                                    }



                                } else {
                                    System.out.println("");
                                    Menu.getInstance().setTimeout("\u26A0" + "No se encuentran coincidencias, por favor introduzca un dato valido", 2500);
                                    System.out.println();
                                    GenerarBatalla(pokemonJugador1, pokemonJugador2, jugador1, jugador2);
                                }

                            } else {
                                System.out.println("");
                                Menu.getInstance().setTimeout("\u26A0" + "No se encuentran coincidencias, por favor introduzca un dato valido", 2500);
                                System.out.println();
                                GenerarBatalla(pokemonJugador1, pokemonJugador2, jugador1, jugador2);
                            }
                        }else {
                                System.out.println("");
                                Menu.getInstance().setTimeout("\u26A0" + "Este pokemon ya esta devilitado, no puede atacar", 2500);
                                System.out.println();
                                GenerarBatalla(pokemonJugador1, pokemonJugador2, jugador1, jugador2);
                            }
                    } else {
                        System.out.println("");
                        Menu.getInstance().setTimeout("\u26A0" + "No se encuentran coincidencias, por favor introduzca un dato valido", 2500);
                        System.out.println();
                        GenerarBatalla(pokemonJugador1, pokemonJugador2, jugador1, jugador2);
                    }

                } else {
                    System.out.println("");
                    Menu.getInstance().setTimeout("\u26A0" + "No se encuentran coincidencias, por favor introduzca un dato valido", 2500);
                    System.out.println();
                    GenerarBatalla(pokemonJugador1, pokemonJugador2, jugador1, jugador2);
                }
            }
        }
    }

    public Pokemon buscarPokemonAtacado(int poderAtacante, int idAtacado) {

        Pokemon nuevoAtacado = PokemonController.getInstancia().BuscarPokemon(idAtacado);

        return nuevoAtacado;
    }

   
    public void RegistroEstadistica(){
        int X,Y;
        if(contadorPokemon1 > contadorPokemon2 && contadorPokemon1 > contadorPokemon3 && contadorPokemon1 > contadorPokemon4){
            X=contadorPokemon1;
        }else{
            if(contadorPokemon2 > contadorPokemon1 && contadorPokemon2 > contadorPokemon3 && contadorPokemon2 > contadorPokemon4){
                X=contadorPokemon2;
            }else{
                if(contadorPokemon3 > contadorPokemon1 && contadorPokemon3 > contadorPokemon2 && contadorPokemon3 > contadorPokemon4){
                    X=contadorPokemon3;
                }else
                    X=contadorPokemon4;
            }
        }
        if(contadorPokemon1 < contadorPokemon2 && contadorPokemon1 < contadorPokemon3 && contadorPokemon1 < contadorPokemon4){
            Y=contadorPokemon1;
        }else{
            if(contadorPokemon2 < contadorPokemon1 && contadorPokemon2 < contadorPokemon1 && contadorPokemon2 < contadorPokemon4){
                Y=contadorPokemon2;
            }else{
                if(contadorPokemon3 < contadorPokemon1 && contadorPokemon3 < contadorPokemon2 && contadorPokemon3 < contadorPokemon4){
                    Y=contadorPokemon3;
                }else
                    Y=contadorPokemon4;
            }
        }
        System.out.println("el mayor es "+X+" y el menor es "+Y);
     
    }
    
    public void mostrarPokesJugadores(String jugador1, String jugador2) {
        String estado = "Disponible";
        String estado2 = "Devilitado";
        String leftAlignFormat = "| %-10s | %-20s | %-10s | %-20s |%n";
        System.out.println("");
        System.out.println("\tPokemon de " + jugador1);
        System.out.println("\t---------------------------");
        System.out.println("");
        System.out.format("+------------+----------------------+ +----------+----------------------+%n");
        System.out.format("|  Pokemon   |         Datos        | | Pokemon2 |         Datos        |%n");
        System.out.format("+------------+----------------------+ +----------+----------------------+%n");
        System.out.format(leftAlignFormat, "ID", pokemonJugador1[0].getId(), "| ID    ", pokemonJugador1[1].getId());
        System.out.format(leftAlignFormat, "Nombre", pokemonJugador1[0].getNombre(), "| Nombre", pokemonJugador1[1].getNombre());
        System.out.format(leftAlignFormat, "Vida ", pokemonJugador1[0].getPuntosVida(), "| Vida", pokemonJugador1[1].getPuntosVida());
        System.out.format(leftAlignFormat, "Ataque", pokemonJugador1[0].getPuntosAtaque(), "| Ataque", pokemonJugador1[1].getPuntosAtaque());

        if (pokemonJugador1[0].getEstado() == true && pokemonJugador1[1].getEstado() == true) {
            System.out.format(leftAlignFormat, "Estado", estado, "| Estado", estado);

        }
        if (pokemonJugador1[0].getEstado() == true && pokemonJugador1[1].getEstado() == false) {
            System.out.format(leftAlignFormat, "Estado", estado, "| Estado", estado2);
        }
        if (pokemonJugador1[0].getEstado() == false && pokemonJugador1[1].getEstado() == true) {
            System.out.format(leftAlignFormat, "Estado", estado2, "| Estado", estado);
        }
        if (pokemonJugador1[0].getEstado() == false && pokemonJugador1[1].getEstado() == false) {
            System.out.format(leftAlignFormat, "Estado", estado2, "| Estado", estado2);
        }

        System.out.format("+------------+----------------------+ +----------+----------------------+%n");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("\tPokemon de " + jugador2);
        System.out.println("\t---------------------------");
        System.out.format("+------------+----------------------+ +----------+----------------------+%n");
        System.out.format("|  Pokemon   |         Datos        | | Pokemon2 |         Datos        |%n");
        System.out.format("+------------+----------------------+ +----------+----------------------+%n");
        System.out.format(leftAlignFormat, "ID", pokemonJugador2[0].getId(), "| ID    ", pokemonJugador2[1].getId());
        System.out.format(leftAlignFormat, "Nombre", pokemonJugador2[0].getNombre(), "| Nombre", pokemonJugador2[1].getNombre());
        System.out.format(leftAlignFormat, "Vida ", pokemonJugador2[0].getPuntosVida(), "| Vida", pokemonJugador2[1].getPuntosVida());
        System.out.format(leftAlignFormat, "Ataque", pokemonJugador2[0].getPuntosAtaque(), "| Ataque", pokemonJugador2[1].getPuntosAtaque());
        if (pokemonJugador2[0].getEstado() == true && pokemonJugador2[1].getEstado() == true) {
            System.out.format(leftAlignFormat, "Estado", estado, "| Estado", estado);

        }
        if (pokemonJugador2[0].getEstado() == true && pokemonJugador2[1].getEstado() == false) {
            System.out.format(leftAlignFormat, "Estado", estado, "| Estado", estado2);
        }
        if (pokemonJugador2[0].getEstado() == false && pokemonJugador2[1].getEstado() == true) {
            System.out.format(leftAlignFormat, "Estado", estado2, "| Estado", estado);
        }
        if (pokemonJugador2[0].getEstado() == false && pokemonJugador2[1].getEstado() == false) {
            System.out.format(leftAlignFormat, "Estado", estado2, "| Estado", estado2);
        }
        System.out.format("+------------+----------------------+ +----------+----------------------+%n");

    }

    public static boolean esNumero(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException e) {
            resultado = false;
        }

        return resultado;
    }

}
