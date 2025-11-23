package DesignPatterns.behavioral.command;

public class PlaceOrderCommand implements ICommand {

    private OrderService orderService;

    public PlaceOrderCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute() {
        System.out.println("Placing Order");
        orderService.placeOrder();
    }
}
