package DesignPatterns.structural.decorator;

public class BasicPaymentService implements IPaymentService {

    @Override
    public void pay(double amount) {
        System.out.println("Payment of Rs. " + amount + " processed.");
    }
}
