import java.util.Scanner;

public class Main {
    public static int SAVED_MATRICES = 5;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Matrix[] saved = new Matrix[SAVED_MATRICES];
        int counter = 0;

        String[] options = new String[]{
                "Exit",
                "Show options",
                "Saved matrices",
                "Save matrix",
                "Sum matrices",
                "Multiply matrices",
                "Transpose matrix",
        };

        int chosen = 1;
        while (true) {
            Matrix a;
            Matrix b;
            try {
                switch (chosen) {
                    case 0:
                        System.exit(0);
                    case 1:
                        System.out.println("\u001B[36m" + "Available options:" + "\u001B[0m");
                        for (int i = 0; i < options.length; i++) {
                            System.out.println(i + " - " + options[i]);
                        }
                        break;
                    case 2:
                        System.out.println("\u001B[36m" + "Saved matrices:" + "\u001B[0m");
                        for (int i = 0; i < counter; i++) {
                            System.out.println((i + 1) + ":");
                            Matrix.showMatrix(saved[i]);
                        }
                        break;
                    case 3:
                        if (counter == SAVED_MATRICES) {
                            System.out.print("\u001B[33m" + "The oldest matrix will be deleted. Continue? (1/0) " + "\u001B[0m");
                            if (in.nextInt() == 0) break;

                            for (int i = 1; i < SAVED_MATRICES; i++) {
                                saved[i - 1] = saved[i];
                            }

                            counter--;
                        }
                        System.out.println("MATRIX TO SAVE");

                        saved[counter] = new Matrix();
                        counter++;
                        System.out.println("\u001B[32m" + "Successfully saved" + "\u001B[36m");
                        break;
                    case 4:
                        System.out.print("Do you want to work with saved matrices? (1/0) ");
                        if (in.nextInt() == 1) {
                            System.out.print("Enter two numbers of saved matrices: ");
                            String[] input = in.nextLine().split(" ");
                            int i = Integer.parseInt(input[0]);
                            int j = Integer.parseInt(input[1]);
                            if (i < counter && j < counter) {
                                throw new RuntimeException("Incorrect chosen matrix!");
                            }
                            a = saved[i];
                            b = saved[j];
                        } else {
                            System.out.println("FIRST MATRIX");
                            a = new Matrix();

                            System.out.println("SECOND MATRIX");
                            b = new Matrix();
                        }
                        System.out.println("\u001B[36m" + "SUM" + "\u001B[0m");
                        Matrix.showMatrix(Matrix.sumMatrices(a, b));
                        break;
                    case 5:
                        System.out.print("Do you want to work with saved matrices? (1/0) ");
                        if (in.nextInt() == 1) {
                            System.out.print("Enter two numbers of saved matrices: ");
                            String[] input = in.nextLine().split(" ");
                            int i = Integer.parseInt(input[0]);
                            int j = Integer.parseInt(input[1]);
                            if (i < counter && j < counter) {
                                throw new RuntimeException("Incorrect chosen matrix!");
                            }
                            a = saved[i];
                            b = saved[j];
                        } else {
                            System.out.println("FIRST MATRIX");
                            a = new Matrix();

                            System.out.println("SECOND MATRIX");
                            b = new Matrix();
                        }
                        System.out.println("\u001B[36m" + "MULTIPLICATION" + "\u001B[0m");
                        Matrix.showMatrix(Matrix.multiplyMatrices(a, b));
                        break;
                    case 6:
                        System.out.print("Do you want to work with saved matrix? (1/0) ");
                        if (in.nextInt() == 1) {
                            System.out.print("Enter number of saved matrix: ");
                            int i = in.nextInt();
                            if (i < counter) a = saved[in.nextInt()];
                            else throw new RuntimeException("Incorrect chosen matrix!");
                        } else {
                            System.out.println("MATRIX");
                            a = new Matrix();
                        }
                        System.out.println("\u001B[36m" + "TRANSPOSITION" + "\u001B[0m");
                        Matrix.showMatrix(Matrix.transposeMatrix(a));
                        break;
                }
            } catch (RuntimeException e) {
                System.out.println("\u001B[31m" + e.getMessage() + "\u001B[0m");
            }

            System.out.println("\u001B[36m" + "\nChoose an option:" + "\u001B[0m");
            chosen = in.nextInt();
        }
    }
}