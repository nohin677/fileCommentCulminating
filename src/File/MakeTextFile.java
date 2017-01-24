/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * creates a text file pre: none post: a text file has been created
 */
public class MakeTextFile extends MakeFile implements InputInterface, OutputInterface {

    //variable declaration 
    private StringBuilder out;
    private BufferedReader buffRead;
    private InputStream fis;
    private FileReader reader;
    private BufferedWriter buffWriter;
    private OutputStreamWriter output;
    private FileOutputStream fileOut;
    private File file;
    private String fileName;
    
    /*
    sets String fileName to the name of the file
    pre: none
    post: fileName = the name of the file
    */
    public MakeTextFile(String fileName) {
        super(fileName);
        this.fileName = getFileName();
    }
    
    /*
    creates a new file
    pre: none
    post: a new file is created
    */
    @Override
    public void createNewFile() {
        file = new File(fileName);
    }
    
    /*
    creates an input stream
    pre: none
    post: a new input stream has been created
    */
    @Override
    public void createInputStream() throws FileNotFoundException {

        fis = new FileInputStream(file);
        buffRead = new BufferedReader(new InputStreamReader(fis));
        out = new StringBuilder();

    }
    
    /*
    reads the file
    pre: none
    post: the file has been read
    */
    @Override
    public String OutPutReadLine() throws IOException {
        String nextLine;
        if ((nextLine = buffRead.readLine()) != null) {
            return nextLine;
        } else {
            return null;
        }

    }
    
    /*
    returns the file
    pre: none
    post: the file is returned
    */
    public File returnFile() {
        return file;
    }
    
    /*
    creates a new file reader
    pre: none
    post: a new file reader has been created
    */
    public void createFileReader() throws FileNotFoundException {
        reader = new FileReader(file);
    }
    
    /*
    returns the file reader
    pre: none
    post: the file reader is returned
    */
    public FileReader returnFileReader() {
        return reader;
    }
    
    /*
    creates a new output stream
    pre: none
    post: a new output stream has been created
    */
    @Override
    public void createOutputStream() throws FileNotFoundException, UnsupportedEncodingException {
        //buffWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(textFile), "utf-8")); 
        fileOut = new FileOutputStream(file);
        output = new OutputStreamWriter(fileOut, "utf-8");
        buffWriter = new BufferedWriter(output);
    }
    
    /*
    returns the buffered writer
    pre: none
    post: the buffered writer is returned
    */
    public BufferedWriter returnBuffer() throws IOException {
        return buffWriter;
    }
    
    /*
    changes the file name
    pre: none
    post: the file name has been changed
    */
    public void changeFileName(String name) {

    }

}
