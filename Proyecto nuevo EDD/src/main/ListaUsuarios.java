/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author andres
 */
public class ListaUsuarios {
    private NodoUsuarios head;
    private int lenght;

    public ListaUsuarios() {
        this.head = null;
        this.lenght = 0;
    }

    public NodoUsuarios getHead() {
        return head;
    }

    public void setHead(NodoUsuarios head) {
        this.head = head;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }
    
    public boolean vacio(){
        return getHead()== null;
    }
    
    
    
    
    
    
    
}
