/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg.ROfficerScenes;

import Users.RegistrationOfficer;
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
public class ROfficer_HomeSceneController implements Initializable {
    RegistrationOfficer ROfficer;
    
    @FXML    private Label WelcomeLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void initData(RegistrationOfficer ROfficer) {
        this.ROfficer = ROfficer;
        WelcomeLabel.setText("Welcome " + ROfficer.getFullName());
    }

    @FXML
    private void logOutButtonClick(ActionEvent event) {
    }

    @FXML
    private void transferRequestButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ROfficer_TransferListScene.fxml"));
        Parent homeScene = loader.load();
        Scene rOfficerHomePage = new Scene(homeScene);
        ROfficer_TransferListSceneController controller = loader.getController();
        controller.initData(ROfficer);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(rOfficerHomePage);
        window1.show();
    }

    @FXML
    private void printSomethingButtonClick(ActionEvent event) {
    }
    
}
