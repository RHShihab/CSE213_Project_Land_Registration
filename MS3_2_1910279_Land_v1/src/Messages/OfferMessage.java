
package Messages;

import Properties.*;
import Users.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mainpkg.AppendableObjectOutputStream;
import mainpkg.SignUpSceneController;

public class OfferMessage implements Serializable{
    Property property;
    Buyer buyer;
    String propertyName, prefPrice, noteToSeller;
    int propertyPrice;
    boolean isAccepted = false;
    
    public OfferMessage(Property property, String prefPrice, String noteToSeller, Buyer buyer) {
        this.property = property;
        this.prefPrice = prefPrice;
        this.noteToSeller = noteToSeller;
        this.propertyPrice = property.getPrice();
        this.propertyName = property.getName();
        this.buyer = buyer;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Property getProperty() {
        return property;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getPrefPrice() {
        return prefPrice;
    }

    public String getNoteToSeller() {
        return noteToSeller;
    }

    public int getPropertyPrice() {
        return propertyPrice;
    }

    public boolean isIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    public String getMessage(){
        return "work in progress!!!";
    }
    
    public void addOfferMessageToList(){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("OfferMessage.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(this);

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
    
    public static ObservableList<OfferMessage> getListOfMessages(){
        ObservableList<OfferMessage> listOfMessages = FXCollections.observableArrayList();
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
            f = new File("OfferMessage.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            OfferMessage m;
            try{
                while(true){
                    m = (OfferMessage)ois.readObject();
                    listOfMessages.add(m);
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
        return listOfMessages;
    }

}
