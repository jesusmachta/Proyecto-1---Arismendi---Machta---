/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *Clase nod relaciones con sus getters y setters
 * @author andres
 */
public class NodoRelaciones {
    private Relaciones elemento;
    private NodoRelaciones next;

    public NodoRelaciones(Relaciones elemento) {
        this.elemento = elemento;
        this.next = null;
    }

    public Relaciones getElemento() {
        return elemento;
    }

    public void setElemento(Relaciones elemento) {
        this.elemento = elemento;
    }

    public NodoRelaciones getNext() {
        return next;
    }

    public void setNext(NodoRelaciones next) {
        this.next = next;
    }
    
    
    
    
}
