/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homescreen.admin.user;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
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
    private ListView<String> userListView;
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
    private ArrayList<String> userAList = new ArrayList<String>();
    private ObservableList<String> userOList = FXCollections.observableArrayList();

    Connection con;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeAndDate();
        timeLabel.setText(getDatoTid());
    }

    @FXML
    private void deleteUser(ActionEvent event) {
        if (nameField.getText().isEmpty() || phoneField.getText().isEmpty()
                || usernameField.getText().isEmpty() || passwordField.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Fejl!");
            alert.setHeaderText(null);
            alert.setContentText("Ikke tilstrækkelig information angivet!");
            alert.showAndWait();
        } else {
            try {
                int employeeNumber = Integer.parseInt(employeeNumberField.getText());
                int phone = Integer.parseInt(phoneField.getText());
                sql.openConnection();
                sql.deleteEmployee(employeeNumber, nameField.getText(), phone, usernameField.getText(), passwordField.getText());
                sql.closeConnection();
                awaitingActionArea.setText("Fuldført! Bruger Slettet!");

                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Godkendt!");
                alert.setHeaderText(null);
                alert.setContentText("Fuldført! Bruger slettet!");
                alert.showAndWait();

            } catch (Exception e) {
                awaitingActionArea.setText("Fejl ved slet af Bruger");

                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Fejl!");
                alert.setHeaderText(null);
                alert.setContentText("Fejl ved slet af bruger!");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void showUsers(ActionEvent event) {
        try {
            userAList = sql.seeUserList();
            userListView.setItems(userOList);
            for (int i = 0; i < userAList.size(); i++) {
                userOList.add(userAList.get(i));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void createUser(ActionEvent event) {
        if (employeeNumberField.getText().isEmpty() || nameField.getText().isEmpty()
                || phoneField.getText().isEmpty() || mailField.getText().isEmpty()
                || usernameField.getText().isEmpty() || passwordField.getText().isEmpty()
                || permissionField.getText().isEmpty()) {

            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Fejl!");
            alert.setHeaderText(null);
            alert.setContentText("Ikke tilstrækkelig information angivet!");
            alert.showAndWait();

        } else {
            int employeeNumber = Integer.parseInt(employeeNumberField.getText());
            int phone = Integer.parseInt(phoneField.getText());
            int permission = Integer.parseInt(permissionField.getText());
            try {
                sql.openConnection();
                sql.addEmployee(employeeNumber, nameField.getText(), phone, mailField.getText(), usernameField.getText(), passwordField.getText(), permission);
                sql.closeConnection();
                awaitingActionArea.setText("Fuldført! Bruger Oprettet");

                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Godkendt!");
                alert.setHeaderText(null);
                alert.setContentText("Fuldført bruger oprettet!");
                alert.showAndWait();

            } catch (Exception e) {
                awaitingActionArea.setText("Fejl ved opret af Bruger!");

                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Fejl!");
                alert.setHeaderText(null);
                alert.setContentText("Fejl ved opret af bruger!");
                alert.showAndWait();
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

    @FXML
    private void exitButton(ActionEvent event) {
        closeWindow(event);
    }

    @FXML
    private void logOffButton(ActionEvent event) {
        changeFXML("/LoginPAGE/LoginPAGE.fxml", event);
    }

}
