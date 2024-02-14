import java.util.Scanner;

public class Matrix {
    int n, m;
    ComplexNumber[][] matrix;

    Matrix(int n0, int m0) {
        n = n0;
        m = m0;
        matrix = new ComplexNumber[n][m];
    }

    void initMatrix() {
        System.out.println("Imaginary numbers of the type 'a+bi' allowed. Enter matrix " + n + "*" + m + ":");
        for (int i = 0; i < n; i++) {
            Scanner in = new Scanner(System.in);
            String[] line = in.nextLine().split(" ");

            if (line.length != m) {
                System.out.println("Incorrect input. " + m + " numbers separated by ' ' expected.");
                return;
            }

            matrix[i] = new ComplexNumber[m];

            for (int j = 0; j < m; j++) {
                matrix[i][j] = new ComplexNumber(line[j]);
            }
        }
    }

    void showMatrix(Matrix a) {
        System.out.println("Your matrix:");
        for (int i = 0; i < a.n; i++) {
            for (int j = 0; j < a.m; j++) {
                if (a.matrix[i][j].b == 0) {
                    System.out.print(a.matrix[i][j].a + " ");
                } else if (a.matrix[i][j].b > 0) {
                    System.out.print(a.matrix[i][j].a + "+" + a.matrix[i][j].b + "i ");
                } else {
                    System.out.print(a.matrix[i][j].a);
                    System.out.print(a.matrix[i][j].b + "i ");
                }
            }
            System.out.println();
        }
    }
}
