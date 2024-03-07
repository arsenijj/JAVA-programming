package task6.Fibonacci;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Fibonacci extends RecursiveTask<Integer> {
    final int n;

    Fibonacci(int n) {
        this.n = n;
    }

    protected Integer compute() {
        if (n <= 1)
            return n;
        Fibonacci f1 = new Fibonacci(n - 1);
        f1.fork();
        Fibonacci f2 = new Fibonacci(n - 2);
        return f2.compute() + f1.join();
    }

    public static void main(String[] args) {

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
        ForkJoinPool pool = new ForkJoinPool();
        int result = pool.invoke(new Fibonacci(n));
        System.out.println("Fibonacci number at position " + n + " is: " + result);
        pool.close();
    }
}
