/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg.BuyerScenes;

import Properties.Property;
import Users.Buyer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shiha
 */
public class Buyer_PropertyDetailsSceneController implements Initializable {
    Buyer buyer;
    Property selectedProperty;
    @FXML    private TextArea propertyDetailsTextArea;
    @FXML    private Label landTitleTextField;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void initData(Buyer buyer, Property selectedProperty) {
        this.buyer = buyer;
        this.selectedProperty = selectedProperty;
        landTitleTextField.setText("Details of "+selectedProperty.getName() +":");
        propertyDetailsTextArea.setText(selectedProperty.toString());
    }

    @FXML
    private void makeOfferButtonClick(ActionEvent event) {
    }

    @FXML
    private void backButonClick(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("Buyer_SearchProperty.fxml"));
        Parent root = loader1.load();
        Scene buyerHomePage = new Scene(root);
        Buyer_SearchPropertyController controller1 = loader1.getController();
        controller1.initData(buyer);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(buyerHomePage);
        window1.show();
    }
    
    
}
