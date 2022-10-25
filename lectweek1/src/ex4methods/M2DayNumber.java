package ex4methods;

import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.in;
import static java.lang.System.out;

/*
    Program to calculate the day number for some day in a given year.
    - See http://mistupid.com/calendar/dayofyear.htm

    This is demonstration of functional decomposition
    Assume you have a top level method solving the problem. Break down
    top level method into smaller methods solving parts of the problem etc.
    During this we run tests to make sure the methods works as expected.
    Combine the method to solve the original problem.

    *** This demonstrates our technique to test ***
    (in real life there's advanced test frameworks to use)

 */
public class M2DayNumber {

    public static void main(String[] args) {
        new M2DayNumber().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        //test();                // <--------- Uncomment to test only

        // -- Input ----------------
        out.print("Input the year > ");
        int year = sc.nextInt();
        out.print("Input the month number > ");
        int month = sc.nextInt();
        out.print("Input the day number > ");
        int day = sc.nextInt();

        // --- Process ---------

        // Call top level method
        int dayNbr = getDayNbr(year, month, day);

        // ---- Output ----
        printResult(year, month, day, dayNbr);

    }

    // ------------ Methods ----------------------------

    // The top level method will call other methods
    int getDayNbr(int year, int month, int day) {
        // Sum all days to month before and add day number
        int n = sumToMonth(month - 1) + day;    // Call other method
        if (month > 2 && isLeapYear(year)) {    // Call other method
            n++;
        }
        return n;
    }

    // Used by getDayNbr
    int sumToMonth(int month) { // No check for leap year, methods do *one* thing
        int sum = 0;
        for (int i = 1; i <= month; i++) {
            sum = sum + getDaysInMonth(i);
        }
        return sum;
    }

    // Used by getDayNbr
    boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Used by sumToMonth
    int getDaysInMonth(int month) {
        if (month == 2) {
            return 28;
        } else if (month <= 7 && month % 2 != 0 ||
                month > 7 && month % 2 == 0) {
            return 31;
        } else {
            return 30;
        }
    }

    // IO method (not tested)
    void printResult(int year, int month, int day, int dayNbr) {
        out.println("Ordinal number for " + day + "/" + month + " in " + year + " is: " + dayNbr);
        if (isLeapYear(year)) {
            out.println(year + " is a leap year");
        } else {
            out.println(year + " is not a leap year");
        }
    }

    // Any non trivial method should be tested.
    // If not ... can't build a solution out of possible failing parts!
    void test() {
        // All should print true, so that we don't need to
        // inspect the outputs to decide if result correct
        out.println(isLeapYear(2004));
        out.println(!isLeapYear(2017));

        out.println(getDaysInMonth(1) == 31);
        out.println(getDaysInMonth(7) == 31);
        out.println(getDaysInMonth(9) == 30);

        out.println(sumToMonth(1) == 31);
        out.println(sumToMonth(2) == 59); // No check for leap year here

        exit(0);    // Exit program
    }
}