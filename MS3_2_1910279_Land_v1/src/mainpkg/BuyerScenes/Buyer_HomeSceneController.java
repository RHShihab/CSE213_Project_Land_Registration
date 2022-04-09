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

/**
 * FXML Controller class
 *
 * @author shiha
 */
public class Buyer_HomeSceneController implements Initializable {

    @FXML
    private Label WelcomeLabel;
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
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void logOutButtonClick(ActionEvent event) throws IOException {
        //for going to another scene in the existing windows
        
//        Parent scene2Parent = FXMLLoader.load(getClass().getResource("I:/IUB/CSE213_oop/New_semester/Git/CSE213_Project_Land_Registration/MS3_2_1910279_Land_v1/src/mainpkg/BuyerScenes/SignUpScene.fxml"));
//        Scene scene2 = new Scene(scene2Parent);   
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        window.setScene(scene2);
//        window.show();

//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        Parent scene2Parent = FXMLLoader.load(getClass().getResource("HomeScene.fxml");
//        Stage stage2 = ;
        
//        stage.close();
    }
    
}
