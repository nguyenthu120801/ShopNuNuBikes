/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author buidu
 */
public class staff {
    private int staffID,active,storeID,managerID;
    private String firstName,lastName,email,phone, username, password;

    public staff() {
    }

    public staff(int staffID, int active, int storeID, int managerID, String firstName, String lastName, String email, String phone) {
        this.staffID = staffID;
        this.active = active;
        this.storeID = storeID;
        this.managerID = managerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public staff(int staffID, int active, int storeID, int managerID, String firstName, String lastName, String email, String phone, String username, String password) {
        this.staffID = staffID;
        this.active = active;
        this.storeID = storeID;
        this.managerID = managerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getStaffID() {
        return staffID;
    }

    public int getActive() {
        return active;
    }

    public int getStoreID() {
        return storeID;
    }

    public int getManagerID() {
        return managerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "staff{" + "staffID=" + staffID + ", active=" + active + ", storeID=" + storeID + ", managerID=" + managerID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + '}';
    }
    
}
