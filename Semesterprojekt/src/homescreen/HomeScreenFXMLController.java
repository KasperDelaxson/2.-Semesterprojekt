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
import homescreen.Description;
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
    Description description = new Description();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeAndDate();
        ddImage.setImage(description.dd);
        velkommenLabel.setText("Velkommen: \"brugernavn\"");
        dateTimeLabel.setText(getDatoTid());
        informationArea.setVisible(false); 
    }

    @FXML
    private void blueChangeToS(MouseEvent event) {
        blueImage.setImage(description.blue);
        informationArea.setText(null);

    }

    @FXML
    private void blueChangeToL(MouseEvent event) {
        blueImage.setImage(description.blue2);
        informationArea.setText(description.features.get("Notater"));
    }

    @FXML
    private void greenChangeToS(MouseEvent event) {
        greenImage.setImage(description.green);
        informationArea.setText(null);
    }

    @FXML
    private void greenChangeToL(MouseEvent event) {
        greenImage.setImage(description.green2);
        informationArea.setText(description.features.get("Kommentar"));
    }

    @FXML
    private void yellowChangeToS(MouseEvent event) {
        yellowImage.setImage(description.yellow);
        informationArea.setText(null);
    }

    @FXML
    private void yellowChangeToL(MouseEvent event) {
        yellowImage.setImage(description.yellow2);
        informationArea.setText(description.features.get("Ydelser"));
    }

    @FXML
    private void purpleChangeToS(MouseEvent event) {
        purpleImage.setImage(description.purple);
        informationArea.setText(null);
    }

    @FXML
    private void purpleChangeToL(MouseEvent event) {
        purpleImage.setImage(description.purple2);
        informationArea.setText(description.features.get("Medicin"));
    }

    @FXML
    private void redChangeToS(MouseEvent event) {
        redImage.setImage(description.red);
        informationArea.setText(null);
    }

    @FXML
    private void redChangeToL(MouseEvent event) {
        redImage.setImage(description.red2);
        informationArea.setText(description.features.get("Indstillinger"));
    }

    @FXML
    private void darkBlueChangeToS(MouseEvent event) {
        darkBlueImage.setImage(description.darkBlue);
        informationArea.setText(null);
    }

    @FXML
    private void darkBlueChangeToL(MouseEvent event) {
        darkBlueImage.setImage(description.darkBlue2);
        informationArea.setText(description.features.get("Admin"));
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
