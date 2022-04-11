/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg.BuyerScenes;

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
import javafx.stage.Stage;
import mainpkg.MainClass;

/**
 * FXML Controller class
 *
 * @author shiha
 */
public class Buyer_HomeSceneController implements Initializable {

    @FXML    private Label WelcomeLabel;
    Buyer buyer;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void initData(Buyer buyer) {
        this.buyer = buyer;
        WelcomeLabel.setText(buyer.getFullName());
    }

    @FXML
    private void logOutButtonClick(ActionEvent event) throws IOException {
        //closes the app
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        stage.close();
        
        Parent scene2Parent = FXMLLoader.load(MainClass.class.getResource("HomeScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);   
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

    @FXML
    private void searchPropertyButtonClick(ActionEvent event) throws IOException {
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
