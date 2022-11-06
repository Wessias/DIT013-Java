package ex3static.s5methods;

/*

    Methods to calculate shoe sizes (imagine world wide web shop).

    Typical usage of class/static methods for collections of
    pure functions (calculations).

    No need to remember anything in between calls.
    (calculations not checked, probably incorrect)

 */
public class ShoeSizeUtils {

    // NO instance variables (nor static)

    // Class methods
    public static double getChildSizeEnglish(double lastInInches) {
        return 3 * lastInInches - 12;
    }

    public static double getAdultSizeEnglishMale(double lastInInches) {
        return 3 * lastInInches - 25;
    }

    public static double getAdultSizeEnglishFemale(double lastInInches) {
        return 3 * lastInInches - 23;
    }

    public static double getAdultSizeUSMale(double lastInInches) {
        return 3 * lastInInches - 24;
    }

    public static double getAdultSizeUSFemale(double lastInInches) {
        return 3 * lastInInches - 23;
    }

    public static double getSizeEU(double lastIncm) {
        return (double) 3 / 2 * lastIncm;
    }

    private ShoeSizeUtils(){}  // Private constructor, can't create objects
}