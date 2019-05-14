/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homescreen.journal.viewJournal;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
 * @author Malth
 */
public class ViewJournalFXMLController extends ParentController implements Initializable {

    @FXML
    private ListView patientList;
    private ObservableList<String> namesList = FXCollections.observableArrayList();
    @FXML
    private ListView<?> referalDatelist;
    private SQLConnection sql = new SQLConnection();
    @FXML
    private Label dateTimeLabel;
    private ArrayList <String> nameList = new ArrayList<String>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
        nameList = sql.seeClientList();
        patientList.setItems(namesList);
        for(int i = 0;i<nameList.size();i++){
        namesList.add(nameList.get(i));}}
        catch(Exception e){}

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
