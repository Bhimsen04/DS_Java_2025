package DesignPatterns.structural.proxy;

public class PaymentServiceImpl implements IPaymentService {

    @Override
    public void pay(double amount) {
        System.out.println("Payment of Rs. " + amount + " processed.");
    }
}
