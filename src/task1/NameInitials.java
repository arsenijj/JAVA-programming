package task1;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NameInitials {

    public void makenNameInitials(String expression) {

        String[] parts = expression.split("\\s+");
        if (parts.length >= 3) {
            // System.out.println("\tString \"" + expression + " \" contains more than 3
            // words.");

        } else if (parts.length == 2) {
            // System.out.println("\tString \"" + expression + " \" contains less than 3
            // words.");
            return;
        } else if ((parts.length == 1) && (parts[0].equals(""))) {
            System.out.println("\n");
            return;
        }

        System.out.println(String.format("%s %s.%s.", parts[1], parts[0].toUpperCase().charAt(0),
                parts[2].toUpperCase().charAt(0)));

    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new FileReader(new FileChooser().choser()));

        try {
            NameInitials nameInitials = new NameInitials();
            String line = bf.readLine();
            while (line != null) {

                try {
                    nameInitials.makenNameInitials(line);
                } catch (NullPointerException e) {
                }

                line = bf.readLine();

            }

        } catch (FileNotFoundException e) {
            System.out.println("File couldn't be found.");
        }
        bf.close();
    }

}