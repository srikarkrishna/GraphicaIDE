import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class Load {
    public static void load(String[] args) {
        // write your code here
        File file;
        Scanner fileIn;
        int response;
        JFileChooser chooser = new JFileChooser("");

        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        response = chooser.showOpenDialog(null);

        if(response == JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile();

            try {
                fileIn = new Scanner(file);
                if(file.isFile()){
                    while(fileIn.hasNextLine()){
                        String line = fileIn.nextLine();
                        System.out.println(line);

                    }

                }
                else{
                    System.out.println("That was not a file!");
                }
                fileIn.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

}



