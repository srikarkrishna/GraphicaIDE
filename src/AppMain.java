import icons.BarsIcon;
import icons.IconBase;
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
    Icons icon = new BarsIcon();
    String selectedIconText;
    static int tabIndex=2;
    IconBase iconBase;

    public AppMain(String title) {
        setTitle(title);
        lPanel = new LeftPanel();
        jTabbedPane = new JTabbedPane();
        createWorkSpace();
        menuBar = new JMenuBar();
        addMenu();
        JSplitPane horizontalPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, lPanel, jTabbedPane);
        JSplitPane verticalPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, menuBar, horizontalPane);
        horizontalPane.setResizeWeight(0.2);
        verticalPane.setEnabled(false);
        verticalPane.setResizeWeight(0.03);
        add(verticalPane);
        menuBar.setBackground(Color.BLUE);
        setSize(1280, 720);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        verticalPane.resetToPreferredSizes();
        horizontalPane.resetToPreferredSizes();
        addPanelActionListeners();
    }
    public static void main(String[] args)
    {
        JFrame jframe = new AppMain(windowTitle);
    }
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
    }

    private void createWorkSpace() {
        WorkingPanel workingPanel = new WorkingPanel();
        jTabbedPane.add("Space 1", workingPanel);
        workingPanel.setBackground(Color.ORANGE);
    }

    public void addPanelActionListeners(){
        iconBase = new IconBase();
        JButton []iconsArray = LeftPanel.getIconsArray();
        for (JButton button : iconsArray) {
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    selectedIconText = button.getText();
                    super.mouseReleased(e);
                    int tabIndex = jTabbedPane.getSelectedIndex();
                    WorkingPanel tab = (WorkingPanel) jTabbedPane.getComponent(tabIndex);
                    System.out.println(tabIndex+"Tab Name");
                    icon.draw(tab.getGraphics(), (int) (MouseInfo.getPointerInfo().getLocation().getX()-320),
                            (int) (MouseInfo.getPointerInfo().getLocation().getY())-160);
                    tab.repaint();
                }
            });
            button.addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    super.mouseDragged(e);
                    selectedIconText = button.getText();
                    icon = iconBase.getIconObject(button.getText());
                        icon.draw(getGraphics(), (int) (MouseInfo.getPointerInfo().getLocation().getX() - button.getWidth() / 3),
                                (int) (MouseInfo.getPointerInfo().getLocation().getY() - button.getHeight() / 3));
                        repaint();
                }
            });
        }
    }

    private void addMenu(){
        menuBar.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton buttonNewTab = new JButton("New Tab");
        JButton buttonLoad = new JButton("Load");
        JButton buttonSave = new JButton("Save");
        menuBar.add(buttonNewTab);
        menuBar.add(buttonLoad);
        menuBar.add(buttonSave);
        buttonNewTab.setPreferredSize(new Dimension(150,40));
        buttonLoad.setPreferredSize(new Dimension(150,40));
        buttonSave.setPreferredSize(new Dimension(150,40));
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
