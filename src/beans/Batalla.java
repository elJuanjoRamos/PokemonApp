/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.Pokemon;
/**
 *
 * @author Juan José Ramos
 */
public class Batalla {
    
    private int idBatalla;
    private String jugador1;
    private String jugador2;
    private Pokemon[] pokemonJugador1;
    private Pokemon[] pokemonJugador2;
    private String ganador;
    private int golpesPokemon1;
    private int golpesPokemon2;
    private int ataquesPokemon1;
    private int ataquesPokemon2;
    private int golpesPokemon3;
    private int golpesPokemon4;
    private int ataquesPokemon3;
    private int ataquesPokemon4;
    private int turnoJugador1;
    private int turnoJugador2;
    //Constructor
    public Batalla(int id, String jugador1, String jugador2, Pokemon[] pokemonJugador1, Pokemon[] pokemonJugador2, String ganador, int cantidadGolpesPokemon1, 
            
            int cantidadGolpesPokemon2, int ataquesRecibidosPokemon1, int ataquesRecibidosPokemon2, int cantidadGolpesPokemon3, int cantidadGolpesPokemon4,
            int ataquesRecibidosPokemon3, int ataquesRecibidosPokemon4, int turnoJugador1, int turnoJugador2){
        this.idBatalla = id;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.pokemonJugador1 = pokemonJugador1;
        this.pokemonJugador2 = pokemonJugador2;
        this.ganador = ganador;
        this.golpesPokemon1 = cantidadGolpesPokemon1;
        this.golpesPokemon2 = cantidadGolpesPokemon2;
        this.golpesPokemon3 = cantidadGolpesPokemon3;
        this.golpesPokemon4 = cantidadGolpesPokemon4;
        this.ataquesPokemon1 = ataquesRecibidosPokemon1;
        this.ataquesPokemon2 = ataquesRecibidosPokemon2;
        this.ataquesPokemon3 = ataquesRecibidosPokemon3;
        this.ataquesPokemon4 = ataquesRecibidosPokemon4;
        this.turnoJugador1 = turnoJugador1;
        this.turnoJugador2 =  turnoJugador2;
    }
    
    //Getters
    
    public Integer getId() {
        return this.idBatalla;
    }
    public String getJugador1() {
        return this.jugador1;
    }
    public String getJugador2() {
        return this.jugador2;
    }
    public Pokemon[] getPokemonJugador1() {
        return this.pokemonJugador1;
    }
    public Pokemon[] getPokemonJugador2() {
        return this.pokemonJugador2;
    }
    public String getGanador() {
        return this.ganador;
    }
    public int getGolpesPokemon1() {
        return this.golpesPokemon1;
    }
     
    public int getGolpesPokemon2() {
        return this.golpesPokemon2;
    }
    public int getGolpesPokemon3() {
        return this.golpesPokemon3;
    }
    public int getGolpesPokemon4() {
        return this.golpesPokemon4;
    }
    
    public int getAtaquesPokemon1() {
        return this.ataquesPokemon1;
    }
    public int getAtaquesPokemon2() {
        return this.ataquesPokemon2;
    }
    public int getAtaquesPokemon3() {
        return this.ataquesPokemon3;
    }
    public int getAtaquesPokemon4() {
        return this.ataquesPokemon4;
    }
    
    public int getTurnoJugador1(){
        return this.turnoJugador1;
    }
    public int getTurnoJugador2(){
        return this.turnoJugador2;
    }
    //Setters
    public void setId(int id) {
         this.idBatalla = id;
    }
    
    public void setJugador1(String jugador1) {
         this.jugador1 = jugador1;
    }
    
    public void setJugador2(String jugador2) {
         this.jugador2 = jugador2;
    }
    public void setPokemonJugador1( Pokemon[] pokemonJugador1 ) {
       this.pokemonJugador1 = pokemonJugador1;
    }
    public void setPokemonJugador2( Pokemon[] pokemonJugador2 ) {
        this.pokemonJugador2 = pokemonJugador2;
    }
    public void setGanador(String ganador) {
       this.ganador = ganador;
    }
    
    public void setGolpesPokemon1( int golpes ) {
        this.golpesPokemon1 = golpes;
    }
    public void setGolpesPokemon2( int golpes ) {
        this.golpesPokemon2 = golpes;
    }
    public void setGolpesPokemon3( int golpes ) {
        this.golpesPokemon3 = golpes;
    }
    public void setGolpesPokemon4( int golpes ) {
        this.golpesPokemon1 = golpes;
    }
    public void setAtaquesPokemon1( int ataques ) {
        this.ataquesPokemon1 = ataques;
    }
    public void setAtaquesPokemon2( int ataques ) {
        this.ataquesPokemon2 = ataques;
    }
    public void setAtaquesPokemon3( int ataques ) {
        this.ataquesPokemon3 = ataques;
    }
    public void setAtaquesPokemon4( int ataques ) {
        this.ataquesPokemon4 = ataques;
    }
    
    public void setTurnoJugador1( int turno ) {
        this.turnoJugador1 = turno;
    }
    public void setTurnoJugador2( int turno ) {
        this.turnoJugador2 = turno;
    }
}
