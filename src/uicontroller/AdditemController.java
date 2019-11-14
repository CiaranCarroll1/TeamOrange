package uicontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class AddItemController extends ViewController implements Initializable {
    
    //private ViewController view = new ViewController();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    @FXML
    private void goBackClicked(ActionEvent event) throws IOException {
        loadScreen(event, "/ui/createorder.fxml");
    }
    
     @FXML
    private void starterClicked(ActionEvent event) throws IOException {
        loadScreen(event, "/ui/createorder.fxml");
    }
    
    @FXML
    private void mainClicked(ActionEvent event) throws IOException {
        loadScreen(event, "/ui/createorder.fxml");
    }
    
    @FXML
    private void dessertClicked(ActionEvent event) throws IOException {
        loadScreen(event, "/ui/createorder.fxml");
    }
    
    @FXML
    private void beverageClicked(ActionEvent event) throws IOException {
        loadScreen(event, "/ui/createorder.fxml");
    }
}