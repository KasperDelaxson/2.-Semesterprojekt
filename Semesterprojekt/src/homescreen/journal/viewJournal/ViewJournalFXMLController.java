/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homescreen.journal.viewJournal;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import mainAndParent.ParentController;
import semesterprojekt.Employee;
import semesterprojekt.SQLConnection;

/**
 * FXML Controller class
 *
 * @author Kenneth Haahr
 */
public class ViewJournalFXMLController extends ParentController implements Initializable {

    /**
     * Initializes the controller class.
     */
    SQLConnection sql = new SQLConnection();
    @FXML
    private ListView<?> referalDatelist;
    @FXML
    private ListView<?> patientList;
    private ObservableList<String> nameList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        
    }

    @FXML
    private void goBackToNotesFromView(ActionEvent event) {
//        changeFXML("/homescreen/journal/journalFXML.fxml", event);
        seeClientList();
    }

    @FXML
    private void logOffButton(ActionEvent event) {
        changeFXML("/LoginPAGE/LoginPAGE.fxml", event);
    }

    private void seeClientList() {
// 1. orpet forbindelse til patientdatabase
// 2. vis liste over tilknyttede patienter
// 3. Vælg ønskede patien

        Employee e = Employee.getEmployee();
        String sqlString = "SELECT patientsocialsecurity FROM journal WHERE employeeassigned = " + e.getEmployeeNumber() + ";";
        String social;
        try {
            sql.openConnection();
            Connection con = sql.getCon();
            int i = 1;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlString);
            Statement st2 = con.createStatement();
            ResultSet rt ;
            while (rs.next()) {
                social = rs.getString(i);
                String sqlString2 = "SELECT name FROM patient WHERE socialsecurity='" + social + "';";
                rt = st2.executeQuery(sqlString2);
                //nameList.add(rs.getString(i));
                i++;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
//        patientList.getItems();
    }

    @FXML
    private void goBackToNotesFromView(MouseEvent event) {
// 1. orpet forbindelse til patientdatabase
// 2. vis liste over tilknyttede patienter
// 3. Vælg ønskede patien
    }

}
