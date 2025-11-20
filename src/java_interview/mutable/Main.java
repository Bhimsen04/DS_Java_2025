package java_interview.mutable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Address adr = new Address("Delhi", "DL");
        List<String> hobbies = new ArrayList<>(List.of("Cricket", "Music"));
        Map<String, String> m = new HashMap<>();
        m.put("dept", "IT");

        Employee emp = new Employee(1, "John", adr, hobbies, m);

        // Change original Address
        adr.setCity("Mumbai");
        Address address = emp.getAddress();
        address.setCity("Patran");

        // Change original list
        hobbies.add("Dance");
        emp.getHobbies().add("Gym");

        // Change original map
        m.put("role", "Dev");
        emp.getDetails().put("name", "John");

        // Employee remains SAFE
        System.out.println(emp.getAddress().getCity()); // Delhi ✔
        System.out.println(emp.getHobbies());           // [Cricket, Music] ✔
        System.out.println(emp.getDetails());           // {dept=IT} ✔
    }
}
