package ex5filehandling.f1file;

import java.io.Serializable;


/*
        Dummy class used for binary file handling i.e. write an object
        to a binary file.
 */
// MUST Implement Serializable to be able to save the object
public class MyClass implements Serializable {
    private String name;

    public MyClass(){}

    public MyClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}