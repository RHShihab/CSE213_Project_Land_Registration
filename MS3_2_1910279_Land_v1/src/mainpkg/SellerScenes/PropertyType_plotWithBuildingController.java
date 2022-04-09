/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg.SellerScenes;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author shiha
 */
public class PropertyType_plotWithBuildingController implements Initializable {

    @FXML    private TextField areaPerFloorTextField;
    @FXML    private TextField noOfFloorsTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public String getAreaPerFloorTextField() {
        return areaPerFloorTextField.getText();
    }

    public String getNoOfFloorsTextField() {
        return noOfFloorsTextField.getText();
    }
    
    
}
