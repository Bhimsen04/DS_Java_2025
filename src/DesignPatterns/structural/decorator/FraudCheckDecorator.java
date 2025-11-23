package DesignPatterns.structural.decorator;

public class FraudCheckDecorator extends PaymentDecorator {

    public FraudCheckDecorator(IPaymentService IPaymentService) {
        super(IPaymentService);
    }

    @Override
    public void pay(double amount) {
        System.out.println("[FraudCheck] Checking user risk score...");
        super.pay(amount);
        System.out.println("[FraudCheck] Risk Completed...");
    }
}
