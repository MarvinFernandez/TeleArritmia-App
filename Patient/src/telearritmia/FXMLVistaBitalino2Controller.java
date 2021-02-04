/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telearritmia;

import BITalino.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javax.bluetooth.RemoteDevice;
import pojo.Patient;

/**
 * FXML Controller class
 *
 * @author danielmarchan
 */
public class FXMLVistaBitalino2Controller implements Initializable {

    @FXML
    private Button recordBut;
    @FXML
    private Button but_SaveSend;
    @FXML 
    private Button but_Upload;
    //@FXML
    //private ProgressIndicator indicator;
    @FXML
    private TextField textMacAddress;
    @FXML
    private Accordion steps;
    
    
    
   
    @FXML
    private void savePatient(ActionEvent event){
        String name = Main.patient.getName();
        String surname = Main.patient.getSurname();
        String filename = name.concat(surname);
        File file = new File(filename.concat(".txt"));
        Main.persistence.guardar(file, Main.patient);
        System.out.println("saved");
    }
    
    @FXML
    private void loadPatient(ActionEvent event){
        String nameFile = "DanielMarchan.txt"; //esto habria que cambiar, el doctor deberia meter el nombre del archivo a cargar
        File file = new File(nameFile);
        Patient p = new Patient();
            
            if(!file.exists()){
                    System.out.println("Archivo inexistente");
            }
            else        
                    try{  
                        p=Main.persistence.cargar(file);
                        System.out.println(p);
                        System.out.println("load");
                    }
                    catch(ClassNotFoundException ex){
                        System.out.println("error en la lectura intente de nuevo");
                    }       
    }
    
    
    @FXML
    private void record(ActionEvent event){
      
            System.out.println("el thread va a empezar");
            Blue blue = new Blue();
            blue.start();
            //blue.join(); esto no funciona
            
            /*BITalino bitalino = new BITalino();
            System.out.println("entra al método");
            int seconds = 0;
            String macAddress = textMacAddress.getText();//You should have the MAC ADDRESS in a sticker in the Bitalino
            System.out.println("este es tu MacAddress:"+ macAddress);
            try {
            
            //Sampling rate, should be 10, 100 or 1000
            int SamplingRate = 100;
            bitalino.open(macAddress, SamplingRate);
   
            int[] channelsToAcquire = {1, 2};
            bitalino.start(channelsToAcquire);
            Frame[] frame;
            
            for (int j = 0; j < 30; j++) {
            
            //Each time read a block of 10 samples
            int block_size=100;
            
            frame = bitalino.read(block_size);
            
            System.out.println("size block: " + frame.length);
            seconds = j;
            System.out.println("\ntime in seconds"+seconds);
            
            //Print the samples
            for (int i = 0; i < frame.length; i++) {
            
            /*System.out.println((j * block_size + i) + " seq: " + frame[i].seq + " "
            + frame[i].analog[0] + " "
            + frame[i].analog[1] + " "
            //  + frame[i].analog[2] + " "
            //  + frame[i].analog[3] + " "
            //  + frame[i].analog[4] + " "
            //  + frame[i].analog[5]
            );*/
            /*           Main.patient.addTime(j*block_size+i);
            Main.patient.addECG(frame[i].analog[0]);
            Main.patient.addEDA(frame[i].analog[1]);
            
            }
            }
            //stop acquisition
            bitalino.stop();
            } catch (BITalinoException ex) {
            System.out.println("Hola soy bitalino y no funciono");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Throwable ex) {
            System.out.println("throwable error");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
            try {
            //close bluetooth connection
            if (bitalino != null) {
            bitalino.close();
            }
            } catch (BITalinoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
       */
         
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}    
