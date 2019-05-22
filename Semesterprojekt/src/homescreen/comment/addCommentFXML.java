/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homescreen.comment;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Samir
 */
public class addCommentFXML implements Initializable {

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
    private void saveJournal(ActionEvent event) {
    }

    @FXML
    private void attachFile(ActionEvent event) {
    }


    @FXML
    private void logOffButton(ActionEvent event) {
        changeFXML("/LoginPAGE/LoginPAGE.fxml", event);
    }

    @FXML
    private void goBackToViewCommentScreen(ActionEvent event) {
          changeFXML("/homescreen.comment/CommentFXML.fxml", event);
    }
       private void changeFXML(String loginPAGELoginPAGEfxml, ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
