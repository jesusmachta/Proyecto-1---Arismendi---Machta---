/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *Clase nodo usuario con sus respectivos getters y setters
 * @author andrespaz
 */
public class NodoUsuarios {
    private Usuario elemento;
    private NodoUsuarios next;

    public NodoUsuarios(Usuario elemento) {
        this.elemento = elemento;
        this.next = null;
    }

    public Usuario getElemento() {
        return elemento;
    }

    public void setElemento(Usuario elemento) {
        this.elemento = elemento;
    }

    public NodoUsuarios getNext() {
        return next;
    }

    public void setNext(NodoUsuarios next) {
        this.next = next;
    }
    
    
    
    
}
