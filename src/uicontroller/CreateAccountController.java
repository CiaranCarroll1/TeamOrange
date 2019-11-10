package uicontroller;

import businesslogic.accounts.Account;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class CreateAccountController implements Initializable {

    @FXML private TextField forename;
    @FXML private TextField surname;
    @FXML private TextField phoneNumber;
    private ScreenController controller = new ScreenController();
    Account newAccount;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    private void submitDetails(ActionEvent event) throws IOException
    {
        String fname = forename.getText();
        String sname = surname.getText();
        int pnumber = Integer.parseInt(phoneNumber.getText());
        
        //Checks for valid input
        
        newAccount = new Account(pnumber, fname, sname);
        
        //if valid => enter details in database and back to mainmenu
        
        controller.loadScreen(event, "/ui/mainmenu.fxml");
    }
    
}
