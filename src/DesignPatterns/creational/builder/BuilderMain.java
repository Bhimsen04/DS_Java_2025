package DesignPatterns.creational.builder;

public class BuilderMain {
    public static void main(String[] args) {
        User user = User.builder()
                .id(1)
                .name("John")
//                .email("john@gmail.com")
                .age(30)
                .build();

        System.out.println(user);

    }
}
