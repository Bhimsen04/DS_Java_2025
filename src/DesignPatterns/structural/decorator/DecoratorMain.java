package DesignPatterns.structural.decorator;

/*
    Used a lot in Spring, especially in logging, filtering, adding extra behavior without modifying existing code.
    Payment Processing with Add-On Features

    E-commerce Payment flow:

    Base payment →
    then add features like
    ✔ logging
    ✔ fraud check
    ✔ notification
    ✔ retry mechanism

    None of these change the original payment class — they simply wrap it.

    ✔ Spring Security Filters : Every filter wraps another filter → perfect example of decorators.
    ✔ HttpServletRequestWrapper, ResponseWrapper : These extend original request/response and add features.
    ✔ Jackson JSON ObjectMapper : Add custom serializers/decorators to modify JSON output.
 */
public class DecoratorMain {

    public static void main(String[] args) {
        FraudCheckDecorator fraudCheckDecorator = new FraudCheckDecorator(new BasicPaymentService());
        IPaymentService service = new LoggingDecorator(fraudCheckDecorator);
        service.pay(5000);

        LoggingDecorator loggingDecorator = new LoggingDecorator(new BasicPaymentService());
        IPaymentService service2 = new FraudCheckDecorator(loggingDecorator);
        service2.pay(15000);
    }
}
