package task6.Fibonacci;

import java.util.concurrent.ForkJoinPool;

public class Main {

    public void run() {
        int n = new GetNumber().getNumber();
        ForkJoinPool pool = new ForkJoinPool();
        int result = pool.invoke(new Fibonacci(n));
        System.out.println("Fibonacci number at position " + n + " is: " + result);
        pool.close();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
