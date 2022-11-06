package ex2shortforswitch;

import static java.lang.System.out;

/*
    A switch statement is a selection (like if) but only use
    equality (== or equals) to match (also somewhat more compact
    if *not* using IntelliJ formatting :-(  )

    Used when we just are looking for equality

    NOTE: There's also a switch expression from Java 14 (not used in course)
    
 */
public class FS2SwitchStatement {

    public static void main(String[] args) {
        new FS2SwitchStatement().program();
    }

    void program() {

        // ------ Switch statement with primitive types ----------
        int i = 4;
        switch (i) {          // Switch with int (NOTE: double not allowed)
            case 0:                // If match 0 ...
                out.println("match 0"); // ... run this
                break;          // MUST use break, else will run "case 1" also (fall through)
            case 1:
                out.println("match 1");
                break;
            case 2:
                out.println("match 2");
                break;
            case 3:
                out.println("match 3");
                break;
            case 4:
                out.println("match 4");
                break;
            default:
                out.println("no match");  // If no match
        }
        // break will jump to here


        //---------- Switch with String --------------
        String s = "qqq";
        switch (s) {
            case "aaa":
                out.println("match aaa");
                break;
            case "bbb":
                out.println("match bbb");
                break;
            default:
                out.println("no match");
        }

        // ---- Switch with enum (NOTE: other class objects not allowed) ----
        Color c = Color.BLACK;
        switch (c) {
            case WHITE:
                out.println("white");
                break;
            case BLACK:
                out.println("black");
                break;
            default:
                out.println("no match");
        }

        // --------- Switch using variables ------------
        int j = 0;
        final int k = 1, l = 2;   // Variables allowed if final
        switch (j) {
            //case j: break;     // Not final
            case k:
                out.println(1);
                break;
            case l:
                out.println(2);
                break;
            default:
                out.println("no match");
        }
    }

    // --------- Type -------------

    enum Color {
        BLACK, WHITE;
    }

}
