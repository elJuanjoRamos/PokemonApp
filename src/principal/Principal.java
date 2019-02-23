
package principal;

import java.io.IOException;

import controller.PokemonController;
import menu.Menu;

/**
 *
 * @author Juan José Ramos
 */
public class Principal {
    
    public static void main(String[] args) throws IOException {

         String img =
            " #&\n " +                                                
          " %@@\n " +                                               
         " &@@(.\n " +                                             
        " %&....                                        / .\n " +    
        " .....                     */#@@@@&&&       ..    / \n " +  
       " *....,                /......@@@@@@.      *.     .. \n " +  
       " (....*            (.........@@@@/       /.... ...../\n " +  
       " (...      .....,...........@%         (............*\n " +  
       " ,       .# @*.........,(.           /...............\n "  +  
     " (//  ......@@%(.......,             *.................\n " +  
    " *@@.......,.....**/,.....          .,..............,,  \n " +  
   " ,,..*(#((*....***/(.,...         (.............,.\n " +       
    " *(....#(((%....(///(.....,         /.........,.\n " +          
    " //*....#/*(......,......../         (,.,,,*\n " +              
      " /......,...........(//,../         (,,(\n " +                
      " .//,.............%.,.(....(        (***(\n " +               
" /(, ...................*,/,,.....*.   /******,\n " +               
" ,*.....................*.........../ *****/\n " +                  
" * ........*........................./  /**#\n " +                  
           " *.........................(. *(((*      \n " +          
           " ...........................,#(((                \n " +  
            " ,........................,,((,                 \n " +  
            " *........................,,**                  \n " +  
            " *......................,,,,/                   \n " +  
             " /......,,,,,,,,,,,,,,,,,,,/                   \n " +   
               " (,,,,,*(      */,,,,,,/(                    \n " +  
                  " (*/,             (//*                    \n " +  
                   " %,.              (,( \n ";

        // Insert pokemon
        PokemonController.getInstance().AddPokemon("pikachu", img, 100, 150);
        PokemonController.getInstance().AddPokemon("charmander", "true", 115, 35);
        PokemonController.getInstance().AddPokemon("charizard", "true", 10, 40);
        PokemonController.getInstance().AddPokemon("ponita", "true", 120, 30);
        PokemonController.getInstance().AddPokemon("pikachu 2", "false", 0, 150);

        Menu.getInstance().OptionsMenu();
        
        


        
        
        
        


 

/*
        PokemonController.getInstance().DisplayPokemons();

        PokemonController.getInstance().EditPokemon(4, "fffff", 69, 69);

        PokemonController.getInstance().DisplayPokemons();*/
    }
}