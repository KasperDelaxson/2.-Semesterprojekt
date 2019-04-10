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
    private TextArea textArea;
    @FXML
    private Button publish;
    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void textArea(MouseEvent event) {
    }

    @FXML
    private void publish(ActionEvent event) {
    }

    @FXML
    private void back(ActionEvent event) {
    }
    
}
