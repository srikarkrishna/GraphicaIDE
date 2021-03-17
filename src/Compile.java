import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Compile implements ActionListener {

    private AppMain mainFrame;
    public Compile(AppMain frame){
        this.mainFrame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // int selectedIndex = mainFrame.jTabbedPane.getSelectedIndex();
        // WorkingPanel workingPanel = mainFrame.workingPanelArray.get(selectedIndex);
        // CompileTab(workingPanel);
    }

    public Boolean CompileTab(WorkingPanel workingPanel){
        // should return whether all shapes are connected or not
        // left to implement
        // allShapesConnected()
        return false;
    }
}
