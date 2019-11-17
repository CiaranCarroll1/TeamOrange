package ui.view;

public enum Views {
  Login("/ui/view/login.fxml"),
  MainMenu("/ui/view/mainmenu.fxml"),
  CreateAccount("/ui/view/createaccount.fxml"),
  EditAccount("/ui/view/editaccount.fxml"),
  Order("/ui/view/order.fxml"),
  ViewOrders("/ui/view/mainmenu.fxml");

 private String value;
 
 public String getValue() {
    return value;
   }
 private Views(String value) {
  this.value = value;
 } 
}
