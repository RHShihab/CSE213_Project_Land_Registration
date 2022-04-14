/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg.SellerScenes;

import Messages.OfferMessage;
import static Messages.OfferMessage.getListOfMessages;
import Properties.Property;
import Users.Seller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * FXML Controller class
 *
 * @author shiha
 */
public class Seller_OfferListSceneController implements Initializable{
    Seller seller;
    ObservableList<OfferMessage> currentUserOffers = FXCollections.observableArrayList();
    ObservableList<OfferMessage> otherUserOffers = FXCollections.observableArrayList();
    @FXML    private TableView<OfferMessage> offerViewTable;
    @FXML    private TableColumn<OfferMessage, String> propertyNameColumn;
    @FXML    private TableColumn<OfferMessage, Integer> yourPrice;
    @FXML    private TableColumn<OfferMessage, String> buyerPrice;
    @FXML    private TableColumn<OfferMessage, String> Comments;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    void initData(Seller seller) {
        this.seller = seller;
        
        propertyNameColumn.setCellValueFactory(new PropertyValueFactory<>("propertyName"));
        yourPrice.setCellValueFactory(new PropertyValueFactory<>("propertyPrice"));
        buyerPrice.setCellValueFactory(new PropertyValueFactory<>("prefPrice"));
        Comments.setCellValueFactory(new PropertyValueFactory<>("noteToSeller"));
        
        ObservableList<OfferMessage> allOffers = OfferMessage.getListOfMessages();
        for(OfferMessage i: allOffers){
            if(i.getProperty().getOwnerId().equals(seller.getUserName())){
                if(!i.isIsAccepted()){
                    currentUserOffers.add(i);
                }
            }
            else{
                otherUserOffers.add(i);
            }
        }
        offerViewTable.setItems(currentUserOffers);
    }

    @FXML
    private void approveOfferButtonClick(ActionEvent event) {
        ObservableList<OfferMessage> listOfUpdatedMessages = FXCollections.observableArrayList();

        OfferMessage selectedMessage = offerViewTable.getSelectionModel().getSelectedItem();
        //changes the status of selected message in the list
        for(OfferMessage i: currentUserOffers){
            if(selectedMessage == i){
                i.setIsAccepted(true);
                listOfUpdatedMessages.add(i);
            }
        }
        //do not add any message with the same property as the selected message
        for(OfferMessage i: currentUserOffers){
            if(selectedMessage.getProperty() == i.getProperty()){
                //do not add it to the list of updated Messages
            }
            else{
                listOfUpdatedMessages.add(i);
            }
        }
        //Add the other user offer messages to the updated messages
        for(OfferMessage i: otherUserOffers){
                listOfUpdatedMessages.add(i);
        }
        
        /////rewrites the file with the changed selected message (where isAccepted = true)
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("OfferMessage.bin");

                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);

            try {
                for (OfferMessage i : listOfUpdatedMessages) {
                    oos.writeObject(i);
                }
                oos.close();
            } catch (IOException ex) {
                oos.close();
            }
        } catch (Exception ex) {

        }
        System.out.println("List of messages has been updated");
    }

    @FXML
    private void backButtonClick(ActionEvent event) {
    }
    
}
