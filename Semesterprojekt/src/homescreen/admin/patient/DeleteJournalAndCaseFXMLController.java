/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homescreen.admin.patient;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import mainAndParent.ParentController;
import semesterprojekt.SQLConnection;

/**
 * FXML Controller class
 *
 * @author Kaspe
 */
public class DeleteJournalAndCaseFXMLController extends ParentController implements Initializable {

    @FXML
    private TextArea informationArea;
    @FXML
    private TextField socialSecurityField;
    @FXML
    private Label timeLabel;
    SQLConnection sql = new SQLConnection();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeAndDate();
        timeLabel.setText(getDatoTid());
        informationArea.setText("OBS! Ved slet af sagsakter til tilhørende patient \n kan dette ikke fortrydes!");
    }

    @FXML
    private void updateTime(MouseEvent event) {
        timeAndDate();
        timeLabel.setText(getDatoTid());

    }

    @FXML
    private void goBackToAdmin(ActionEvent event) {
        changeFXML("/homescreen/admin/AdminFXML.fxml", event);
    }

    @FXML
    private void logOffButton(ActionEvent event) {
        changeFXML("/LoginPAGE/LoginPAGE.fxml", event);
    }

    @FXML
    private void exitButton(ActionEvent event) {
        closeWindow(event);
    }

    @FXML
    private void deletePatientCase(ActionEvent event) {
        if (socialSecurityField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ikke tilstrækkelig information angivet!", "Fejl!", 1);
        } else {
            sql.deleteJournal(socialSecurityField.getText());
        }
    }

}
