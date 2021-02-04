/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telearritmia;

import java.io.IOException;
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
import javafx.stage.Stage;
import pojo.Window;

/**
 * FXML Controller class
 *
 * @author danielmarchan
 */
public class FXMLVistaInitController implements Initializable {

    @FXML
    private Button login;
    @FXML
    private Button register;
    
    
    
    @FXML
    private void startLogin(ActionEvent event){
        try {
            ((Node)(event.getSource())).getScene().getWindow().hide();
            Parent parent = FXMLLoader.load(getClass().getResource("FXMLVistaLogin.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Username validation");
            //Image ico = new Image("/.png");
            //stage.getIcons().add(ico);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLVistaInitController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Problems with username validation Vista");
            System.out.println(ex);
        }    
    }
    
     @FXML
    private void startRegister(ActionEvent event){
        try {
            ((Node)(event.getSource())).getScene().getWindow().hide();
            Parent parent = FXMLLoader.load(getClass().getResource("FXMLVistaPatient.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Register patient");
            //Image ico = new Image("/.png");
            //stage.getIcons().add(ico);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLVistaInitController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Problems with Register Vista");
            System.out.println(ex);
        }
    }
    
    
    
    /*veamos si se sube*/
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
