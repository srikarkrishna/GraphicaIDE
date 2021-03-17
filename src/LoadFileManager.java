import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author Keshav & Sneha
 * @since 03-13-2020
 *
 *
 */
class LoadFileManager implements ActionListener {
    private String fileName;
    private AppMain mainFrame;

    public LoadFileManager(AppMain frame) {
      this.mainFrame = frame;
    }

    /*************************************************************************************
     *  - Method Name: actionPerformed()
     *  - Return Type :none
     *  - Authors : Sneha
     *  - Creation Date : 03/13/2021
     *  - Desc: Action performed while load
     ***************************************************************************************/
    public void actionPerformed(ActionEvent e) {
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
