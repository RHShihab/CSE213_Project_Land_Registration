/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg.BuyerScenes;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author shiha
 */
public class Buyer_ViewWishListController implements Initializable {

    @FXML    private CheckBox plotWithBuildingCheckBox;
    @FXML    private CheckBox emptyPlotCheckBox;
    @FXML    private CheckBox flatCheckBox;
    @FXML    private ComboBox<?> divisionComboBox;
    @FXML    private TextField minPriceRangeTextField;
    @FXML    private TextField maxPriceRangeTextField;
    @FXML    private TableView<?> tableView;
    @FXML    private TableColumn<?, ?> propertyNameColumn;
    @FXML    private TableColumn<?, ?> propertyPriceColumn;
    @FXML    private TableColumn<?, ?> addressLineColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backButtonClick(ActionEvent event) {
    }

    @FXML
    private void searchPropertyButtonClick(ActionEvent event) {
    }

    @FXML
    private void seePropertyDetailsButtonClick(ActionEvent event) {
    }
    
}
