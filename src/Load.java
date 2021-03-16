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
 * @since 03-16-2020
 *
 *
 */
class Load implements ActionListener {
    private String fileName;
    //private JTabbedPane pane;
    private AppMain mainFrame;

    public Load(AppMain frame) {
      this.mainFrame = frame;
    }

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

                Container content = mainFrame.getContentPane();
                content.removeAll();
                //content.add(new OptionsPanel(), BorderLayout.NORTH);
                content.add(new LeftPanel(), BorderLayout.WEST);
                JTabbedPane pane = new JTabbedPane();
                mainFrame.setTabbedPane(pane);
                content.add(pane, BorderLayout.CENTER);
                System.out.println("added left panel");
//                StoreClickPoints.link1=null;
//                StoreClickPoints.link2=null;
                mainFrame.workingPanelArray = new ArrayList<WorkingPanel>();
                int i = 1;
                for (Component component : tabsToOpen) {
                    System.out.println("reading each component in the workspace");
                    WorkingPanel panel = (WorkingPanel) component;
                    mainFrame.jTabbedPane.add("Tab"+i , panel);
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
