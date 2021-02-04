/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import pojo.Patient;

/**
 *
 * @author danielmarchan
 */
public class Persistence {
    
     /*Un metodo que lee de un archivo objeto de tipo patient en binario
        y me devuelve un patient que ha leido*/
    public Patient cargar(File f) throws ClassNotFoundException {
        FileInputStream pat = null;     
        ObjectInputStream pati = null;
        Patient patient=null;

        try{    
                pat = new FileInputStream (f);     
                pati = new ObjectInputStream(pat);
                patient=(Patient)pati.readObject();
        }
        catch(IOException ex){
            System.out.println(ex);
        }
        /*Tiene que cerrar el flujo de datos*/
        finally{
            if(pati!=null){
               try{
               pati.close();
               }
               catch(IOException ex){
               System.out.println(ex);          
                }
            }    
        if(pat!=null){
              try{
                pat.close();}
              catch(IOException ex){
                  System.out.println(ex);}}
        }
        return patient; }


      
    /*Le paso un path y me tiene que guardar esa poblacion ahi*/
    public void guardar(File f,Patient patient){
        FileOutputStream pat = null;     
        ObjectOutputStream pati = null;    
      
        try{
            pat = new FileOutputStream (f);     
            pati = new ObjectOutputStream(pat);
            pati.writeObject(patient);
        }
      
        catch(IOException ex){
          System.out.println("Error en la escritura");
        }
      
        finally{
            if(pati!=null){
                try{
                    pati.close();
                    }
                catch(IOException ex){
                    System.out.println(ex);;
                }
             }
            if(pat!=null){
                try{
                    pat.close();}
                catch(IOException ex){
                    System.out.println(ex);
                }
            }
        }
    }
    
    
    
    
     /*El file se lee por pantalla es muy sencillo 
        Esto lo vamos a meter dentro del boton para cargar una poblacion 
    
            System.out.println("Introduzca el path del archivo que contiene la poblacion:");
            
            String nom=leer();
            f = new File(nom);
            
            if(!f.exists()){
                    System.out.println("Archivo inexistente");break;
            }
            
            else        
                    try{  
                        p=per.cargar(f);
                        System.out.println(p);break;
                    }
                    catch(ClassNotFoundException ex){
                        System.out.println("error en la lectura intente de nuevo");
                        break;
                    }       
            */
    
    
    /*Esto para guardar
    
    System.out.println("Escriba el nuevo path de su archivo:");
                String nuevo=leer();   
                f = new File(nuevo);
                per.guardar(f, p);
                System.out.println("Creado");
                System.out.println("\n");
    
    */
    
    
}


 
