package DesignPatterns.behavioral.observer;

public class ObserverMain {
    public static void main(String[] args) {
        OrderPublisher publisher = new OrderPublisher();

        publisher.subscribe(new EmailObserver());
        publisher.subscribe(new InventoryObserver());
        publisher.subscribe(new InvoiceObserver());

        publisher.notifyObservers("ORD12345");

    }
}
