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
    @FXML
    private ListView<String> handoutListView;

    private ArrayList<String> nameList = new ArrayList<String>();
    private ArrayList<String> medicinList = new ArrayList<String>();

    SQLConnection sql = new SQLConnection();

    private ObservableList<String> namesList = FXCollections.observableArrayList();
    private ObservableList<String> medicinsList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeAndDate();
        dateTimeLabel.setText(getDatoTid());
        try {
            nameList = sql.seeClientList();
            patientListView.setItems(namesList);
            for (int i = 0; i < nameList.size(); i++) {
                namesList.add(nameList.get(i));
            }
        } catch (Exception e) {
        }

        patientListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    medicinListView.getItems().clear();
                    medicinList = sql.getMeds((String)patientListView.getSelectionModel().getSelectedItem());
                    medicinListView.setItems(medicinsList);
                    for (int i = 0; i < medicinList.size(); i++) {
                        medicinsList.add(medicinList.get(i));
                    }
                } catch (Exception e) {
                    System.out.println("There is no recorded medicin entry");
                }
            }
        });
//        referalDatelist.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                journalText.clear();
//                String returnString = sql.getJournal((String) referalDatelist.getSelectionModel().getSelectedItem());
//                journalText.setText(returnString);
//            }
//        });
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

}
