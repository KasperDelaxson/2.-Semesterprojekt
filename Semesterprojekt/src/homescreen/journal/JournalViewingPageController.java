/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homescreen.journal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author mehme
 */
public class JournalViewingPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goBack(ActionEvent event) {
        changeFXML("journalMaintaincePageFXML.fxml", event);
    }

    private void changeFXML(String journalMaintaincePageFXMLfxml, ActionEvent event) {
        throw new UnsupportedOperationException("Fejl i JournalViewingPageController//changeFXML"); //To change body of generated methods, choose Tools | Templates.
    }
    
}