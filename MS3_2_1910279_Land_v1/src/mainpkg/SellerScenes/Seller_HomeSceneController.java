/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg.SellerScenes;

import Properties.*;
import Users.*;
import java.io.IOException;
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
import mainpkg.PropertyList;

/**
 * FXML Controller class
 *
 * @author shiha
 */
public class Seller_HomeSceneController implements Initializable {

    @FXML
    private Label WelcomeLabel;
    Seller seller;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void initData(Seller seller) {
        this.seller = seller;
        WelcomeLabel.setText(seller.getFullName());
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void addPropertyButtonClick(ActionEvent event) throws IOException {
        //opening new scene in the existing window with the user data
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("Seller_AddPropertyScene.fxml"));
        Parent root = loader1.load();
        Scene scene = new Scene(root);
        Seller_AddPropertySceneController controller1 = loader1.getController();
        controller1.initData(seller);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(scene);
        window1.show();
    }

    @FXML
    private void listOfMyPropertiesButtonClick(ActionEvent event) {
        ArrayList<Property> listOfProperty = 
                PropertyList.GetListOfProperty();
        
        for (Property i: listOfProperty){
            if(i.getOwnerId().equals(seller.getUserName())){
                System.out.println(i);
                System.out.println("");
            }
        }
        System.out.println("List of Properties has been shown");
    }

    @FXML
    private void listOfOffersButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("Seller_OfferListScene.fxml"));
        Parent root = loader1.load();
        Scene scene = new Scene(root);
        Seller_OfferListSceneController controller1 = loader1.getController();
        controller1.initData(seller);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(scene);
        window1.show();
    }
    
}
