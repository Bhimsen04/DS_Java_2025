package java_interview.serializable.badPractice;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeDemo {
    public static void main(String[] args) throws Exception {
        User user = new User();
        user.name = "Ravi";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.ser"));
        oos.writeObject(user);
        oos.close();

        System.out.println("User serialized successfully");
    }
}
