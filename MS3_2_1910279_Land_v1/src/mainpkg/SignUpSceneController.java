/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import Users.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shiha
 */
public class SignUpSceneController implements Initializable {

    @FXML    private TextField FullName;
    @FXML    private ComboBox signUpComboBox;
    @FXML    private TextField email;
    @FXML    private TextField password;
    @FXML    private TextField confirmPassword;
    private TextArea fileOutput;
    @FXML    private TextField userName;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        signUpComboBox.getItems().addAll("Buyer","Seller","Real Estate Agent","Registration Officer","Ministry of Land Officer");
    }    

    @FXML
    private void signUpButtonClick(ActionEvent event) {
        UserList.signUp(FullName.getText(), userName.getText(), password.getText()
                , signUpComboBox.getValue().toString(), email.getText());         
        
        ArrayList<User>uList = UserList.GetListOfUser();
        for(User i : uList){
            if(i instanceof Buyer) System.out.print("Buyer:\t");
            else if(i instanceof Seller) System.out.print("Seller:\t");
            else if(i instanceof REA) System.out.print("REA:\t");
            else if(i instanceof RegistrationOfficer) System.out.print("R Officer:\t");
            else if(i instanceof MolOfficer) System.out.print("MolOfficer:\t");
            
            System.out.println(i.toString());
        }
    }

    @FXML
    private void goToHomeSceneButtonClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("HomeScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
               
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene2);
        window.show();
    }

//    private void loadBinDataButtonClick(ActionEvent event) {
//        
//        ArrayList<User> listOfUser = new ArrayList<User>();
//        
//        fileOutput.setText("");
//        File f = null;
//        FileInputStream fis = null;      
//        ObjectInputStream ois = null;
//        
//        try {
//            f = new File("user.bin");
//            fis = new FileInputStream(f);
//            ois = new ObjectInputStream(fis);
//            User s;
//            try{
//                fileOutput.setText("");
//                while(true){
//                    System.out.println("Printing objects.");
//                    s = (User)ois.readObject();
//                    
//                    System.out.println(s.toString());
//                    fileOutput.appendText(s.toString() + "\n");
//                }
//            }//end of nested try
//            catch(Exception e){
//            }//nested catch     
//            fileOutput.appendText("\nAll objects are loaded successfully...\n");            
//        } catch (IOException ex) { } 
//        finally {
//            try {
//                if(ois != null) ois.close();
//            } catch (IOException ex) { }
//        }  
//    }
    
}
