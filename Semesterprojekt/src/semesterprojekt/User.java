/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterprojekt;

import java.util.UUID;

/**
 *
 * @author mehme
 */
public class User {
    
    private UUID id;
    private String username;
    private int permission;
    private String password;
    
    public User(UUID id, String username, String password, int permission) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.permission = permission;
    }
    
}
