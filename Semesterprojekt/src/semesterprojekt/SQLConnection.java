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
}

