package org.mansourappdevelopment;

import org.junit.jupiter.api.*;
import org.mansourappdevelopment.models.Person;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Testing adding objects to the persons list defined in the UnitTestingDemo class.")
class UnitTestingDemoTest {
    private static UnitTestingDemo unitTestingDemo;
    private static Person person1;
    private static Person person2;

    //@BeforeAll and @AfterAll are class level methods so, they should be static
    @BeforeAll
    static void initBeforeAll() {
        System.out.println("Before All");
        unitTestingDemo = new UnitTestingDemo();
        String person1Name = "Mahmoud";
        String person1Sex = "Male";
        int person1Age = 26;
        person1 = new Person(person1Name, person1Sex, person1Age);
        String person2Name = "Maggie";
        String person2Sex = "Female";
        int person2Age = 17;
        person2 = new Person(person2Name, person2Sex, person2Age);
    }

    @BeforeEach
    void executeBeforeEach() {
        System.out.println("Before Each");
        unitTestingDemo.addPerson(person1);
        unitTestingDemo.addPerson(person2);
    }

    @AfterEach
    void executeAfterEach() {
        System.out.println("After Each");
        unitTestingDemo.removePerson(person1);
        unitTestingDemo.removePerson(person2);
    }

    //@BeforeAll and @AfterAll are class level methods so, they should be static
    @AfterAll
    static void executeAfterAll() {
        System.out.println("After All");
    }

    @Test
    @Tag("Persons")
    @DisplayName("Testing adding two Person objects to the persons list inside the class UnitTestingDemo.")
    void addPersonToPersonsList() {
        assertNotNull(unitTestingDemo.getAllPersons());

        assertEquals("Mahmoud", unitTestingDemo.getAllPersons().get(0).getName());
        assertEquals("Male", unitTestingDemo.getAllPersons().get(0).getSex());
        assertEquals(26, unitTestingDemo.getAllPersons().get(0).getAge());
        assertTrue(unitTestingDemo.getAllPersons().get(0).isAdult());

        //Using assertAll to test all these tests at once
        assertAll(
                () -> assertEquals("Maggie.", unitTestingDemo.getAllPersons().get(1).getName()),
                () -> assertEquals("Female.", unitTestingDemo.getAllPersons().get(1).getSex()),
                () -> assertEquals(18, unitTestingDemo.getAllPersons().get(1).getAge()),
                () -> assertFalse(unitTestingDemo.getAllPersons().get(1).isAdult())
        );

    }

    @Test
    @Tag("Persons")
    @DisplayName("Checking if the persons list declared inside this method with the same person1 & person2 objects as the persons list defined " +
            "inside the UnitTestingDemo class are equal.")
    void checkCollectionsEquality() {
        List<Person> persons = List.of(person1, person2);
        assertEquals(persons, unitTestingDemo.getAllPersons());
        assertIterableEquals(persons, unitTestingDemo.getAllPersons());
    }

    @Nested
    @DisplayName("Testing Exceptions")
    class otherTests {
        @Test
        @DisplayName("Testing Exceptions resulting from the throwException method defined in the UnitTestingDemo class.")
        void testExceptions() {
            Exception exception = assertThrows(Exception.class, () -> {
                unitTestingDemo.throwException();
            });

            //custom error messages. But the message will always be calculated when the test succeeds or fails.
            //That's why we need to use a lambda expression instead.
//            assertEquals("This is a test exception.", exception.getMessage(),
//                    "The expected message and the provided one don't match." + exception.getMessage());

            //This way the lambda expression will be evaluated only when the test succeed
            assertEquals("This is a test exception.", exception.getMessage(),
                    () -> "The expected message and the provided one don't match." + exception.getMessage());
        }
    }


}