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
 * creates a music file
 * pre: none
 * post: music file has been made
 */
public class MakeMusicFile extends MakeFile{
    //String, Media, and MediaPlayer are made
    private String path;
    private Media media;
    private MediaPlayer mp;
    
    /*
    sets MediaPlayer to the media player
    pre: none
    post: mp = media player
    */
    public MakeMusicFile(String fileName,MediaPlayer mp) {
        super(fileName);
        this.mp = mp;
    }
    
    /*
    creates a new file called path
    pre: none
    post: a new file has been created
    */
    public void createNewFile() throws FileNotFoundException {
        path = new File(getFileName()).getAbsolutePath();

    }
    
    /*
    creates a new media player called mp
    pre: none
    post: new Media and MediaPlayer have been created
    */
    public void createMusicPlayer() {
        media = new Media(new File(path).toURI().toString());
        mp = new MediaPlayer(media);
    }
    
    /*
    returns the MediaPlayer
    pre: none
    post: the media player has been returned
    */
    public MediaPlayer returnMediaPlayer() {
        return mp;
    }
    
}
