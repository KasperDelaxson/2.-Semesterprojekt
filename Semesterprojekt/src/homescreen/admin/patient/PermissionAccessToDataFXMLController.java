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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
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
public class PermissionAccessToDataFXMLController extends ParentController implements Initializable {

    @FXML
    private TextField firstEmployeeField;
    @FXML
    private TextField nextEmployeeField;
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
    private void givePermissionButton(ActionEvent event) {
        if (firstEmployeeField.getText().isEmpty() || nextEmployeeField.getText().isEmpty() || socialSecurityField.getText().isEmpty()) {

            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Fejl!");
            alert.setHeaderText(null);
            alert.setContentText("Ikke tilstrækkelig information angivet!");
            alert.showAndWait();

        } else {
            int firstField = Integer.parseInt(firstEmployeeField.getText());
            int nextField = Integer.parseInt(nextEmployeeField.getText());
            sql.alterPermissionToJournal(socialSecurityField.getText(), firstField, nextField);

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Godkendt!");
            alert.setHeaderText(null);
            alert.setContentText("Der er nu tildelt adgang til borgers sagsakter!");
            alert.showAndWait();
        }
    }

}
