import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class Load {
    /*************************************************************************************
     *  - Method Name: load()
     *  - Input Parameters : WorkingPanel workingPanel
     *  - Return Type :void
     *  - Author : Keshav
     *  - Creation Date : 03/08/2021
     *  - Desc: Loads the content of file into the Working panel object.
     ***************************************************************************************/
    public static void load(WorkingPanel workingPanel) {
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
                        /**In Progress**/
                    }

                }
                else{
                    System.out.println("Incorrect file format!");
                }
                fileIn.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

}



