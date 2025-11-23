package DesignPatterns.structural.adapter;

// Third-Party WhatsApp API (Incompatible)
public class ThirdPartyWhatsAppAPI {
    public void pushMessage(String content) {
        System.out.println("WhatsApp message: " + content);
    }
}
