package task3.SortingByManyParameters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import task1.FileChooser;
import java.util.*;
import java.util.Collections;

// Name | Surname | SursurName | Company | Rate
public class Sort {

    static Comparator<ArrayList<String>> comparator = new Comparator<ArrayList<String>>() {
        @Override
        public int compare(ArrayList<String> first, ArrayList<String> second) {
            int firstRating = Integer.parseInt(first.get(2));
            int secondRating = Integer.parseInt(second.get(2));
            int ratingComparison = (firstRating == secondRating) ? 0 : firstRating > secondRating ? 1 : -1;
            if (ratingComparison == 0) {
                return first.get(0).compareTo(second.get(0));
            }
            return -ratingComparison;
        }
    };

        public static void write(String path, ArrayList<ArrayList<String>> data){
            try (FileWriter writer = new FileWriter(path)){
                for (ArrayList<String> row : data){
                    for (String item: row){
                        writer.write(item + " ");
                    }
                    writer.write("\n");
                }
                System.out.println("Data has already written to the distanation file.");
            } catch (IOException e){
                System.out.println("Some trouble has occured while writing result data.");
            }
        }
    

    public static void main(String[] args) throws IOException {

        new FileChooser();
        BufferedReader bf = new BufferedReader(new FileReader(FileChooser.choser()));
        ArrayList<ArrayList<String>> data = new ArrayList<>();

        try {

            String line = bf.readLine();
            while (line != null) {

                String[] separated = line.split("\\s+");
                String ownerName = String.format("%s %s %s", separated[0], separated[1], separated[2]);

                String companyName = "";
                for (int i = 3; i < separated.length - 1; i++) {
                    companyName += separated[i] + " ";
                }

                String rating = separated[separated.length - 1];

                ArrayList<String> current = new ArrayList<>();
                current.add(ownerName);
                current.add(companyName);
                current.add(rating);
                data.add(current);

                line = bf.readLine();

            }

        } catch (FileNotFoundException e) {
            System.out.println("File couldn't be found.");
        }

        bf.close();
        Collections.sort(data, comparator);
        String path = FileChooser.chosen.replace(".txt", "_sorted.txt");
        write(path, data);
        System.out.println(data.getClass());
    }

}
