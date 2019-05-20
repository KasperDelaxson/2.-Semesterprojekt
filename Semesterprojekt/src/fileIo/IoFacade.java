/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileIo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author erso
 */
public class IoFacade {

    public String readFile(File inFile) {
        // File I/O med explicit lukning af filen
        StringBuilder sb = new StringBuilder();
        Scanner sc = null;// Declaration
        try {
            sc = new Scanner(inFile);// Initialization and openig the file
            while (sc.hasNext()) {
                sb.append(sc.nextLine() + "\n");
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            sc.close();// Closing file and stream
        }
        return sb.toString();
    }

    public void writeFile(String txt, File outFile) {
        // File I/O med brug af AutoCloaseble
        try (FileWriter fw = new FileWriter(outFile)) {
            fw.write(txt);
            fw.flush();// Write the buffer to the file
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
