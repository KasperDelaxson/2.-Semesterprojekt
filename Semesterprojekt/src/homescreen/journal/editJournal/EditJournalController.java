/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homescreen.journal.editJournal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import mainAndParent.ParentController;

/**
 * FXML Controller class
 *
 * @author Kenneth Haahr
 */
public class EditJournalController extends ParentController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void goBackToNotesFromEdit(ActionEvent event) {
        changeFXML("/homescreen/journal/journalFXML.fxml", event);
    }

    @FXML
    private void logOffButton(ActionEvent event) {
        changeFXML("/LoginPAGE/LoginPAGE.fxml", event);
    }

    @FXML
    private void attachFile(ActionEvent event) {

    }

    @FXML
    private void saveNote(ActionEvent event) {

    }
    
        @FXML
    private void seeClientList(ActionEvent event) {

    }
    
        @FXML
    private void seeClientReferenceByDate(ActionEvent event) {

    }
    
        @FXML
    private void editSelectedNote(ActionEvent event) {

    }
}
