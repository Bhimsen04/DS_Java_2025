package DesignPatterns.behavioral.observer;

public class InvoiceObserver implements IOrderObserver {
    @Override
    public void update(String orderId) {

        System.out.println("Invoice generated for Order: " + orderId);
    }
}
