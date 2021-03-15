import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
    //private Frame frame;

    public void Load() {
      //  this.frame = frame;
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
                JFrame frame = new JFrame();
                Container content = frame.getContentPane();
                content.removeAll();
                content.add(new AppMain("new_file"), BorderLayout.NORTH);
                JTabbedPane pane = new JTabbedPane();
                content.add(pane, BorderLayout.CENTER);
                content.add(new LeftPanel(), BorderLayout.WEST);

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
