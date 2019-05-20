/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homescreen.journal.writeJournal;

import fileIo.IoFacade;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import mainAndParent.ParentController;

/**
 * FXML Controller class
 *
 * @author Kenneth Haahr
 */
public class WriteJournalFXMLController extends ParentController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private File journalFile;
    @FXML
    private Button BackButton;
    @FXML
    private Button LogOut;
    @FXML
    private Button SaveNote;
    @FXML
    private Button AttachFile;
    @FXML
    private Label dateTimeLabel;
    @FXML
    private TextArea textAreajournal;
    
    private IoFacade facade;
    private File inFile;
    private FileChooser fileChooser;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeAndDate();
        dateTimeLabel.setText(getDatoTid());
    }

    @FXML
    private void goBackToNotes(ActionEvent event) {
        changeFXML("/homescreen/journal/journalFXML.fxml", event);
    }

    @FXML
    private void logOffButton(ActionEvent event) {
        changeFXML("/LoginPAGE.fxml/", event);
    }

    @FXML
    private void saveNote(ActionEvent event) {
        journalFile = new File("note" + Date.valueOf(LocalDate.MAX) + ".txt");
        
        try {
            journalFile.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(WriteJournalFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Couldn't create file.");
        }
    }

    @FXML
    private void attachFile(ActionEvent event) {
        textAreajournal.clear();
        File inFile;
        try {
        inFile = fileChooser.showOpenDialog(null);
        String txt = facade.readFile(inFile);
        textAreajournal.setText(txt);
        } catch (NullPointerException ex) {
            textAreajournal.setText("Can't open file");
        }
    }

    @FXML
    private void updateTime(MouseEvent event) {
        timeAndDate();
        dateTimeLabel.setText(getDatoTid());
    }

  
}
