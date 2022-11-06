package ex2oomodels.oo1personcar;

/*
     The concept of a (very simplified) person
 */
public class Person {

    private final String name;
    private boolean hasDriverLicence;    // Default false

    public Person(String name) {
        this.name = name;
    }

    // ----------- Typical style for booleans -------------------

    public boolean hasDriverLicence() {
        return hasDriverLicence;
    }

    public void setDriverLicence(boolean b) {
        this.hasDriverLicence = b;
    }

    // -------------- Setter/getters ---------------------

    public String getName() {
        return name;
    }

    // toString, equals, hashCode omitted
}


