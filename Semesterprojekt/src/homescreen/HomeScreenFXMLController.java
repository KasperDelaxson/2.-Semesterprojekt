package homescreen;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import mainAndParent.ParentController;

/**
 * FXML Controller class
 *
 * @author Kasper
 */
public class HomeScreenFXMLController extends ParentController implements Initializable {

    @FXML
    private Label velkommenLabel;
    @FXML
    private Label dateTimeLabel;
    @FXML
    private ImageView ddImage;
    @FXML
    private ImageView blueImage;
    @FXML
    private ImageView greenImage;
    @FXML
    private ImageView yellowImage;
    @FXML
    private ImageView purpleImage;
    @FXML
    private ImageView darkBlueImage;
    @FXML
    private ImageView redImage;
    @FXML
    private TextArea informationArea;
    @FXML
    private ToggleGroup helpButtonGroup;
    /**
     * Initializes the controller class.
     */
    //Pictures:
    Image dd = new Image("/pictures/DIGI-DAGBOG.png");
    Image blue = new Image("/pictures/homeScreenPictures/Blue.png");
    Image blue2 = new Image("/pictures/homeScreenPictures/Blue2.png");
    Image darkBlue = new Image("/pictures/homeScreenPictures/DarkBlue.png");
    Image darkBlue2 = new Image("/pictures/homeScreenPictures/DarkBlue2.png");
    Image green = new Image("/pictures/homeScreenPictures/Green.png");
    Image green2 = new Image("/pictures/homeScreenPictures/Green2.png");
    Image purple = new Image("/pictures/homeScreenPictures/Purple.png");
    Image purple2 = new Image("/pictures/homeScreenPictures/Purple2.png");
    Image red = new Image("/pictures/homeScreenPictures/Red.png");
    Image red2 = new Image("/pictures/homeScreenPictures/Red2.png");
    Image yellow = new Image("/pictures/homeScreenPictures/yellow.png");
    Image yellow2 = new Image("/pictures/homeScreenPictures/yellow2.png");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ddImage.setImage(dd);
        velkommenLabel.setText("Velkommen: \"brugernavn\"");
        dateTimeLabel.setText("10/04-2019 16:10");
        informationArea.setVisible(false);
    }

    @FXML
    private void blueChangeToS(MouseEvent event) {
        blueImage.setImage(blue);
        informationArea.setText(null);

    }

    @FXML
    private void blueChangeToL(MouseEvent event) {
        blueImage.setImage(blue2);
        informationArea.setText("Her kan der: "
                + "\n Skrives notater "
                + "\n Se notater "
                + "\n redigere notater");
    }

    @FXML
    private void greenChangeToS(MouseEvent event) {
        greenImage.setImage(green);
        informationArea.setText(null);
    }

    @FXML
    private void greenChangeToL(MouseEvent event) {
        greenImage.setImage(green2);
        informationArea.setText("Her kan der: "
                + "\n Skrives kommentar "
                + "\n Se kommentar "
                + "\n redigere kommentar");
    }

    @FXML
    private void yellowChangeToS(MouseEvent event) {
        yellowImage.setImage(yellow);
        informationArea.setText(null);
    }

    @FXML
    private void yellowChangeToL(MouseEvent event) {
        yellowImage.setImage(yellow2);
        informationArea.setText("Her kan der: "
                + "\n Se tildelt ydelser for borger");
    }

    @FXML
    private void purpleChangeToS(MouseEvent event) {
        purpleImage.setImage(purple);
        informationArea.setText(null);
    }

    @FXML
    private void purpleChangeToL(MouseEvent event) {
        purpleImage.setImage(purple2);
        informationArea.setText("Her kan der: "
                + "\n Se udleveret medicin for borger");
    }

    @FXML
    private void redChangeToS(MouseEvent event) {
        redImage.setImage(red);
        informationArea.setText(null);
    }

    @FXML
    private void redChangeToL(MouseEvent event) {
        redImage.setImage(red2);
        informationArea.setText("Her ses indstillinger af systemet");
    }

    @FXML
    private void darkBlueChangeToS(MouseEvent event) {
        darkBlueImage.setImage(darkBlue);
        informationArea.setText(null);
    }

    @FXML
    private void darkBlueChangeToL(MouseEvent event) {
        darkBlueImage.setImage(darkBlue2);
        informationArea.setText("Kun adgang for Admin: "
                + "\n Håndtere hvem der må se hvad "
                + "\n Slette sagsakter "
                + "\n Se/vise samlede borgers data "
                + "\n Åbne/Lukke borgers sag "
                + "\n Se hvem der har tilgået hvad");
    }

    @FXML
    private void contactButton(ActionEvent event) {
        changeFXML("ContactFXML.fxml", event);
    }

    @FXML
    private void logOffButton(ActionEvent event) {
    }

    @FXML
    private void exitButton(ActionEvent event) {
        closeWindow(event);
    }

    @FXML
    private void showHelp(ActionEvent event) {
        informationArea.setVisible(true);
    }

    @FXML
    private void hideHelp(ActionEvent event) {
        informationArea.setVisible(false);
    }

}
