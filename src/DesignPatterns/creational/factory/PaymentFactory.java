package DesignPatterns.creational.factory;

public class PaymentFactory {


    public static IPayment getPayment(String type) {
        switch (type) {
            case "CARD":
                return new CardPayment();
            case "UPI":
                return new UpiPayment();
            default:
                throw new IllegalArgumentException("Invalid Payment Type");
        }

    }
}
