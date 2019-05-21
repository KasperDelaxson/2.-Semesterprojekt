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

/**
 * FXML Controller class
 *
 * @author Kaspe
 */
public class CreateDeletePatientFXMLController implements Initializable {
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
    private Label permissionLabel;
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
    private TextField permissionField;
    @FXML
    private Label advarselLabel;
    @FXML
    private TextArea patientListView;

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
    private void deleteUser(ActionEvent event) {
    }

    @FXML
    private void showUsers(ActionEvent event) {
    }

    @FXML
    private void createUser(ActionEvent event) {
    }

    @FXML
    private void showCreateUser(ActionEvent event) {
    }

    @FXML
    private void showDeleteUser(ActionEvent event) {
    }

    @FXML
    private void goBackToAdmin(ActionEvent event) {
    }

    @FXML
    private void logOffButton(ActionEvent event) {
    }

    @FXML
    private void exitButton(ActionEvent event) {
    }
    
}
