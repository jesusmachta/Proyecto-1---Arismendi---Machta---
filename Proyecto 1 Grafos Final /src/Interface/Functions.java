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
 *
 * @author luisarismendi
 */

/**
 * Aca se declaran las nuevas variables con las cuales llamaremos a las interfaces graficas
 * @author andres
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
/**
 * Aca se lee el archivo txt y se retorna como texto de tipo string
 * @param direccion
 * @return 
 */
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
/**
 * aca recorremos el txt y separamos a los usuarios de las relaciones y retorna un texto de tipo String con los usuarios
 * @return 
 */
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
/**
 * Aca recorremos el txt y separamos a las relaciones de los usuarios y retorna un texto de tipo string con las relaciones
 * @return 
 */    
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
/**
 * Actualizamos el txt con los valores actualizados de los usuarios y las relaciones
 * y se pasa de parametros los usuarios y las relaciones
 * @param u
 * @param r
 * @return 
 */   
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

/**
 * Agregamos usuarios al archivo txt y se pasa de parametros el usuario y el ID 
 * @param usuario
 * @param id 
 */    
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
/**
 * Borramos usuarios del archivo txt y se pasa de parametro el usuario que queremos eliminar
 * @param usuario 
 */   
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
/**
 * Aca mostramos a los usuarios registrados en el txt y retorna un texto de tipo String con ellos
 * @return 
 */    
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
/**
 * Mostramos los IDS de los usuarios registrados en el txt y retorna un texto de tipo String con ellos
 * @return 
 */    
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
/**
 * Aca creamos vinculos entre usuarios y se pasa de parametro el ID del primer usuario , el ID del segundo usuario
 * Y sus años de amistad
 * @param a
 * @param b
 * @param c
 * @return 
 */    
    
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
/**
 * Mostramos la pestaña Cargar datos
 */
    
    public void CargarDatos(){
        main.setVisible(false);
        txt.setVisible(true);
    }

/**
 * esta funcion nos permite mostrar graficamente el grafo
 */
    
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

/**
 * Esta funcion nos muestra la interfaz grafica main
 */
    
    public void Main(){
        main.setVisible(true);
        
    }
/**
 * Esta funcion nos permite devolvernos a la interfaz grafica main
 */
    public void Volver(){
        txt.setVisible(false);
        show.setVisible(false);
        agregar.setVisible(false);
        borrar.setVisible(false);
        agregarA.setVisible(false);
        main.setVisible(false);
    }
/**
 * Esta funcion nos permite abrir la interfaz Mostrar Usuarios
 */   
    public void mostrar(){
        show.setVisible(true);
        main.setVisible(false);
    }
/**
 * Esta nos permite abrir la interfaz Agregar Usuarios
 */
    
    public void agregar(){
        main.setVisible(false);
        agregar.setVisible(true);
       
    }
    
/**
 * Esta nos abre la interfaz borrar usuarios
 */
    public void borrarU(){
        main.setVisible(false);
        borrar.setVisible(true);
        
    }
/**
 * Esta nos abre la interfaz grafica Borrar Usuarios
 */
    public void AgregarR(){
        main.setVisible(false);
        agregarA.setVisible(true);
        
    }
/**
 * Esta nos permite abrir la interfaz Mostrar BFS
 */
    
    public void MostrarBFS(){
        main.setVisible(false);
        bfs.setVisible(true);
    }
/**
 * Esta nos permite abrir la interfaz mostrar DFS
 */    
    public void MostrarDFS(){
        main.setVisible(false);
        dfs.setVisible(true);
    }
/**
 * Esta nos permite abrir la interfaz Mostrar puentes
 */    
    public void MostrarPuentes(){
        main.setVisible(false);
        puentes.setVisible(true);
    }
 /**
  * En esta funcion Obtenemos el ID de cada usuario y retornamos un Array de ellos
  * @param relaciones
  * @param i
  * @return 
  */   
    public String ObtenerIDUsuario(String relaciones, int i){
        String[] ids = relaciones.split(" ");
        return ids[i];
    }
/**
 * Obbtenemos la cantidad de IDS y retornamos un valor de tipo int con la cantidad
 * @param relaciones
 * @return 
 */    
    public int contarIDS(String relaciones){
        int n = 1;
        for (int i = 0; i < relaciones.length(); i++) {
            if (relaciones.charAt(i) == ' ') {
                n++;
            }
        }
        return n;
    }
/**
 * Aca realizamos el recorrido DFS y retornamos un texto de tipo con el recorrido que hace
 * @param i
 * @param listaAdy
 * @param visitados
 * @return 
 */
    
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

/**
 * Aca obtenemos el indice en donde se encuentra el usuario y pasamos de parametros un array de usuarios y el usuario que 
 * se quiere conseguir el id y retorna el indice
 * @param usuarios
 * @param nombre
 * @return 
 */
    
    public int ObtenerIndiceUsuario(String[] usuarios, String nombre){
        int n = usuarios.length;
        for(int i=0; i < n; i++){
            if(usuarios[i].startsWith(nombre)){
                return i;
            }
        }
        return -1;
    }
/**
 * Aca creamos la lista de adyacencia y la retornamos ya con sus valore asignados
 * @return 
 */    
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

/**
 * Aca obtenemos las islas por el recorrido dfs dentro de la lista de adyacencia y retornamos un string con las islas
 * @param listaAdy
 * @return 
 */    
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
/**
 * Aca recorremos la lista de adyacencia y obtenemos la cantidad de islas que contiene el grafo retornamos un int con lo que obtuvimos
 * @param listaAdy
 * @return 
 */
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
    
/**
 * Aca obtenemos las relaciones que son puentes en el grafo y retornamos un String con dicha relacion
 * @return 
 */
    
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
    
/**
 * 
 * @param amigos
 * @return 
 */
    
    public String eliminarPrimerID(String amigos){
        int start = amigos.indexOf(" ");
        if(start == -1){
            return "";
        } else {
            return amigos.substring(start + 1);
        }
    }
/**
 * Realizamos el recorrido bfs de la lista de abyacencia y retorna un String con el recorrido realizado
 * @param i
 * @param listaAdy
 * @param visitados
 * @return 
 */    
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
/**
 * Aca obtenemos las islas por el recorrido bfs y retornamos un String con el recorrido que hizo
 * @return 
 */    
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
 
/**
 * Aca creamos una lista que contiene a todos los usuarios con sus ids y retornamos dicha lista
 * @return 
 */    
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
/**
 * Creamos una lista con la cantidad de relaciones existentes en el txt y la retornamos
 * @return 
 */    
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
    
    

