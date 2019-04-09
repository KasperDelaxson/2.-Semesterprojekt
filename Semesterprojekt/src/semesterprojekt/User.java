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
    
    private UUID id;
   private String username; 
    private String password; 
    private int permission; 
    
    public User (UUID id, String username, String password, int permission) {
        this.id = id;
        this.username = username; 
        this.password = password;
        this.permission = permission;
       
        
    }

    public UUID getid() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermission() {
        return this.permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }
   
}
