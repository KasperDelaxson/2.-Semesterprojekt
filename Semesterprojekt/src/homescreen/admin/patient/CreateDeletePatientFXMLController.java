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
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import mainAndParent.ParentController;
import semesterprojekt.SQLConnection;

/**
 * FXML Controller class
 *
 * @author Kaspe
 */
public class CreateDeletePatientFXMLController extends ParentController implements Initializable {

    SQLConnection sql = new SQLConnection();
    @FXML
    private Label timeLabel;
    @FXML
    private Button deleteUserButton;
    @FXML
    private TextArea awaitingActionArea;
    @FXML
    private Button createUserButton;
    @FXML
    private ToggleGroup bruger;
    @FXML
    private Label employeeAssignedLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label phoneLabel;
    @FXML
    private Label mailLabel;
    @FXML
    private Label socialSecurityLabel;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private TextField employeeassignedField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField mailField;
    @FXML
    private TextField socialSecurityField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label advarselLabel;

    @FXML
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeAndDate();
        timeLabel.setText(getDatoTid());
        advarselLabel.setText("OBS! Ved slet af Patient kan dette ikke fortrydes!");
    }

    @FXML
    private void updateTime(MouseEvent event) {
        timeAndDate();
        timeLabel.setText(getDatoTid());
    }

    @FXML
    private void deleteUser(ActionEvent event) {
        if (nameField.getText().isEmpty() || phoneField.getText().isEmpty() || mailField.getText().isEmpty()
                || socialSecurityField.getText().isEmpty() || usernameField.getText().isEmpty() || passwordField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ikke tilstrækkelig information angivet!", "Fejl!", 1);
        } else {
            int phone = Integer.parseInt(phoneField.getText());
            try {
                sql.openConnection();
                sql.deletePatient(nameField.getText(), phone, mailField.getText(), usernameField.getText(), passwordField.getText(), socialSecurityField.getText());
                awaitingActionArea.setText("Fuldført! Patient slettet!");
                JOptionPane.showMessageDialog(null, "Fuldført patient slettet! ", "Godkendt", 1);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                awaitingActionArea.setText("Fejl ved slet af patient!");
                JOptionPane.showMessageDialog(null, "Fejl ved slet af bruger ", "Fejl", 1);
            }
        }
    }

    @FXML
    private void createUser(ActionEvent event) {
        if (employeeassignedField.getText().isEmpty() || nameField.getText().isEmpty() || phoneField.getText().isEmpty() || mailField.getText().isEmpty()
                || socialSecurityField.getText().isEmpty() || usernameField.getText().isEmpty() || passwordField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ikke tilstrækkelig information angivet!", "Fejl!", 1);
        } else {
            int phone = Integer.parseInt(phoneField.getText());
            int permission = 1;
            int employeeassigned = Integer.parseInt(employeeassignedField.getText());
            try {
                sql.openConnection();
                sql.addPatient(nameField.getText(), phone, mailField.getText(), socialSecurityField.getText(), usernameField.getText(), passwordField.getText(), permission, employeeassigned);
                awaitingActionArea.setText("Fuldført! Patient oprettet!");
                JOptionPane.showMessageDialog(null, "Fuldført Patient oprettet! ", "Godkendt", 1);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                awaitingActionArea.setText("Fejl ved opret af patient!");
                JOptionPane.showMessageDialog(null, "Fejl ved opret af patient!", "Fejl", 1);
            }
        }
    }

    @FXML
    private void showCreateUser(ActionEvent event) {
        advarselLabel.setVisible(false);
        createUserButton.setVisible(true);
        deleteUserButton.setVisible(false);
        employeeassignedField.setVisible(true);
        employeeAssignedLabel.setVisible(true);

    }

    @FXML
    private void showDeleteUser(ActionEvent event) {
        advarselLabel.setVisible(true);
        createUserButton.setVisible(false);
        deleteUserButton.setVisible(true);
        employeeassignedField.setVisible(false);
        employeeAssignedLabel.setVisible(false);
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
    private void showPatients(ActionEvent event) {
    }

}
