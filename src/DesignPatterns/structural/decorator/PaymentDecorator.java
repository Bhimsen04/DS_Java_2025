package DesignPatterns.structural.decorator;

// Decorator (Base Class)
public class PaymentDecorator implements IPaymentService {

    protected IPaymentService IPaymentService;

    public PaymentDecorator(IPaymentService IPaymentService) {
        this.IPaymentService = IPaymentService;
    }

    @Override
    public void pay(double amount) {
        IPaymentService.pay(amount);
    }
}
