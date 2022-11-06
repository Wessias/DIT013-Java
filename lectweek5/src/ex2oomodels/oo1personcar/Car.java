package ex2oomodels.oo1personcar;


/*
      The concept of a Car with an owner (a Person!)

      This is a small OO model i.e. objects referencing
      other objects  (concept) to build a model (abstraction) of the problem
      at hand
 */
public class Car {

    private final String brand;
    private final String id;
    private final int modelYear;
    private Person owner;       // Reference to other concept!

    // Constructor
    public Car(String brand, String id, int modelYear, Person owner) {
        this.brand = brand;
        this.id = id;
        this.modelYear = modelYear;
        this.owner = owner;
    }

    // Setter/getters
    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Person getOwner() {
        return owner;
    }

    // toString, equals, hashCode omitted

}