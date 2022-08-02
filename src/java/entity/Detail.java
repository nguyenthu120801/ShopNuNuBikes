/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public class Detail {
    private int ProductID;
    private String Productname;
    private int Quantity;
    private double listPrice;

    public Detail() {
    }

    public Detail(int ProductID, String Productname, int Quantity, double listPrice) {
        this.ProductID = ProductID;
        this.Productname = Productname;
        this.Quantity = Quantity;
        this.listPrice = listPrice;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductname() {
        return Productname;
    }

    public void setProductname(String Productname) {
        this.Productname = Productname;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    
}
