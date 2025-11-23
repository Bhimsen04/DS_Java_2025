package DesignPatterns.behavioral.stateDesign;

public class NewState implements IOrderState {
    @Override
    public void next(OrderContext ctx) {
        ctx.setState(new ProcessingState());
    }

    @Override
    public void previous(OrderContext ctx) {
        System.out.println("Already in NEW state.");
    }

    @Override
    public void printStatus() {
        System.out.println("Order is in NEW state.");
    }
}
