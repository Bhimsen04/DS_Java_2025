package DesignPatterns.behavioral.chainOfResponsibility;

// Token Validation Handler
public class LoggingHandler extends Handler {

    @Override
    public void handle(String request) {
        System.out.println("Logging request: " + request);

        if (next != null) next.handle(request);
    }

}
