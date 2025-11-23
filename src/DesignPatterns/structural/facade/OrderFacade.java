package DesignPatterns.structural.facade;

public class OrderFacade {

    private PaymentService paymentService;
    private InventoryService inventoryService;
    private NotificationService notificationService;
    private ShippingService shippingService;

    public OrderFacade() {
        this.paymentService = new PaymentService();
        this.inventoryService = new InventoryService();
        this.notificationService = new NotificationService();
        this.shippingService = new ShippingService();
    }

    public void placeOrder(String item, double amount) {

        paymentService.pay(amount);
        inventoryService.reduceStock(item);
        shippingService.ship(item);
        notificationService.sendOrderConfirmation("Order placed for " + item);

        System.out.println("Order placed successfully!");
    }
}

