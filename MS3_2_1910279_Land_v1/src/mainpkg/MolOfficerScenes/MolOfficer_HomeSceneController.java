/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg.MolOfficerScenes;

import Messages.OfferMessage;
import Properties.Property;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import mainpkg.MainClass;

/**
 * FXML Controller class
 *
 * @author shiha
 */
public class MolOfficer_HomeSceneController implements Initializable {
    RegistrationOfficer registrationOfficer;
    @FXML    private Label WelcomeLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void initData(RegistrationOfficer registrationOfficer) {
        this.registrationOfficer = registrationOfficer;
        WelcomeLabel.setText("Welcome " + registrationOfficer.getFullName());
    }

    @FXML
    private void logOutButtonClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(MainClass.class.getResource("HomeScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);   
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

    @FXML
    private void transferRequestButtonClick(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MolOfficer_ListOfSoldPropertiesScene.fxml"));
        Parent homeScene = loader.load();
        Scene mOfficerHomePage = new Scene(homeScene);
        MolOfficer_ListOfSoldPropertiesSceneController controller = loader.getController();
        controller.initData(registrationOfficer);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(mOfficerHomePage);
        window1.show();
    }

    @FXML
    private void printSomethingButtonClick(ActionEvent event) {
    }
    
}
