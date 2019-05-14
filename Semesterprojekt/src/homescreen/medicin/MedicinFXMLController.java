/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homescreen.medicin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import mainAndParent.ParentController;

/**
 * FXML Controller class
 *
 * @author Kaspe
 */
public class MedicinFXMLController extends ParentController implements Initializable {
    @FXML
    private Label dateTimeLabel;
    @FXML
    private ListView<?> patientListView;
    @FXML
    private ListView<?> medicinListView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeAndDate();
        dateTimeLabel.setText(getDatoTid());
    
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
