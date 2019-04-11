/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterprojekt;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;

/**
 * FXML Controller class
 *
 * @author mehme
 */
public class FXMLController implements Initializable {
    @FXML
    private ListView<?> journalList;
    @FXML
    private ListView<?> patientList;
    @FXML
    private BorderPane borderPane;
    @FXML
    private TextArea textArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void logOut(ActionEvent event) {
    }

    @FXML
    private void textArea(MouseEvent event) {
    }

    @FXML
    private void newJournal(ActionEvent event) {
    }


    
}
