/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Properties;

import java.io.Serializable;

/**
 *
 * @author shiha
 */
public abstract class Property implements Serializable{
    protected String name, ownerId, note;
    protected int price;
    protected Address address;
 
    Property(String name, String ownerId, String note, int price, 
            String street, String area, String district, String division){
        this.address = new Address(street, area, district, division);
        this.name = name;
        this.ownerId = ownerId;
        this.note = note;
        this.price = price;
    }
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Address getAddress() {
        return address;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    public String getOwnerId() {
        return ownerId;
    }

    public String getNote() {
        return note;
    }
    
    public String getDivision(){
        return address.getDivision();
    }
    
    @Override
    public String toString(){
        return "Name: " + name + ", Owner ID: " + ownerId + ", Price: " + price
                + "\nAddress:\n" +address
                + "\nNote:\n" + note;
    }
}
