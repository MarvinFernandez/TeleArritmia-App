/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telearritmia;

import BITalino.BITalino;
import BITalino.BITalinoException;
import BITalino.Frame;
import java.net.URL;

import java.util.ResourceBundle;
import java.util.Vector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.bluetooth.RemoteDevice;

/**
 * FXML Controller class
 *
 * @author marvi
 */
public class FXMLBitalinoController implements Initializable {
    
    public static Frame[] frame;
    
   
    //Vector<RemoteDevice> devices = Main.bitalino.findDevices();
    String macAddress = null;
    //Sampling rate, should be 10, 100 or 1000
    int SamplingRate = 100;
    // selet apropiade channel
    int[] channelsToAcquire = {1, 5};
    
    
    @FXML
    private TextField textMacAdress;        
    
    @FXML
    private Label errorLable;
    
    @FXML 
    private Button recordButton;

    
    
    
    /*@FXML
    private void macAdress(ActionEvent event) throws BITalinoException{
        //save mac Adresse
        macAddress=textMacAdress.getText();
        Main.bitalino.open(macAddress , SamplingRate);
 
    }*/
    
    private void record(ActionEvent event) throws BITalinoException{
        macAddress = macAddress=textMacAdress.getText();
        if (macAddress == null){
        //introduce macAdress Error
             errorLable.setText("Introduce the Mac Adresse of Bitalino");
        }
        else{
           // Main.bitalino.open(macAddress, SamplingRate);
           // Main.bitalino.start(channelsToAcquire); 
            
            //indicate size of the recod
            for (int j = 0; j < 10; j++) {

                //Each time read a block of 10 samples 
                int block_size=100;//Each time read a block of 10 samples 
                frame = Main.bitalino.read(block_size);

                System.out.println("size block: " + frame.length);

                //Print the samples
                //creamos tres vectores [tiempo, ECG, EDA].
                
                for (int i = 0; i < frame.length; i++) {
                    System.out.println((j * block_size + i) + " seq: " + frame[i].seq + " "
                            + frame[i].analog[0] + " "
                            + frame[i].analog[1] + " "         
                    //  + frame[i].analog[2] + " "
                    //  + frame[i].analog[3] + " "
                    //  + frame[i].analog[4] + " "
                    //  + frame[i].analog[5]
                    );

                }
            }
        }
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
