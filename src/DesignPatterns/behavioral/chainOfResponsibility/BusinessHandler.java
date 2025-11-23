package DesignPatterns.behavioral.chainOfResponsibility;

// Token Validation Handler
public class BusinessHandler extends Handler {

    @Override
    public void handle(String request) {
        System.out.println("Business logic executed for: " + request);
    }

}
