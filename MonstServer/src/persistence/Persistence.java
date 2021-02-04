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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import pojo.Data;
import pojo.Patient;
import pojo.UserInfo;
import pojo.Fecha;

/**
 *
 * @author danielmarchan
 */
public class Persistence {
    
     /*Un metodo que lee de un archivo objeto de tipo patient en binario
        y me devuelve un patient que ha leido*/
    public boolean cargar(UserInfo userInfo) throws ClassNotFoundException {
        FileInputStream pat = null;     
        ObjectInputStream pati = null;
        Patient patient=null;
        String id=userInfo.getUsername();
        String password=userInfo.getPassword();
        Boolean aux=false;
        try{    
                String archivo= id.concat("\\");
                File file= new File(archivo);
                if(file.exists()){
                    String archivo2= archivo.concat(id);
                    archivo2=archivo2.concat(".txt");
                    pat = new FileInputStream (archivo2);     
                    pati = new ObjectInputStream(pat);
                    patient=(Patient)pati.readObject();
                    if(patient.getUserpassword().equals(password)){
                        System.out.println("Funciona el cargar");
                        aux=true;             
                        //habría que expecificar el tipo de error
                    }else{ 
                        System.out.println("no concuerda la contraseña");
                        aux=false;
                    }
                }else{
                    System.out.println("no lee la carpeta");
                    aux=false;
                }
               
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
        return aux; }


      
    /*Le paso un path y me tiene que guardar ese paciente ahi*/
    public void guardar(String id,Patient patient){
        
       
        FileOutputStream pat = null;     
        ObjectOutputStream pati = null;    
      
        try{
            String path_1=id.concat("\\");
            File f1= new File(path_1);
            f1.mkdirs();
            String path= path_1.concat(id);
            path=path.concat(".txt");
            File f= new File(path);
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
     public Fecha generarFecha(){
            Date d = new Date();
            Calendar c = new GregorianCalendar(); 
            c.setTime(d);
            int dia, mes, annio;
            dia = c.get(Calendar.DATE);
            mes = c.get(Calendar.MONTH);
            annio = c.get(Calendar.YEAR);
            Fecha today=new Fecha(dia,mes,annio);
            return today;
     }
     
     public void guardardatos(String id, Data datos){
        FileOutputStream pat = null;     
        ObjectOutputStream pati = null;    
      
        try{
            String path_1=id.concat("\\");
            String dia, mes, annio;
            Fecha today=datos.getDom();
            dia = Integer.toString(today.getDia());
            mes = Integer.toString(today.getMes());
            annio = Integer.toString(today.getAño());
            String cadena=path_1+dia+"_"+mes+"_"+annio+".txt";
            File f= new File(cadena);
            pat = new FileOutputStream (f);     
            pati = new ObjectOutputStream(pat);
            pati.writeObject(datos);
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
    
}


 
