package DesignPatterns.behavioral.command;

/* The Command Pattern encapsulates each request as an object, allowing you to parameterize methods, queue operations, log operations,
  or support undo operations. In Spring Boot, it is widely used in CQRS, asynchronous job execution, Kafka message processing,
  transaction workflows, and scheduled batch jobs. It cleanly separates request creation from request execution. */
public class Main {

    public static void main(String[] args) {

        OrderService service = new OrderService();

        ICommand place = new PlaceOrderCommand(service);
        ICommand cancel = new CancelOrderCommand(service);

        CommandInvoker invoker = new CommandInvoker();

        invoker.addCommand(place);
        invoker.addCommand(cancel);

        invoker.processCommands();
    }
}
