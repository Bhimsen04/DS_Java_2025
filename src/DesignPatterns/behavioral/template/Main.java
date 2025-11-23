package DesignPatterns.behavioral.template;

public class Main {

    public static void main(String[] args) {
        DataProcessor jsonProcessor = new JsonProcessor();
        jsonProcessor.process();

        DataProcessor csvProcessor = new CsvProcessor();
        csvProcessor.process();
    }
}
