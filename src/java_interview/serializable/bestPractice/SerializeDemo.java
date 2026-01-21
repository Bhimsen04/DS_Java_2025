package java_interview.serializable.bestPractice;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeDemo {
    public static void main(String[] args) throws Exception {
        User user = new User();
        user.name = "Bhim";

        ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream("user2.ser"));
        oos.writeObject(user);
        oos.close();

        System.out.println("User serialized successfully");
    }
}
