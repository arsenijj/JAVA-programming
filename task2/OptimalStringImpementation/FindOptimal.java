package task2.OptimalStringImpementation;

import java.util.Random;

public class FindOptimal {

    public static String randomString(Integer amount) {
        String generated = "";
        Random random = new Random();
        for (int i = 0; i < amount; i++) {
            generated += (char) (random.nextInt(65536));
        }
        return generated;
    }

    public static void count(String chosenClass) {

        Long timeCounter = System.currentTimeMillis();

        if (chosenClass.equals("String")) {
            String generated = "";
            for (int i = 0; i < 1e5; i++) {
                generated += randomString(10);
            }
        } else if (chosenClass.equals("StringBuffer")) {
            StringBuffer generated = new StringBuffer();
            for (int i = 0; i < 1e5; i++) {
                generated.append(randomString(10));
            }
        } else {
            StringBuilder generated = new StringBuilder();
            for (int i = 0; i < 1e5; i++) {
                generated.append(randomString(10));
            }
        }

        Long timeCounterSec = (long) ((System.currentTimeMillis() - timeCounter) / 1000.0);
        String result = String.format("%s 1e6 characters long is generated for %d millis (%d seconds)", chosenClass,
                timeCounter, timeCounterSec);
        System.out.println(result);
    }

    public static void main(String[] args) {
        count("String");
        count("StringBuffer");
        count("StringBuilder");
    }

}