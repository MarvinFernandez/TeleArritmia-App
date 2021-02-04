/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterserver;


import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.Persistence;
import pojo.Confirmation;
import pojo.Data;
import pojo.Patient;
import pojo.UserInfo;
import pojo.Window;

/**
 *
 * @author danielmarchan
 */
public class MonsterServer {

    static ServerSocket serverSocket = null ;
    static Socket socket = null;
    static OutputStream output =  null;
    static ObjectOutputStream objectOutput = null;
    static InputStream input =  null;
    static ObjectInputStream objectInput = null;
    static Object tmp;
    static Confirmation confirm = new Confirmation();
    static UserInfo userinfo = new UserInfo();
    static Boolean read_login = FALSE;
    static Data data = new Data();
    static Window window = new Window();
    static Patient patient = new Patient();
    static Persistence persitence= new Persistence();
    
    public static void main(String[] args) {
        
        try {
            serverSocket = new ServerSocket(9000);
            socket = serverSocket.accept();
            System.out.println("Connection client created");
            
            output = socket.getOutputStream();
            input = socket.getInputStream();
            
            objectOutput = new ObjectOutputStream(output);
            objectInput = new ObjectInputStream(input);            
        
         } catch (IOException ex) {
            Logger.getLogger(MonsterServer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("problemas socket");
        }
        
        
     
        try {
            System.out.println("Antes del bucle");
            while((tmp = objectInput.readObject())!= null){
                System.out.println("Entramos al bucle de read Object tipo ventana");
                window = (Window) tmp;
                System.out.println(window);
                if((window.getWindow().equals(Window.Windows_type.STOP))||
                        (window.getWindow().equals(Window.Windows_type.LOGIN))||
                        (window.getWindow().equals(Window.Windows_type.RECORDING))||
                        (window.getWindow().equals(Window.Windows_type.REGISTER))
                        ){
                    System.out.println("tenemos un objeto window");
                    break;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MonsterServer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("problems reading object");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MonsterServer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error reading window");
        }
        
        
        switch(window.getWindow()){
            case LOGIN:
                read_login = TRUE;
                while(read_login){
                try {
                    System.out.println("Estamos en la ventana de login");
                    while((tmp = objectInput.readObject())!= null){
                        read_login = FALSE;
                        System.out.println("Entra al bucle");
                        userinfo = (UserInfo) tmp;
                        System.out.println(userinfo);
                        if(persitence.cargar(userinfo)){
                            System.out.println("Cargado!");
                            confirm.setConfirm(Boolean.TRUE);
                        }
                        else{
                            System.out.println("es falso");
                            confirm.setConfirm(Boolean.FALSE);
                            break;
                        } 
                    }
                    
                } catch (ClassNotFoundException ex) {
                    System.out.println("Problems reading object");
                    Logger.getLogger(MonsterServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    catch(IOException ex){
                    System.out.println("reciving object problems");  
                    }
                }
                
                try {
                    System.out.println(confirm);
                    objectOutput.writeObject(confirm);
                    objectOutput.flush();
                } catch (IOException ex) {
                    Logger.getLogger(MonsterServer.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("sending objects problems");
                }
                break;
                
            case REGISTER:
                System.out.println("Estamos en la ventana de register");
                Boolean read_Register= TRUE;
                while(read_Register){
      
                    try {
                        while((tmp = objectInput.readObject())!= null){
                            read_Register = FALSE;
                            System.out.println("Entra al bucle");
                            patient = (Patient) tmp;
                            break;
                        }
                        System.out.println(patient);
                        persitence.guardar(patient.getId(), patient);
                        //persitence.guardaruser(patient.getUserinfo());
                    
                    } catch (IOException ex) {
                        Logger.getLogger(MonsterServer.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(MonsterServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                break;
                
            case RECORDING:
                System.out.println("Estamos en la ventana de recording");
                break;
                
            case STOP:
                System.out.println("We stop de server");
                releaseResourcesObject(objectInput,objectOutput,socket,serverSocket);
                break;
                
            default:
                System.out.println("No window recognized");
                break;
                
        
        }
        
        
    }
    
    private static void releaseResourcesObject(ObjectInputStream objectInputStream,ObjectOutputStream objectOutputStream, Socket socket, ServerSocket ss) {
        try {
            objectInputStream.close();
            objectOutputStream.close();
        } catch (IOException ex) {
            System.out.println("Error closing ObjectStream");
        }
        try {
            socket.close();
        } catch (IOException ex) {
            System.out.println("Error closing socket");
        }
        try {
            ss.close();
        } catch(IOException ex){
            System.out.println("Error closing serverSocket");
        }
    }
    
}
