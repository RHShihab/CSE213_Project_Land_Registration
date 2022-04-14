/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg.ROfficerScenes;

import Messages.OfferMessage;
import Properties.Property;
import Users.RegistrationOfficer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mainpkg.AppendableObjectOutputStream;
import static mainpkg.PropertyList.GetListOfProperty;
import mainpkg.SignUpSceneController;

/**
 * FXML Controller class
 *
 * @author shiha
 */
public class ROfficer_TransferListSceneController implements Initializable {
    RegistrationOfficer ROfficer;
    ObservableList<OfferMessage>transferReqList = FXCollections.observableArrayList();
    ObservableList<OfferMessage> allOffers = FXCollections.observableArrayList();
    @FXML    private TableView<OfferMessage> requestListTable;
    @FXML    private TableColumn<OfferMessage, String> sellerNameColumn;
    @FXML    private TableColumn<OfferMessage, Integer> askingPriceColumn;
    @FXML    private TableColumn<OfferMessage, String> buyerNameColumn;
    @FXML    private TableColumn<OfferMessage, Integer> finalPriceColumn;
    @FXML    private TableColumn<OfferMessage, String> propertyNameColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    void initData(RegistrationOfficer ROfficer) {
        this.ROfficer = ROfficer;
        allOffers = OfferMessage.getListOfMessages();
        for(OfferMessage i: allOffers){
            if(i.isIsAccepted()){
                transferReqList.add(i);
            }
        }
        
        sellerNameColumn.setCellValueFactory(new PropertyValueFactory<>("sellerName"));
        askingPriceColumn.setCellValueFactory(new PropertyValueFactory<>("askingPrice"));
        buyerNameColumn.setCellValueFactory(new PropertyValueFactory<>("buyerName"));
        finalPriceColumn.setCellValueFactory(new PropertyValueFactory<>("finalPrice"));
        propertyNameColumn.setCellValueFactory(new PropertyValueFactory<>("propertyName"));
        requestListTable.setItems(transferReqList);
    }
    
    @FXML
    private void approveButtonClick(ActionEvent event) {
        //soldProperties
        OfferMessage selectedItem = requestListTable.getSelectionModel().getSelectedItem();
        
        writeToFile(selectedItem); //updates soldPropertiesList.bin
        allOffers.remove(selectedItem);
        replaceFile(allOffers); //rewrites the OfferMessage.bin
        
        ArrayList<Property> listOfProperty = GetListOfProperty();
        Property deletedProperty = null;
        for(Property i: listOfProperty){
            if(selectedItem.getPropertyName().equals(i.getName())){
                deletedProperty = i;
            }
        }
        if(deletedProperty != null){
            listOfProperty.remove(deletedProperty);
            System.out.println("property has been deleted");
        }
        replacepropertyList(listOfProperty);
    }

    @FXML
    private void declineButtonClick(ActionEvent event) {
    }

    @FXML
    private void backButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ROfficer_HomeScene.fxml"));
        Parent homeScene = loader.load();
        Scene rOfficerHomePage = new Scene(homeScene);
        ROfficer_HomeSceneController controller = loader.getController();
        controller.initData(ROfficer);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(rOfficerHomePage);
        window1.show();
    }
    
    private void writeToFile(OfferMessage selectedItem){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("soldPropertiesList.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(selectedItem);

        } catch (IOException ex) {
            Logger.getLogger(SignUpSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(SignUpSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void replaceFile(ObservableList<OfferMessage> allOffers){
        /////rewrites the file with the changed selected message (where isAccepted = true)
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("OfferMessage.bin");

                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);

            try {
                for (OfferMessage i : allOffers) {
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
    
    private void replacepropertyList(ArrayList<Property> listOfProperty){
        /////rewrites the file with the changed selected message (where isAccepted = true)
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("listOfProperty.bin");

                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);

            try {
                for (Property i : listOfProperty) {
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
}
