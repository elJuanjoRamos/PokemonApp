
package controller;


import beans.Pokemon;

/**
 *
 * @author Juan José Ramos
 */
public class PokemonController {

    private static PokemonController instance;
    private Pokemon[] pokemons = new Pokemon[20];
   
    
    private String[] batallas = new String[100];
    
    
    
    
    private PokemonController(){}
    
    public static PokemonController getInstance(){
        if(instance == null){
            instance = new PokemonController();
        }
        return instance;
    }

    public void AddPokemon(String name, String img, Integer healthPoint, Integer attackPoint) {
        for (int i = 0; i < pokemons.length; i++) {
            if (pokemons[i] == null) {
                pokemons[i] = new Pokemon(i, name, img, healthPoint, attackPoint);
                break;
            } 
        }
    }

    public void DisplayPokemons() {
        String state = "";
        for (int i = 0; i < pokemons.length; i++) {

            if ( pokemons[i] != null ) {
                if(pokemons[i].getState()) {
                    state = "Available";
                } else {
                    state = "Not Available";
                }

                System.out.println(" " +    pokemons[i].getImg());
                String leftAlignFormat = "| %-15s | %-15s | %-15s |%n";
                System.out.format("+-----------------+-----------------+-----------------+%n");
                System.out.format("| Pokemon Data    |      Stats      |      Stats      |%n");
                System.out.format("+-----------------+-----------------+-----------------+%n");
                System.out.format(leftAlignFormat, "ID" , pokemons[i].getId(), pokemons[i].getImg());
                System.out.format(leftAlignFormat, "Name" , pokemons[i].getName(), "");
                System.out.format(leftAlignFormat, "State" , state, pokemons[i].getImg());
                System.out.format(leftAlignFormat, "Health Points" , pokemons[i].getHealthPoint(), "");
                System.out.format(leftAlignFormat, "Attack Points" , pokemons[i].getAttackPoint(), "");
                System.out.format("+-----------------+-----------------+%n");  

            } 
  
        }

       
    } 
    public void DisplayPokemons2() {
        String state = "";
        String leftAlignFormat = "| %-5s | %-20s | %-15s | %-15s |%n";
        System.out.format("+-------+----------------------+-----------------+-----------------+%n");
        System.out.format("| ID    |         Name         |    Healt Point  |   Attack Point  |%n");
        System.out.format("+-------+----------------------+-----------------+-----------------+%n");
                
        for (int i = 0; i < pokemons.length; i++) {

            if ( pokemons[i] != null ) {
                if(pokemons[i].getState()) {
                    state = "Available";
                } else {
                    state = "Not Available";
                }
                System.out.format(leftAlignFormat, pokemons[i].getId(), pokemons[i].getName(), pokemons[i].getHealthPoint(), pokemons[i].getAttackPoint());
                System.out.format("+-------+----------------------+-----------------+-----------------+%n");                
            } 
        } 
    }

    public void EditPokemon(Integer id, String name, Integer healthPoint, Integer attackPoint) {
        for ( int i = 0; i < pokemons.length; i++ ) {
            if ( i == id ) {
                Pokemon pokemon = pokemons[i];
                pokemon.setName(name);
                pokemon.setHealthPoint(healthPoint);
                pokemon.setAttackPoint(attackPoint);
            }
        }
    }
    
    public void FindPokemon(int id){
        String leftAlignFormat = "| %-5s | %-20s | %-15s | %-15s |%n";

        for ( int i = 0; i < pokemons.length; i++ ) {
            if ( i == id ) {
                Pokemon pokemon = pokemons[i];
                System.out.format("+-------+----------------------+-----------------+-----------------+%n");
                System.out.format("| ID    |         Name         |    Healt Point  |   Attack Point  |%n");
                System.out.format("+-------+----------------------+-----------------+-----------------+%n");
                System.out.format(leftAlignFormat, pokemon.getId(), pokemon.getName(), pokemon.getHealthPoint(), pokemon.getAttackPoint());
                System.out.format("+-------+----------------------+-----------------+-----------------+%n");                
            }
        }
    }

}