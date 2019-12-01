package business.logic.order.state;

import business.logic.order.Order;

public class CompletedState implements OrderState{
    
    @Override
    public void change(Order order){
        order.setState(new CompletedState());
    }
    @Override
    public int getStatus(){
        return 1;
    }
}
