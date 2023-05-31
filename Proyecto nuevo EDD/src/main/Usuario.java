/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author andres
 */
public class Usuario {
    private String name;
    private int id;

    public Usuario(String name, int id) {
        this.name = name;
        this.id = id;
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
    
}
