package DesignPatterns.structural.facade;

public class NotificationService {
    public void sendOrderConfirmation(String msg) {
        System.out.println("Confirmation sent: " + msg);
    }
}
