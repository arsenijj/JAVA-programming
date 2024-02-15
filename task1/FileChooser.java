package task1;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;



public class FileChooser {
      
    public static String main(String[] args){
        
    
        // assertTrue(userDirectory.endsWith());
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(null);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Choose file", "txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        String chosen = chooser.getSelectedFile().getAbsolutePath();
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You've chosen to open this file: " +
                    chosen);
        }
        return chosen;
    }
}
