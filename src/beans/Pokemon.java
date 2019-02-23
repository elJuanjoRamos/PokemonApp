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
    private String name;
    private String img;
    private Boolean state;
    private Integer healthPoint;
    private Integer attackPoint;

    // constructor
    public Pokemon(Integer id, String name, String img, Integer healthPoint, Integer attackPoint) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.state = true;
        this.healthPoint = healthPoint;
        this.attackPoint = attackPoint;
    }

    // Getter methods
    public Integer getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getImg() {
        return this.img;
    }
    public Boolean getState() {
        return this.state;
    }
    public Integer getHealthPoint() {
        return this.healthPoint;
    }
    public Integer getAttackPoint() {
        return this.attackPoint;
    }

    // Setter methods
    /*public void setId(Integer id) {
        this.id = id;
    }
    public void setImg(String img) {
        this.img = img;
    }
    */

    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setState(Boolean state) {
        this.state = state;
    }
    public void setHealthPoint(Integer healthPoint) {
        this.healthPoint = healthPoint;
    }
    public void setAttackPoint(Integer attackPoint) {
        this.attackPoint = attackPoint;
    }

}