import java.util.Scanner;

public class Matrix {
    int n, m;
    ComplexNumber[][] matrix;

    // in-code matrix initialization
    Matrix(int n0, int m0) {
        n = n0;
        m = m0;
        matrix = new ComplexNumber[n][m];
    }

    // console matrix initialization
    Matrix() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter matrix boundaries:");
        String[] nums = in.nextLine().split(" ");
        if (nums.length != 2) {
            throw new RuntimeException("2 numbers were expected.");
        }

        n = Integer.parseInt(nums[0]);
        m = Integer.parseInt(nums[1]);
        matrix = new ComplexNumber[n][m];

        System.out.println("Imaginary numbers of the type 'a+-bi' allowed. Enter matrix " + n + "*" + m + ":");
        for (int i = 0; i < n; i++) {
            String[] line = in.nextLine().split(" ");

            if (line.length != m) {
                throw new RuntimeException("Incorrect input. " + m + " numbers separated by ' ' expected.");
            }

            matrix[i] = new ComplexNumber[m];

            for (int j = 0; j < m; j++) {
                matrix[i][j] = new ComplexNumber(line[j]);
            }
        }
    }

    static Matrix sumMatrices(Matrix a, Matrix b) {
        if (a.n != b.n || a.m != b.m) {
            throw new RuntimeException("Only matrices with equal boundaries can be summed up!");
        }

        Matrix c = new Matrix(a.n, a.m);
        for (int i = 0; i < c.n; i++) {
            for (int j = 0; j < c.m; j++) {
                c.matrix[i][j] = ComplexNumber.sum(a.matrix[i][j], b.matrix[i][j]);
            }
        }
        return c;
    }

    static Matrix multiplyMatrices(Matrix a, Matrix b) {
        if (a.m != b.n) {
            throw new RuntimeException("Incorrect matrices' sizes for multiplication!");
        }

        Matrix c = new Matrix(a.n, b.m);

        for (int i = 0; i < c.n; i++) {
            for (int j = 0; j < c.m; j++) {
                c.matrix[i][j] = new ComplexNumber(0, 0);
                for (int k = 0; k < a.m; k++) {
                    c.matrix[i][j] = ComplexNumber.sum(c.matrix[i][j], ComplexNumber.multiplication(a.matrix[i][k], b.matrix[k][j]));
                }
            }
        }
        return c;
    }

    static Matrix transposeMatrix(Matrix a) {
        Matrix c = new Matrix(a.m, a.n);
        for (int i = 0; i < c.n; i++) {
            for (int j = 0; j < c.m; j++) {
                c.matrix[i][j] = a.matrix[a.n - j - 1][i];
            }
        }
        return c;
    }

    static void showMatrix(Matrix a) {
        System.out.println();
        for (int i = 0; i < a.n; i++) {
            for (int j = 0; j < a.m; j++) {
                if (a.matrix[i][j].b == 0) {
                    System.out.printf("%5d | ", a.matrix[i][j].a);
                } else if (a.matrix[i][j].b > 0) {
                    System.out.printf("%5s | ", a.matrix[i][j].a + "+" + a.matrix[i][j].b + "i");
                } else {
                    System.out.printf("%5s | ", a.matrix[i][j].a + "-" + (-1) * a.matrix[i][j].b + "i");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}