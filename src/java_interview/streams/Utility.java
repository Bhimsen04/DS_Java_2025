package java_interview.streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utility {

    public static List<Person> getPersonList1() {
        List<Person> list = new ArrayList<>();
        list.add(createPerson(1, "Alice"));
        list.add(createPerson(2, "Bob"));
        list.add(createPerson(3, "Charlie"));
        list.add(createPerson(4, "David"));
        list.add(createPerson(5, "Bob"));
        return list;
    }

    public static List<Person> getPersonList2() {
        List<Person> list = new ArrayList<>();
        list.add(createPerson(6, "David"));
        list.add(createPerson(7, "Bob"));
        list.add(createPerson(8, "Frank"));
        return list;
    }

    private static Person createPerson(int id, String name) {
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        return person;
    }

    public static Map<String, List<Map<String, String>>> getMapOfListOfMap() {
        Map<String, List<Map<String, String>>> m = new HashMap<>();

        for (int i = 1; i <= 10; i++) {

            Map<String, String> innerMap = new HashMap<>();
            innerMap.put("id", String.valueOf(i));
            innerMap.put("name", "Person-" + i);
            innerMap.put("city", "City-" + i);

            List<Map<String, String>> list = new ArrayList<>();
            list.add(innerMap);

            m.put("key-" + i, list);
        }
        return m;
    }
}
