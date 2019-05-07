/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterprojekt;

import java.security.Permission;
import java.util.UUID;

/**
 *
 * @author mehme
 */
public class User {


    private String username;
    private String password;
    private int permission;

    public User(String username, String password, int permission) {
 
        this.username = username;
        this.password = password;
        this.permission = permission;

    }



    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPermission() {
        return permission;
    }
    


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

}

