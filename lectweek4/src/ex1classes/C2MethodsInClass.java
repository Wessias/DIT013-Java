package ex1classes;

import static java.lang.System.out;

/*
     Calling methods in class from inside other methods in class common
     Don't need to specify object for the method, "this" is assumed

 */
public class C2MethodsInClass {

    public static void main(String[] args) {
        new C2MethodsInClass().program();
    }

    void program() {
        MyClass m = new MyClass();
        m.doItAll();             // Must have object first
    }


    // --------- Class  ------------------


    class MyClass {

        void doItAll(){
            doThis();  // Hmm, no object first ..??
            this.doThis();   // The object is this (the actual object). Implicit!
            doThat();   // Same as above
        }


        void doThis(){

        }
        void doThat(){

        }
    }

}
