package DesignPatterns.behavioral.chainOfResponsibility;

// Token Validation Handler
public class AuthHandler extends Handler {

    @Override
    public void handle(String request) {
        System.out.println("Authenticating request...");

        if (request.contains("auth-fail")) {
            System.out.println("Auth failed! Stopping chain.");
            return;
        }

        if (next != null) next.handle(request);
    }
}
