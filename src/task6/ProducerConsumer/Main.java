package task6.ProducerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public void run() {
        BlockingQueue<Food> queue = new LinkedBlockingQueue<>();

        Producer producer = new Producer(queue);
        Consumer consumer1 = new Consumer(queue, "Biba");
        Consumer consumer2 = new Consumer(queue, "Boba");

        Thread producerThread = new Thread(producer);
        Thread consumerThread1 = new Thread(consumer1);
        Thread consumerThread2 = new Thread(consumer2);

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
