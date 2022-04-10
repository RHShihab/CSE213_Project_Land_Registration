/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import mainpkg.BuyerScenes.Buyer_HomeSceneController;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainpkg.SellerScenes.Seller_HomeSceneController;

/**
 *
 * @author shiha
 */
public class HomeSceneController implements Initializable {

    @FXML    private TextField Name;
    @FXML    private TextField Password;
    @FXML    private ComboBox<String> UserTypeComboBox;
    @FXML    private Label logInError;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<User>uList = UserList.GetListOfUser();
        for(User i : uList){
            if(i instanceof Buyer) System.out.print("Buyer:\t");
            else if(i instanceof Seller) System.out.print("Seller:\t");
            else if(i instanceof REA) System.out.print("REA:\t");
            else if(i instanceof RegistrationOfficer) System.out.print("R Officer:\t");
            else if(i instanceof MolOfficer) System.out.print("MolOfficer:\t");
            
            System.out.println(i.toString());
        }
        UserTypeComboBox.getItems().addAll("Buyer","Seller","Real Estate Agent","Registration Officer","Ministry of Land");
    }    

    @FXML
    private void goToSignUpSceneButtonClick(ActionEvent event) throws IOException {
        
        //opening new another scene in the existing window
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("SignUpScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);   
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

    @FXML
    private void loginButtonClick(ActionEvent event) throws IOException {
        //login(String userName, String password, String userType)
//        "".equals(Name.getText()) || "".equals(Password.getText()) || 
        if("".equals(Name.getText()) || "".equals(Password.getText()) || UserTypeComboBox.getValue()==null){
            logInError.setText("shob fill up koro PLEASE");
        } else {
            User loggedInUser = User.login(Name.getText(),
                    Password.getText(),
                    UserTypeComboBox.getValue());
            if(loggedInUser == null){
                logInError.setText("User name and password didn't match");
            }
            else {
                if(loggedInUser instanceof Buyer){
                    //opening new scene in the existing window with the user data
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("BuyerScenes/Buyer_HomeScene.fxml"));
                    Parent root = loader.load();
                    Scene buyerHomePage = new Scene(root);
                    Buyer_HomeSceneController controller1 = loader.getController();
                    controller1.initData((Buyer)loggedInUser);
                    Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window1.setScene(buyerHomePage);
                    window1.show();
                }
                else if(loggedInUser instanceof Seller){
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("SellerScenes/Seller_HomeScene.fxml"));
                    Parent homeScene = loader.load();
                    Scene sellerHomePage = new Scene(homeScene);
                    Seller_HomeSceneController controller = loader.getController();
                    controller.initData((Seller)loggedInUser);
                    Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window1.setScene(sellerHomePage);
                    window1.show();
                }
                else if(loggedInUser instanceof REA){
                    logInError.setText("Hello Mr. " + loggedInUser.getFullName());
                }
            }
        }
    }
    
}
