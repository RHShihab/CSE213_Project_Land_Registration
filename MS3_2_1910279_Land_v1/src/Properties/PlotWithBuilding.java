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
public class PlotWithBuilding extends Property implements Serializable{
    protected int noOfFloor, areaPerFloor;
    
    public PlotWithBuilding(String name, String ownerId, String note, int price, 
            String street, String area, String district, String division, 
            int noOfFloor, int areaPerFloor) {
        super(name, ownerId, note, price, street, area, district, division);
        this.noOfFloor = noOfFloor;
        this.areaPerFloor = areaPerFloor;
    }

    public int getNoOfFloor() {
        return noOfFloor;
    }

    public int getAreaPerFloor() {
        return areaPerFloor;
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

    public String getNote() {
        return note;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    
    @Override
    public String toString(){
        return "Name: " + name + ", Owner ID: " + ownerId + ", Price: " + price
                + "\nPlot with building details: No of floors: " + noOfFloor + ", Area per Floor: " + areaPerFloor
                + "\nAddress: " +address
                + "\nNote:\n" + note;
    }
    
}
