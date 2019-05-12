/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPAGE;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import semesterprojekt.Employee;
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

    private int employeeNumber;
    private final SQLConnection sql = new SQLConnection();
    private Connection con;

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
        if (usernameLabel.getText().isEmpty() || passwordLabel.getText().isEmpty()) {
            fejlBox.setVisible(true);
            fejlLabel.setText("Ikke tilstrækkelig information givet!");
        } else{
            try {
            boolean login = sql.checkLogin(usernameLabel.getText(), passwordLabel.getText());
            if (login) {
                changeFXML("/homescreen/HomeScreenFXML.fxml", event);
            } else {
                fejlBox.setVisible(true);
                fejlLabel.setText("Ugyldige loginoplysninger");
            }
        } catch (SQLException e) {

            e.getMessage();

        }
        Employee.setEmployee(usernameLabel.getText(), passwordLabel.getText(), setEmployeeNumber(usernameLabel.getText()));
    }

}

@FXML
        private void updateTime(MouseEvent event) {
        timeAndDate();
        timeLabel.setText(getDatoTid());
    }

    @FXML
        private void exitButton(ActionEvent event) {
        closeWindow(event);
    }

    public int setEmployeeNumber(String name) {
        String sqlString = "SELECT employeeNumber FROM users WHERE username = '" + name + "';";

        try {
            sql.openConnection();
            con = sql.getCon();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlString);
            while (rs.next()) {
                employeeNumber = rs.getInt(1);

            }
            sql.closeConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return employeeNumber;
    }

}
