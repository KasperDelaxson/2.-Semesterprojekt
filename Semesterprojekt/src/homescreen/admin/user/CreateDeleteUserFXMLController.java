/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homescreen.admin.user;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import mainAndParent.ParentController;
import semesterprojekt.SQLConnection;

/**
 * FXML Controller class
 *
 * @author Kasper
 */
public class CreateDeleteUserFXMLController extends ParentController implements Initializable {

    @FXML
    private Label advarselLabel;
    @FXML
    private TextArea awaitingActionArea;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField permissionField;
    @FXML
    private ToggleGroup bruger;
    @FXML
    private TextArea userListView;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private Button deleteUserButton;
    @FXML
    private Label permissionLabel;
    @FXML
    private Button createUserButton;
    @FXML
    private Label timeLabel;
    @FXML
    private Label employeeNumberLabel;
    @FXML
    private TextField employeeNumberField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField mailField;
    @FXML
    private Label nameLabel;
    @FXML
    private Label phoneNumberLabel;
    @FXML
    private Label mailLabel;
    SQLConnection sql = new SQLConnection();
    ObservableList<String> userList;
    Connection con;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeAndDate();
        timeLabel.setText(getDatoTid());
    }

    @FXML
    private void deleteUser(ActionEvent event) {
    }

    @FXML
    private void showUsers(ActionEvent event) {
        
    }
    

    @FXML
    private void createUser(ActionEvent event) {
        if (employeeNumberField.getText() == null || nameField.getText() == null 
                || phoneField.getText() == null || mailField.getText() == null 
                || usernameField.getText() == null || passwordField.getText() == null
                || permissionField.getText() == null){
            awaitingActionArea.setText("Ikke tilstrækkelig information givet");
        }
        else {
            int employeeNumber = Integer.parseInt(employeeNumberField.getText());
            int phone = Integer.parseInt(phoneField.getText());
            int permission = Integer.parseInt(permissionField.getText());
            try {
                sql.openConnection();
                sql.addEmployee(employeeNumber, nameField.getText(), phone , mailField.getText(), usernameField.getText(), passwordField.getText(), permission);
                sql.closeConnection();
                awaitingActionArea.setText("Fuldført! Bruger Oprettet");
            } catch(Exception e){
                System.out.println("Error adding employee");
            }
            
        }
    }

    @FXML
    private void showCreateUser(ActionEvent event) {
        advarselLabel.setVisible(false);
        createUserButton.setVisible(true);
        deleteUserButton.setVisible(false);
        employeeNumberLabel.setVisible(true);
        employeeNumberField.setVisible(true);
        mailLabel.setVisible(true);
        mailField.setVisible(true);
        permissionLabel.setVisible(true);
        permissionField.setVisible(true);
    }

    @FXML
    private void showDeleteUser(ActionEvent event) {
        advarselLabel.setVisible(true);
        createUserButton.setVisible(false);
        deleteUserButton.setVisible(true);
        employeeNumberLabel.setVisible(false);
        employeeNumberField.setVisible(false);
        mailLabel.setVisible(false);
        mailField.setVisible(false);
        permissionLabel.setVisible(false);
        permissionField.setVisible(false);
    }

    @FXML
    private void goBack(ActionEvent event) {
        changeFXML("/homescreen/admin/AdminFXML.fxml", event);
    }

    @FXML
    private void updateTime(MouseEvent event) {
        timeAndDate();
        timeLabel.setText(getDatoTid());
    }

}
