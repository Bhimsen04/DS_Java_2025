package DesignPatterns.structural.facade;

public class FacadeMain {
    public static void main(String[] args) {

        OrderFacade facade = new OrderFacade();
        facade.placeOrder("Laptop", 55000);
    }
}
