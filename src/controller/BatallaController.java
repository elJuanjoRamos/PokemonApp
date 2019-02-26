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
    Pokemon atacado = new Pokemon();
    Pokemon atacante = new Pokemon();
    Boolean turno = true;
    
    private BatallaController(){}
    
    public static BatallaController getInstancia(){
        if(instancia == null){
            instancia = new BatallaController();
        }
        return instancia;
    }
    
    public void AgregarBatalla(String jugador1, String jugador2, Pokemon[] pokemonJugador1, Pokemon[] pokemonJugador2, String ganador) {
        for (int i = 0; i < batalla.length; i++) {
            if (batalla[i] == null) {
                //batalla[i] = new Batalla(i, jugador1, jugador2, pokemonJugador1, pokemonJugador2, ganador);
                break;
            }   
        }
    }
    
      public void MostrarDatosBatalla() {
        for (int i = 0; i < batalla.length; i++) {
            if(batalla[i] != null){
                System.out.println("Datos de batalla");
                System.out.println("Jugador1: " + batalla[i].getJugador1());
                for (int j = 0; j < batalla[i].getPokemonJugador1().length; j++) {
                    System.out.println("Pokemon: " + batalla[i].getPokemonJugador1()[j].getNombre());
                    
                }
                System.out.println("Jugador2: " + batalla[i].getJugador2());
                for (int j = 0; j < batalla[i].getPokemonJugador2().length; j++) {
                    System.out.println("Pokemon: " + batalla[i].getPokemonJugador2()[j].getNombre());
                    
                }
            }
        }
    }
      
    public void GenerarBatalla(Pokemon[] pokemonPlayer1, Pokemon[] pokemonPlayer2, String jugador1, String jugador2){
        pokemonJugador1 = pokemonPlayer1;
        pokemonJugador2 = pokemonPlayer2;
        if(turno == true) {
            String pokemon = "";
            
            
            mostrarPokesJugadores(jugador1, jugador2);
            System.out.println("");
            System.out.println("");
            
            System.out.println("Turno de " + jugador1);
            System.out.println("-----------------------");
            System.out.println("");

            System.out.print("Seleccione el Id de uno de tus pokemon para que ataque: ");
            int atacante = scanner.nextInt();
            
            for (int i = 0; i < pokemonJugador1.length; i++) {
                while( true ) {
                    if( pokemonJugador1[i].getId() == atacante ) {
                        String pokemon1 = pokemonJugador1[i].getNombre();
                        int ataquePokemon1 = pokemonJugador1[i].getPuntosAtaque();
                        System.out.println("");
                        System.out.println("");
                        System.out.println("Pokemon que va a atacar es " + pokemon1 );
                        System.out.println("");
                        System.out.println("");
                        System.out.print("Seleccione el pokemon de "+ jugador2+" al que desea atacar: ");
                        scanner.nextLine();

                    } else {
                        System.out.println("");
                        System.out.println("");
                        System.out.println("No se encuentan coincidencias, por favor introduce un numero valido");
                        System.out.println("");
                        System.out.println("");
                        
                    }
                    break;
                } 
            }
            
            
            
            
            
            
            
            
    
            
        } else if(turno == false) {
            System.out.println("");
            System.out.println("");
            System.out.println("Turno de " + jugador2);
            System.out.println("-----------------------");
            System.out.println("");
            String pokemon2="";
            int ataquePokemon1 = 0;
            System.out.print("Seleccione el Id de uno de tus pokemon para que ataque:");
            int atacante = scanner.nextInt();
            
            for (int i = 0; i < pokemonJugador1.length; i++) {
                if( pokemonJugador1[i].getId() == atacante ) {
                    pokemon2 = pokemonJugador1[i].getNombre();
                    ataquePokemon1 = pokemonJugador1[i].getPuntosAtaque();
            
                    break;
                } else {
                    System.out.println("No se encontro ninguna coincidencia");
                }
            }
            
            System.out.println("");
            System.out.println("");
            System.out.println("Pokemon que va a atacar es " + pokemon2 );
            System.out.println("");
            System.out.println("");
            System.out.print("Seleccione el pokemon de "+ jugador1+" al que desea atacar: ");
            scanner.nextLine();
            int atacado = scanner.nextInt();
            String pokemon1 = PokemonController.getInstancia().BuscarPokemon(atacado).getNombre();
            
            System.out.println("El pokemon Atacado es" + pokemon2 );
            
            Pokemon newPokemonAtacado = buscarPokemonAtacado(atacante, atacado);
            for (int i = 0; i < pokemonJugador2.length; i++) {
                if(pokemonJugador2[1].getId() == atacado) {
                    pokemonJugador2[1] = newPokemonAtacado;
                }
            }
            System.out.println("");
            System.out.println("");
            String texto = "El "+ pokemon2 +" de " + jugador2 + " hizo " + ataquePokemon1 + " de daño al "+ pokemon1 + " de " + jugador1; 
            Menu.getInstance().setTimeout(texto, 2500);
            System.out.println("");
            System.out.println("");
            mostrarPokesJugadores(jugador1, jugador2);
            
  
            
            
            
            turno = !turno;
       
                  
        }
        
        
        
        GenerarBatalla(pokemonJugador1, pokemonJugador2, jugador1, jugador2);        
   
    }  
   
   public Pokemon buscarPokemonAtacado(int idAtacante, int idAtacado) {
        atacante = PokemonController.getInstancia().BuscarPokemon(idAtacante);
        atacado = PokemonController.getInstancia().BuscarPokemon(idAtacado);
        
        
        nuevaVida = atacado.getPuntosVida() - atacante.getPuntosAtaque();
        vidaActual = atacado.getPuntosVida(); 
        if(vidaActual != 0) {
            if(atacado.getPuntosVida() > atacante.getPuntosAtaque()) {
                atacado.setPuntosVida(nuevaVida);
            } else {
                atacado.setPuntosVida(0);
                atacado.setEstado(false);
            }
            

        }
     return atacado;
   }
    
   
    public void mostrarPokesJugadores(String jugador1, String jugador2){
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
                System.out.format(leftAlignFormat, "ID" , pokemonJugador1[0].getId(), "| ID    " , pokemonJugador1[1].getId());
                System.out.format(leftAlignFormat, "Nombre",  pokemonJugador1[0].getNombre(), "| Nombre", pokemonJugador1[1].getNombre());
                System.out.format(leftAlignFormat, "Vida ", pokemonJugador1[0].getPuntosVida(), "| Vida",pokemonJugador1[1].getPuntosVida());
                System.out.format(leftAlignFormat, "Ataque", pokemonJugador1[0].getPuntosAtaque(), "| Ataque", pokemonJugador1[1].getPuntosAtaque());
                    
                if( pokemonJugador1[0].getEstado() == true &&  pokemonJugador1[1].getEstado() == true) {
                    System.out.format(leftAlignFormat, "Estado", estado, "| Estado",estado);

                } if( pokemonJugador1[0].getEstado() == true &&  pokemonJugador1[1].getEstado() == false ) {
                        System.out.format(leftAlignFormat, "Estado", estado, "| Estado", estado2);                                    
                }
                if( pokemonJugador1[0].getEstado() == false &&  pokemonJugador1[1].getEstado() == true) {
                        System.out.format(leftAlignFormat, "Estado", estado2, "| Estado", estado);                                    
                } 
                if( pokemonJugador1[0].getEstado() == false &&  pokemonJugador1[1].getEstado() == false) {
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
                System.out.format(leftAlignFormat, "ID" , pokemonJugador2[0].getId(), "| ID    " , pokemonJugador2[1].getId());
                System.out.format(leftAlignFormat, "Nombre",  pokemonJugador2[0].getNombre(), "| Nombre", pokemonJugador2[1].getNombre());
                System.out.format(leftAlignFormat, "Vida ", pokemonJugador2[0].getPuntosVida(), "| Vida",pokemonJugador2[1].getPuntosVida());
                System.out.format(leftAlignFormat, "Ataque", pokemonJugador2[0].getPuntosAtaque(), "| Ataque", pokemonJugador2[1].getPuntosAtaque());
                if( pokemonJugador2[0].getEstado() == true &&  pokemonJugador2[1].getEstado() == true) {
                    System.out.format(leftAlignFormat, "Estado", estado, "| Estado",estado);

                } if( pokemonJugador2[0].getEstado() == true &&  pokemonJugador2[1].getEstado() == false ) {
                        System.out.format(leftAlignFormat, "Estado", estado, "| Estado", estado2);                                    
                }
                if( pokemonJugador2[0].getEstado() == false &&  pokemonJugador2[1].getEstado() == true) {
                        System.out.format(leftAlignFormat, "Estado", estado2, "| Estado", estado);                                    
                } 
                if( pokemonJugador2[0].getEstado() == false &&  pokemonJugador2[1].getEstado() == false) {
                        System.out.format(leftAlignFormat, "Estado", estado2, "| Estado", estado2);                                    
                }
                System.out.format("+------------+----------------------+ +----------+----------------------+%n");
                
    }
}
