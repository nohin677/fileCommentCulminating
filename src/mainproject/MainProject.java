/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproject;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class MainProject extends Application {
   //@FXML private javafx.scene.control.Button closeButton;
    @Override
    public void start(Stage primaryStage) throws IOException {
     
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
      
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setResizable(false);
        primaryStage.setTitle("The Great Adventure");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("img/sword1.png"));
        primaryStage.show();
        
    
        
        
    }
    


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
       
        
    }
    
    
    
}
