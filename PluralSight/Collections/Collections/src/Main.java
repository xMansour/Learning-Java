import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Person ali = new Person("Ali", 36);
        Person ahmed = new Person("Ahmed", 40);
        Person mohamed = new Person("Mohamed", 23);

        List<Person> persons = new ArrayList<>();
        persons.add(ahmed);
        persons.add(ali);
        persons.add(mohamed);

/*
//         This code will generate a concurrent modification exception due trying to modify the persons list while using a for each.
         for (Person person : persons) {
         if (person.getAge() < 30)
         persons.remove(person);
         }
*/
        System.out.println("Before using the iterator, the list size is: " + persons.size());
        System.out.println("Contains mohamed " + persons.contains(mohamed));
        //Instead use Iterators
        Iterator<Person> iterator = persons.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getAge() < 30)
                iterator.remove();
        }

        System.out.println("After using the iterator, the list size is: " + persons.size());
        System.out.println("Contains mohamed " + persons.contains(mohamed));
        System.out.println("Unsorted persons: " + persons);

/*
        persons.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });
*/
//        persons.sort((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge()));

        persons.sort(Comparator.comparingInt(Person::getAge));

        System.out.println("Sorted persons: " + persons);

        Map<Integer, Person> personMap = new HashMap<>();
        personMap.put(1, ali);
        personMap.put(2, ahmed);
        personMap.put(3, mohamed);
        Set<Integer> keySet = personMap.keySet();
        Collection<Person> valueSet = personMap.values();
        Set<Map.Entry<Integer, Person>> entrySet = personMap.entrySet();
        //var entries = personMap.entrySet();
        System.out.println("The map before: " + personMap);
        System.out.println("Entry Set before: " + entrySet);
        keySet.remove(1);
        System.out.println("The map after: " + personMap);
        valueSet.remove(ahmed);
        System.out.println("The map after: " + personMap);
        System.out.println("Entry Set before: " + entrySet);
        personMap.forEach((key, value) -> System.out.println("Key: " + key + " Value: " + value));
//        personMap.forEach((key, value) -> value.setAge(value.getAge() + 10)); //but the object's value is changed
        personMap.replaceAll((key, value) -> new Person(value.getName(), value.getAge() + 10)); //same as above, but the value is changed inside the map
        personMap.forEach((key, value) -> System.out.println("Key: " + key + " Value: " + value));

        System.out.println("Last modified persons: " + persons);
        persons.add(mohamed);
        persons.add(ali);
        persons.add(ahmed);
        persons.add(mohamed);
        System.out.println("Added persons: " + persons);

        //streams
        persons
                .stream()
                .filter(person -> person.getAge() > 30)
                //.sorted() this uses the default compareTo method defined in the Person class
                //.sorted(Comparator.comparingInt(Person::getAge))
                /*.sorted(new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return 0;
                    }
                })*/
                //.count();
                .map(Person::getName)
                .forEach(System.out::println);

        long count = persons
                .stream()
                .filter(person -> person.getAge() < 30)
                .count();

        System.out.println("count = " + count);
        System.out.println("=================================");

        //Lambda Expressions
        List<String> names = new ArrayList<>(List.of("Mahmoud", "Ali", "Omar", "Mohamed", "Ahmed", "Ti"));
        Supplier<String> supplier = () -> "Hi";
        Consumer<String> consumer = str -> System.out.println("str = " + str);
        Predicate<String> predicate = str -> str.startsWith("M");
        Function<Person, String> function = (person) -> person.getName();
        Runnable runnable = () -> System.out.println("Hello from runnable");

        //names.removeIf(predicate);
        //names.removeIf(str -> str.startsWith("A"));

        //Comparator<String> alphabeticalSort = (name1, name2) -> name1.compareTo(name2);   //Alphabetical Sort
        //names.sort(alphabeticalSort);
        Comparator<String> lengthSort = (name1, name2) -> Integer.compare(name1.length(), name2.length());
        names.sort(lengthSort);
        System.out.println("sorted names = " + names);
        System.out.println("=================================");

        //getting average ages of persons using streams
        long count1 = persons
                .stream()
                .map(person -> person.getAge())
                .filter(age -> age > 30)
                .count();
        System.out.println("count1 = " + count1);

        Person person1 = new Person("person1", 1);
        Person person2 = new Person("person2", 2);
        Person person3 = new Person("person3", 3);
        Person person4 = new Person("person4", 4);
        Person person5 = new Person("person5", 5);
        Person person6 = new Person("person6", 6);
        Person person7 = new Person("person7", 7);
        Person person8 = new Person("person8", 8);
        City ny = new City("NY", person1, person2, person3);
        City seattle = new City("Seattle", person4, person5, person6);
        City california = new City("California", person7, person8);

        List<City> cities = List.of(ny, seattle, california);
        long personsCount =
                cities
                        .stream()
                        .flatMap(city -> city.getPersons().stream())
                        .count();

        System.out.println("personsCount = " + personsCount);

        //streams of arrays

        System.out.println("=================================");
        Person[] personsArray = {person1, person2, person3, person4, person5};
        System.out.println(Stream.of(personsArray).count());
        Arrays.stream(personsArray).forEach(System.out::println);
        System.out.println("=================================");

        Path path = Path.of("src/Main.java");
        try (Stream<String> lines = Files.lines(path)) {
            //lines.forEach(System.out::println); //prints the file contents
            System.out.println(lines.count());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println("=================================");
        String wordToCountLetters = "wordToCountTheLetters";
        System.out.println(Pattern.compile("").splitAsStream(wordToCountLetters).count());
        wordToCountLetters
                .chars()
                .forEach(System.out::println);

        System.out.println("=================================");
        List<Person> personsList = List.of(person1, person2, person3, person4, person5, person6, person7, person8);
        double avg = personsList
                .stream()
                .mapToInt(Person::getAge)
                .average()
                .orElseThrow(); //when a terminal method returns optional.

        System.out.println("avg = " + avg);
        System.out.println("=================================");

        Path csvPath = Path.of("data/ExtractRackData.csv");
        try (Stream<String> csvLines = Files.lines(csvPath)) {
            csvLines.skip(1).map(line -> line.split(",")).forEach(arr ->{
                System.out.println(arr[0]);
            });
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}