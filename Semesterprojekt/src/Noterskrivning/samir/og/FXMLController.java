/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Noterskrivning.samir.og;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author mehme
 */
public class FXMLController implements Initializable {
    @FXML
    private TextArea textAreaNote;
    @FXML
    private Button publishNote;
    @FXML
    private Button backFromNote;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void publishNote(ActionEvent event) {
    }

    @FXML
    private void backFromNote(ActionEvent event) {
    }

    @FXML
    private void textAreaNote(MouseEvent event) {
    }
    
}
