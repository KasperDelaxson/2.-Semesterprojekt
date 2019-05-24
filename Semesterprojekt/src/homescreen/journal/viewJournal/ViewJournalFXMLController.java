/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homescreen.journal.viewJournal;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import mainAndParent.ParentController;
import semesterprojekt.SQLConnection;

/**
 * FXML Controller class
 *
 * @author Malth
 */
public class ViewJournalFXMLController extends ParentController implements Initializable {

    @FXML
    private ListView patientList;
    private ObservableList<String> namesList = FXCollections.observableArrayList();
    @FXML
    private ListView referalDatelist;
    private SQLConnection sql = new SQLConnection();
    @FXML
    private Label dateTimeLabel;
    private ArrayList<String> nameList = new ArrayList<String>();
    private ArrayList<String> dateList = new ArrayList<String>();
    private ObservableList<String> datesList = FXCollections.observableArrayList();
    @FXML
    private TextArea journalText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            nameList = sql.seeClientList();
            patientList.setItems(namesList);
            for (int i = 0; i < nameList.size(); i++) {
                namesList.add(nameList.get(i));
            }
        } catch (Exception e) {
        }
        patientList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    referalDatelist.getItems().clear();
                    dateList = sql.getDates((String) patientList.getSelectionModel().getSelectedItem());
                    referalDatelist.setItems(datesList);
                    for (int i = 0; i < dateList.size(); i++) {
                        datesList.add(dateList.get(i));
                    }
                } catch (Exception e) {
                    System.out.println("There is no recorded journal entry");
                }
            }
        });
        referalDatelist.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                journalText.clear();
                String returnString = sql.getJournal((String) referalDatelist.getSelectionModel().getSelectedItem());
                journalText.setText(returnString);
            }
        });
    }

    @FXML
    private void exitButton(ActionEvent event) {
        closeWindow(event);
    }

    @FXML
    private void goBackToNotesFromView(ActionEvent event) {
        changeFXML("/homescreen/journal/JournalFXML.fxml", event);
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
}
