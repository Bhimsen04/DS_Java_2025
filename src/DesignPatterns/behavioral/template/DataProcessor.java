package DesignPatterns.behavioral.template;

/* A behavioral pattern where a base class defines algorithm steps
   and subclasses override specific parts without changing the structure.

   e.g JdbcTemplate, RestTemplate, RedisTemplate, KafkaTemplate.*/
public abstract class DataProcessor {

    public final void process() {
        readData();
        processData();
        writeData();
    }

    public void writeData() {
        System.out.println("Writing data...");
    }

    public abstract void processData();

    private void readData() {
        System.out.println("Reading data...");
    }
}
