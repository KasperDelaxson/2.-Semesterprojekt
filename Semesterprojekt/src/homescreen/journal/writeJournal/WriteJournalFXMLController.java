/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homescreen.journal.writeJournal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import mainAndParent.ParentController;
import semesterprojekt.SQLConnection;

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
    private ListView clientList;
    private ArrayList<String> clients = new ArrayList<String>();
    private ObservableList<String> obsClient = FXCollections.observableArrayList();
    private SQLConnection sql = new SQLConnection();

    @FXML
    private TextArea noteArea;
    private String selectedPatient = null;
    private String patientSelected;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeAndDate();
        dateTimeLabel.setText(getDatoTid());
        clients = sql.seeClientList();
        try {
            clients = sql.seeClientList();
            clientList.setItems(obsClient);
            for (int i = 0; i < clients.size(); i++) {
                obsClient.add(clients.get(i));
            }
        } catch (Exception e) {
        }
        clientList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                selectedPatient = (String) clientList.getSelectionModel().getSelectedItem();
            }
        });
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

        sql.saveNote(selectedPatient, (String) noteArea.getText());
//        journalFile = new File("note" + Date.valueOf(LocalDate.MAX) + ".txt");
//        
//        try {
//            journalFile.createNewFile();
//        } catch (IOException ex) {
//            Logger.getLogger(WriteJournalFXMLController.class.getNameForList()).log(Level.SEVERE, null, ex);
//            System.err.println("Couldn't create file.");
//        }

        sql.saveNote(selectedPatient, (String) noteArea.getText());

        if (selectedPatient != null && !noteArea.getText().isEmpty()) {

            sql.saveNote(selectedPatient, selectedPatient);

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Journal gemt");
            alert.setHeaderText(null);
            alert.setContentText("Journal gemt");
            alert.showAndWait();

        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("FEJL!");
            alert.setHeaderText(null);
            alert.setContentText("Patient skal vælges og note skal skrives!");
            alert.showAndWait();

        }
    }

    @FXML
    private void attachFile(ActionEvent event) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            File file = null;
            String text;

            public void run() {
                JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                jfc.setDialogTitle("Select a file");
                jfc.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
                jfc.addChoosableFileFilter(filter);

                int returnValue = jfc.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    file = jfc.getSelectedFile();
                }

                BufferedReader br = null;
                try {
                    br = new BufferedReader(new FileReader(file));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(WriteJournalFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }

                String st;
                try {
                    while ((st = br.readLine()) != null) {
                        text = text + st;
                    }
                    sql.saveNote(selectedPatient, (String) text);
                } catch (IOException ex) {
                    Logger.getLogger(WriteJournalFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    @FXML
    private void exitButton(ActionEvent event) {
        closeWindow(event);
    }

    @FXML
    private void updateTime(MouseEvent event) {
        timeAndDate();
        dateTimeLabel.setText(getDatoTid());
    }

}
