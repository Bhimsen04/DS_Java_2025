package DesignPatterns.behavioral.chainOfResponsibility;

/*
    Spring Boot Internals Using Chain of Responsibility
    UsernamePasswordAuthFilter -> JwtFilter -> CsrfFilter -> CorsFilter -> SessionFilter (Request passes through each filter step-by-step)
    A request is passed through a chain of handlers.
 */
public class CORMain {
    public static void main(String[] args) {
        Handler auth = new AuthHandler();
        Handler log = new LoggingHandler();
        Handler business = new BusinessHandler();

        auth.setNext(log).setNext(business);

        auth.handle("Process payment request");
    }
}
