package task5;

import javax.swing.JFileChooser;

public class DirectoryChooser {

    private String chosen;

    public String choser() {
        
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setCurrentDirectory(null);
        int returnVal = chooser.showOpenDialog(null);
        chosen = chooser.getSelectedFile().getAbsolutePath();
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You've chosen to use this directory: " +
                    chosen);
        }
        return chosen;
    }

}
