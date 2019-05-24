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
    private ListView<?> medicinListView;
    
    SQLConnection sql = new SQLConnection();
    
    ArrayList <String> nameList = new ArrayList<String>();
    private ObservableList<String> namesList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeAndDate();
        dateTimeLabel.setText(getDatoTid());
        try{
        nameList = sql.seeClientList();
        patientListView.setItems(namesList);
        for(int i = 0;i<nameList.size();i++){
        namesList.add(nameList.get(i));}}
        catch(Exception e){}
    
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
