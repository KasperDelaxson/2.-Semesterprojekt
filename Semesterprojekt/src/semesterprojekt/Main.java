/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterprojekt;

import java.util.ArrayList;

/**
 *
 * @author mehme
 */

//Jeg har lavet denne klasse fordi jeg tænkte vi havde brug for en klasse hvor
//stort set alt vores kode skulle foregå
public class Main {
    
    private ArrayList<User> users;
   
    public static void main(String args[]) {
        //users = new ArrayList<User>();
        SQLConnection con = new SQLConnection();
        con.openConnection();
        //con.addEmployee(2,"sanne",12345678,"sanne@hotmail.com","sanne123","sanneerhot",5);
        con.getEmployee("sanne");
        con.closeConnection();
    }
    
    public void createUser(User user, ArrayList<User> users) {
        users.add(user);
    }
    
    public void createUsers() {
        
    }
    
}
