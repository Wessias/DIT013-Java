package ex2oomodels.oo1personcar;

import static java.lang.System.out;

/*
     Using a small OO model with two classes, Car and Person

     This class is not part of the model, it's just used
     to play around with the model (Car-Person)
 */
public class TestCarPersonModel {

    public static void main(String[] args) {
        new TestCarPersonModel().program();
    }

    void program() {

        /*
              Building the model
              ------------------
              The model is build "outside" the model, i.e.
              Car doesn't create the owner. The owner is created
              before and sent as a reference to Car using the constructor
         */

        // Create the model parts
        Person owner = new Person("Sven");
        // Connect objects to a full model using the constructor
        Car car = new Car("Volvo", "XMM176", 2016, owner);

        // Use the model
        out.println(car.getOwner().getName()); // Get a person, then get the name


    }
}




