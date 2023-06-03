/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *Clase usuario con sus respetivos getters y setters, parametros
 * nombre del usuario, el ID y la lista de adyacencia que contiene cada usuario
 * @author andres
 */
public class Usuario {
    private String name;
    private int id;
    private ListaAdy list;

    public Usuario(String name, int id) {
        this.name = name;
        this.id = id;
        this.list = new ListaAdy();
    }

    public Usuario() {
    }
    

    public String getName() {
        return name;
    }

    public void setUsuario(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ListaAdy getList() {
        return list;
    }

    public void setList(ListaAdy list) {
        this.list = list;
    }
    
    
    
}
