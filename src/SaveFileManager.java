import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
/**
 *
 * @author Sneha
 * @since  03-13-2020
 *
 */
public class SaveFileManager implements ActionListener {
    private String fileName;

    public SaveFileManager(){

    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Saving workspace");
        //need to change
        JTabbedPane pane = new JTabbedPane();
        FileOutputStream fileOutStream = null;
        ObjectOutputStream objectOutStream = null;
        Component[] tabs = pane.getComponents();
        try {
            JFileChooser chosenFile = new JFileChooser();
            int showSaveDialog = chosenFile.showSaveDialog(null);
            if (showSaveDialog == JFileChooser.APPROVE_OPTION) {
                fileName = chosenFile.getSelectedFile().getAbsolutePath().toString() + ".ser";
            }
            fileOutStream = new FileOutputStream(new File(fileName));
            objectOutStream = new ObjectOutputStream(fileOutStream);
            objectOutStream.writeObject(tabs);
            fileOutStream.flush();
            if (objectOutStream != null) {
                objectOutStream.close();
            }
            if (fileOutStream != null) {
                fileOutStream.close();
            }
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}