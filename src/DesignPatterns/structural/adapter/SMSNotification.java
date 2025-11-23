package DesignPatterns.structural.adapter;

public class SMSNotification implements INotificationService {


    @Override
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}
