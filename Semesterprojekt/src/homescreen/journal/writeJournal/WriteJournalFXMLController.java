/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homescreen.journal.writeJournal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Date;
import java.sql.Statement;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import mainAndParent.ParentController;
import semesterprojekt.SQLConnection;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;
import mainAndParent.ParentController;
import pictures.homeScreenPictures.ImageMain;
import semesterprojekt.Employee;
import semesterprojekt.SQLConnection;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
    
    private final SQLConnection sql1 = new SQLConnection();
    private Connection con;
    PreparedStatement pst = null; 
    @FXML
    private TextField employeeAssignedField; 

    @FXML
    private TextField socialSecurityField; 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeAndDate();
        dateTimeLabel.setText(getDatoTid());
        clients = sql.seeClientList();
        try{
        clients = sql.seeClientList();
        clientList.setItems(obsClient);
        for(int i = 0;i<clients.size();i++){
        obsClient.add(clients.get(i));}}
        catch(Exception e){}
        clientList.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                selectedPatient = (String)clientList.getSelectionModel().getSelectedItem();
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
        Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Saved");
                alert.setHeaderText(null);
                alert.setContentText("Saved");
                alert.showAndWait();
    
                int employeeassigned = Integer.parseInt(employeeAssignedField.getText());
                
                sql.saveToJournal(noteArea.getText(),employeeassigned,socialSecurityField.getText());
                     
       
    }
    

    @FXML
    private void attachFile(ActionEvent event) {
    }

    @FXML
    private void updateTime(MouseEvent event) {
        timeAndDate();
        dateTimeLabel.setText(getDatoTid());
    }


}
