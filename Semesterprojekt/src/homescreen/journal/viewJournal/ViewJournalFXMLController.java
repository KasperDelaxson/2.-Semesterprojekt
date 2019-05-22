/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homescreen.journal.viewJournal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Samir
 */
public class ViewJournalFXMLController implements Initializable {

    @FXML
    private ListView<?> patientList;
    @FXML
    private ListView<?> referalDatelist;
    @FXML
    private Label dateTimeLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void updateTime(MouseEvent event) {
    }

    @FXML
    private void goBackToNotesFromView(ActionEvent event) {
    }

    @FXML
    private void logOffButton(ActionEvent event) {
    }
    
}
