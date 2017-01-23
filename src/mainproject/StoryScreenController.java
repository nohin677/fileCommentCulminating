/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproject;

import File.MakeMusicFile;
import File.MakeTextFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class StoryScreenController implements Initializable {
    @FXML
    private TextArea mainTextArea;
    @FXML
    private ComboBox<?> characterComboBox;
    @FXML
    private Button inventoryButton;
    @FXML
    private TreeView<?> equipmentTreeView;
    @FXML
    private ListView<?> commandsListView;
    @FXML
    private Button saveButton;
    @FXML
    private MediaView mv;
    
    private MediaPlayer mp;
    private MakeMusicFile newMusic;
    private Media me;
    private MakeTextFile newTextFile;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         playMusic();
         startDialuge();
         
        
        
    }
    public void startDialuge(){
        newTextFile = new MakeTextFile("");
         newTextFile.createNewFile();
        try {
            newTextFile.createInputStream();
        } catch (FileNotFoundException ex) {
            
        }
        mainTextArea.setEditable(false);
        dialuge1();
      
    }
    public void dialuge1(){
        int cycle = 8;
        setTimer(cycle);
    }
    public void setTimer(int cycle){
         Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(2000),
                e -> displayWords()));
        timeline.setCycleCount(cycle);
        timeline.play();
    }
   public void displayWords(){
      try {
            mainTextArea.appendText( newTextFile.OutPutReadLine() + "\n");

        } catch (IOException ex) {
            System.err.print("Error Found");
        }
   }
    public void playMusic(){
      
        String path = new File("C:/Users/USER/Documents/NetBeansProjects/MainProject/src/media/song2.mp3").getAbsolutePath();
        me = new Media(new File(path).toURI().toString());
        mp = new MediaPlayer(me);
        mv.setMediaPlayer(mp);
        mp.setAutoPlay(true);
       
         /*newMusic = new MakeMusicFile("C:/Users/USER/Documents/NetBeansProjects/MainProject/src/media/song2.mp3",mp);
        try {
            newMusic.createNewFile();
            newMusic.createMusicPlayer();
        } catch (FileNotFoundException ex) {
        }
        mv.setMediaPlayer(newMusic.returnMediaPlayer());
        (newMusic.returnMediaPlayer()).play();*/
       
  
    
}
}
