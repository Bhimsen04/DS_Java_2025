package java_interview.mutable;

import java.util.*;

public final class Employee {

    private final int id;
    private final String name;
    private final Address address;            // deep copied
    private final List<String> hobbies;       // deep copied
    private final Map<String, String> details; // deep copied

    public Employee(int id, String name, Address address,
                    List<String> hobbies, Map<String, String> details) {

        this.id = id;
        this.name = name;

        // 🔥 Deep copy mutable Address (important!)
        this.address = new Address(address.getCity(), address.getState());

        // 🔥 Make list immutable (best performance)
        this.hobbies = Collections.unmodifiableList(new ArrayList<>(hobbies));

        // 🔥 Make map immutable (best performance)
        this.details = Collections.unmodifiableMap(new HashMap<>(details));
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Return deep copy
    public Address getAddress() {
        return new Address(address.getCity(), address.getState());
    }

    // Returning unmodifiable list is perfectly safe
    public List<String> getHobbies() {
        return new ArrayList<>(hobbies);
    }

    public Map<String, String> getDetails() {
        return new HashMap<>(details);
    }
}
