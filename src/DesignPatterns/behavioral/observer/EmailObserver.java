package DesignPatterns.behavioral.observer;

public class EmailObserver implements IOrderObserver {
    @Override
    public void update(String orderId) {
        System.out.println("Email sent for Order: " + orderId);
    }
}
