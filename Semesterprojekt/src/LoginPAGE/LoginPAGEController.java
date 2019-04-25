/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPAGE;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import mainAndParent.ParentController;
import pictures.homeScreenPictures.ImageMain;

/**
 * FXML Controller class
 *
 * @author mehme
 */
public class LoginPAGEController extends ParentController implements Initializable {
    @FXML
    private ImageView logInPicture;
    ImageMain img = new ImageMain();
    @FXML
    private Label sloganLabel;
    @FXML
    private Label timeLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        logInPicture.setImage(img.dd);
        sloganLabel.setText("The digital diary, in your pocket");
        timeAndDate();
        timeLabel.setText(getDatoTid());
    }    

    @FXML
    private void logIn(ActionEvent event) {
        changeFXML("/homescreen/HomeScreenFXML.fxml", event);
    }

    @FXML
    private void updateTime(MouseEvent event) {
        timeAndDate();
        timeLabel.setText(getDatoTid());
    }
    
}
