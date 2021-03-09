import icons.BarsIcon;
import icons.Icons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppMain extends JFrame{
    final static String windowTitle = "GRAPHICAL IDE";
    LeftPanel lPanel;
    JTabbedPane jTabbedPane;
    JMenuBar menuBar;
    BorderLayout borderLayoutLeft;
    Icons icon = new BarsIcon();
    static int tabIndex=2;

    public AppMain(String title) {
        setTitle(title);
        lPanel = new LeftPanel();
        jTabbedPane = new JTabbedPane();
        createWorkSpace();
        menuBar = new JMenuBar();
        addMenu();
        borderLayoutLeft = new BorderLayout();
        JSplitPane hPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, lPanel, jTabbedPane);
        JSplitPane vPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, menuBar, hPane);
        hPane.setResizeWeight(0.2);
        vPane.setEnabled(false);
        vPane.setResizeWeight(0.1);
        add(vPane);
        lPanel.setBackground(Color.CYAN);
        jTabbedPane.setBackground(Color.GREEN);
        menuBar.setBackground(Color.BLUE);
        setSize(1280, 720);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vPane.resetToPreferredSizes();
        hPane.resetToPreferredSizes();
        addPanelActionListeners();
    }
    public static void main(String[] args)
    {
        JFrame jframe = new AppMain(windowTitle);

    }

    private void createWorkSpace() {
        WorkingPanel workingPanel = new WorkingPanel();
        jTabbedPane.add("Space 1", workingPanel);
        workingPanel.setBackground(Color.ORANGE);
    }

    public void addPanelActionListeners(){

        JButton []iconsArray = LeftPanel.getIconsArray();
        for (JButton button : iconsArray) {
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    super.mouseReleased(e);
                    WorkingPanel tab = (WorkingPanel) jTabbedPane.getSelectedComponent();
                    icon.draw(tab.getGraphics(), (int) (MouseInfo.getPointerInfo().getLocation().getX()),
                            (int) (MouseInfo.getPointerInfo().getLocation().getY()));
                    repaint();
                }
            });
            button.addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    super.mouseDragged(e);
                    if (button.getText().equals("||")) {
                        icon.draw(getGraphics(), (int) (MouseInfo.getPointerInfo().getLocation().getX() - button.getWidth() / 3),
                                (int) (MouseInfo.getPointerInfo().getLocation().getY() - button.getHeight() / 3));
                        repaint();
                    }
                }
            });
        }
    }

    private void addMenu(){
        JButton buttonNewTab = new JButton("New Tab");
        JButton buttonLoad = new JButton("Load");
        JButton buttonSave = new JButton("Save");
        menuBar.add(buttonNewTab);
        menuBar.add(buttonLoad);
        menuBar.add(buttonSave);

        buttonNewTab.addActionListener(e -> {
                String tabName = "Space ";
                tabName += tabIndex;
                tabIndex += 1;
                WorkingPanel workingPanel = new WorkingPanel();
                workingPanel.setBackground(Color.ORANGE);
                jTabbedPane.add(tabName, workingPanel);
        });
    }
}
