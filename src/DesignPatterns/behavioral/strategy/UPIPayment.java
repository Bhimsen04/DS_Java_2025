package DesignPatterns.behavioral.strategy;

public class UPIPayment implements IPaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}
