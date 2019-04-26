/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterprojekt;

import java.util.UUID;

/**
 *
 * @author ahashmathivathan
 */
public class Employee extends User {
  
    public Employee(UUID id, String username, String password, int permission) {
        super(id, username, password, permission);
    }
    
    public boolean isPedagogue()
    {
        return true;
    }
    
    public boolean isSocialWorker()
    {
        return false;
    }  
    
    public boolean isDoctor()
    {
        return false;
    }
}
