package DesignPatterns.creational.factory;

public class UpiPayment implements IPayment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " by UPI");
    }
}
