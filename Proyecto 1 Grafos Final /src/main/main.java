/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import Interface.Functions;
import javax.swing.JOptionPane;

/**
 *Clase main en la cual comienza la ejecucion del programa 
 * @author andrespaz
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Archivo ar = new Archivo();
        String direccion = ".//src//file//file.txt";
        String InfoFile = ar.leer(direccion);
        //System.out.println("InfoFile = " + InfoFile);
        String[] array = InfoFile.split("\n");
        Functions f = new Functions();
        //f.AgregarUsuario("andres", 132);
        //f.BorrarUsuario("andres");
        //f.MostrarUsuarios();
        //f.crearRelaciones("121","232","5");
        f.Main();
        // f.Relaciones();
        f.LlenarListas();
        
        }
}
   
