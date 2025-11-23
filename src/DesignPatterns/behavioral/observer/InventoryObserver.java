package DesignPatterns.behavioral.observer;

public class InventoryObserver implements IOrderObserver {
    @Override
    public void update(String orderId) {

        System.out.println("Inventory updated for Order: " + orderId);
    }
}
