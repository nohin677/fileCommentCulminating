/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changeLineInFile;

import File.MakeTextFile;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class ChangeLineInFile {

    private MakeTextFile newTextFile;

    public void changeALineInATextFile(String fileName, String newLine, int lineNumber) throws UnsupportedEncodingException, IOException {
        newTextFile = new MakeTextFile(fileName);
        String content = new String();
        String editedContent = new String();
        content = readFile(fileName);
        editedContent = editLineInContent(content, newLine, lineNumber);
        writeToFile(fileName, editedContent);

    }

    private int numberOfLinesInFile(String content) {
        int numberOfLines = 0;
        int index = 0;
        int lastIndex = 0;

        lastIndex = content.length() - 1;

        while (true) {

            if (content.charAt(index) == '\n') {
                numberOfLines++;

            }

            if (index == lastIndex) {
                numberOfLines = numberOfLines + 1;
                break;
            }
            index++;

        }

        return numberOfLines;
    }

    private String[] turnFileIntoArrayOfStrings(String content, int lines) {
        String[] array = new String[lines];
        int index = 0;
        int tempInt = 0;
        int startIndext = 0;
        int lastIndex = content.length() - 1;

        while (true) {

            if (content.charAt(index) == '\n') {
                tempInt++;

                String temp2 = new String();
                for (int i = 0; i < index - startIndext; i++) {
                    temp2 += content.charAt(startIndext + i);
                }
                startIndext = index;
                array[tempInt - 1] = temp2;

            }

            if (index == lastIndex) {

                tempInt++;

                String temp2 = new String();
                for (int i = 0; i < index - startIndext + 1; i++) {
                    temp2 += content.charAt(startIndext + i);
                }
                array[tempInt - 1] = temp2;

                break;
            }
            index++;

        }

        return array;
    }

    private String editLineInContent(String content, String newLine, int line) {

        int lineNumber = 0;
        lineNumber = numberOfLinesInFile(content);

        String[] lines = new String[lineNumber];
        lines = turnFileIntoArrayOfStrings(content, lineNumber);

        if (line != 1) {
            lines[line - 1] = "\n" + newLine;
        } else {
            lines[line - 1] = newLine;
        }
        content = new String();

        for (int i = 0; i < lineNumber; i++) {
            content += lines[i];
        }

        return content;
    }

    private void writeToFile(String file, String content) throws FileNotFoundException, UnsupportedEncodingException, IOException {
      newTextFile.createOutputStream();
       // try(/*BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"))*/){ 
            //newTextFile.createNewFile();
            //newTextFile.createOutputStream();
      try {
          newTextFile.returnBuffer().write(content);
           } finally {
        if ( newTextFile.returnBuffer() != null)  newTextFile.returnBuffer().close();
    }
            /*
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } */
    }

    private String readFile(String filename) {
        String content = null;
        
        //File file = new File(filename);
        //FileReader reader = null;
        try {
               newTextFile.createNewFile();
               newTextFile.createFileReader();
           // reader = new FileReader(file);
            char[] chars = new char[(int) newTextFile.returnFile().length()];
            newTextFile.returnFileReader().read(chars);
            //reader.read(chars);
            content = new String(chars);
            newTextFile.returnFileReader().close();
            //reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (newTextFile.returnFileReader() != null) {
                try {
                    newTextFile.returnFileReader().close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        System.out.println(content);
        return content;
    }

}
