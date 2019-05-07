/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homescreen.journal;

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
import pictures.homeScreenPicturesSmall.ImageSecond;

/**
 * FXML Controller class
 *
 * @author Kasper
 */
public class JournalFXMLController extends ParentController implements Initializable {
    @FXML
    private Label dateTimeLabel;
    @FXML
    private ImageView redImage;
    @FXML
    private ImageView yellowImage;
    @FXML
    private ImageView greenImage;
    @FXML
    private Label seJournalLabel;
    @FXML
    private Label redigereJournalLabel;
    
    Description des = new Description();
    ImageSecond img = new ImageSecond();
    
    @FXML
    private Label skrivJournalLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeAndDate();
        dateTimeLabel.setText(getDatoTid());
        skrivJournalLabel.setText(des.features.get("Skriv Journal"));
        seJournalLabel.setText(des.features.get("Se Journal"));
        redigereJournalLabel.setText(des.features.get("Rediger Journal"));
    }    

    @FXML
    private void backToHomescreenButton(ActionEvent event) {
        changeFXML("/homescreen/homeScreenFXML.fxml", event);
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
    private void redChangeToS(MouseEvent event) {
        redImage.setImage(img.red);
    }

    @FXML
    private void redChangeToL(MouseEvent event) {
        redImage.setImage(img.red2);
    }

    @FXML
    private void changeToWriteJournal(MouseEvent event) {
        changeFXML("/homescreen/journal/writeJournal/WriteJournalFXML.fxml", event);
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
    private void changeToEditJournal(MouseEvent event) {
         changeFXML("/homescreen/journal/editJournal/EditJournalFXML.fxml", event);
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
    private void changeToViewJournal(MouseEvent event) {
         changeFXML("/homescreen/journal/viewJournal/ViewJournalFXML.fxml", event);
   }

    @FXML
    private void updateTime(MouseEvent event) {
        timeAndDate();
        dateTimeLabel.setText(getDatoTid());
    }
    
}
