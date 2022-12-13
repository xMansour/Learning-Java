import java.util.Collections;
import java.util.List;

public class City {
    private String name;
    private List<Person> persons;

    public City(String name, Person... persons) {
        this.name = name;
        this.persons = List.of(persons);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPersons() {
        return Collections.unmodifiableList(persons);
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
