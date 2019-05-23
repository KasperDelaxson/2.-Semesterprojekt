/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homescreen.comment;

import homescreen.Description;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import mainAndParent.ParentController;
import pictures.homeScreenPicturesSmall.ImageSecond;
import semesterprojekt.Employee;
import semesterprojekt.SQLConnection;

/**
 * FXML Controller class
 *
 * @author Kasper
 */
public class CommentFXMLController extends ParentController implements Initializable {
    @FXML
    private Label dateTimeLabel;
    @FXML
    private ImageView redImage;
    @FXML
    private ImageView yellowImage;
    @FXML
    private ImageView greenImage;
    @FXML
    private Label writeComentLabel;
    @FXML
    private Label seeComentLabel;
    @FXML
    private Label editComentLabel;
    
    ImageSecond img = new ImageSecond();
    Description des = new Description();
    SQLConnection sql = new SQLConnection();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeAndDate();
        dateTimeLabel.setText(getDatoTid());
        writeComentLabel.setText(des.features.get("Skriv Kommentar"));
        seeComentLabel.setText(des.features.get("Se Kommentar"));
        editComentLabel.setText(des.features.get("Rediger Kommentar"));
    }    

    @FXML
    private void updateTime(MouseEvent event) {
        timeAndDate();
        dateTimeLabel.setText(getDatoTid());
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
    private void changeToWriteComent(MouseEvent event) {
        String username = Employee.getEmployee().getUsername();
        sql.getPermission(username);
        if (sql.getPermissionNumber() > 1){
            changeFXML("/homescreen/comment/writeComment/WriteCommentFXML.fxml", event);
        } else {
            JOptionPane.showMessageDialog(null, "Du har ikke tilladelse til at tilgå dette!", "Tilladelse er ikke eksisterende", 1);
        }
        
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
    private void changeToEditComent(MouseEvent event) {
        String username = Employee.getEmployee().getUsername();
        sql.getPermission(username);
        if (sql.getPermissionNumber() > 1){
            changeFXML("/homescreen/comment/editComment/EditCommentFXML.fxml", event);
        } else {
            JOptionPane.showMessageDialog(null, "Du har ikke tilladelse til at tilgå dette!", "Tilladelse er ikke eksisterende", 1);
        }
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
    private void changeToSeeComent(MouseEvent event) {
        String username = Employee.getEmployee().getUsername();
        sql.getPermission(username);
        if (sql.getPermissionNumber() > 0){
            changeFXML("/homescreen/comment/viewComment/ViewCommentFXML.fxml", event);
        } else {
            JOptionPane.showMessageDialog(null, "Du har ikke tilladelse til at tilgå dette!", "Tilladelse er ikke eksisterende", 1);
        }
    }

    @FXML
    private void backToHomescreenButton(ActionEvent event) {
        changeFXML("/homescreen/HomeScreenFXML.fxml", event);
    }

    @FXML
    private void logOffButton(ActionEvent event) {
        changeFXML("/LoginPAGE/LoginPAGE.fxml", event);
    }

    @FXML
    private void exitButton(ActionEvent event) {
        closeWindow(event);
    }
    
}
