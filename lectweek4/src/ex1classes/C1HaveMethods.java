package ex1classes;

import static java.lang.System.out;

/*
    Classes (objects) may have methods (and normally have)
    Idea is to bundle data (the instance variables) used in methods and
    the methods using the data.

 */
public class C1HaveMethods {

    public static void main(String[] args) {
        new C1HaveMethods().program();
    }

    void program() {
        final int winPoints = 20;

        Player p = new Player("Sven", 10);

        // ------ Use method outside class ----------
        out.println(isWinner(p, winPoints));


        // ----- Use method in class ----------

        // Dot notation to call method in object p
        // MUST have object first (if not inside object, more later)
        out.println(p.isWinner(winPoints));

        p.points = 22;
        out.println(p.isWinner(winPoints));

        /*
            METHOD vs FUNCTION
            --------------------
            Because all "functions" in Java belongs to an object
            the functions are called methods. There are no freestanding
            functions in Java.

         */
    }

    // -------- Method --------------------

    // Not so good...
    boolean isWinner(Player p, int winPoints) {
        // ... must extract data from player, then use it.
        return p.points >= winPoints;
    }

    // --------- Class  ------------------

    // Better put method in object (class)
    class Player {
        String name;
        int points;

        Player(String name, int points) {
            this.name = name;
            this.points = points;
        }

        // The data needed to check if player is winner
        // is in the object (points)! No need to extract data!
        // So better put method in class (NOTE: one param less)
        boolean isWinner(int winPoints) {  // Better
            return points >= winPoints;   // points same as this.points
        }
    }

}
