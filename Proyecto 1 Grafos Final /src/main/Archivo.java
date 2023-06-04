/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author andrespaz
 */


public class Archivo {
  
    
/**
 * Lee el txt y lo retorna como un String
 * @param direccion
 * @return 
 */
    
    public String leer(String direccion) {
        String text = "";

        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String a = "";
            String bfRead;
            int option = 0;
            while ((bfRead = bf.readLine()) != null) {
                
                if (bfRead.equalsIgnoreCase("Relaciones")) {
                    option = 1;
                    a = a + bfRead+"\n";
                    
                }else if(option ==0){
                    a = a + bfRead + "\n";
                }else{
                    a = a + bfRead + "\n";
                }
            }
            text = a;
        } catch (IOException e) {
            text = "";
            JOptionPane.showMessageDialog(null, "Error al leer el archivo");

        }

        return text;
    }
}

