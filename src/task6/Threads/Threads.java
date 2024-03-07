package task6.Threads;

public class Threads {
    private static int sharedVariable = 0;
    private static final int ITERATIONS = 100000;

    public void run() {
        Thread thread1 = new Thread(new IncrementTask());
        Thread thread2 = new Thread(new IncrementTask());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final value of sharedVariable: " + sharedVariable);
    }

    static class IncrementTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < ITERATIONS; i++) {
                synchronized (Threads.class) {
                    sharedVariable++;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Threads().run();
    }

}
