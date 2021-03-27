import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Sneha
 * @since 03-13-2020
 *
 *
 */
public class FileManager {
    private AppMain mainFrame;
    private String fileName;

    public FileManager(AppMain mainFrame){
        this.mainFrame = mainFrame;
    }
    /*************************************************************************************
     *  - Method Name: saveFile()
     *  - Return Type :none
     *  - Authors : Keshav
     *  - Creation Date : 03/13/2021
     *  - Desc: Method to save the workspace
     ***************************************************************************************/
    public void saveFile(){
        FileOutputStream fileOutStream;
        ObjectOutputStream objectOutStream;
        Component[] tabs = mainFrame.jTabbedPane.getComponents();
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
            JOptionPane.showMessageDialog(mainFrame, "Workspace saved sucessfully");
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

    /*************************************************************************************
     *  - Method Name: loadFile()
     *  - Return Type :none
     *  - Authors : Sneha
     *  - Creation Date : 03/13/2021
     *  - Desc: Method to load the workspace
     ***************************************************************************************/
    public void loadFile(){
        FileInputStream fileInStream = null;
        ObjectInputStream objectInStream = null;
        Component[] tabsToOpen;
        try {
            JFileChooser chosenFile = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("SER516", "ser");
            chosenFile.setFileFilter(filter);
            int showOpenDialog = chosenFile.showOpenDialog(null);
            if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
                fileName = chosenFile.getSelectedFile().getAbsolutePath();
                fileInStream = new FileInputStream(fileName);
                objectInStream = new ObjectInputStream(fileInStream);
                tabsToOpen = (Component[]) objectInStream.readObject();
                mainFrame.workingPanelArray = new ArrayList<>();
                int i = 1;
                mainFrame.jTabbedPane.removeAll();
                for (Component component : tabsToOpen) {
                    WorkingPanel panel = (WorkingPanel) component;
                    mainFrame.jTabbedPane.add("Space"+i , panel);
                    mainFrame.workingPanelArray.add(panel);
                    panel.repaint();
                    i++;
                }
            }
            if (objectInStream != null) {
                objectInStream.close();
            }
            if (fileInStream != null) {
                fileInStream.close();
            }
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException e1) {
        }
    }
}
