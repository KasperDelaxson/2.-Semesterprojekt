/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPAGE;

import homescreen.Description;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import mainAndParent.ParentController;

/**
 * FXML Controller class
 *
 * @author mehme
 */
public class LoginPAGEController extends ParentController implements Initializable {
    @FXML
    private ImageView logInPicture;
    Description description = new Description();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        logInPicture.setImage(description.dd);
    }    

    @FXML
    private void logIn(ActionEvent event) {
        changeFXML("/homescreen/HomeScreenFXML.fxml", event);
    }
    
}
