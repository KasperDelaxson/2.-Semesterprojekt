/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homescreen;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import mainAndParent.ParentController;

/**
 * FXML Controller class
 *
 * @author Kasper
 */
public class ContactFXMLController extends ParentController implements Initializable {

    @FXML
    private TextArea contactTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        contactTextArea.setText("Systemet er lavet af gruppe 13, bestående af: \n"
                + "(Sorterer Alfabetisk) \n"
                + "\nAhash Mathivathan: Ahmat18@student.sdu.dk \n"
                + "Kasper Sebastiampillai: Kaseb18@student.sdu.dk \n"
                + "Kenneth Michael Haahr: Kehaa18@student.sdu.dk \n"
                + "Malthe Petersen: Malpe18@student.sdu.dk \n"
                + "Mehmed Emin Øzer: Meuze18@student.sdu.dk \n"
                + "Samir Al Idrissi: Salid18@student.sdu.dk ");

    }

    @FXML
    private void goBack(ActionEvent event) {
        changeFXML("HomeScreenFXML.fxml", event);
    }

    @FXML
    private void logOut(ActionEvent event) {
        changeFXML("/LoginPAGE/LoginPAGE.fxml", event);
    }

    @FXML
    private void exitProgram(ActionEvent event) {
        closeWindow(event);
    }

}
