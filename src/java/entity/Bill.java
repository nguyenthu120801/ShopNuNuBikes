/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public class Bill {
    private int ID;
    private String CustomerName;
    private String Date;
    private double total;
    private int status;

    public Bill() {
    }

    public Bill(int ID, String CustomerName, String Date, double total, int status) {
        this.ID = ID;
        this.CustomerName = CustomerName;
        this.Date = Date;
        this.total = total;
        this.status = status;
    }

    public Bill(int status) {
        this.status = status;
    }

    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
