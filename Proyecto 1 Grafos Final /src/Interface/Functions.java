/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import main.Grafo;
import main.ListaAdy;
import main.ListaUsuarios;
import main.Usuario;
import main.ListaRelaciones;
import main.NodoRelaciones;
import main.NodoUsuarios;
import main.Relaciones;

import main.main;
import org.graphstream.ui.view.Viewer;

/**
 * Aca se declaran las nuevas variables con las cuales llamaremos a las interfaces graficas
 * @author andrespaz, jesusmachta, luisarismendi
 */

public class Functions {
    Main main = new Main();
    CargarTxt txt = new CargarTxt();
    MostrarUsuarios show = new MostrarUsuarios();
    AgregarUsuario agregar = new AgregarUsuario();
    BorrarUsuario borrar = new BorrarUsuario();
    AgregarAmistades agregarA = new AgregarAmistades();
    MostrarDFS dfs = new MostrarDFS();
    MostrarBFS bfs = new MostrarBFS();
    MostrarPuentes puentes = new MostrarPuentes();

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
        String[]arrayR = r.split("\n");
        
        String a = "Usuarios \n";
        String id = "";
                
        int p = 1;
        int y = 1;
        //System.out.println("arrayU= " + arrayU[4]);
        for (int i = 1; i < arrayU.length; i++) {
            String []g = arrayU[i].split(",");
            
            y +=1;
            if(arrayU[i].contains(user)){   
                id = g[0];
                JOptionPane.showMessageDialog(null, "Usuario eliminado con exito");
            }else{
                a += arrayU[i] + "\n";
                p +=1;
            }  
        }
        if(y==p){
            JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado o fue elimando anteriormente");
        }
        
        String r2 = "Relaciones \n";
        
        for (int i = 1; i < arrayR.length; i++) {            
            if(!arrayR[i].contains(id)){   
                r2 += arrayR[i] + "\n";
            }  
        }
        
        f.ActualizarTxt(a,r2);
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
    
    public String MostrarIDS(){
        Functions f = new Functions();
        String u = f.SepararUsuarios();
        String a = "";
        String [] arrayU = u.split("\n");
        for (int i = 1; i < arrayU.length; i++) {
            String [] h = arrayU[i].split(",");
            a += h[0] + "\n";
            
        }
        return a;
    }
    
