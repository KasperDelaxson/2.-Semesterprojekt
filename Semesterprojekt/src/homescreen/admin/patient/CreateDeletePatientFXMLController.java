/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homescreen.admin.patient;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
    private ArrayList<String> patientAList = new ArrayList<String>();
    private ObservableList<String> patientOList = FXCollections.observableArrayList();
    @FXML
    private ListView<String> patientListView;

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

            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Fejl!");
            alert.setHeaderText(null);
            alert.setContentText("Ikke tilstrækkelig information angivet!");
            alert.showAndWait();
        } else {
            int phone = Integer.parseInt(phoneField.getText());
            try {
                sql.openConnection();
                sql.deletePatient(nameField.getText(), phone, mailField.getText(), usernameField.getText(), passwordField.getText(), socialSecurityField.getText());
                awaitingActionArea.setText("Fuldført! Patient slettet!");
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Godkendt");
                alert.setHeaderText(null);
                alert.setContentText("Fuldført patient slettet! ");
                alert.showAndWait();

            } catch (Exception e) {
                System.out.println(e.getMessage());
                awaitingActionArea.setText("Fejl ved slet af patient!");

                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Fejl!");
                alert.setHeaderText(null);
                alert.setContentText("Fejl ved slet af bruger");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void createUser(ActionEvent event) {
        if (employeeassignedField.getText().isEmpty() || nameField.getText().isEmpty() || phoneField.getText().isEmpty() || mailField.getText().isEmpty()
                || socialSecurityField.getText().isEmpty() || usernameField.getText().isEmpty() || passwordField.getText().isEmpty()) {

            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Fejl!");
            alert.setHeaderText(null);
            alert.setContentText("Ikke tilstrækkelig information angivet!");
            alert.showAndWait();

        } else {
            int phone = Integer.parseInt(phoneField.getText());
            int permission = 1;
            int employeeassigned = Integer.parseInt(employeeassignedField.getText());
            try {
                sql.openConnection();
                sql.addPatient(nameField.getText(), phone, mailField.getText(), socialSecurityField.getText(), usernameField.getText(), passwordField.getText(), permission, employeeassigned);
                awaitingActionArea.setText("Fuldført! Patient oprettet!");

                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Godkendt!");
                alert.setHeaderText(null);
                alert.setContentText("Fuldført Patient oprettet!");
                alert.showAndWait();

            } catch (Exception e) {
                System.out.println(e.getMessage());
                awaitingActionArea.setText("Fejl ved opret af patient!");

                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Fejl!");
                alert.setHeaderText(null);
                alert.setContentText("Fejl ved opret af patient!");
                alert.showAndWait();

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
        try {
            patientAList = sql.seePatientList();
            patientListView.setItems(patientOList);
            for (int i = 0; i < patientAList.size(); i++) {
                patientOList.add(patientAList.get(i));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
