/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg.ROfficerScenes;

import Messages.requestList;
import Users.RegistrationOfficer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author shiha
 */
public class ROfficer_TransferListSceneController implements Initializable {
    RegistrationOfficer ROfficer;
    @FXML    private TableView<requestList> requestListColumn;
    @FXML    private TableColumn<requestList, String> sellerNameColumn;
    @FXML    private TableColumn<requestList, String> askingPriceColumn;
    @FXML    private TableColumn<requestList, String> buyerNameColumn;
    @FXML    private TableColumn<requestList, String> finalPriceColumn;
    @FXML    private TableColumn<requestList, String> propertyNameColumn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void initData(RegistrationOfficer ROfficer) {
        this.ROfficer = ROfficer;
    }
    
    @FXML
    private void approveButtonClick(ActionEvent event) {
    }

    @FXML
    private void declineButtonClick(ActionEvent event) {
    }

    @FXML
    private void backButtonClick(ActionEvent event) {
    }
    
}
