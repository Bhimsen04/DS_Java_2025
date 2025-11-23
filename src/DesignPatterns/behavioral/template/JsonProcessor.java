package DesignPatterns.behavioral.template;

public class JsonProcessor extends DataProcessor {

    @Override
    public void processData() {
        System.out.println("Processing JSON data");
    }

    public void writeData() {
        System.out.println("Overriding Write Data ...");
    }

}
