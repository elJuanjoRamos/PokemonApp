
package principal;

import controller.BatallaController;
import java.io.IOException;
import java.util.Random;

import beans.*;
import controller.*;
import menu.Menu;


/**
 *
 * @author Juan José Ramos
 */
public class Principal {
    
    public static void main(String[] args) throws IOException {
        

        Random rand = new Random();
        PokemonController.getInstancia().cargarImages();
        PokemonController.getInstancia().AgregarPokemon("pikachu",  rand.nextInt(15) + 5 , rand.nextInt(50) + 50);
        PokemonController.getInstancia().AgregarPokemon("charmander", rand.nextInt(15) +5, rand.nextInt(50) + 50);
        PokemonController.getInstancia().AgregarPokemon("diglett", rand.nextInt(15) +5, rand.nextInt(50) + 50);
        PokemonController.getInstancia().AgregarPokemon("arcanine", rand.nextInt(15) +5, rand.nextInt(50) + 50);
        PokemonController.getInstancia().AgregarPokemon("squirtle", rand.nextInt(15) +5, rand.nextInt(50) + 50);
        PokemonController.getInstancia().AgregarPokemon("bulbasaur", rand.nextInt(15) +5, rand.nextInt(50) + 50);
        PokemonController.getInstancia().AgregarPokemon("pichu", rand.nextInt(15) + 5 , rand.nextInt(50) + 50);
        PokemonController.getInstancia().AgregarPokemon("raichu", rand.nextInt(15) + 5 , rand.nextInt(50) + 50);

        
        Menu.getInstance().OptionsMenu();
        
        

    }
}