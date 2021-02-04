/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telearritmia;

import BITalino.BITalino;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import persistence.Persistence;
import pojo.*;

/**
 *
 * @author marvi
 */
public class Main extends Application {
    
    private Stage primaryStage;
    public static Patient patient = new Patient();
    public static BITalino bitalino = new BITalino();
    public static Persistence persistence = new Persistence();
    
    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        this.primaryStage.initStyle(StageStyle.UTILITY);
        this.primaryStage.setResizable(false);
        this.primaryStage.setTitle("TeleArritmia");
        initProgram();
    }
    
    public void initProgram(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLVistaInit.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Problems with Init Vista");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
