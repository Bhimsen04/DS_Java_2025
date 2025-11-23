package DesignPatterns.behavioral.stateDesign;

public class DeliveredState implements IOrderState {
    @Override
    public void next(OrderContext ctx) {
        System.out.println("Already in Delivery state.");
    }

    @Override
    public void previous(OrderContext ctx) {
        ctx.setState(new ShippedState());
    }

    @Override
    public void printStatus() {
        System.out.println("Order is Delivered.");
    }
}
