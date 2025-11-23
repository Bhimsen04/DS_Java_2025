package DesignPatterns.structural.adapter;

public class EmailNotification implements INotificationService {


    @Override
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}
