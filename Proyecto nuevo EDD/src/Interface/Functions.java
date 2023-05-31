/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import main.ListaUsuarios;
import main.Usuario;

import main.main;
/**
 *
 * @author andres
 */
public class Functions {
    Main main = new Main();
    CargarTxt txt = new CargarTxt();
    MostrarUsuarios show = new MostrarUsuarios();
    AgregarUsuario agregar = new AgregarUsuario();
    BorrarUsuario borrar = new BorrarUsuario();
    AgregarAmistades agregarA = new AgregarAmistades();
    
    
    public String leer(String direccion){
        
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
    
    public String SepararUsuarios(){
        
        Functions f = new Functions();
        String direccion = "src//file//file.txt";
        String txt = f.leer(direccion);
        String usuarios = "";
        String[]arrayU = txt.split("\n");
        for (int i = 0; i < arrayU.length; i++) {

            if(arrayU[i].contains("Relaciones")){
                break; 
            }usuarios +=  arrayU[i] + "\n";
                  
                
                
            }
        //System.out.println(usuarios);
        return usuarios;
        }
    
    public String SepararRelaciones(){
        Functions f = new Functions();
        String direccion = "src//file//file.txt";
        String txt = f.leer(direccion);
        String relaciones = "";
        String[]arrayR = txt.split("\n");
        int cont = 1;
        for (int i = 1; i < arrayR.length; i++) {
            //
            cont ++;
            if(arrayR[i].contains("Relaciones")){ 
                break;
            } 
        }
        for (int j = cont-1; j < arrayR.length; j++) {
            relaciones += arrayR[j] + "\n";
            
        }
        
        
        return relaciones;
    }
    
    public String ActualizarTxt(String u, String r){
        File Old_File=new File("src//file//file.txt");
        Old_File.delete();
        File New_File=new File("src//file//file.txt");
        String a = u + r;
        //System.out.println(a);

        try {
            try (FileWriter b = new FileWriter(New_File, false)) {
                b.write(a);
            }
        } catch (IOException e) {
        }
        return a;
    }

    
    public void AgregarUsuario(String usuario,int id){
        Functions f = new Functions();
        String p = String.valueOf(id);
        String u = f.SepararUsuarios();
        String r = f.SepararRelaciones();
        if(u.contains(usuario) || r.contains(p)){
           JOptionPane.showMessageDialog(null, "El usuario ya esta registrado");
        }else{
            u += id + ", @" + usuario + "\n";
            String j = f.ActualizarTxt(u, r);
            JOptionPane.showMessageDialog(null, "Usuario registrado con exito");

        }
        
    }
    
    public void BorrarUsuario(String usuario){
        String user = "@" + usuario;
       
        Functions f = new Functions();
        String u = f.SepararUsuarios();
        String r = f.SepararRelaciones();
        
        String[]arrayU = u.split("\n");
        
        
        String a = "Usuarios \n";
        
        int p = 1;
        int y = 1;
        //System.out.println("arrayU= " + arrayU[4]);
        for (int i = 1; i < arrayU.length; i++) {
            String []g = arrayU[i].split(",");
            
            y +=1;
            if(arrayU[i].contains(user)){   
                JOptionPane.showMessageDialog(null, "Usuario eliminado con exito");
            }else{
                a += arrayU[i] + "\n";
                p +=1;
            }  
        }
        if(y==p){
            JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado o fue elimando anteriormente");
        }
        
        f.ActualizarTxt(a,r);
       
        
    }
    
    public String MostrarUsuarios(){
        Functions f = new Functions();
        String u = f.SepararUsuarios();
        String a = "";
        String [] arrayU = u.split("\n");
        for (int i = 1; i < arrayU.length; i++) {
            String [] h = arrayU[i].split(",");
            a += h[1] + "\n";
            
        }
        return a;
    }
    
    public String crearRelaciones(String a,String b,String c){
        Functions f = new Functions();
        String r = f.SepararRelaciones();
        String u = f.SepararUsuarios();
        String [] arrayR = r.split("\n");
        int g = 1;
        for (int i = 1; i <arrayR.length ; i++) {
            if(arrayR[i].contains(a) || arrayR[i].contains(b)){
                r += a +", " + b + ", " + c + "\n";  
                break;
            }else{
                g++;
            }  
        }
        if(g==arrayR.length){
            JOptionPane.showMessageDialog(null, "No estan registrados los usuarios con esos id");
        }else{
            JOptionPane.showMessageDialog(null, "Relacion creada con exito");
        }
        f.ActualizarTxt(u, r);
        
        return r;
    }
    
    public void CargarDatos(){
        main.setVisible(false);
        txt.setVisible(true);
        
        
    }
    
    public void Main(){
        main.setVisible(true);
        
    }
    
    public void Volver(){
        txt.setVisible(false);
        main.setVisible(true);
        show.setVisible(false);
        agregar.setVisible(false);
    }
    
    public void mostrar(){
        show.setVisible(true);
        main.setVisible(false);
    }
    
    public void agregar(){
        agregar.setVisible(true);
        main.setVisible(false);
    }
    public void borrarU(){
        borrar.setVisible(true);
        main.setVisible(false);
    }
    public void AgregarR(){
        agregarA.setVisible(true);
        main.setVisible(false);
    }
    
    
}
