
package controller;


import beans.Pokemon;

/**
 *
 * @author Juan José Ramos
 */
public class PokemonController {

    
    
    private Pokemon[] pokemons = new Pokemon[20];
   private String[] batallas = new String[100];
    
    
    private PokemonController(){}
    
    
    //Singleton
    private static PokemonController instance;
    public static PokemonController getInstancia(){
        if(instance == null){
            instance = new PokemonController();
        }
        return instance;
    }

    public void AgregarPokemon(String name, String img, Integer attackPoint, Integer healthPoint) {
        
        for (int i = 0; i < pokemons.length; i++) {
            if (pokemons[i] == null) {
                pokemons[i] = new Pokemon(i, name, img, healthPoint, attackPoint);
                break;
            } 
        }
    }

    public void MostrarPokemon() {
        String state = "";
        for (int i = 0; i < pokemons.length; i++) {

            if ( pokemons[i] != null ) {
                if(pokemons[i].getEstado()) {
                    state = "Disponible";
                } else {
                    state = "No Disponible";
                }

                System.out.println("\t " +    pokemons[i].getImg());
                String leftAlignFormat = "| %-15s | %-15s |%n";
                System.out.format("\t\t+-----------------+-----------------+%n");
                System.out.format("\t\t| Pokemon Data    |      Stats      |%n");
                System.out.format("\t\t+-----------------+-----------------+%n");
                System.out.format("\t\t" +leftAlignFormat, "ID" , ""+ pokemons[i].getId());
                System.out.format("\t\t" +leftAlignFormat, "Nombre" , ""+ pokemons[i].getNombre());
                System.out.format("\t\t" +leftAlignFormat, "Estado" , ""+ state);
                System.out.format("\t\t" +leftAlignFormat, "Puntos Vida" ,""+ pokemons[i].getPuntosVida());
                System.out.format("\t\t" +leftAlignFormat, "Puntos Ataque" ,""+ pokemons[i].getPuntosAtaque());
                System.out.format("\t\t+-----------------+-----------------+%n");  

            } 
        }
    } 
    

    public void EditarPokemon(Integer id, String nombre, Integer puntosVida, Integer puntosAtaque, boolean estado) {
        for ( int i = 0; i < pokemons.length; i++ ) {
            if ( i == id ) {
                Pokemon pokemon = pokemons[i];
                pokemon.setNombre(nombre);
                pokemon.setPuntosVida(puntosVida);
                pokemon.setPuntosAtaque(puntosAtaque);
                pokemon.setEstado(estado);
            }
        }
    }
    
    public Pokemon BuscarPokemon(int id){
        Pokemon pokemon = new Pokemon();
        for ( int i = 0; i < pokemons.length; i++ ) {
            try {
                if ( i == id ) {
                    pokemon = pokemons[i];
                    break;    
                }
            } catch(NullPointerException e) {
                System.out.println("Ningun pokemon coincide con las especificaciones");
                return null;
            }
        }
        return pokemon;
    }
}