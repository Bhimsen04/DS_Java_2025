package DesignPatterns.creational.factory;

/*  e.g
    Notification Factory : Email, Whatsapp, SMS
    File Reader Factory : •	CSVReader, PDFReader, ExcelReader
    Payment Factory : •	Razorpay, Paytm, Cash
 */
public class FactoryMain {

    public static void main(String[] args) {
        IPayment payment = PaymentFactory.getPayment("CARD");
        payment.pay(1000);
    }
}
