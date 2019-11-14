package uicontroller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class ViewController  {
    
    public void loadScreen(ActionEvent event, String screen) throws IOException
    {
        Parent viewParent = FXMLLoader.load(getClass().getResource(screen));
            Scene viewScene = new Scene(viewParent);
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(viewScene);
            window.show();
    }
    
}