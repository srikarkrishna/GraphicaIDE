import javax.swing.*;
import java.awt.*;

public class AppMain extends JFrame{
    final static String windowTitle = "GRAPHICAL IDE";
    LeftPanel lPanel;
    RightPanel rPanel;
    MenuBar menuBar;
    BorderLayout borderLayoutLeft;

    public AppMain(String title) {
        setTitle(title);
        lPanel = new LeftPanel();
        rPanel = new RightPanel();
        menuBar = new MenuBar();
        borderLayoutLeft = new BorderLayout();

        //setLayout(borderLayoutFrame);

        JSplitPane hPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, lPanel, rPanel);
        JSplitPane vPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, menuBar, hPane);
        hPane.setResizeWeight(0.2);
        vPane.setEnabled(false);
        vPane.setResizeWeight(0.1);
        add(vPane);
        //add(hPane);
        //System.out.println("ko");
        lPanel.setBackground(Color.CYAN);
        rPanel.setBackground(Color.GREEN);
        menuBar.setBackground(Color.BLUE);
        //lPanel.setLayout(borderLayoutLeft);
        // rPanel.setLayout(borderLayoutRight);
        //add(lPanel, BorderLayout.WEST);
       // add(rPanel, BorderLayout.EAST);
        setSize(1280, 720);
        setVisible(true);
        setResizable(true);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // pane.setDividerLocation(pane.getSize().width/5);
        vPane.resetToPreferredSizes();
        hPane.resetToPreferredSizes();
    }
    public static void main(String args[])
    {
        JFrame jframe = new AppMain(windowTitle);
    }
}
