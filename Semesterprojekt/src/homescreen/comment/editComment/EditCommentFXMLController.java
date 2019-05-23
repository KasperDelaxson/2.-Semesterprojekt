/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homescreen.comment.editComment;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import mainAndParent.ParentController;

/**
 * FXML Controller class
 *
 * @author Kasper
 */
public class EditCommentFXMLController extends ParentController implements Initializable {
    @FXML
    private Label dateTimeLabel;
    @FXML
    private ListView<?> patientListView;
    @FXML
    private ListView<?> dateListView;
    @FXML
    private TextArea editCommentArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeAndDate();
        dateTimeLabel.setText(getDatoTid());
    }    

    @FXML
    private void goBackToComment(ActionEvent event) {
        changeFXML("/homescreen/comment/commentFXML.fxml", event);
    }

    @FXML
    private void updateTime(MouseEvent event) {
        timeAndDate();
        dateTimeLabel.setText(getDatoTid());
    }

    @FXML
    private void logOffButton(ActionEvent event) {
        changeFXML("/LoginPAGE/LoginPAGE.fxml", event);
    }

    @FXML
    private void saveJournal(ActionEvent event) {
    }

    @FXML
    private void attachFile(ActionEvent event) {
    }
    
}
