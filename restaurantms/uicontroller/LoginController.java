package uicontroller;

public class LoginController implements Initializable {
    
    @FXML private TextField username;
    @FXML private TextField password;
    private boolean validLogin = false;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void attemptLogin(ActionEvent event) {
        String uname = username.getText();
        String pword = password.getText();
        if(uname.equals("username") && pword.equals("password"))
        {
            goToMain();
        }
        else
        {
            System.out.println("Invalid Login!");
            username.setText("");
            password.setText("");
        }
    }
    
    private void goToMain()
    {
        System.out.println("Transferring to main menu");
    
    }
    
}
