package task6.Fibonacci;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetNumber {
    public int getNumber() {
        int n = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the positive integer: ");
            n = scanner.nextInt();
            scanner.close();
        } catch (InputMismatchException e) {
            System.out.println("An error has occured. Value of n would be zero");
            e.getStackTrace();
        }
        if (n < 0) {
            System.out.println("Number must be positive.");
            System.exit(0);
        }
        return n;
    }
}