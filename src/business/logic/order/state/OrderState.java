package business.logic.order.state;

import business.logic.order.Order;

public interface OrderState {
    public void change(Order order);
    public int getStatus();
}
