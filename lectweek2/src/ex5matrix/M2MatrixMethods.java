package ex5matrix;

import java.util.Arrays;

import static java.lang.System.out;

/*
     Matrices as parameters and return types
     Same as for arrays  (matrix is array of arrays)

     NOTE: Use row (r) and col (c) as variable names **not** x and y or other,
     may get very confused when program grow...
 */

public class M2MatrixMethods {

    public static void main(String[] args) {
        new M2MatrixMethods().program();
    }

    void program() {
        // Declare and initialize matrix variable m
        int[][] m = {
                {1, 2, 3,},
                {4, 5, 6,},
                {7, 8, 9,},
        };

        // --------- Call methods with matrix params ---------------

        int s = sum(m);
        out.println(s);

        int[][] theCopy = copy(m);
        plotMatrix(theCopy);

        transpose(theCopy);
        plotMatrix(theCopy);
    }

    // --------- Methods ----------------------

    int sum(int[][] m) {
        int sum = 0;
        // To traverse matrix normally use nested for-loops
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m[0].length; c++) {
                sum = sum + m[r][c];
            }
        }
        return sum;
    }


    int[][] copy(int[][] m) {
        // Create the copy matrix
        int[][] cpy = new int[m.length][m.length];
        for (int r = 0; r < m.length; r++) {      // Copy values from m to cpy
            for (int c = 0; c < m[0].length; c++) {
                cpy[r][c] = m[r][c];
            }
        }
        return cpy;
    }

    // Will change original
    void transpose(int[][] m) {
        for (int row = 0; row < m.length; row++) {
            for (int col = row + 1; col < m[row].length; col++) {
                int tmp = m[row][col];
                m[row][col] = m[col][row];
                m[col][row] = tmp;
            }
        }
    }


    void plotMatrix(int[][] m) {
        // Traversing by row
        for (int row = 0; row < m.length; row++) {
            // Row is an array!
            out.println(Arrays.toString(m[row]));
        }
    }

}

