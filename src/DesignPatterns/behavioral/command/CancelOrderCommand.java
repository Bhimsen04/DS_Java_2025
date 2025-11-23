package DesignPatterns.behavioral.command;

public class CancelOrderCommand implements ICommand {

    private OrderService orderService;

    public CancelOrderCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute() {
        System.out.println("Cancelling Order");
        orderService.cancelOrder();
    }
}
