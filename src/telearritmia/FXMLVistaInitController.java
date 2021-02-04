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

/**
 * FXML Controller class
 *
 * @author danielmarchan
 */
public class FXMLVistaInitController implements Initializable {

    @FXML
    private Button initialization;
    
    
    @FXML
    private void startProgram(ActionEvent event){
        try {
            ((Node)(event.getSource())).getScene().getWindow().hide();
            Parent parent = FXMLLoader.load(getClass().getResource("FXMLVistaPatient.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Patient");
            //Image ico = new Image("/.png");
            //stage.getIcons().add(ico);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLVistaInitController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Problems with patient Vista");
        }
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
