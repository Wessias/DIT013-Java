package ex3supersub;


import static java.lang.System.out;

/*
    Primitive values/variables have different sizes. Important in many
    contexts but not very interesting in this course.

    - char    2 bytes (unsigned)
    - int     4 bytes
    - float   4 bytes (but bits interpreted different as in int)
    - double  8 bytes
    etc.

    Reference type all have same size (depending om machine 32 or 64 bits)

*/
public class SS9Sizes {

    public static void main(String[] arg) {
        new SS9Sizes().program();
    }

    void program() {

        // Smaller to bigger types no problem
        char ch = '2';     // char 2 bytes
        int n = ch;        // 2 byte to int (4 bytes)
        double d = n;      // 4 bytes to 8 bytes (and also other representation)

        // Bigger to smaller must cast (possibly lose information)
        ch = (char) n;
        n = (int) d;

        // Overflow
        int i = Integer.MAX_VALUE; // Primitives has size i.e. min/max values
        out.println(i + 1);

        // Underflow
        int j = Integer.MIN_VALUE;
        out.println(j - 1);

        // Going round in circle
        out.println(Integer.MAX_VALUE + 1 == Integer.MIN_VALUE);

        // NOTE: Double.Min_VALUE in not negative (smallest possible value representable)
        out.println(Double.MIN_VALUE);
        out.println(Double.MAX_VALUE);

    }

}
