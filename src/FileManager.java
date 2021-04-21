import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

/**
 * @author Sneha
 * @since 03-13-2020
 */
public class FileManager {
    private AppMain mainFrame;
    private String fileName;

    public FileManager(AppMain mainFrame) {
        this.mainFrame = mainFrame;
    }

    /**
     * Author: Keshav
     * Desc: Method to save the workspace
     */
    public void saveFile() throws IOException {
        FileOutputStream fileOutStream;
        ObjectOutputStream objectOutStream;
        Component[] tabs = mainFrame.jTabbedPane.getComponents();
        JFileChooser chosenFile = new JFileChooser();
        int showSaveDialog = chosenFile.showSaveDialog(null);
        if (showSaveDialog == JFileChooser.APPROVE_OPTION) {
            fileName = chosenFile.getSelectedFile().getAbsolutePath() + ".ser";
        }
        fileOutStream = new FileOutputStream(fileName);
        objectOutStream = new ObjectOutputStream(fileOutStream);
        objectOutStream.writeObject(tabs);
        fileOutStream.flush();
        JOptionPane.showMessageDialog(mainFrame, "Workspace saved sucessfully");
        //if (objectOutStream != null) {
            objectOutStream.close();
        //}
        //if (fileOutStream != null) {
            fileOutStream.close();
        //}
    }

    /**
     * Author: Sneha
     * Desc: Method to load the workspace
     */
    public void loadFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInStream = null;
        ObjectInputStream objectInStream = null;
        Component[] tabsToOpen;
        JFileChooser chosenFile = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("SER516", "ser");
        chosenFile.setFileFilter(filter);
        int showOpenDialog = chosenFile.showOpenDialog(null);
        if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
            fileName = chosenFile.getSelectedFile().getAbsolutePath();
            fileInStream = new FileInputStream(fileName);
            objectInStream = new ObjectInputStream(fileInStream);
            tabsToOpen = (Component[]) objectInStream.readObject();
            AppMain.workingPanelArray = new ArrayList<>();
            int i = 1;
            mainFrame.jTabbedPane.removeAll();
            for (Component component : tabsToOpen) {
                WorkingPanel panel = (WorkingPanel) component;
                panel.addIconActionListeners();
                mainFrame.jTabbedPane.add("Space" + i, panel);
                AppMain.workingPanelArray.add(panel);
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
    }
}
