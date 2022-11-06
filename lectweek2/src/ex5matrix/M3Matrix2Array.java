package ex5matrix;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
    Convert matrix to array

    May be useful in between (to simplify algorithms)

 */
public class M3Matrix2Array {

    public static void main(String[] args) {
        new M3Matrix2Array().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {

        int[][] m = readMatrix();
        writeMatrix(m);
        out.println();

        out.print("Matrix converted to array ");
        writeArray(matrix2Array(m));
    }

    // --------- Methods ----------------------

    int[] matrix2Array(int[][] m) {
        int[] arr = new int[m.length * m[0].length];
        int k = 0;   // Index for array
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m[0].length; c++) {
                arr[k] = m[r][c];
                k++;  // Step array
            }
        }
        return arr;
    }


    // Alternate, using more math fewer variables
    int[] matrix2Array2(int[][] m) {
        int[] arr = new int[m.length * m[0].length];
        int nCols = m[0].length;
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m[0].length; c++) {
                arr[r * nCols + c] = m[r][c];  // Math here
            }
        }
        return arr;
    }

    // ----------------- IO Methods  ------------------

    int[] readArray() {
        out.print("Length > ");
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            out.print(i + " > ");
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    void writeArray(int[] arr) {
        out.println(Arrays.toString(arr));
    }

    int[][] readMatrix() {
        out.print("Input matrix rows and columns > ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] m = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                out.print(r + ":" + c + " > ");
                m[r][c] = sc.nextInt();
            }
        }
        return m;
    }

    void writeMatrix(int[][] m) {
        for (int r = 0; r < m.length; r++) {
            out.print("[ ");
            for (int c = 0; c < m[0].length; c++) {
                out.print(m[r][c] + " ");
            }
            out.println("]");
        }
    }

}

