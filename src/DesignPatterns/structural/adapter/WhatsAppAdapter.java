package DesignPatterns.structural.adapter;

public class WhatsAppAdapter implements INotificationService {

    private ThirdPartyWhatsAppAPI api;

    public WhatsAppAdapter(ThirdPartyWhatsAppAPI api) {
        this.api = api;
    }

    @Override
    public void send(String message) {
        api.pushMessage(message);
    }
}
