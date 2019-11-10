package uicontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class CreateOrder implements Initializable {

    private ScreenController controller = new ScreenController();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void addItem(ActionEvent event) throws IOException {
            controller.loadScreen(event, "/ui/additem.fxml"); 
    }
    
    @FXML
    private void completeOrder(ActionEvent event) throws IOException {
            controller.loadScreen(event, "/ui/mainmenu.fxml"); 
    }
    
}
