/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *Clase Lista Usuarios con sus getters, setters y funciones primitivas
 * @author andres
 */
public class ListaUsuarios {
    private NodoUsuarios head;
    private int length;

    public ListaUsuarios() {
        this.head = null;
        this.length = 0;
    }

    public NodoUsuarios getHead() {
        return head;
    }

    public void setHead(NodoUsuarios head) {
        this.head = head;
    }

    public int getLenght() {
        return length;
    }

    public void setLenght(int lenght) {
        this.length = lenght;
    }
    
    public boolean vacio(){
        return getHead()== null;
    }
    
    
    public void InsertarPrincipio(Usuario element) {
        NodoUsuarios node = new NodoUsuarios(element);
        if (vacio()) {
            setHead(node);
        } else {
            node.setNext(getHead());
            setHead(node);
        }
        length++;
    }
    
    public void InsertarFinal(Usuario element) {
        NodoUsuarios node = new NodoUsuarios(element);
        if (vacio()) {
            setHead(node);
        } else {
            NodoUsuarios pointer = getHead();
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(node);
        }
        length++;
    }
    
    
    public void InsertarEnIndice(Usuario element) {
        NodoUsuarios node = new NodoUsuarios(element);
        if (vacio()) {
            setHead(node);
        } else {
            NodoUsuarios pointer = getHead();
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(node);
        }
        length++;
    }
    
    public void Imprimir(){
        NodoUsuarios pointer = getHead();
        while (pointer != null) {
            System.out.print(pointer.getElemento() + ", ");
            pointer = pointer.getNext();
        }
    }
    
    
    
    
    
    
    
}
