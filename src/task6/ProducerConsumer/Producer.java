package task6.ProducerConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private final BlockingQueue<Food> queue;

    public Producer(BlockingQueue<Food> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Random random = new Random();
                Thread.sleep((random.nextInt(5) + 1) * 1000);
                int randomIndex = random.nextInt(6);
                switch (randomIndex) {
                    case 0:
                        queue.put(new Food("Shawarma", 700));
                        break;
                    case 1:
                        queue.put(new Food("Water", 0));
                        break;
                    case 2:
                        queue.put(new Food("Gainer", 777));
                        break;
                    case 3:
                        queue.put(new Food("Pure isolate", 160));
                        break;
                    case 4:
                        queue.put(new Food("Pancakes with caviar", 500));
                        break;
                    case 5:
                        queue.put(new Food("California roll", 200));
                        break;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
