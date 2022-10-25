package ex4methods;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
    To structure the program and to help solving specific tasks we use methods.
    Methods, are smaller parts of a program (subprograms)
    - The ideal method returns a calculated value given some input values
    (similar to a mathematical function)
   - But not all do: Some methods don't take any input and some don't return
   any result (or both).

   Methods here are taking or returning values of primitive types or Strings

   Any method *MUST* be declared before use. Method declaration is like:

   type methodName ( parameter list ) {     (<- method head)
           ...statements ...                (<- method body, a block with statements)
   }

   - Type before name is type of value returned (if any), the "return type". If nothing returned
     we set void before the name.
   - Parameter list is a number of declared variables (i.e. type and name, separated with ',').
     The variables are used to store incoming data from the method call (variable
     to store incoming data = parameter).
   - The above is collectively named the method head
   - Body is a block of statements that the method should execute. In particular there should
     be a return statement (except if method doesn't return anything).

   To call a method (i.e. run the method):
   - Write method name in code, supply arguments in parenthesis.
   - Assign return value to some variable if value should be used later (if not, value lost)
   NOTE:
   - Declared parameter list and arguments values at call must match: number of, type of, order of
   - When assigning result, return type must be compatible with variable type

    TIP: To inspect the execution of this try the debugger

 */
public class M1Methods {

    public static void main(String[] args) {
        new M1Methods().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        // Method called. Result compared with expected value and then written out
        // All should print true except last
        out.println(add(1, 3) == 4);    // Call method add, arguments 1 and 3 should be equals 4
        out.println(f2c(32) == 0);   // Call method f2c
        out.println(abs(-12) == 12);
        out.println(pow(2, 8) == 256);
        out.println(isEven(6));      // Call method isEven(), argument 6, return boolean (no == needed)

        // Methods with Strings. Should read/print name.
        String name = getName();
        welcome(name);

    }

    // ----- Method declarations written after (outside) program() ------------

    // Method declarations must be in outermost block. Method declaration inside other
    // method declaration *NOT* allowed (nested not allowed)
    // Order of declarations here doesn't matter (try to change order)

    // A method declaration:
    // - Return type int, name add, parameter list: two int parameters named a and b
    // - Parameter names may be chosen arbitrarily
    int add(int a, int b) {
        int sum = a + b;        // NOTE: sum not really needed, see f2c
        return sum;
    }

    // Fahrenheit to Celsius
    double f2c(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;  // Return calculated value immediately
    }

    // Sometimes must have more return statement (checked by compiler)
    int abs(int n) {
        if (n < 0) {
            return -n;
        }
        return n;
    }

    // No exp (pow) operator in Java (like ^). Write our own.
    int pow(int b, int e) {
        int p = 1;
        for (int i = 0; i < e; i++) {
            p = p * b;
        }
        return p;
    }

    // Short boolean method (good, usage makes code easier to read/understand)
    // NOTE: Methods name is a question, should be possible to answer yes or no to.
    boolean isEven(int n) {
        return n % 2 == 0;
    }


    // An IO method (using IO). String return type, No parameters.
    String getName() {
        out.print("Please enter your name > ");
        return sc.nextLine();        // Return input immediately
    }

    // Another IO method. String as parameter. void means no return value,
    // so no return statement here. This method just performs an action,
    // no value calculated.
    // NOTE: You may have return in a void-method but **not** any value after return
    void welcome(String name) {
        out.println("Welcome " + name);
    }

}
