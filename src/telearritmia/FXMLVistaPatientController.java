/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telearritmia;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pojo.Patient.GENDER;

/**
 * FXML Controller class
 *
 * @author danielmarchan
 */
public class FXMLVistaPatientController implements Initializable {

    @FXML
    private TextField textName;
    @FXML
    private TextField textSurname;
    @FXML
    private TextField textID;
    @FXML
    private TextField textEmail;
    @FXML
    private TextField textInfo;
    @FXML
    private Button information;
    @FXML
    private Button bitalino;
    @FXML
    private DatePicker dob;
    @FXML
    private ChoiceBox<GENDER> gender;
    
    
  
    @FXML
    private void startBitalinoVista(ActionEvent event){
        try {
            
            Parent parent = FXMLLoader.load(getClass().getResource("FXMLVistaBitalino.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Bitalino");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLVistaPatientController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Problems with vistaBitalino");
        }
    }
    
    @FXML
    private void showInfo(ActionEvent event){
        Main.patient.setName(textName.getText());
        Main.patient.setSurname(textSurname.getText());
        Main.patient.setId(textID.getText());
        Main.patient.setEmail(textEmail.getText());
        Main.patient.setSex(gender.getValue());
        Date date = new Date();
        date.setDate(dob.getValue().getDayOfMonth());//should be setDate (day) something weird here
        date.setMonth(dob.getValue().getMonthValue());
        date.setYear(dob.getValue().getYear());
        Main.patient.setDob(date);
        //textInfo.setText(Main.patient.toString());
        System.out.println(Main.patient.toString());
    }
    
    private void loadData(){
        gender.getItems().add(GENDER.male);
        gender.getItems().add(GENDER.female);
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
 
    }    
    
}
