import util.DataTransferObject;

public class Customer implements DataTransferObject {
    private Long id;
    private String firstName;
    private String lastName;
    private String homeTown;

    public Customer(Long id, String firstName, String lastName, String homeTown) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeTown = homeTown;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", homeTown='" + homeTown + '\'' +
                '}';
    }
}
