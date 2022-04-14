package mainpkg.BuyerScenes;

import Properties.*;
import Users.*;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mainpkg.PropertyList;

/**
 * FXML Controller class
 *
 * @author shiha
 */
public class Buyer_SearchPropertyController implements Initializable {
    Buyer buyer;
    @FXML    private CheckBox plotWithBuildingCheckBox;
    @FXML    private CheckBox emptyPlotCheckBox;
    @FXML    private CheckBox flatCheckBox;
    @FXML    private TextField minPriceRangeTextField;
    @FXML    private TextField maxPriceRangeTextField;
    @FXML    private ComboBox<String> divisionComboBox;
    @FXML    private TableView<Property> tableView;
    @FXML    private TableColumn<Property, String> propertyNameColumn;
    @FXML    private TableColumn<Property, String> propertyPriceColumn;
    @FXML    private TableColumn<Property, String> addressLineColumn;
    @FXML    private Label divisionErrorTextLabel;
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
        propertyNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        propertyPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        addressLineColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
    }    
    
    public void initData(Buyer buyer) {
        this.buyer = buyer;
    }
    
    public ObservableList<Property> getProperty(){
        ObservableList<Property> searchedProperty = FXCollections.observableArrayList();
        ArrayList<Property> listOfProperty = PropertyList.GetListOfProperty();
        
        int minPrice = (!"".equals(minPriceRangeTextField.getText()))?parseInt(minPriceRangeTextField.getText()):0;       
        int maxPrice = (!"".equals(maxPriceRangeTextField.getText()))?parseInt(maxPriceRangeTextField.getText()):2147483647;
        String division = (divisionComboBox.getValue() == null)?"":divisionComboBox.getValue();
//        System.out.println("min: "+minPrice + "\tmax: "+maxPrice);
        boolean pb = plotWithBuildingCheckBox.isSelected(),
                ep = emptyPlotCheckBox.isSelected(),
                f = flatCheckBox.isSelected();
        
        for (Property i: listOfProperty){
            if(minPrice<=i.getPrice() && maxPrice>=i.getPrice()){
                //skips property if outside of price range

                // 0 0 0 && 1 1 1
                if( (!pb && !ep && !f) || (pb && ep && f) /*|| "".equals(division)*/ ){
                    //show all type of properties
                    searchedProperty.add(i);
                }
                else {
//                    if(division.equals(i.getDivision())){
                        if((f)&&(i instanceof Flat)){
                        searchedProperty.add(i);
                        }
                        if((ep)&&(i instanceof EmptyPlot)){
                        searchedProperty.add(i);
                        }
                        if((pb)&&(i instanceof PlotWithBuilding)){
                        searchedProperty.add(i);
                        }
//                    }
                }
            }
        }
        return searchedProperty;
    }

    @FXML
    private void searchPropertyButtonClick(ActionEvent event) {
        
//        if(divisionComboBox.getValue() == null){
//            divisionErrorTextLabel.setText("please select a division");
//        }else{
            //does not search for property if combo box is empty
            divisionErrorTextLabel.setText("");
            ObservableList<Property> searchedProperty = getProperty();
            tableView.setItems(searchedProperty);

// advanced search debug code (shows property type)
//            System.out.println("...searching");
//            for(Property i: searchedProperty){
//                if(i instanceof Flat) System.out.println("Flat");
//                if(i instanceof EmptyPlot) System.out.println("EmptyPlot");
//                if(i instanceof PlotWithBuilding) System.out.println("PlotWithBuilding");
//            }System.out.println("\n\n");
//        }
    }


    @FXML
    private void backButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Buyer_HomeScene.fxml"));
        Parent root = loader.load();
        Scene buyerHomePage = new Scene(root);
        Buyer_HomeSceneController controller1 = loader.getController();
        controller1.initData(buyer);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(buyerHomePage);
        window1.show();
    }

    @FXML
    private void seePropertyDetailsButtonClick(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Buyer_PropertyDetailsScene.fxml"));
        Parent personViewParent = loader.load();
        Scene personViewScene = new Scene(personViewParent);
        
        //access the controller
        Buyer_PropertyDetailsSceneController controller = loader.getController();
        controller.initData(buyer, tableView.getSelectionModel().getSelectedItem());
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(personViewScene);
        window.show();
    }
    
}
