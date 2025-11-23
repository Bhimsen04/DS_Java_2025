package DesignPatterns.behavioral.stateDesign;

public class ShippedState implements IOrderState {

    @Override
    public void next(OrderContext ctx) {
        ctx.setState(new DeliveredState());
    }

    @Override
    public void previous(OrderContext ctx) {
        ctx.setState(new ProcessingState());
    }

    @Override
    public void printStatus() {
        System.out.println("Order is SHIPPED.");
    }

}
