/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterprojekt;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import mainAndParent.ParentController;

/**
 *
 * @author Malthe
 */
public class SQLConnection extends ParentController {

    private final String url = "jdbc:postgresql://balarama.db.elephantsql.com:5432/cyxmirsh";
    private final String username = "cyxmirsh";
    private final String password = "DFphZvwuCLTpqv7BxuaqbjlHrjFfz4PJ";
    private Connection con;
    private ArrayList<String> nameList = new ArrayList<String>();
    private int permissionNumber;
    private String name;

    public void openConnection() {

        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
    }

    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("No connection to close.");
        }
    }

    public void addEmployee(int employeeNumber, String name, int phone, String mail, String username, String password, int permission) {
        String sql = "INSERT INTO users(uuid,employeenumber,name,phone,mail,username,password,permission) VALUES ((select uuid_generate_v4()) ," + employeeNumber + ",'" + name + "'," + phone + ",'" + mail + "','" + username + "','" + password + "'," + permission + ");";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println("Succes.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getEmployee(String name) {
        String sql = "SELECT * FROM users WHERE name = '" + name + "';";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            displayActor(rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteEmployee(int employeenumber, String name, int phoneNumber, String username, String password) {
        String sql = "DELETE FROM users WHERE employeenumber = '" + employeenumber + "' AND name = '" + name + "'"
                + "AND phone = '" + phoneNumber + "' AND username = '" + username + "' AND password = '" + password + "';";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getUsers() {
        openConnection();
        String sql = "SELECT name FROM users;";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            displayActor(rs);
            closeConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void displayActor(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("username"));
        }
    }

    public boolean checkLogin(String username, String password) throws SQLException {
        boolean loginCheck = false;
        try {

            String pass = "5rfbu7tggbnjuy67cbh7rdvbhytr23489098765432wdv";
            openConnection();
            String sql = "SELECT password FROM users WHERE username = '" + username + "';";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                pass = rs.getString("password");
            }

            closeConnection();

            if (pass.equals(password)) {
                loginCheck = true;
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return loginCheck;
    }

    public Connection getCon() {

        try {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected.");
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        return con;
    }

    public ArrayList seeClientList() {

        Employee e = Employee.getEmployee();
        String sqlString = "SELECT socialsecurity FROM patient WHERE employeeassigned = " + e.getEmployeeNumber() + ";";
        ArrayList<String> socials = new ArrayList<String>();

        try {
            openConnection();
            Connection con = getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlString);
            int i = 1;
            while (rs.next()) {
                socials.add(rs.getString(i));
            }

            i = 0;
            while (i < socials.size()) {
                String sqlString2 = "SELECT name FROM patient WHERE socialSecurity = '" + socials.get(i) + "';";
                Statement st2 = con.createStatement();
                ResultSet rs2 = st2.executeQuery(sqlString2);

                while (rs2.next()) {
                    nameList.add(rs2.getString(1));
                }
                i++;
            }
            closeConnection();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        ArrayList<String> sortedNameList = removeDuplicates(nameList);

        return sortedNameList;
    }

    private <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
        ArrayList<T> newList = new ArrayList<T>();
        for (T element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }

    /**
     * @return the permissionNumber
     */
    public int getPermissionNumber() {
        return permissionNumber;
    }

    /**
     * @param permissionNumber the permissionNumber to set
     */
    public void setPermissionNumber(int permissionNumber) {
        this.permissionNumber = permissionNumber;
    }

    public void getPermission(String username) {
        openConnection();
        String sql = "SELECT permission FROM users WHERE username = '" + username + "';";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int i = rs.getInt("permission");
                setPermissionNumber(i);
            }
            closeConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeName(String username) {
        String fullName = null;
        String sql = "SELECT name FROM users WHERE username = '" + username + "';";
        try {
            openConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                fullName = rs.getString("name");
                setName(fullName);
            }
            closeConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return fullName;
    }

    public ArrayList getDates(String name) {
        String sqlString = "SELECT created FROM journal WHERE patientsocialSecurity = "
                + "(SELECT socialSecurity FROM patient WHERE name = '" + name + "');";
        ArrayList<String> dates = new ArrayList<String>();
        try {
            openConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlString);
            while (rs.next()) {
                dates.add(rs.getString(1));
            }
        } catch (SQLException e) {
        }

        return dates;
    }

    public String getJournal(String date) {

        String returnString = null;
        String sqlString = "SELECT takeNotes FROM Journal WHERE created = '" + date + "';";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlString);
            while (rs.next()) {
                returnString = rs.getString(1);
            }
        } catch (SQLException e) {
        }
        return returnString;
    }

    public String getNameForList() {
        Employee e = Employee.getEmployee();
        String sqlString = "SELECT name FROM users WHERE username = '" + e.getUsername() + "';";
        String name = "user";
        try {
            openConnection();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlString);
            while (rs.next()) {
                name = rs.getString(1);
            }
            closeConnection();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return name;
    }

    public void saveNote(String name, String text) {
        String now = getTimeAndDate();
        String sql = "INSERT INTO journal(takenotes,employeeassigned,patientsocialsecurity,created)"
                + "VALUES ('" + text + "',"
                + Employee.getEmployee().getEmployeeNumber()
                + ",(SELECT socialsecurity FROM patient WHERE name = '" + name + "')"
                + ", '" + now + "');";
        try {
            openConnection();
            Statement st = con.createStatement();
            st.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Error");
        }
    }
    public String getTimeAndDate() {
        LocalDateTime lokalDatoTid = LocalDateTime.now();
        DateTimeFormatter datoformat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTime = lokalDatoTid.format(datoformat);
        return dateTime;
    }

    public void addPatient(String name, int phone, String mail, String socialsecurity, String username, String password, int permission, int employeeassigned) {
        String sql = "INSERT INTO patient(uuid,name,phone,mail,socialsecurity,username,password,permission,employeeassigned) "
                + "VALUES ((select uuid_generate_v4()) ,'" + name + "'," + "" + phone + ",'" + mail + "','" + socialsecurity + "','" + username + "','" + password + "'," + permission + "," + employeeassigned + ");";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println("Succes.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deletePatient(String name, int phoneNumber, String mail, String username, String password, String socialsecurity) {
        String sql = "DELETE FROM patient WHERE socialsecurity = '" + socialsecurity + "' AND name = '" + name + "'"
                + "AND phone = " + phoneNumber + " AND mail = '" + mail + "' AND username = '" + username + "' AND password = '" + password + "';";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getPatients() {
        openConnection();
        String sql = "SELECT name, phone, mail, socialsecurity FROM patient ORDER BY name;";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
            }
            closeConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
