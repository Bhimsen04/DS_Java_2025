package DesignPatterns.behavioral.strategy;

/*
    Strategy Pattern allows you to switch between multiple algorithms/behaviors at runtime without changing the main logic.
 */
public class StrategyMain {

    public static void main(String[] args) {
        PaymentContext ctx = new PaymentContext(new UPIPayment());
        ctx.pay(500);

    }
}
