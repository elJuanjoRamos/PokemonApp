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
import java.util.InputMismatchException;

/**
 *
 * @author Juan José Ramos
 */
public class Menu {

    /*Instancias*/
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();
    
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
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }
    

    
    
    
    public void OptionsMenu() {
                        System.out.println("                                  ,'\\\n" +
"\t\t    _.----.        ____         ,'  _\\   ___    ___     ____\n" +
"\t\t_,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.\n" +
"\t\t\\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |\n" +
"\t\t \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |\n" +
"\t\t   \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |\n" +
"\t\t    \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |\n" +
"\t\t     \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |\n" +
"\t\t      \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |\n" +
"\t\t       \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |\n" +
"\t\t        \\_.-'       |__|    `-._ |              '-.|     '-.| |   |\n" +
"\t\t                                `'                            '-._|");
               
                
             
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.format("\t\t\t╔════════════════════════════╗%n");
        System.out.format("\t\t\t║                 Pokemon App                ║%n");
        System.out.format("\t\t\t╚════════════════════════════╝%n");
        System.out.println(" ");
        System.out.println("Elige el numero de la opcion para continuar:");
        System.out.println("1.Acceder");
        System.out.println("2.Salir");
        System.out.println(" ");
        System.out.print("═\\Opcion: ");
        
        
        
        String option = scanner.nextLine();
        if(esNumero(option)) {
          switch (Integer.parseInt(option)) {
            case 1:
                
                scanner.nextLine();
                MainMenu();
                break;
            case 2:
                System.out.println("Gracias por participar");
            default:
                break;

            }    
        } else {
            System.out.println("");
            setTimeout("\u26A0" + "No puede introducir letras, por favor proporcione una opcion correcta", 2500);
            System.out.println();
            OptionsMenu();
        }
    }
    
    public void MainMenu() {

        System.out.format("\t\t\t╔════════════════════════════╗%n");
        System.out.format("\t\t\t║                Menu Principal              ║%n");
        System.out.format("\t\t\t╚════════════════════════════╝%n");
        System.out.println(" ");
        
        System.out.println("Ellige una opcion para continuar:");
        System.out.println("1.Administrador");
        System.out.println("2.Batalla con dos jugadores");
        System.out.print("═\\Opcion: ");
        
        String option1 = scanner.nextLine();
        
        if (esNumero(eliminarEspacios(option1))) {
            switch (Integer.parseInt(option1)) {
                case 1:
                    System.out.format("       +--------------------------+%n");
                    System.out.format("       |       Welcome Admin      |%n");
                    System.out.format("       +--------------------------+%n");
                    System.out.println(" ");
                    System.out.print("Password: ");
                    try {
                        String password = scanner.nextLine();
                        if (Integer.parseInt(eliminarEspacios(password)) == 201801262) {
                            AdminMenu();
                            
                        } else {
                            setTimeout("El Password no es correcto", 2500);
                            MainMenu();
                        }
                    } catch (NumberFormatException e) {
                        setTimeout("El Password no es correcto", 2500);
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
        } else {
            System.out.println("");
            setTimeout("\u26A0" + "No puede introducir letras, por favor proporcione una opcion correcta", 2500);
            System.out.println();
            MainMenu();
        }
        
    }
    
    public void AdminMenu() {
        
        System.out.println("Elige una opcion para continuar:");
        System.out.println("1.Lista de pokemon");
        System.out.println("2.Agregar Pokemon");
        System.out.println("3.Editar Pokemon");
        System.out.println("4.Reportes");
        System.out.println("5.Menu Principal");;
        System.out.println(" ");
        System.out.print("═\\Opcion: ");
        
        try {
            
            int option2 = scanner.nextInt();
            
            switch (option2) {
                case 1:
                    PokemonController.getInstancia().MostrarPokemon();
                    AdminMenu();
                    break;
                case 2:
                    System.out.println("       +------------------------+%n");
                    System.out.println("       |       Nuevo Pokemon    |%n");
                    System.out.println("       +------------------------+%n");
                    System.out.println(" ");
                    do {
                        
                        System.out.print("Ingrese un nombre: ");
                        scanner.nextLine();
                        String pokemonName = scanner.nextLine();
                        
                        int ataque = rand.nextInt(20);
                        ataque += 5;
                        
                        int vida = rand.nextInt(max - min) + min;
                        
                        PokemonController.getInstancia().AgregarPokemon(pokemonName, vida, ataque);
                        System.out.println("");
                        System.out.println("Pokemon Agregado Correctamente!!");
                        System.out.println("");
                        
                        System.out.println("Desea agregar otro pokemon?");
                        System.out.println("1.Si");
                        System.out.println("2.No");
                        System.out.println("");
                        System.out.print("═\\Opcion: ");
                        
                        option2 = scanner.nextInt();
                        
                    } while (option2 == 1);
                    AdminMenu();
                    
                    break;
                case 3:
                    System.out.println("           +----------------------------+");
                    System.out.println("           |       Editar a Pokemon     |");
                    System.out.println("           +---------------++-----------+");
                    System.out.println(" ");
                    System.out.println(" ");
                    PokemonController.getInstancia().MostrarPokemon();
                    
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("Elije el ID o el nombre del pokemon que desea editar");
                    System.out.println("");
                    System.out.print("═\\Pokemon: ");
                    scanner.nextLine();
                    String id = scanner.nextLine();
                    if (esNumero(id)) {
                        
                        Pokemon p = PokemonController.getInstancia().BuscarPokemon(Integer.parseInt(id));
                        System.out.println("");
                        
                        if (p != null) {
                            System.out.println("");
                            System.out.println("El pokemon que se va a editar es: " + p.getNombre());
                            System.out.print("Nuevo Nombre: ");
                            String nombre = scanner.nextLine();
                            
                            System.out.print("Nueva Vida: ");
                            String vida = scanner.nextLine();
                            System.out.print("Nuevo Ataque: ");
                            String ataque = scanner.nextLine();
                            
                            if (esNumero(vida, ataque) == true) {
                                if (Integer.parseInt(vida) != 0 && Integer.parseInt(ataque) != 0) {
                                    PokemonController.getInstancia().EditarPokemon(p.getId(), nombre, Integer.parseInt(vida), Integer.parseInt(ataque), true);
                                    System.out.println("");
                                    System.out.println("");
                                    System.out.println("Pokemon Editado Correctamente!!");
                                    System.out.println("");
                                    System.out.println("");
                                } else {
                                    System.out.println("");
                                    System.out.println("");
                                    System.out.println("\u26A0" + "T anto la vida como el ataque tiene que ser mayor a cero");
                                    System.out.println("");
                                    System.out.println("");
                                    
                                }                                
                            } else if (esNumero(vida, ataque) == false) {
                                System.out.println("");
                                System.out.println("");
                                System.out.println("\u26A0" + " La vida y el poder solo pueden ser numeros");
                                System.out.println("");
                                System.out.println("");
                                
                            }
                            
                            AdminMenu();
                            break;
                        } else {
                            System.out.println(" ");
                            System.out.println(" ");
                            System.out.println("No se encuentran coincidencias, por favor introduzca un numero valido");
                            AdminMenu();
                        }
                        
                    } else {
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println("\u26A0" + " Solo puede introducir numeros para seleccionar un pokemon");
                        MainMenu();
                        
                    }
                
                case 4:
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.format("\t\t\t╔════════════════════════════╗%n");
                    System.out.format("\t\t\t║                   Reportes                 ║%n");
                    System.out.format("\t\t\t╚════════════════════════════╝%n");
                    System.out.println(" ");

                    System.out.println("Elige una opcion para continuar:");
                    System.out.println("1.Registro de Partidas");
                    System.out.println("2.Estadisticas");
                    System.out.println("Otro Numero.Menu Principal");
                    System.out.println("");
                    System.out.print("═\\Opcion: ");
        
                    try {
                        int op = scanner.nextInt();
                        
                        switch(op) {
                            case 1:
                                BatallaController.getInstancia().MostrarDatosBatalla();
                            case 2: 
                                BatallaController.getInstancia().RegistroEstadistica();
                            
                            default:
                                scanner.nextLine();
                                MainMenu();
                                break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println("Solo se puede ingear numeros");
                        System.out.println(" ");
                        System.out.println(" ");
                        scanner.nextLine();
                        MainMenu();

                    }
        
                    
                case 5:
                    scanner.nextLine();
                    MainMenu();
                    
                default: 
                    scanner.nextLine();
                    MainMenu();
                    break;
            }
            
        } catch (InputMismatchException e) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Solo se puede ingear numeros");
            System.out.println(" ");
            System.out.println(" ");
            scanner.nextLine();
            MainMenu();
            
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
        System.out.println("");
        System.out.print("═\\Elija una opcion: ");
        
        try {
            playerOption = scanner.nextLine();
            
            switch (Integer.parseInt(eliminarEspacios(playerOption))) {
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
                        
                        while (true) {
                            
                            System.out.print("Por favor," + jugador1 + ", elija el Id del pokemon que desea utilizar: ");
                            playerOption = scanner.nextLine();
                            pokemonJugador1[0] = PokemonController.getInstancia().BuscarPokemon(Integer.parseInt(eliminarEspacios(playerOption)));
                            
                            if (pokemonJugador1[0] != null) {
                                
                                while (true) {
                                    System.out.print("Elija el segundo Pokemon: ");
                                    playerOption = scanner.nextLine();
                                    pokemonJugador1[1] = PokemonController.getInstancia().BuscarPokemon(Integer.parseInt(eliminarEspacios(playerOption)));
                                    if (pokemonJugador1[1] != null) {
                                        System.out.println(" ");
                                        System.out.println(" ");
                                        while (true) {
                                            System.out.print("Por favor," + jugador2 + ", elija el Id del pokemon que desea utilizar: ");
                                            playerOption = scanner.nextLine();
                                            pokemonJugador2[0] = PokemonController.getInstancia().BuscarPokemon(Integer.parseInt(eliminarEspacios(playerOption)));
                                            if (pokemonJugador2[0] != null) {
                                                while (true) {
                                                    System.out.print("Elija el segundo Pokemon: ");
                                                    playerOption = scanner.nextLine();
                                                    pokemonJugador2[1] = PokemonController.getInstancia().BuscarPokemon(Integer.parseInt(eliminarEspacios(playerOption)));
                                                    
                                                    if (pokemonJugador2[1] != null) {
                                                        
                                                        BatallaController.getInstancia().GenerarBatalla(pokemonJugador1, pokemonJugador2, jugador1, jugador2);
                                                        break;
                                                    } else {
                                                        System.out.println(" ");
                                                        System.out.println(" ");
                                                        System.out.println("\u26A0" + "No se encuentran coincidencias, por favor introduzca un numero valido");
                                                        
                                                    }
                                                }
                                            } else {
                                                System.out.println(" ");
                                                System.out.println(" ");
                                                System.out.println("\u26A0" + "No se encuentran coincidencias, por favor introduzca un numero valido");
                                                
                                            }
                                        }
                                        
                                    } else {
                                        System.out.println(" ");
                                        System.out.println(" ");
                                        System.out.println("\u26A0" + "No se encuentran coincidencias, por favor introduzca un numero valido");
                                        
                                    }
                                }
                                
                            } else {
                                System.out.println("");
                                System.out.println("");
                                System.out.println("\u26A0" + "No se encuentran coincidencias, por favor introduzca un numero valido");
                                
                            }
                        }
                        
                    } catch (NumberFormatException e) {
                        setTimeout("Solo se pueden introducir IDs para seleccionar un pokemon", 2500);
                        MainMenu();
                    }
                    
                    break;
                case 2:
                    MainMenu();
                    
                default:
                    scanner.nextLine();
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("Por favor elija una opcion valida");
                    System.out.println(" ");
                    System.out.println(" ");
                    MainMenu();
                    break;
            }
            
        } catch (NumberFormatException e) {
            setTimeout("Solo se puede ingresar numeros", 2500);
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
    
    public void setTimeout(String texto, int delay) {
        try {
            
            System.out.format("          " + texto + "     %n");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            
            Thread.sleep(delay);
        } catch (Exception e) {
            System.err.println(e);
        }
        
    }
    
    public static boolean esNumero(String cadena, String cadena2) {
        
        boolean resultado;
        
        try {
            Integer.parseInt(cadena);
            Integer.parseInt(cadena2);
            resultado = true;
        } catch (NumberFormatException e) {
            resultado = false;
        } catch (InputMismatchException a) {
            resultado = false;
        }
        
        return resultado;
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
