package org.mansourappdevelopment;

import org.mansourappdevelopment.models.Person;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnitTestingDemo {
    private final List<Person> persons = new ArrayList<>();

    public static void main(String[] args) {

    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void removePerson(Person person) {
        persons.removeIf(p -> p.equals(person));
    }

    public List<Person> getAllPersons() {
        return Collections.unmodifiableList(persons);
    }

    public void throwException() throws Exception {
        throw new Exception("This is a test exception.");
    }
}