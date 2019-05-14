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

    private static Employee e;
    private String username;
    private String password;
    private int employeeNumber;
    private int permission;

    private Employee(String username, String password, int employeeNumber, int permission) {
        super(username, password, employeeNumber);
        this.username = username;
        this.password = password;
        this.employeeNumber = employeeNumber;
        this.permission = permission;
    }

    public static void setEmployee(String username, String password, int employeeNumber, int permission) {
        e = new Employee(username, password, employeeNumber, permission);
    }
    public static Employee getEmployee(){
        return e;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public boolean isPedagogue() {
        return true;
    }

    public boolean isSocialWorker() {
        return false;
    }

    public boolean isDoctor() {
        return false;
    }
}
