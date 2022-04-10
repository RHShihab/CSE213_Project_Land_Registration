/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import Properties.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shiha
 */
public class PropertyList {
    public static void createEmptyPlot(String name, String ownerId, int price, 
            String street, String area, String district, String division,
            int sizeOfPlot){
        EmptyPlot tempProp = new EmptyPlot(name, ownerId, price, 
                                           street, area, district, division,
                                           sizeOfPlot);
        addPropertyToList(tempProp);
        System.out.println(tempProp);
    }
    
    public static void createFlat(String name, String ownerId, int price, 
            String street, String area, String district, String division,
            int size){
        Flat tempProp = new Flat(name, ownerId, price, 
                                 street, area, district, division,
                                 size);
        addPropertyToList(tempProp);
        System.out.println(tempProp);
    }
    
    public static void createPlotWithBuilding(String name, String ownerId, int price, 
            String street, String area, String district, String division, 
            int noOfFloor, int areaPerFloor) {
        
        PlotWithBuilding tempProp = new PlotWithBuilding(name, ownerId, price, 
                                    street, area, district, division, 
                                    noOfFloor, areaPerFloor);
        addPropertyToList(tempProp);
        System.out.println(tempProp);
    }
    
    public static void addPropertyToList(Property newProperty){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("property.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(newProperty);

        } catch (IOException ex) {
            Logger.getLogger(SignUpSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(SignUpSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
    }
    
    public static ArrayList<Property> GetListOfProperty(){
        ArrayList<Property> listOfProperty = new ArrayList<>();
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("property.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Property p;
            try{
                while(true){
                    p = (Property)ois.readObject();
                    listOfProperty.add(p);
                }
            }//end of nested try
            catch(Exception e){
            }//nested catch     
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
//        for (Property i: listOfProperty){
////            if(i.getOwnerId().equals(seller.getUserName())){
//                System.out.println(i);
//                System.out.println("");
////            }
//        }
        return listOfProperty;
    }
}
