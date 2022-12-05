import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person ali = new Person("Ali", 36);
        Person ahmed = new Person("Ahmed", 40);
        Person mohamed = new Person("Mohamed", 23);

        List<Person> persons = new ArrayList<>();
        persons.add(ali);
        persons.add(ahmed);
        persons.add(mohamed);

        /*
         This code will generate a concurrent modification exception due trying to modify the persons list while using a for each.
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

    }
}