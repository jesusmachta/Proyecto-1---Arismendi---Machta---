/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *Clase listaRelaciones con sus respectivos getters, setters y funciones primitivas
 * @author jesusmachta
 */
public class ListaRelaciones {
    private NodoRelaciones head;
    private  int length;

    public ListaRelaciones() {
        this.head = null;
        this.length = 0;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    

    public NodoRelaciones getHead() {
        return head;
    }

    public void setHead(NodoRelaciones head) {
        this.head = head;
    }
    
    
    
    public boolean vacio(){
        return getHead()== null;
    }
    
    public void InsertarPrincipio(Relaciones element) {
        NodoRelaciones node = new NodoRelaciones(element);
        if (vacio()) {
            setHead(node);
        } else {
            node.setNext(getHead());
            setHead(node);
        }
        length++;
    }
    
    public void InsertarFinal(Relaciones element) {
        NodoRelaciones node = new NodoRelaciones(element);
        if (vacio()) {
            setHead(node);
        } else {
            NodoRelaciones pointer = getHead();
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(node);
        }
        length++;
    }
    
    
    public void InsertarEnIndice(Relaciones element) {
        NodoRelaciones node = new NodoRelaciones(element);
        if (vacio()) {
            setHead(node);
        } else {
            NodoRelaciones pointer = getHead();
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(node);
        }
        length++;
    }
    
    public void Imprimir(){
        NodoRelaciones pointer = getHead();
        while (pointer != null) {
            System.out.print(pointer.getElemento() + ", ");
            pointer = pointer.getNext();
        }
    }
    
}
