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
    
    public PlotWithBuilding(String name, String ownerId, int price, 
            String street, String area, String district, String division, 
            int noOfFloor, int areaPerFloor) {
        super(name, ownerId, price, street, area, district, division);
        this.noOfFloor = noOfFloor;
        this.areaPerFloor = areaPerFloor;
    }
    
    @Override
    public String toString(){
        return "Name: " + name + ", Owner ID: " + ownerId + ", Price: " + price
                + "\nPlot with building details: No of floors: " + noOfFloor + ", Area per Floor: " + areaPerFloor
                + "\nAddress: " +address;
    }
    
}
