package uicontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class MainMenuController implements Initializable {

    private ScreenController controller = new ScreenController();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void createOrder(ActionEvent event) throws IOException {
            controller.loadScreen(event, "/ui/createorder.fxml"); 
    }
    
}
