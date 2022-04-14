package mainpkg;

import Users.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserList {
    
    public static void signUp(String name, String userName, String password, String userType, String email){
        if (userType == "Seller"){
            Seller tempUser = new Seller(name, userName, password, email);
            addUserToList(tempUser);
        }
        else if (userType == "Buyer"){
            Buyer tempUser = new Buyer(name, userName, password, email);
            addUserToList(tempUser);
        }else if (userType == "Real Estate Agent"){
            REA tempUser = new REA(name, userName, password, email);
            addUserToList(tempUser);
        }
        else if (userType == "Registration Officer"){
            RegistrationOfficer tempUser = new RegistrationOfficer(name, userName, password, email);
            addUserToList(tempUser);
        }
        else if (userType == "Ministry of Land Officer"){
            MolOfficer tempUser = new MolOfficer(name, userName, password, email);
            addUserToList(tempUser);
        }
    }
    
    public static void addUserToList(User signedUpUser){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("user.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(signedUpUser);

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
    
    public static ArrayList<User> GetListOfUser(){
        ArrayList<User> listOfUser = new ArrayList<>();
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("user.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User s;
            try{
                while(true){
                    s = (User)ois.readObject();
                    listOfUser.add(s);
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
        
        return listOfUser;
    }
}
