import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter matrix boundaries:");

        String[] nums = in.nextLine().split(" ");

        if (nums.length != 2) {
            System.out.println("Two numbers expected.");
            return;
        }
        Matrix a = new Matrix(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
        a.initMatrix();
        a.showMatrix(a);
    }
}