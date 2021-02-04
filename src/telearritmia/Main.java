/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telearritmia;

import BITalino.BITalino;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
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
    public static Boolean disconnect = false;
    
    public static Socket socket = null;
    
    public static OutputStream output =  null;
    public static ObjectOutputStream objectOutput = null;
    public static InputStream input =  null;
    public static ObjectInputStream objectInput = null;
    
    public static Confirmation confirm = new Confirmation();
    public static UserInfo userinfo = new UserInfo();
    public static Data data = new Data();
    public static Window window = new Window();
    
    
    
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
 
        try {
            Main.socket = new Socket("localhost",9000);
            Main.output = Main.socket.getOutputStream();
            Main.input = Main.socket.getInputStream();
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLVistaLoginController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("We cannot initialize connection");
        }
        
        try {
            Main.objectOutput = new ObjectOutputStream(Main.output);
            Main.objectInput = new ObjectInputStream(Main.input);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Problems creating the ObjectStream");
        }
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
