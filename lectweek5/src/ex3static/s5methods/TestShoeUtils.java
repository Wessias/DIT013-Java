package ex3static.s5methods;

import static java.lang.System.out;

/*
    Usages of static methods, use of pure functionality
 */

public class TestShoeUtils {

    public static void main(String[] args) {
        new TestShoeUtils().program();
    }

    void program() {
        // Use classname-dot-method (no object needed)
        out.println(ShoeSizeUtils.getAdultSizeEnglishFemale(23));
        out.println(ShoeSizeUtils.getSizeEU(46));
        out.println(ShoeSizeUtils.getAdultSizeUSFemale(20));
    }



}
