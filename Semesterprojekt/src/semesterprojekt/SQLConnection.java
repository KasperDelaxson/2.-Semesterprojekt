/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterprojekt;

import java.sql.*;
import javafx.collections.ObservableList;

/**
 *
 * @author Malthe
 */
public class SQLConnection {
    
    private final String url = "jdbc:postgresql://balarama.db.elephantsql.com:5432/cyxmirsh";
    private final String username = "cyxmirsh";
    private final String password = "DFphZvwuCLTpqv7BxuaqbjlHrjFfz4PJ";
    private Connection con;
    private ObservableList<String> nameList;
    
    
    public void openConnection(){
        
        try{
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected.");
        }
        catch(SQLException e){
            System.out.println(e.getErrorCode());
        }
    }
    public void closeConnection(){
        try{
        con.close();
            System.out.println("Connection closed.");
        }
        catch(SQLException e){
            System.out.println("No connection to close.");
        }
    }
    public void addEmployee(int employeeNumber, String name, int phone, String mail, String username, String password, int permission){
        String sql = "INSERT INTO users(uuid,employeenumber,name,phone,mail,username,password,permission) VALUES ((select uuid_generate_v4()) ," + employeeNumber + ",'" + name + "'," + phone + ",'" + mail + "','" + username + "','" + password + "'," + permission + ");";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println("Succes.");
        }
        catch(SQLException e){
                System.out.println(e.getMessage());
        }
    }
    public void getEmployee(String name){
        String sql = "SELECT * FROM users WHERE name = '" + name + "';";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            displayActor(rs); 
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private void displayActor(ResultSet rs) throws SQLException {
        while(rs.next()){
            System.out.println(rs.getString("uuid"));
            System.out.println(rs.getString("employeenumber"));
            System.out.println(rs.getString("name"));
            System.out.println(rs.getInt("phone"));
            System.out.println(rs.getString("mail"));
        }
    }
    public boolean checkLogin(String username, String password)throws SQLException {
        boolean loginCheck = false;
        try{
            
            String pass = "5rfbu7tggbnjuy67cbh7rdvbhytr23489098765432wdv";
            openConnection();
            String sql = "SELECT password FROM users WHERE username = '"+ username +"';";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
            pass = rs.getString("password");
            }
            
            closeConnection();
            
            if(pass.equals(password))
            {
                loginCheck = true;
            }
        }
        catch(SQLException e){
            e.getMessage();
        }
        return loginCheck;
    }
    public Connection getCon(){
                        
        try{
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected.");
        }
        catch(SQLException e){
            System.out.println(e.getErrorCode());
        }
        return con;
    }
    
    public ObservableList seeClientList() {

        Employee e = Employee.getEmployee();
        String sqlString = "SELECT patientsocialsecurity FROM journal WHERE employeeassigned = " + e.getEmployeeNumber() + ";";
        String social;
        System.out.println();
        try {
            openConnection();
            Connection con = getCon();
            int i = 1;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlString);
            System.out.println(i);
            while (rs.next()) { 
                social = rs.getString(i);
                String sqlString2 = "SELECT name FROM patient WHERE socialsecurity='" + social + "';";
                Statement st2 = con.createStatement();
                ResultSet rt = st2.executeQuery(sqlString2);
                nameList.add(rt.getString(i));
                System.out.println(i);
                i++;
                
            }
            closeConnection();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
            
        }
        return nameList;
    }
}

