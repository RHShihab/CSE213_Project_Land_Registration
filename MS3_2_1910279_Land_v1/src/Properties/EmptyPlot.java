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

    public EmptyPlot(String name, String ownerId, int price, 
            String street, String area, String district, String division,
            int sizeOfPlot) {
        super(name, ownerId, price, street, area, district, division);
        this.sizeOfPlot = sizeOfPlot;
    }
    
    @Override
    public String toString(){
        return "Property name: " + name + ", Owner ID: " + ownerId + ", Price: " + price
                + "\nEmpty plot details: Size of plot: " + sizeOfPlot
                + "\nAddress: " +address;
    }
}
