/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg.SellerScenes;

import Users.*;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mainpkg.PropertyList;

/**
 * FXML Controller class
 *
 * @author shiha
 */
public class Seller_AddPropertySceneController implements Initializable {
    private Seller seller;
    private PropertyType_EmptyPlotController a;
    private PropertyType_plotWithBuildingController b;
    private PropertyType_FlatController c;
    
    @FXML    private TextField propertyNameTextField;
    @FXML    private TextField streetTextField;
    @FXML    private TextField areaTextField;
    @FXML    private TextField districtTextField;
    @FXML    private ComboBox<String> divisionComboBox;
    @FXML    private BorderPane propertyTypeBorderPane;
    @FXML    private ComboBox<String> propertyTypeComboBox;
    @FXML    private Label errorLabel;
    @FXML    private TextField propertyPriceTextField;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        divisionComboBox.getItems().addAll("Barishal", "Chittagong", 
                                           "Dhaka", "Khulna", 
                                           "Mymenshingh", "Rajshahi", 
                                           "Rangpur", "Sylhet");
        propertyTypeComboBox.getItems().addAll("Empty plot", 
                                               "Plot with Building",
                                               "Flat");
    }    

    void initData(Seller seller) {
        this.seller = seller;
    }

    @FXML
    private void savePropertyButtonClick(ActionEvent event) throws IOException {
        if("Empty plot".equals(propertyTypeComboBox.getValue())){
//            System.out.println(a.getSizeOfPlotTextField());
            
            PropertyList.createEmptyPlot(propertyNameTextField.getText(), 
                    seller.getUserName(), 
                    parseInt(propertyPriceTextField.getText()), 
                    streetTextField.getText(), 
                    areaTextField.getText(), 
                    districtTextField.getText(), 
                    divisionComboBox.getValue(),
                    parseInt(a.getSizeOfPlotTextField()));
            
            System.out.println("Empty plot has been created");
        }
        else if("Plot with Building".equals(propertyTypeComboBox.getValue())){
//            System.out.println(b.getNoOfFloorsTextField());
//            System.out.println(b.getAreaPerFloorTextField());
            
            PropertyList.createPlotWithBuilding(propertyNameTextField.getText(), 
                    seller.getUserName(), 
                    parseInt(propertyPriceTextField.getText()), 
                    streetTextField.getText(), 
                    areaTextField.getText(), 
                    districtTextField.getText(), 
                    divisionComboBox.getValue(), 
                    parseInt(b.getNoOfFloorsTextField()),
                    parseInt(b.getAreaPerFloorTextField()));
            
            System.out.println("Plot with Building has been created");
        }
        else if("Flat".equals(propertyTypeComboBox.getValue())){
//            System.out.println(c.getAreaTextField());
            
            PropertyList.createFlat(propertyNameTextField.getText(), 
                    seller.getUserName(), 
                    parseInt(propertyPriceTextField.getText()), 
                    streetTextField.getText(), 
                    areaTextField.getText(), 
                    districtTextField.getText(), 
                    divisionComboBox.getValue(),
                    parseInt(c.getAreaTextField()));
            
            System.out.println("Flat has been created");
        }
        else{
            
        }
    }

    @FXML
    private void propertyTypeComboBoxChanged(ActionEvent event) throws IOException {
        if("Empty plot".equals(propertyTypeComboBox.getValue())){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("PropertyType_EmptyPlot.fxml"));
            Parent root = loader.load();
            a = loader.getController();
            propertyTypeBorderPane.setCenter(root);
            
        }
        else if("Plot with Building".equals(propertyTypeComboBox.getValue())){
//            Parent root = FXMLLoader.load(getClass().getResource("PropertyType_plotWithBuilding.fxml"));
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("PropertyType_plotWithBuilding.fxml"));
            Parent root = loader.load();
            b = loader.getController();
            propertyTypeBorderPane.setCenter(root);
        }
        
        else if("Flat".equals(propertyTypeComboBox.getValue())){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("PropertyType_Flat.fxml"));
            Parent root = loader.load();
            c = loader.getController();
            propertyTypeBorderPane.setCenter(root);
        }
    }

    @FXML
    private void discardPropertyButtonClick(ActionEvent event) throws IOException {
        
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("Seller_HomeScene.fxml"));
        Parent root = loader1.load();
        Scene scene = new Scene(root);
        Seller_HomeSceneController controller1 = loader1.getController();
        controller1.initData(seller);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(scene);
        window1.show();
    }
    
}
