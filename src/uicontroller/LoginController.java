package uicontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class LoginController extends ViewController implements Initializable {
    
    @FXML private TextField username;
    @FXML private TextField password;
    private boolean validLogin = false;
    //private ViewController view = new ViewController();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void loginClicked(ActionEvent event) throws IOException {
        if(checkLoginDetails())
        {
            loadScreen(event, "/ui/mainmenu.fxml");
        }
        else
        {
            System.out.println("Invalid Login!");
            username.setText("");
            password.setText("");   
        }
        
    }
    
    private boolean checkLoginDetails()
    {
        String uname = username.getText();
        String pword = password.getText();
        if(uname.equals("username") && pword.equals("password"))
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
}
