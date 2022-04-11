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
public class EmptyPlot extends Property implements Serializable{
    
    protected int sizeOfPlot;

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public int getSizeOfPlot() {
        return sizeOfPlot;
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

    public String getNote() {
        return note;
    }

    public Address getAddress() {
        return address;
    }

    public EmptyPlot(String name, String ownerId, String note, int price, 
            String street, String area, String district, String division,
            int sizeOfPlot) {
        super(name, ownerId, note, price, street, area, district, division);
        this.sizeOfPlot = sizeOfPlot;
    }
    
    @Override
    public String toString(){
        return "Property name: " + name + ", Owner ID: " + ownerId + ", Price: " + price
                + "\nEmpty plot details: Size of plot: " + sizeOfPlot
                + "\nAddress: " +address
                + "\nNote:\n" + note;
    }
}
