package DesignPatterns.behavioral.strategy;

public class CardPayment implements IPaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using CARD");
    }
}
