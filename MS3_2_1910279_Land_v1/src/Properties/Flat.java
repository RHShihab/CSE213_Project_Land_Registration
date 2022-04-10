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
public class Flat extends Property implements Serializable{
    protected int size;

    public Flat(String name, String ownerId, int price, 
            String street, String area, String district, String division,
            int size) {
        super(name, ownerId, price, street, area, district, division);
        this.size = size;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public int getPrice() {
        return price;
    }

    public Address getAddress() {
        return address;
    }

    public int getSize() {
        return size;
    }
    
    @Override
    public String toString(){
        return "Property name: " + name + ", Owner ID: " + ownerId + ", Price: " + price
                + "\nFlat details: Size of flat: " + size
                + "\nAddress: " +address;
    }
}
