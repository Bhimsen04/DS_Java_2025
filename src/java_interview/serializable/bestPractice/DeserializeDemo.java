package java_interview.serializable.bestPractice;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeDemo {
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream("user2.ser"));

        User user = (User) ois.readObject();
        ois.close();

        System.out.println("Name: " + user.name);
        System.out.println("Age: " + user.age);
    }
}
