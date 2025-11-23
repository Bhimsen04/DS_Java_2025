package DesignPatterns.behavioral.stateDesign;

public interface IOrderState {
    void next(OrderContext ctx);

    void previous(OrderContext ctx);

    void printStatus();
}
