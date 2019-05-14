/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homescreen.journal.viewJournal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import mainAndParent.ParentController;
import semesterprojekt.SQLConnection;

/**
 * FXML Controller class
 *
 * @author Malth
 */
public class ViewJournalFXMLController extends ParentController implements Initializable {

    @FXML
    private ListView<?> patientList;
    @FXML
    private ListView<?> referalDatelist;
    private SQLConnection sql = new SQLConnection();
    private ObservableList<String> nameList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nameList = sql.seeClientList();
        System.out.println("hellooo");
    }    

    @FXML
    private void goBackToNotesFromView(ActionEvent event) {
        changeFXML("/homescreen/journal/JournalFXML.fxml", event);
    }

    @FXML
    private void logOffButton(ActionEvent event) {
        changeFXML("/LoginPAGE/LoginPAGE.fxml", event);
    
    }
}
