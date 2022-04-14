/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg.BuyerScenes;

import Messages.OfferMessage;
import Properties.*;
import Users.*;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shiha
 */
public class Buyer_MakeOfferSceneController implements Initializable {
    Buyer buyer;
    Property selectedProperty;
    @FXML    private Label propertyNameTextField;
    @FXML    private TextField preferredPriceTextField;
    @FXML    private TextArea noteToBuyerTextArea;
    @FXML    private Label messageErrorLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    void initData (Buyer buyer, Property selectedProperty){
        this.buyer = buyer;
        this.selectedProperty = selectedProperty;
        propertyNameTextField.setText("Making offer to " + selectedProperty.getName() + ":");
    }

    @FXML
    private void confirmOfferButtonClick(ActionEvent event) throws IOException {
        String preferredPrice = preferredPriceTextField.getText();
        String noteToBuyer = noteToBuyerTextArea.getText();
        
        if("".equals(preferredPrice) || "".equals(noteToBuyer)){
            messageErrorLabel.setText("Please fill up the form");
        }
        else{
            OfferMessage message = new OfferMessage(selectedProperty, preferredPrice, noteToBuyer, buyer);
            message.addOfferMessageToList();
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Buyer_HomeScene.fxml"));
            Parent root = loader.load();
            Scene buyerHomePage = new Scene(root);
            Buyer_HomeSceneController controller1 = loader.getController();
            controller1.initData(buyer);
            Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
            window1.setScene(buyerHomePage);
            ////////////////////////SHOW ALERT/////////////////////////
            window1.show();
        }
    }

    @FXML
    private void discardOfferButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Buyer_PropertyDetailsScene.fxml"));
        Parent personViewParent = loader.load();
        Scene personViewScene = new Scene(personViewParent);
        Buyer_PropertyDetailsSceneController controller = loader.getController();
        controller.initData(buyer, selectedProperty);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(personViewScene);
        window.show();
    }
    
}
