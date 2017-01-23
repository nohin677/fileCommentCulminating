/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import java.io.File;
import java.io.FileNotFoundException;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author USER
 */
public class MakeMusicFile extends MakeFile{
    private String path;
    private Media media;
    private MediaPlayer mp;
    public MakeMusicFile(String fileName,MediaPlayer mp) {
        super(fileName);
        this.mp = mp;
    }
   
        public void createNewFile() throws FileNotFoundException{
           path = new File(getFileName()).getAbsolutePath();
          
        }
        public void createMusicPlayer(){
            media = new Media(new File(path).toURI().toString());
             mp = new MediaPlayer(media);
        }
        
        public MediaPlayer returnMediaPlayer(){
            return mp;
        }
    
}
