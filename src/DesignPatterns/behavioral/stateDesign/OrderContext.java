package DesignPatterns.behavioral.stateDesign;

public class OrderContext {

    private IOrderState state;

    public OrderContext() {
        this.state = new NewState(); // initial state
    }

    public void setState(IOrderState state) {
        this.state = state;
    }

    public void next() {
        state.next(this);
    }

    public void previous() {
        state.previous(this);
    }

    public void printStatus() {
        state.printStatus();
    }
}

