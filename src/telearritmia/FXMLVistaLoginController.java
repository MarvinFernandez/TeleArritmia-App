/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telearritmia;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pojo.Confirmation;
import pojo.UserInfo;
import pojo.Window;

/**
 * FXML Controller class
 *
 * @author danielmarchan
 */
public class FXMLVistaLoginController implements Initializable {
    
    @FXML
    TextField textUsername;
    @FXML
    TextField textPassword;
    @FXML
    Button login;
    @FXML
    Label confirmation;
    
    Boolean is_User = false; 
    
    
    
    
    @FXML
    private void startProgram(ActionEvent event){
        String confirmation_server;
        String username = textUsername.getText();
        String password = textPassword.getText();
        Main.userinfo = new UserInfo(username,password);
        
        
        System.out.println(Main.window);
        
        try {
            System.out.println(Main.userinfo);
            
            Main.objectOutput.writeObject(Main.userinfo);
            Main.objectOutput.flush();
            
            Object tmp;
            
            try {
                while((tmp = Main.objectInput.readObject())!= null){
                    Main.confirm = (Confirmation) tmp;
                    System.out.println(Main.confirm);
                    if(Main.confirm.getConfirm()){
                        is_User = true;
                        System.out.println(Main.confirm);
                        break;
                    }
                    else {
                        is_User = false;
                        System.out.println(Main.confirm);
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FXMLVistaLoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLVistaLoginController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("no message received back");
        }
        
        if(is_User){
            try {
                ((Node)(event.getSource())).getScene().getWindow().hide();
                Parent parent = FXMLLoader.load(getClass().getResource("FXMLVistaBitalino2.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.setTitle("Bitalino");
                //Image ico = new Image("/.png");
                //stage.getIcons().add(ico);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLVistaInitController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Problems with Patient Vista");
                System.out.println(ex);
            }
            
        }
        else {
            //confirmation.setText("Hey bro there is not username"); Ponerlo en otra ventana
       
             try {
                ((Node)(event.getSource())).getScene().getWindow().hide();
                Parent parent = FXMLLoader.load(getClass().getResource("FXMLVistaInit.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.setTitle("TeleArritmia");
                //Image ico = new Image("/.png");
                //stage.getIcons().add(ico);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLVistaInitController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Problems with initVista");
                System.out.println(ex);
            } 
        }
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Main.window.setWindow(Window.Windows_type.LOGIN);
            Main.objectOutput.writeObject(Main.window);
            Main.objectOutput.flush();
        } catch (IOException ex) {
            Logger.getLogger(FXMLVistaInitController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Problem sending window");
        }
    }    
    
    
    
    private static void releaseResourcesObject(ObjectInputStream objectInputStream,ObjectOutputStream objectOutputStream, Socket socket) {
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
    }
    
    
  
    
    
   
    
}
