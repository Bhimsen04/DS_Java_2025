package DesignPatterns.behavioral.stateDesign;

public class ProcessingState implements IOrderState {

    @Override
    public void next(OrderContext ctx) {
        ctx.setState(new ShippedState());
    }

    @Override
    public void previous(OrderContext ctx) {
        ctx.setState(new NewState());
    }

    @Override
    public void printStatus() {
        System.out.println("Order is PROCESSING.");
    }

}
