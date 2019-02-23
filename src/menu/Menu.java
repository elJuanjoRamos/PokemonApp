/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.util.Random;
import java.util.Scanner;
import beans.Pokemon;
import controller.PokemonController;
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
        System.out.println("Choose a option to continue:");
        System.out.println("1.Login");
        System.out.println("2.Exit");
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
        System.out.format("       +---------------------------+%n");
        System.out.format("       |         Main Menu         |%n");
        System.out.format("       +---------------------------+%n");
        System.out.println(" ");
        
        System.out.println("Choose a option to continue:");
        System.out.println("1.Administrator");
        System.out.println("2.Battles");
        System.out.print("Opcion: ");
        option = scanner.nextInt();

        
        switch( option ) {
            case 1:
                System.out.format("       +--------------------------+%n");
                System.out.format("       |       Welcome Admin      |%n");
                System.out.format("       +--------------------------+%n");
                System.out.println(" ");
                //System.out.print("Password: ");
                //int password = scanner.nextInt();
                AdminMenu();
                /*if (password == 201801262) {
                    
                } else {
                    setTimeout( "El Password no es correcto" , 2500 );
                    MainMenu();
                }*/

                break; 
            case 2:
                PlayerMenu();
                break;
            default:
                MainMenu();
                break;
        }
        
    }
    
    
    public void AdminMenu() {
        

        
            System.out.println("Choose a option to continue:");
            System.out.println("1.Pokemon added");
            System.out.println("2.Add a new Pokemon");
            System.out.println("3.Edit Pokemon");
            System.out.println("4.Report");
            System.out.println("5.Main Menu");;
            System.out.println(" ");
            System.out.print("Option: ");
            
            option = scanner.nextInt();
                
            switch ( option ) {
                case 1:
                    PokemonController.getInstance().DisplayPokemons();
                    AdminMenu(); 
                    break;
                case 2:
                    System.out.println("       +------------------------+%n");
                    System.out.println("       |       New Pokemon      |%n");
                    System.out.println("       +------------------------+%n");
                    System.out.println(" ");
                    do {
                    
                        System.out.print("Insert a Name: ");
                        scanner.nextLine();
                        String pokemonName = scanner.nextLine();
                        System.out.print("Insert a Image: " );
                        String pokemonImg = scanner.nextLine();

                        int attack = rand.nextInt(20);
                        attack += 1;

                        int healt = rand.nextInt(max - min) + min;

                        PokemonController.getInstance().AddPokemon(pokemonName, pokemonImg, healt, attack);
                        System.out.println("");
                        System.out.println("Pokemon successfully added!!");
                        System.out.println("");
                        
                        
                        System.out.println("Do you want to add another pokemon?");
                        System.out.println("1.Yes");
                        System.out.println("2.No");
                        System.out.println("");
                        System.out.print("Option: ");
                        
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
                    PokemonController.getInstance().DisplayPokemons2();
                    System.out.println("Elije el ID del pokemon que desea editar");
                    try {
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        PokemonController.getInstance().FindPokemon(id);
                        
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

    public void PlayerMenu() {
        System.out.println("Hola player");
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

                System.out.format("       +----------------------------+%n");
                System.out.format("          " + texto +"     %n");
                System.out.format("       +----------------------------+%n");
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