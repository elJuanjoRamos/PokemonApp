/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.util.Random;
import java.util.Scanner;
import beans.Pokemon;
import controller.BatallaController;
import controller.PokemonController;
import java.util.HashSet;
import java.util.InputMismatchException;

/**
 *
 * @author Juan José Ramos
 */
public class Menu {

        /*Instancias*/
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();

    
    
    /*Declaracion de variables*/
    int option = 0;
    int admonOption = 0;
    int salir = 0;
    int max = 100;
    int min = 50;
    String playerOption = "";
    String jugador1 = "";
    String jugador2 = "";
    Boolean turno = true;
    Pokemon[] pokemonJugador1 = new Pokemon[2];
    Pokemon[] pokemonJugador2 = new Pokemon[2];
        
    private static Menu instance;


    public static Menu getInstance() {
        if( instance == null ) {
            instance = new Menu();
        }
        return instance;
    }



    public void OptionsMenu() {
        System.out.format("       +---------------------------+%n");
        System.out.format("       |        Pokemon App        |%n");
        System.out.format("       +---------------------------+%n");
        System.out.println(" ");
        System.out.println("Elige una opcion para continuar:");
        System.out.println("1.Acceder");
        System.out.println("2.Salir");
        System.out.println(" ");
        System.out.print("Opcion: ");
        option = scanner.nextInt();


 
        switch( option ) {
            case 1:
                MainMenu();
                break; 
            case 2:
                System.out.println("Gracias por participar");
            default:
                break;
        }
             


        

    }

    
    public void MainMenu() {
        System.out.format("       +--------------------------------+%n");
        System.out.format("       |         Menu Principal         |%n");
        System.out.format("       +--------------------------------+%n");
        System.out.println(" ");
        
        System.out.println("Ellige una opcion para continuar:");
        System.out.println("1.Administrdor");
        System.out.println("2.Batalla con dos jugadores");
        System.out.print("Opcion: ");
        option = scanner.nextInt();

        
        switch( option ) {
            case 1:
                System.out.format("       +--------------------------+%n");
                System.out.format("       |       Welcome Admin      |%n");
                System.out.format("       +--------------------------+%n");
                System.out.println(" ");
                System.out.print("Password: ");
                scanner.nextLine();
                
                try {
                    String password = scanner.nextLine();
                    if (Integer.parseInt(eliminarEspacios(password)) == 201801262) {
                        AdminMenu();

                    } else {
                        setTimeout( "El Password no es correcto" , 2500 );
                        MainMenu();
                    }
                } catch(NumberFormatException e ) {
                    setTimeout( "El Password no es correcto" , 2500 );
                    MainMenu();
                }
                break; 
            case 2:
                MenuJugador();
                break;
            default:
                MainMenu();
                break;
        }
        
    }
    
    
    public void AdminMenu() {
        

        
            System.out.println("Elige una opcion para continuar:");
            System.out.println("1.Pokemon agregados");
            System.out.println("2.Agregar Pokemon");
            System.out.println("3.Editar Pokemon");
            System.out.println("4.Reportes");
            System.out.println("5.Menu Principal");;
            System.out.println(" ");
            System.out.print("Option: ");
            
            option = scanner.nextInt();
                
            switch ( option ) {
                case 1:
                    PokemonController.getInstancia().MostrarPokemon();
                    AdminMenu(); 
                    break;
                case 2:
                    System.out.println("       +------------------------+%n");
                    System.out.println("       |       New Pokemon      |%n");
                    System.out.println("       +------------------------+%n");
                    System.out.println(" ");
                    do {
                    
                        System.out.print("Ingrese un nombre: ");
                        scanner.nextLine();
                        String pokemonName = scanner.nextLine();
                        System.out.print("Ingrese una Imagen: " );
                        String pokemonImg = scanner.nextLine();

                        int attack = rand.nextInt(20);
                        attack += 5;

                        int healt = rand.nextInt(max - min) + min;

                        PokemonController.getInstancia().AgregarPokemon(pokemonName, pokemonImg, healt, attack);
                        System.out.println("");
                        System.out.println("Pokemon Agregado Correctamente!!");
                        System.out.println("");
                        
                        
                        System.out.println("Desea agregar otro pokemon?");
                        System.out.println("1.Si");
                        System.out.println("2.No");
                        System.out.println("");
                        System.out.print("Opcion: ");
                        
                        option = scanner.nextInt();
                        
                    
                    } while ( option == 1 );
                        AdminMenu();
                    

                    break;
                case 3: 
                    System.out.println("           +--------------------------+");
                    System.out.println("           |       Edit a Pokemon     |");
                    System.out.println("           +--------------------------+");
                    System.out.println(" ");
                    System.out.println(" ");
                    PokemonController.getInstancia().MostrarPokemon();
                    System.out.println("Elije el ID o el nombre del pokemon que desea editar");
                    try {
                        System.out.print("Pokemon: ");
                        int id = scanner.nextInt();
                        //PokemonController.getInstancia().BuscarPokemon(eliminarEspacios(id));
                        
                        try {
                            
                        } catch(InputMismatchException e) {
                        
                        }
                        String newName = scanner.nextLine();
                        //int 
                        
                        
                    } catch(InputMismatchException e) {
                        System.out.println("Solo se puede ingear numeros");
                        AdminMenu();
                    }
                    
                    
                    
                    break;
                case 4: 
                    break;
                case 5:
                    MainMenu(); 
                    break;
                
            }

    }

    
    public void MenuJugador() {
        
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("           +--------------------------+");
        System.out.println("           |      Batalla Pokemon     |");
        System.out.println("           +--------------------------+");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("1. Jugar");
        System.out.println("2. Regresar al menu principal");
        System.out.print("Elija una opcion: ");
        scanner.nextLine();
            
        try {
            playerOption = scanner.nextLine();
            
        
            switch( Integer.parseInt(eliminarEspacios(playerOption)) ){
                case 1:
                    System.out.println(" ");

                    System.out.print("Por favor ingrese el nombre del jugador 1: ");
                    jugador1 = scanner.nextLine();
                    System.out.println(" ");
                    
                    System.out.print("Por favor ingrese el nombre del jugador 2: ");
                    jugador2 = scanner.nextLine();
                    
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("           +--------------------------+");
                    System.out.println("           |     Pokemon Permitidos   |");
                    System.out.println("           +--------------------------+");
        
                    PokemonController.getInstancia().MostrarPokemon();
                    System.out.println(" ");
                    System.out.println(" ");
                    try {                    
                        
                        
                        while( true ) {
                    
                            System.out.print("Por favor," + jugador1 + ", elija el Id del pokemon que desea utilizar: ");
                            playerOption= scanner.nextLine();
                            pokemonJugador1[0] = PokemonController.getInstancia().BuscarPokemon(Integer.parseInt(eliminarEspacios(playerOption)));
                        
                            if(pokemonJugador1[0] != null) {
                                System.out.println(" ");
                                System.out.println(" ");

                                while( true ) {
                                    System.out.print("Elija el segundo Pokemon: ");
                                    playerOption= scanner.nextLine();
                                    pokemonJugador1[1] = PokemonController.getInstancia().BuscarPokemon(Integer.parseInt(eliminarEspacios(playerOption)));
                                    if (pokemonJugador1[1] != null) {
                                        System.out.println(" ");
                                        System.out.println(" ");
                                        while( true ) {
                                            System.out.print("Por favor," + jugador2 + ", elija el Id del pokemon que desea utilizar: ");
                                            playerOption= scanner.nextLine();
                                            pokemonJugador2[0] = PokemonController.getInstancia().BuscarPokemon(Integer.parseInt(eliminarEspacios(playerOption)));
                                            if( pokemonJugador2[0] != null ) {
                                                while( true ) {
                                                    System.out.print("Elija el segundo Pokemon: ");
                                                    playerOption= scanner.nextLine();
                                                    pokemonJugador2[1] = PokemonController.getInstancia().BuscarPokemon(Integer.parseInt(eliminarEspacios(playerOption)));

                                                    if( pokemonJugador2[1] != null ) {
                                                        
                                                        BatallaController.getInstancia().GenerarBatalla(pokemonJugador1, pokemonJugador2, jugador1, jugador2);
                                                        break;
                                                    } else {
                                                        System.out.println(" ");
                                                        System.out.println(" ");
                                                        System.out.println("No se encuentran coincidencias, por favor introduzca un numero valido");

                                                    }
                                                }
                                            } else {
                                                System.out.println(" ");
                                                System.out.println(" ");
                                                System.out.println("No se encuentran coincidencias, por favor introduzca un numero valido");

                                            }
                                        }
                                        
                                    } else {
                                        System.out.println(" ");
                                        System.out.println(" ");
                                        System.out.println("No se encuentran coincidencias, por favor introduzca un numero valido");
                            
                                    }
                                }

                            } else {
                                System.out.println("No se encuentran coincidencias, por favor introduzca un numero valido");
                                
                            }
                        }              
                        
                        
                    } catch(NumberFormatException e) {
                        setTimeout("Solo se pueden introducir IDs para seleccionar un pokemon", 2500);
                        MainMenu();
                    }

                    
                    
                    
                    break;
                case 2: 
                    MainMenu();
                    break;
                default:
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("Por favor elija una opcion valida");
                    System.out.println(" ");
                    System.out.println(" ");
                    MainMenu();
                    break;
            }
                   

        } catch(NumberFormatException e) {
                    setTimeout( "Solo se puede ingresar numeros" , 2500 );
                    MainMenu();
        }
        
    }
    
    public String eliminarEspacios(String texto) {
        String nuevoTexto = "";
        for (int x = 0; x < texto.length(); x++) {
            if (texto.charAt(x) != ' ') {
                nuevoTexto += texto.charAt(x);
            }
        }
        return nuevoTexto;
    }
       
    public static void setTimeout(String texto, int delay ) {
            try {

                System.out.format("          " + texto +"     %n");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(" ");
                
                Thread.sleep(delay);
            } catch(Exception e) {
                System.err.println(e);
            }

    }

}