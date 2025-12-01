package java_interview.thread.countDownLatch.example2;

public class Car {
    
    private String name;
    private int speed; // km/h

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    // Simulate driving to the checkpoint
    public void drive() {
        System.out.println(name + " reached the checkpoint at " + speed + " km/h.");
    }

    // Getter for speed
    public int getSpeed() {
        return speed;
    }

}
