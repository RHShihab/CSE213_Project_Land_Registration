/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg.MolOfficerScenes;

import Messages.OfferMessage;
import Users.RegistrationOfficer;
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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shiha
 */
public class MolOfficer_ListOfSoldPropertiesSceneController implements Initializable {
    RegistrationOfficer registrationOfficer;
    @FXML    private TextArea propertyListTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("soldPropertiesList.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            OfferMessage p;
            try{
                while(true){
                    p = (OfferMessage)ois.readObject();
                    propertyListTextArea.appendText(p.toString());
//                    listOfProperty.add(p);
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
    }    
    
    void initData(RegistrationOfficer registrationOfficer) {
        this.registrationOfficer = registrationOfficer;
    }

    @FXML
    private void backButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MolOfficer_HomeScene.fxml"));
        Parent homeScene = loader.load();
        Scene mOfficerHomePage = new Scene(homeScene);
        MolOfficer_HomeSceneController controller = loader.getController();
        controller.initData(registrationOfficer);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(mOfficerHomePage);
        window1.show();
    }

    
    
}
