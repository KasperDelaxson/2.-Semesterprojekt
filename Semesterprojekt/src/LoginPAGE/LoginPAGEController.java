/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPAGE;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import mainAndParent.ParentController;
import pictures.homeScreenPictures.ImageMain;
import semesterprojekt.SQLConnection;

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
    @FXML
    private TextField usernameLabel;
    @FXML
    private PasswordField passwordLabel;
    @FXML
    private AnchorPane fejlBox;
    @FXML
    private Label fejlLabel;
    
    private final SQLConnection sql = new SQLConnection();

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
        try{
        boolean login = sql.checkLogin(usernameLabel.getText(), passwordLabel.getText());
        if(login){
        changeFXML("/homescreen/HomeScreenFXML.fxml", event);
        }
        else{
            fejlBox.setVisible(true);
            fejlLabel.setText("Ugyldige loginoplysninger");
        }
        }
        catch(SQLException e){
            e.getMessage();
        }

    }

    @FXML
    private void updateTime(MouseEvent event) {
        timeAndDate();
        timeLabel.setText(getDatoTid());
    }

}
