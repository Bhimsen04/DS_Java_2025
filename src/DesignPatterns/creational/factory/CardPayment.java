package DesignPatterns.creational.factory;

public class CardPayment implements IPayment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " by CARD");
    }
}
