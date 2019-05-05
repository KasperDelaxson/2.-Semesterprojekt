/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homescreen.admin;

import homescreen.Description;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import mainAndParent.ParentController;
import pictures.homeScreenPictures.ImageMain;

/**
 * FXML Controller class
 *
 * @author Kasper
 */
public class AdminFXMLController extends ParentController implements Initializable {
    @FXML
    private Label dateTimeLabel;
    @FXML
    private ImageView ddImage;
    @FXML
    private ImageView greenImage;
    @FXML
    private ImageView blueImage;
    @FXML
    private ImageView yellowImage;
    @FXML
    private ImageView purpleImage;
    @FXML
    private ImageView darkBlueImage;
    @FXML
    private ImageView redImage;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label6;
    @FXML
    private Label label3;
    @FXML
    private Label label5;
    @FXML
    private Label label4;
    
    ImageMain img = new ImageMain();
    Description des = new Description();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeAndDate();
        dateTimeLabel.setText(getDatoTid());
        label1.setText(des.features.get("Håndter"));
        label2.setText(des.features.get("Sagsakter"));
        label3.setText(des.features.get("Borgers data"));
        label4.setText(des.features.get("Borgers sag"));
        label5.setText(des.features.get("Tilgået"));
        label6.setText(des.features.get("Bruger"));
    }    

    @FXML
    private void greenChangeToS(MouseEvent event) {
        greenImage.setImage(img.green);
    }

    @FXML
    private void greenChangeToL(MouseEvent event) {
        greenImage.setImage(img.green2);
    }
    
    @FXML
    private void updateTime(MouseEvent event) {
        timeAndDate();
        dateTimeLabel.setText(getDatoTid());
    }

    @FXML
    private void blueChangeToS(MouseEvent event) {
        blueImage.setImage(img.blue);
    }

    @FXML
    private void blueChangeToL(MouseEvent event) {
        blueImage.setImage(img.blue2);
    }

    @FXML
    private void yellowChangeToS(MouseEvent event) {
        yellowImage.setImage(img.yellow);
    }

    @FXML
    private void yellowChangeToL(MouseEvent event) {
        yellowImage.setImage(img.yellow2);
    }

    @FXML
    private void purpleChangeToS(MouseEvent event) {
        purpleImage.setImage(img.purple);
    }

    @FXML
    private void purpleChangeToL(MouseEvent event) {
        purpleImage.setImage(img.purple2);
    }

    @FXML
    private void darkBlueChangeToS(MouseEvent event) {
        darkBlueImage.setImage(img.darkBlue);
    }

    @FXML
    private void darkBlueChangeToL(MouseEvent event) {
        darkBlueImage.setImage(img.darkBlue2);
    }

    @FXML
    private void redChangeToS(MouseEvent event) {
        redImage.setImage(img.red);
    }

    @FXML
    private void redChangeToL(MouseEvent event) {
        redImage.setImage(img.red2);
    }

    @FXML
    private void logOffButton(ActionEvent event) {
        changeFXML("/LoginPAGE/LoginPAGE.fxml", event);
    }

    @FXML
    private void exitButton(ActionEvent event) {
        closeWindow(event);
    }

    @FXML
    private void changeToLabel2(MouseEvent event) {
    }

    @FXML
    private void changeToLabel1(MouseEvent event) {
    }

    @FXML
    private void changeToLabel3(MouseEvent event) {
    }

    @FXML
    private void changeToLabel6(MouseEvent event) {
        changeFXML("/homescreen/admin/user/CreateDeleteUserFXML.fxml", event);
    }

    @FXML
    private void changeToLabel5(MouseEvent event) {
    }

    @FXML
    private void changeToLabel4(MouseEvent event) {
    }

    @FXML
    private void goBackToHomescreen(ActionEvent event) {
        changeFXML("/homescreen/HomeScreenFXML.fxml", event);
    }
    
}
