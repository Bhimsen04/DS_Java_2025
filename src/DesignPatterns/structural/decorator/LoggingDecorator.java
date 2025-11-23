package DesignPatterns.structural.decorator;

public class LoggingDecorator extends PaymentDecorator {

    public LoggingDecorator(IPaymentService IPaymentService) {
        super(IPaymentService);
    }

    @Override
    public void pay(double amount) {
        System.out.println("[LOG] Starting payment...");
        super.pay(amount);
        System.out.println("[LOG] Payment completed.");
    }
}
