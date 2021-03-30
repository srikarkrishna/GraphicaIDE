import icons.IconMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Set;

public class Compile implements ActionListener {

    private AppMain mainFrame;
    public Compile(AppMain frame){
        this.mainFrame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         int selectedIndex = mainFrame.jTabbedPane.getSelectedIndex();
         WorkingPanel workingPanel = mainFrame.workingPanelArray.get(selectedIndex);
         CompileTab(workingPanel.getConnections());
    }

    public Boolean CompileTab(HashMap<IconMain, Set<IconMain>> connections){
        // should return whether all shapes are connected or not
        // left to implement
        // allShapesConnected()

        return false;
    }
}
