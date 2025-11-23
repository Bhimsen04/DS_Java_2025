package DesignPatterns.structural.proxy;

/*

    A Proxy acts as a substitute or representative of the real object.
    You call the proxy → proxy adds extra logic → then it calls the real service.

    Proxies (JDK / CGLIB)
 */
public class ProxyMain {
    public static void main(String[] args) {
        IPaymentService service = new PaymentServiceProxy(new PaymentServiceImpl());

        service.pay(1000);
    }
}