    public String MostrarUsuariosID(){
        Functions f = new Functions();
        String u = f.SepararUsuarios();
        String a = "";
        String [] arrayU = u.split("\n");
        for (int i = 1; i < arrayU.length; i++) {
            String [] h = arrayU[i].split(",");
            a += "ID: " + h[0] + "  / " + h[1] +"\n";
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
    
    public void MostrarGrafo(){
        Graph g = new SingleGraph("Grafo");
         
        String direccion = "src//file//file.txt";
        String txt = leer(direccion);
        String[]arrayU = txt.split("\n");
        int i = 1;
        for (; i < arrayU.length; i++) {
            if(arrayU[i].contains("Relaciones")){
                break; 
            }
            String[] usuario = arrayU[i].split(", ");
            int id = Integer.parseInt(usuario[0]);
            g.addNode(Integer.toString(id)).setAttribute("ui.label", Integer.toString(id) + " - " + usuario[1]);
        }
        i = i+1;
        for(; i < arrayU.length; i++) {
            arrayU[i] = arrayU[i].replaceAll("\\s+","");
            String[] relacion = arrayU[i].split(",");
            g.addEdge(relacion[0] + relacion[1], relacion[0], relacion[1]).setAttribute("ui.label", relacion[2]);
        }
        
        g.setAttribute("ui.antialias");
        g.setAttribute("ui.stylesheet", "node{\n" + "size: 100px, 30px;\n fill-color: #add8e6;\n } edge{\n text-background-mode: plain; \n}");
        System.setProperty("org.graphstream.ui", "swing");
        
        Viewer viewer = g.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
    }
    
    public void Main(){
        main.setVisible(true);
        
    }
    
    public void Volver(){
        txt.setVisible(false);
        show.setVisible(false);
        agregar.setVisible(false);
        borrar.setVisible(false);
        agregarA.setVisible(false);
        main.setVisible(false);
    }
    
    public void mostrar(){
        show.setVisible(true);
        main.setVisible(false);
    }
    
    public void agregar(){
        main.setVisible(false);
        agregar.setVisible(true);
        
    }
    public void borrarU(){
        main.setVisible(false);
        borrar.setVisible(true);
        
    }
    public void AgregarR(){
        main.setVisible(false);
        agregarA.setVisible(true);
        
    }
    
    public void MostrarBFS(){
        main.setVisible(false);
        bfs.setVisible(true);
    }
    
    public void MostrarDFS(){
        main.setVisible(false);
        dfs.setVisible(true);
    }
    
    public void MostrarPuentes(){
        main.setVisible(false);
        puentes.setVisible(true);
    }
    
    public String ObtenerIDUsuario(String relaciones, int i){
        String[] ids = relaciones.split(" ");
        return ids[i];
    }
    
    public int contarIDS(String relaciones){
        int n = 1;
        for (int i = 0; i < relaciones.length(); i++) {
            if (relaciones.charAt(i) == ' ') {
                n++;
            }
        }
        return n;
    }
    
    public String DFS(int i, String[] listaAdy,  boolean[] visitados){
        String recorrido = ObtenerIDUsuario(listaAdy[i], 0)+ " ";
        visitados[i] = true;
       
        int n = contarIDS(listaAdy[i]) - 1;
        for(int j = 1; j < n+1; j++){
            String idAmigo = ObtenerIDUsuario(listaAdy[i], j);
            int indice = ObtenerIndiceUsuario(listaAdy, idAmigo); 
            if (!visitados[indice])
                recorrido += DFS(indice, listaAdy, visitados);
        }
        
        return recorrido;
    }
    
    public int ObtenerIndiceUsuario(String[] usuarios, String nombre){
        int n = usuarios.length;
        for(int i=0; i < n; i++){
            if(usuarios[i].startsWith(nombre)){
                return i;
            }
        }
        return -1;
    }
    
    public String[] crearListaAdyacencia(){
        String[] listaAdy = MostrarIDS().split("\n");
        String[] relaciones = SepararRelaciones().split("\n");
                
        int m = relaciones.length;
        for(int i=1; i < m; i++){
            String[] arco = relaciones[i].replaceAll("\\s+","").split(",");
            int indice1 = ObtenerIndiceUsuario(listaAdy, arco[0]);
            int indice0 = ObtenerIndiceUsuario(listaAdy, arco[1]);
            listaAdy[indice1] += " " + arco[1];
            listaAdy[indice0] += " " + arco[0];
        }
        
        return listaAdy;
    }
    
    public String IslasDFS(String[] listaAdy){
        String islas = "";
        
        int n = listaAdy.length;
        boolean[] recorridos = new boolean[n];
        for(int i=0; i < n; i++){
            recorridos[i] = false;
        }
        
        for (int i = 0; i < n; ++i) {
            if (!recorridos[i]) {
                islas += "Isla: ( " + DFS(i, listaAdy, recorridos) + ")\n";
            }
        }
           
        return islas;
    }
    
    public int numeroIslas(String[] listaAdy){
        String islas = IslasDFS(listaAdy);
        
        int lastIndex = 0;
        int numIslas = 0;

        while(lastIndex != -1){
            lastIndex = islas.indexOf("Isla",lastIndex);
            if(lastIndex != -1){
                numIslas ++;
                lastIndex += 5;
            }
        }
       
        return numIslas;
    }
    
    public String Puentes(){
       String puentesEncontrados = "";
       String[] listaAdy = crearListaAdyacencia();
       int numIslasAntes = numeroIslas(listaAdy);
       
        String[] relaciones = SepararRelaciones().split("\n");
        int m = relaciones.length;
        for(int i=1; i < m; i++){
            String[] arco = relaciones[i].replaceAll("\\s+","").split(",");
            int indice1 = ObtenerIndiceUsuario(listaAdy, arco[0]);
            int indice0 = ObtenerIndiceUsuario(listaAdy, arco[1]);
            
            String temp1 = listaAdy[indice1];
            String temp0 = listaAdy[indice0];
            
            listaAdy[indice1] = listaAdy[indice1].replace(arco[1],"").trim().replaceAll(" +", " ");
            listaAdy[indice0] = listaAdy[indice0].replace(arco[0],"").trim().replaceAll(" +", " ");

            
            int numIslasDespues = numeroIslas(listaAdy);
            
            listaAdy[indice1] = temp1;
            listaAdy[indice0] = temp0;
            
            if(numIslasDespues > numIslasAntes){
                puentesEncontrados += "Puente: (" + arco[0] + " " + arco[1] + " " + arco[2] + ")\n";
            }
        }
        
        return puentesEncontrados;
    }
    
    public String eliminarPrimerID(String amigos){
        int start = amigos.indexOf(" ");
        if(start == -1){
            return "";
        } else {
            return amigos.substring(start + 1);
        }
    }
    
    public String BFS(int i, String[] listaAdy,  boolean[] visitados){
        String recorrido = "";
        visitados[i] = true;
        String amigos = "";
        
        String idUsuario = ObtenerIDUsuario(listaAdy[i], 0);
        amigos += idUsuario;
        int n = contarIDS(amigos);
        while (n > 0){
            String amigo = ObtenerIDUsuario(amigos, 0);
            recorrido +=  amigo + " ";
            amigos = eliminarPrimerID(amigos);
            
            int indiceUsuario = ObtenerIndiceUsuario(listaAdy, amigo);
            int cantidadAmigos = contarIDS(listaAdy[indiceUsuario]) - 1;
            for(int j = 1; j < cantidadAmigos + 1; j++){
                String idAmigo = ObtenerIDUsuario(listaAdy[indiceUsuario], j);
                int indiceAmigo = ObtenerIndiceUsuario(listaAdy, idAmigo); 
                if (!visitados[indiceAmigo]){
                    amigos += idAmigo + " ";
                    visitados[indiceAmigo] = true;
                }
            }
            n = contarIDS(amigos) - 1;
        }
        
        return recorrido;
    }
    
    public String IslasBFS(){
        String islas = "";
        String[] listaAdy = crearListaAdyacencia();
        
        int n = listaAdy.length;
        boolean[] recorridos = new boolean[n];
        
        for (int i = 0; i < n; ++i) {
            if (!recorridos[i]) {
                islas += "Isla: ( " + BFS(i, listaAdy, recorridos) + ")\n";
            }
        }

        return islas;
    }
     
    public ListaUsuarios Usuarios(){
        Functions f = new Functions();
        String r = SepararUsuarios();
        String[] arrayU = r.split("\n");
        ListaUsuarios list = new ListaUsuarios();
        for (int i = 1; i < arrayU.length; i++) {
            String g = arrayU[i];
            String [] k = g.split(",");
            int a = Integer.parseInt(k[0]);
            Usuario usuario = new Usuario(k[1],a);
            list.InsertarFinal(usuario);
   
        }
        return list;
        
    }
    
    public ListaRelaciones Relaciones(){
        Functions f = new Functions();
        String r = f.SepararRelaciones();
        String[] arrayU = r.split("\n");
        ListaRelaciones list = new ListaRelaciones();
        for (int i = 1; i < arrayU.length; i++) {
            String g = arrayU[i];
            String l = g.replace(" ", "");
            String [] k = l.split(",");
            int a = Integer.parseInt(k[0]);
            int b = Integer.parseInt(k[1]);
            int c = Integer.parseInt(k[2]);
            Relaciones rela = new Relaciones(a,b,c);
            list.InsertarFinal(rela);
            

    }
        return list;
}
    
    
    public void LlenarListas(){
        
        ListaUsuarios list = Usuarios();
        
        NodoUsuarios pointer = list.getHead();
        
        ListaRelaciones list1 = Relaciones();
        
        ListaAdy list3 = new ListaAdy();
        NodoRelaciones pointer1;
        for (int i = 0; i < list.getLenght(); i++) {
            pointer1 = list1.getHead();
            int r = pointer.getElemento().getId();
            for (int j = 0; j < list1.getLength(); j++) {
                int e = pointer1.getElemento().getId();
                if(r == e){
                    list3.insertFinal(pointer1.getElemento().getId2());   
                }
                pointer1 = pointer1.getNext();
                
                
            }
            pointer.getElemento().setList(list3);
            pointer = pointer.getNext();
        }
        
    }
    
    
}
    
    

