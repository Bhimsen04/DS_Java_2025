package DesignPatterns.structural.proxy;

public class PaymentServiceProxy implements IPaymentService {

    private IPaymentService realService;

    public PaymentServiceProxy(IPaymentService realService) {
        this.realService = realService;
    }

    @Override
    public void pay(double amount) {

        // Security Check
        System.out.println("[Proxy] Checking user authentication...");

        // Logging
        System.out.println("[Proxy] Logging payment request...");

        // Calling real service
        realService.pay(amount);

        // Post actions
        System.out.println("[Proxy] Sending SMS confirmation...");
    }
}