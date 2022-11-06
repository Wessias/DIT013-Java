package ex3supersub;

/*
    Super sub relations when methods involved. When is a method sub of other method.
    This is supplementary

 */
public class SS8Methods {

    public static void main(String[] arg) {
        new SS8Methods().program();
    }

    void program() {
        int i = 3;

        // Expression compiles. Which methods could we replace doIt() with?
        int j = doIt(i);

        // Possible to replace with method with arg type
        // super and return type sub (any of or both)
        j = doOther(i);         // Ok

        //j = doYetOther(i);      // No, param type is sub
        //j = doYetYetOther(i);   // No, return type is super

    }

    // ------------------ Methods -------------------------

    // Method to replace, which below will suffice?
    int doIt(int i) {
        return i;
    }

    char doOther(double d) {  // Return sub, param is super
        return (char)(d + 1);
    }

    int doYetOther(char ch) {    // Return same, param sub
        return ch;  // Implicit cast
    }

    double doYetYetOther(int i) {   // Return is super, param same
        return i;   // Implicit cast
    }
}
