package business.logic.payment;

public class PayContext {
   private PayStrategy strategy;

  public void setPaymentStrategy(PayStrategy strategy) {
    this.strategy = strategy;
  }
  
  public void pay(double price) {
    strategy.receivePayment(price);
  }
}
