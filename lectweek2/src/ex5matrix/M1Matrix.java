package ex5matrix;

import java.util.Arrays;

import static java.lang.System.out;

/*
    A matrix is 2 dimensional array, an array of arrays

    Must use 2 index: First is row and second is col
    - As usual index starts on 0.
    - Upper left corner is [0][0]


    NOTE: We normally use square matrices (but others possible also ragged)!

 */
public class M1Matrix {

    public static void main(String[] args) {
        new M1Matrix().program();
    }

    void program() {

        // ---- Declare and initialize -------

        // m is a matrix (reference) variable
        int[][] m = {               // m references array of arrays
                {1, 2, 3,},         // m[0] = first row (first sub array)
                {4, 5, 6,},         // m[1]
                {7, 8, 9,},         // m[2]
        };

        // ----------- Rows are arrays ----------

        out.println(Arrays.toString(m[2]));

        // ----- Double indices to access variables --------------

        out.println(m[0][2] == 3);    // Row 0, col 2
        //out.println(m[1][3] == 6);   // Exception, index out of bounds

        m[1][2] = 99;    // Assign

        int r = 2;
        int c = 2;
        m[r][c - 1] = -1;    // Assign using variables

        // -------  Traversing ------------------

        /*
            Naming
            -----

            Avoid using x and y (confusing), better use row and col
        */
        // Must use nested loops
        for (int row = 0; row < m.length; row++) {
            for (int col = 0; col < m[row].length; col++) {
                m[row][col]++;   // Increment each element
            }
        }

        // Plot matrix
        for (int row = 0; row < m.length; row++) {
            for (int col = 0; col < m[row].length; col++) {
                out.println(m[row][col]);
            }
        }

        // ----- Create new matrices in program ------------------

        m = new int[][]{    // New 4x4 initialized with values
                {11, 12},
                {21, 22}
        };

        boolean[][] bMatrix = new boolean[2][2];   // New 4x4 matrix with false

        // ---------- Assignment and Equality -----------

        // As for arrays

    }



}

