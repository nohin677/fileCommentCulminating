/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * abstract class to make a file pre: must be inherited post: a file is created
 */
public abstract class MakeFile {

    //creates a string and a file
    private String fileName;
    private File textFile;

    /*
    makes String fileName equal to the name of the file
    pre: none
    post: String fileName is turned into the name of the file
     */
    public MakeFile(String fileName) {
        this.fileName = fileName;

    }

    /*
    creates new file
    pre: none
    post: a new file is made
     */
    public void createNewFile() throws FileNotFoundException {
        textFile = new File(fileName);

    }

    /*
    returns the file name
    pre: none
    post: the name of the file is returned
     */
    public String getFileName() {
        return fileName;
    }

    /*
    returns the file
    pre: none
    post: the file is returned
     */
    public File getFile() {
        return textFile;
    }

}
