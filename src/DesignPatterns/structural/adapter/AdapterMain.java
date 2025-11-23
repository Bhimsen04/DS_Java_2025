package DesignPatterns.structural.adapter;

/*
    Adapter converts one class/interface into another interface that the client expects.

    Real-life example:
    Phone charger adapter converts 220V → 5V
    HDMI-to-VGA converter
    USB-to-Type-C converter

    The devices remain same; adapter converts compatibility.

    Your application expects a NotificationService with: void send(String message);
    But I want to integrate a third-party WhatsApp API whose method is: void pushMessage(String content);

 */
public class AdapterMain {
    public static void main(String[] args) {

        INotificationService email = new EmailNotification();
        INotificationService sms = new SMSNotification();

        INotificationService whatsapp =
                new WhatsAppAdapter(new ThirdPartyWhatsAppAPI());

        email.send("Order Placed");
        sms.send("OTP: 9988");
        whatsapp.send("Delivery Today");

    }
}
