package java_interview.streams;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Person> personList1 = Utility.getPersonList1();
        List<Person> personList2 = Utility.getPersonList2();
//        Map<String, List<Map<String, String>>> mapOfListOfMap = Utility.getMapOfListOfMap();
//        getUniqueNamesFromBothLists(personList1, personList2);
//        printNameOfPersonFromMapOfListOfMap(mapOfListOfMap);            // flatmap used
//        personDetailsInTermsOfMap(personList1);                         // creating map in stream
//        collectotsToMap(personList1);
//        considerUniqueElements();
//        List<String> strings = List.of("1", "2", "3", "4");
//        String join = String.join("5", strings);
//        System.out.println(join);

/*        I/P : Map<dep, Map < Experience, List<Salary>>
          O/P : Map<dep, Map < Experience, Double>>   */
        findMaxSalExpWiseThenDepWise();
    }

    private static void findMaxSalExpWiseThenDepWise() {
        Map<String, Map<Integer, List<Integer>>> input = Map.of(
                "IT", Map.of(
                        1, List.of(100, 200, 300),
                        2, List.of(200, 300, 400)
                ),
                "HR", Map.of(
                        1, List.of(500, 150, 250),
                        2, List.of(180, 220, 100)
                )
        );

        Map<String, Map<Integer, Integer>> result = input.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        depEntry -> depEntry.getValue()
                                .entrySet()
                                .stream()
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        expEntry -> expEntry.getValue()
                                                .stream()
                                                .mapToInt(Integer::intValue)
                                                .max()
                                                .orElse(0)
                                ))
                ));

        System.out.println(result);

    }

    private static void considerUniqueElements() {

        HashMap<Employee, String> hashMap = new HashMap<>();
        hashMap.put(new Employee(1, "Sachin", 40000), "Sachin");
        hashMap.put(new Employee(2, "Sachin", 30000), "Sachin");
        hashMap.put(new Employee(3, "Dravid", 10000), "Dravid");
        hashMap.put(new Employee(4, "Sachin", 40000), "Sachin");
        hashMap.put(new Employee(5, "Yuvi", 59000), "Yuvi");

        List<Employee> list = hashMap.keySet().stream()
                .collect(Collectors.toMap(
                        p -> p.getName() + p.getSalary(),
                        Function.identity(),
                        (p1, p2) -> p1
                ))
                .values().stream().toList();

        System.out.println(list);

        list = hashMap.keySet().stream()
                .collect(Collectors.groupingBy(e -> e.getName() + e.getSalary()))
                .values()
                .stream()
                .filter(l -> l.size() == 1)
                .flatMap(List::stream)
                .toList();

        System.out.println(list);
    }

    private static void collectotsToMap(List<Person> persons) {
        Map<Integer, Person> collect = persons.stream().collect(Collectors.toMap(Person::getId, person -> person));
        System.out.println(collect);

        Map<Integer, Person> collect2 = persons.stream().collect(Collectors.toMap(Person::getId, Function.identity()));
        System.out.println(collect2);
    }

    private static void personDetailsInTermsOfMap(List<Person> personList1) {
        List<Map<String, String>> list = personList1.stream()
                .distinct()
                .map(person -> Map.of("id", person.getId() + "", "name", person.getName() + ""))
                .filter(person -> person.get("id") != null && person.get("name") != null)
                .collect(Collectors.toList());

        System.out.println(list);
    }

    private static void printNameOfPersonFromMapOfListOfMap(Map<String, List<Map<String, String>>> map) {
        Stream<List<Map<String, String>>> stream = map.values().stream();
        Stream<Map<String, String>> mapStream = stream.flatMap(List::stream);
        mapStream.forEach(innerMap -> {
            System.out.println("Values :- " + innerMap.get("name"));
            System.out.println("Values :- " + innerMap.get("city"));
        });

        Stream<Map.Entry<String, List<Map<String, String>>>> stream1 = map.entrySet().stream();
        Stream<Map<String, String>> mapStream1 = stream1.flatMap(f -> f.getValue().stream());
        mapStream1.forEach(innerMap -> System.out.println("Entry Set :- " + innerMap.get("name")));

        List<String> list = map.entrySet()
                .stream()
                .flatMap(
                        entry -> entry.getValue()
                                .stream()
                                .map(m -> {
                                    String name = m.get("name");
                                    String city = m.get("city");
                                    return name + " " + city;
                                }))
                .toList();

        System.out.println(list);

    }

    private static void getUniqueNamesFromBothLists(List<Person> personList1, List<Person> personList2) {
        List<String> result = Stream.concat(
                        personList1.stream().map(Person::getName),
                        personList2.stream().map(Person::getName))
                .distinct()
                .toList();
        System.out.println(result);
    }

}
