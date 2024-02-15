package task1.NameInitials;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import task1.FileChooser;

public class NameInitials {


    public static void makenNameInitials(String expression){

        String[] parts = expression.split("\\s+");
        if (parts.length >= 3){
            System.out.println("String \"" + expression + " \" contains more than 3 words.");
        
        } else if (parts.length < 3 && parts.length > 0){
            System.out.println("String \"" + expression + " \" contains less than 3 words.");
            return;
        } else {
            System.err.println();
        }

        System.out.println(String.format("%s %s.%s.", parts[1], parts[0].toUpperCase().charAt(0), parts[2].toUpperCase().charAt(0)));

    }


    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new FileReader(new FileChooser().main(null)));
        
        try{
            
            String line = bf.readLine();
            while (line != null){
    
                try{
                    makenNameInitials(line);
                } catch (NullPointerException e){}
            
                line = bf.readLine();
    
            }

        } catch (FileNotFoundException e){
            System.out.println("File couldn't be found.");
        }
        bf.close();
    }

    

}