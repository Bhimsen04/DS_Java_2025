package DesignPatterns.behavioral.strategy;

public class PaymentContext {

    private IPaymentStrategy paymentStrategy;

    public PaymentContext(IPaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        paymentStrategy.pay(amount);
    }

}
