package ui.view;

public enum Views {
  Login("/ui/view/login.fxml"),
  MainMenu("/ui/view/mainmenu.fxml"),
  Account("/ui/view/account.fxml"),
  Order("/ui/view/order.fxml"),
  User("/ui/view/user.fxml"),
  CreateAccount("/ui/view/createaccount.fxml"),
  EditAccount("/ui/view/editaccount.fxml"),
  CreateOrder("/ui/view/createorder.fxml"),
  ViewOrders("/ui/view/vieworders.fxml"),
  CreateUser("/ui/view/createuser.fxml"),
  EditUser("/ui/view/edituser.fxml");

 private String value;
 
 public String getValue() {
    return value;
   }
 private Views(String value) {
  this.value = value;
 } 
}
