/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

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
import mainpkg.SellerScenes.DummySceneController;

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
            System.out.println(i.toString());
        }
        UserTypeComboBox.getItems().addAll("Buyer","Seller","Real Estate Agent","Registration Officer","Ministry of Land");
    }    

    @FXML
    private void goToSignUpSceneButtonClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("SignUpScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
               
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene2);
        window.show();
    }

    @FXML
    private void loginButtonClick(ActionEvent event) throws IOException {
        //login(String userName, String password, String userType)
        User loggedInUser = User.login(Name.getText(), 
                                       Password.getText(), 
                                       UserTypeComboBox.getValue());
        if(loggedInUser == null){
            logInError.setText("User name and password didn't match");
        }
        else {
            if(loggedInUser instanceof Buyer){
                logInError.setText("Hello Mr. " + loggedInUser.getFullName());
                
                FXMLLoader loader1 = new FXMLLoader();
                loader1.setLocation(getClass().getResource("BuyerHomeScene.fxml"));
                Parent homeScene1 = loader1.load();
                Scene homepage1 = new Scene(homeScene1);
                BuyerHomeSceneController controller1 = loader1.getController();
                controller1.initData((Buyer)loggedInUser);
                Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window1.setScene(homepage1);
                window1.show();
            }
            else if(loggedInUser instanceof Seller){
                logInError.setText("Hello Mr. " + loggedInUser.getFullName());
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("SellerScenes/DummyScene.fxml"));
                Parent homeScene = loader.load();
                Scene sellerHomePage = new Scene(homeScene);
                DummySceneController controller = loader.getController();
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
