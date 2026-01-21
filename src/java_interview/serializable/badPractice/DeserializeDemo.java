package java_interview.serializable.badPractice;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeDemo {
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream("user.ser"));

        User user = (User) ois.readObject();
        ois.close();

        System.out.println(user.name);
        System.out.println(user.age);
    }
}
