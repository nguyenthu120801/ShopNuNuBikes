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
public class store {
    private int storeID;
    private String storeName,phone,email,street,city,state,zipCode;

    public store(int storeID, String storeName, String phone, String email, String street, String city, String state, String zipCode) {
        this.storeID = storeID;
        this.storeName = storeName;
        this.phone = phone;
        this.email = email;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public store() {
    }

    public int getStoreID() {
        return storeID;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "store{" + "storeID=" + storeID + ", storeName=" + storeName + ", phone=" + phone + ", email=" + email + ", street=" + street + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + '}';
    }
    
}
