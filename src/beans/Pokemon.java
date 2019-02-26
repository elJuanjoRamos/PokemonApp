/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Juan José Ramos
 */
public class Pokemon {

    private Integer id;
    private String nombre;
    private String img;
    private Boolean estado;
    private Integer puntosVida;
    private Integer puntosAtaque;

    // constructor
    public Pokemon(Integer id, String nombre, String img, Integer puntosVida, Integer puntosAtaque) {
        this.id = id;
        this.nombre = nombre;
        this.img = img;
        this.estado = true;
        this.puntosVida = puntosVida;
        this.puntosAtaque = puntosAtaque;
    }
    
    public Pokemon(){
        
    }

    // Getter methods
    public Integer getId() {
        return this.id;
    }
    public String getNombre() {
        return this.nombre;
    }
    public String getImg() {
        return this.img;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    public Integer getPuntosVida() {
        return this.puntosVida;
    }
    public Integer getPuntosAtaque() {
        return this.puntosAtaque;
    }

    // Setter methods
    /*public void setId(Integer id) {
        this.id = id;
    }
    public void setImg(String img) {
        this.img = img;
    }
    */

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public void setPuntosVida(Integer puntosVida) {
        this.puntosVida = puntosVida;
    }
    public void setPuntosAtaque(Integer puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }

}