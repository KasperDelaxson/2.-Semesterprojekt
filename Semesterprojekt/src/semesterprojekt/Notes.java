/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterprojekt;

import java.util.Date;

/**
 *
 * @author mehme
 */
public class Notes {
    
    private String name;
    private Date date;
    
    public Notes(String name, Date date) {
        this.name = name;
        this.date = date;
        
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}
