package DesignPatterns.creational.prototype;

import java.util.List;

/*
    The Prototype Pattern is used to clone existing objects instead of creating new ones from scratch. It is useful when object creation
    is expensive or when we want many objects with the same initial state. In Java, this is implemented using a clone method that performs
    deep or shallow copying. In real systems, prototype is used for caching templates, DTO cloning, document generation,
    and Spring’s prototype bean scope.
 */
public class Main {
    public static void main(String[] args) {

        Document template = new Document(
                "Invoice Template",
                "This is default content",
                List.of("logo.png")
        );

        Document cloned1 = (Document) template.clone();
        Document cloned2 = (Document) template.clone();

        //cloned1.attachments.add("signature.png");
        if (template == cloned1) {
            System.out.println("equal1");
        } else if (template.equals(cloned1)) {
            System.out.println("equal2");
        } else {
            System.out.println("not equal");
        }
        System.out.println(template);
        System.out.println(cloned1);
        System.out.println(cloned2);
    }
}
