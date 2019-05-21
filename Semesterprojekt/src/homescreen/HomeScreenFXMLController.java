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
import pictures.homeScreenPictures.ImageMain;
import semesterprojekt.Employee;
import semesterprojekt.SQLConnection;
import javax.swing.JOptionPane;

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
    ImageMain img = new ImageMain();
    Description description = new Description();
    SQLConnection sql = new SQLConnection();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ddImage.setImage(img.dd);  
        informationArea.setVisible(false);
        timeAndDate();
        dateTimeLabel.setText(getDatoTid());
        String username = sql.getEmployeeName(Employee.getEmployee().getUsername());
        velkommenLabel.setText("Velkommen: " + username);
    }
    @FXML
    private void blueChangeToS(MouseEvent event) {
        blueImage.setImage(img.blue);
        informationArea.setText(null);

    }

    @FXML
    private void blueChangeToL(MouseEvent event) {
        blueImage.setImage(img.blue2);
        informationArea.setText(description.features.get("Journal"));
    }

    @FXML
    private void greenChangeToS(MouseEvent event) {
        greenImage.setImage(img.green);
        informationArea.setText(null);
    }

    @FXML
    private void greenChangeToL(MouseEvent event) {
        greenImage.setImage(img.green2);
        informationArea.setText(description.features.get("Kommentar"));
    }

    @FXML
    private void yellowChangeToS(MouseEvent event) {
        yellowImage.setImage(img.yellow);
        informationArea.setText(null);
    }

    @FXML
    private void yellowChangeToL(MouseEvent event) {
        yellowImage.setImage(img.yellow2);
        informationArea.setText(description.features.get("Ydelser"));
    }

    @FXML
    private void purpleChangeToS(MouseEvent event) {
        purpleImage.setImage(img.purple);
        informationArea.setText(null);
    }

    @FXML
    private void purpleChangeToL(MouseEvent event) {
        purpleImage.setImage(img.purple2);
        informationArea.setText(description.features.get("Medicin"));
    }

    @FXML
    private void redChangeToS(MouseEvent event) {
        redImage.setImage(img.red);
        informationArea.setText(null);
    }

    @FXML
    private void redChangeToL(MouseEvent event) {
        redImage.setImage(img.red2);
        informationArea.setText(description.features.get("Indstillinger"));
    }

    @FXML
    private void darkBlueChangeToS(MouseEvent event) {
        darkBlueImage.setImage(img.darkBlue);
        informationArea.setText(null);
    }

    @FXML
    private void darkBlueChangeToL(MouseEvent event) {
        darkBlueImage.setImage(img.darkBlue2);
        informationArea.setText(description.features.get("Admin"));
    }

    @FXML
    private void contactButton(ActionEvent event) {
        changeFXML("ContactFXML.fxml", event);
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
    private void showHelp(ActionEvent event) {
        informationArea.setVisible(true);
    }

    @FXML
    private void hideHelp(ActionEvent event) {
        informationArea.setVisible(false);
    }

    @FXML
    private void updateTime(MouseEvent event) {
        timeAndDate();
        dateTimeLabel.setText(getDatoTid());
    }
    @FXML
    private void changeToNotes(MouseEvent event) {
        String username = Employee.getEmployee().getUsername();
        sql.getPermission(username);
        if (sql.getPermissionNumber() > 0){
            changeFXML("/homescreen/journal/journalFXML.fxml", event);
        } else {
            JOptionPane.showMessageDialog(null, "Du har ikke tilladelse til at tilgå dette!", "Tilladelse er ikke eksisterende", 1);
        }
       
    }

    @FXML
    private void changeToComent(MouseEvent event) {
        String username = Employee.getEmployee().getUsername();
        sql.getPermission(username);
        if (sql.getPermissionNumber() > 0){
            changeFXML("/homescreen/comment/commentFXML.fxml", event);
        } else {
            JOptionPane.showMessageDialog(null, "Du har ikke tilladelse til at tilgå dette!", "Tilladelse er ikke eksisterende", 1);
        }
    }

    @FXML
    private void changeToAdmin(MouseEvent event) {
        String username = Employee.getEmployee().getUsername();
        sql.getPermission(username);
        if (sql.getPermissionNumber() == 3){
            changeFXML("/homescreen/admin/AdminFXML.fxml", event);
        } else {
            JOptionPane.showMessageDialog(null, "Du har ikke tilladelse til at tilgå dette!", "Tilladelse er ikke eksisterende", 1);
        }
    }

    @FXML
    private void changeToServices(MouseEvent event) {
        String username = Employee.getEmployee().getUsername();
        sql.getPermission(username);
        if (sql.getPermissionNumber() > 1){
            changeFXML("/homescreen/service/ServiceFXML.fxml", event);
        } else {
            JOptionPane.showMessageDialog(null, "Du har ikke tilladelse til at tilgå dette!", "Tilladelse er ikke eksisterende", 1);
        } 
    }

    @FXML
    private void changeToMedicin(MouseEvent event) {
        String username = Employee.getEmployee().getUsername();
        sql.getPermission(username);
        if (sql.getPermissionNumber() > 1){
            changeFXML("/homescreen/medicin/MedicinFXML.fxml", event);
            System.out.println(sql.getPermissionNumber());
        } else {
            JOptionPane.showMessageDialog(null, "Du har ikke tilladelse til at tilgå dette!", "Tilladelse er ikke eksisterende", 1);
            System.out.println(sql.getPermissionNumber());
        }
    }

    @FXML
    private void changeToSettings(MouseEvent event) {
        String username = Employee.getEmployee().getUsername();
        sql.getPermission(username);
        if (sql.getPermissionNumber() == 3){
            
        } else {
            JOptionPane.showMessageDialog(null, "Du har ikke tilladelse til at tilgå dette!", "Tilladelse er ikke eksisterende", 1);
        }
    }

}
