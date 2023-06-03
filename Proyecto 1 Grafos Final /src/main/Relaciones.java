/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *Clase Relaciones con sus respetivos getters y setters
 * parametos ID usuario1, ID usuario2 y años de amistad
 * @author andres
 */
public class Relaciones {
    private int id;
    private int id2;
    private int años;

    public Relaciones(int id, int id2, int años) {
        this.id = id;
        this.id2 = id2;
        this.años = años;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public int getAños() {
        return años;
    }

    public void setAños(int años) {
        this.años = años;
    }
    
    
    
    
    
}
