/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterprojekt;

import java.sql.*;

/**
 *
 * @author Malthe
 */
public class SQLConnection {

    private final String url = "jdbc:postgresql://balarama.db.elephantsql.com:5432/cyxmirsh";
    private final String username = "cyxmirsh";
    private final String password = "DFphZvwuCLTpqv7BxuaqbjlHrjFfz4PJ";
    private Connection con;

    public void openConnection() {

        try {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected.");
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
    }

    public void closeConnection() {
        try {
            con.close();
            System.out.println("Connection closed.");
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
    public void deleteEmployee(int employeenumber, String name, int phoneNumber, String username, String password){
        String sql = "DELETE FROM users WHERE employeenumber = '" + employeenumber + "' AND name = '" + name + "'"
                + "AND phone = '" + phoneNumber + "' AND username = '" + username + "' AND password = '" + password + "';";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            displayActor(rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getUsers() {
        String sql = "SELECT name FROM users;";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            displayActor(rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void displayActor(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(rs.getString("name"));
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
}
