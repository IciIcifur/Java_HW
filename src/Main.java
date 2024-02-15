import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Matrix[] saved = new Matrix[5];
        int counter = -1;

        String[] options = new String[]{
                "Exit",
                "Show options",
                "Saved matrices",
                "Save matrix",
                "Sum matrices",
                "Multiply matrices",
                "Transpose matrix",
                "Find matrix determinant",
        };

        int chosen = 1;
        while (true) {
            Matrix a;
            Matrix b;
            switch (chosen) {
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("Available options:");
                    for (int i = 0; i < options.length; i++) {
                        System.out.println(i + " - " + options[i]);
                    }
                    break;
                case 2:
                    System.out.println("Saved matrices:");
                    for (int i = 0; i <= counter; i++) {
                        System.out.println(i + ":");
                        Matrix.showMatrix(saved[i]);
                    }
                    break;
                case 3:
                    if (counter == 4) {
                        System.out.print("The oldest matrix will be deleted. Continue? (1/0) ");
                        if (in.nextInt() == 0) break;

                        for (int i = 1; i < 4; i++) {
                            saved[i - 1] = saved[i];
                        }
                    } else counter += 1;
                    System.out.println("MATRIX TO SAVE");
                    saved[counter] = new Matrix();
                    if (saved[counter].n != -1) System.out.println("Successfully saved");
                    else {
                        counter--;
                        System.out.println("An error occurred while initialization");
                    }
                    break;
                case 4:
                    System.out.print("Do you want to work with saved matrices? (1/0) ");
                    if (in.nextInt() == 1) {
                        System.out.print("Enter two numbers of saved matrices: ");
                        String[] input = in.nextLine().split(" ");
                        int i = Integer.parseInt(input[0]);
                        int j = Integer.parseInt(input[1]);
                        if (i < counter && j < counter) {
                            a = saved[i];
                            b = saved[j];
                        } else break;
                    } else {
                        System.out.println("FIRST MATRIX");
                        a = new Matrix();
                        if (a.n == -1) {
                            System.out.println("An error occurred while initialization");
                            break;
                        }
                        System.out.println("SECOND MATRIX");
                        b = new Matrix();
                        if (b.n == -1) {
                            System.out.println("An error occurred while initialization");
                            break;
                        }
                    }
                    System.out.println("SUM");
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
                            a = saved[i];
                            b = saved[j];
                        } else break;
                    } else {
                        System.out.println("FIRST MATRIX");
                        a = new Matrix();
                        if (a.n == -1) {
                            System.out.println("An error occurred while initialization");
                            break;
                        }
                        System.out.println("SECOND MATRIX");
                        b = new Matrix();
                        if (b.n == -1) {
                            System.out.println("An error occurred while initialization");
                            break;
                        }
                    }
                    System.out.println("MULTIPLICATION");
                    Matrix.showMatrix(Matrix.multiplyMatrices(a, b));
                    break;
                case 6:
                    System.out.print("Do you want to work with saved matrix? (1/0) ");
                    if (in.nextInt() == 1) {
                        System.out.print("Enter number of saved matrix: ");
                        int i = in.nextInt();
                        if (i < counter) a = saved[in.nextInt()];
                        else break;
                    } else {
                        System.out.println("MATRIX");
                        a = new Matrix();
                        if (a.n == -1) {
                            System.out.println("An error occurred while initialization");
                            break;
                        }
                    }
                    System.out.println("TRANSPOSITION");
                    Matrix.showMatrix(Matrix.transposeMatrix(a));
                    break;
            }
            System.out.println("\nChoose an option:");
            chosen = in.nextInt();
        }


        /*
1 2-1i 7
5 3 1+2i
6 4 1


1 1 1-1i
1 2 2+1i
0 0 1
*/
    }
}