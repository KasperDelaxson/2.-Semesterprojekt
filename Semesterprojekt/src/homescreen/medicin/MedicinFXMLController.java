/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homescreen.medicin;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import mainAndParent.ParentController;
import semesterprojekt.SQLConnection;

/**
 * FXML Controller class
 *
 * @author Kaspe
 */
public class MedicinFXMLController extends ParentController implements Initializable {

    @FXML
    private Label dateTimeLabel;
    @FXML
    private ListView<String> patientListView;
    @FXML
    private ListView<String> medicinListView;

    SQLConnection sql = new SQLConnection();
    private ArrayList<String> patientAList = new ArrayList<String>();
    private ObservableList<String> patientOList = FXCollections.observableArrayList();
    private ArrayList<String> medicineAList = new ArrayList<String>();
    private ObservableList<String> medicineOList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeAndDate();
        dateTimeLabel.setText(getDatoTid());

        try {
            patientListView.getItems().clear();
            patientAList = sql.seePatientList();
            patientListView.setItems(patientOList);
            for (int i = 0; i < patientAList.size(); i++) {
                patientOList.add(patientAList.get(i));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        patientListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                medicinListView.getItems().clear();
                ArrayList<String> med = sql.seeAssignedMedicine(patientListView.getSelectionModel().getSelectedItem());
                medicineAList = med;
                if (med.isEmpty()) {
                    medicineOList.add("Ingen medicin tildelt!");
                } else {
                    medicinListView.setItems(medicineOList);
                    for (int i = 0; i < medicineAList.size(); i++) {
                        medicineOList.add(medicineAList.get(i));
                    }
                }
            }
        });
    }

    @FXML
    private void logOffButton(ActionEvent event) {
        changeFXML("/LoginPAGE/LoginPAGE.fxml", event);
    }

    @FXML
    private void updateTime(MouseEvent event) {
        timeAndDate();
        dateTimeLabel.setText(getDatoTid());
    }

    @FXML
    private void goBackToHomescreen(ActionEvent event) {
        changeFXML("/homescreen/HomeScreenFXML.fxml", event);
    }

    @FXML
    private void exitButton(ActionEvent event) {
        closeWindow(event);
    }

}
