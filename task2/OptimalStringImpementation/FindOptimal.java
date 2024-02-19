package task2.OptimalStringImpementation;

import java.util.Random;
import java.util.*;

public class FindOptimal {

    final static Random random = new Random();
    final static Double LIMIT = 1e5; 
    public static String randomString(Integer amount) {
        String generated = "";
        for (int i = 0; i < amount; i++) {
            generated += (char) (random.nextInt(65536));
        }
        return generated;
    }

    public void count(String chosenClass) {

        Long timeCounter = System.currentTimeMillis();
        if (chosenClass.equals("String")) {
            String generated = new String();
            for (int i = 0; i < LIMIT; i++) {
                generated += randomString(10);
            }
        } else if (chosenClass.equals("StringBuffer")) {
            StringBuffer generated = new StringBuffer();
            for (int i = 0; i < LIMIT; i++) {
                generated.append(randomString(10));
            }
        } else {
            StringBuilder generated = new StringBuilder();
            for (int i = 0; i < LIMIT; i++) {
                generated.append(randomString(10));
            }
        }
        
        Long timeCounterSec = (long) ((System.currentTimeMillis() - timeCounter) / 1000.0);
        String result = String.format("%s 1e6 characters long is generated for %d millis (%d seconds)", chosenClass,
                timeCounter, timeCounterSec);
        System.out.println(result);
    }

    public static void main(String[] args) {
        ArrayList<String> chosen = new ArrayList<>();
        chosen.add("String");
        chosen.add("StringBuffer");
        chosen.add("StringBuilder");
        for (String choice : chosen) {
            new FindOptimal().count(choice);
        }
    }

}