import icons.IconMain;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class AppMain extends JFrame{
    final static String windowTitle = "GRAPHICAL IDE";
    LeftPanel lPanel;
    JTabbedPane jTabbedPane;
    JMenuBar menuBar;
    IconMain icon;
    String selectedIconText;
    static int tabIndex=2;
    IconBase iconBase;
    JSplitPane horizontalPane;
    JSplitPane verticalPane;
    public static ArrayList<WorkingPanel> workingPanelArray;
    /*************************************************************************************
     *  - public Constructor
     *  - Author : Sulabh
     *  - Creation Date : 03/06/2021
     *  - Desc: Place the TabbedPane, Panels and Menubar on the GUI.
     ***************************************************************************************/
    public AppMain(String title) {
        setTitle(title);
        lPanel = new LeftPanel();
        jTabbedPane = new JTabbedPane();
        createWorkSpace();
        menuBar = new JMenuBar();
        addMenu();
        horizontalPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, lPanel, jTabbedPane);
        verticalPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, menuBar, horizontalPane);
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


    public void paintComponents(Graphics g) {
        super.paintComponents(g);
    }

    private void createWorkSpace() {
        WorkingPanel workingPanel = new WorkingPanel();
        jTabbedPane.add("Space 1", workingPanel);
        workingPanel.setBackground(Color.ORANGE);
    }
    /*************************************************************************************
     *  - Method Name: addPanelActionListeners()
     *  - Input Parameters : none
     *  - Return Type :none
     *  - Authors : Samarth, Srikar
     *  - Creation Date : 03/07/2021
     *  - Desc: Action listeners to the icon buttons in the left panel
     ***************************************************************************************/
    public void addPanelActionListeners(){

        iconBase = new IconBase();

        JButton []iconsArray = LeftPanel.getIconsArray();
        for (JButton button : iconsArray) {
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    selectedIconText = button.getText();
                }
            });

            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    super.mouseReleased(e);
                    int tabIndex = jTabbedPane.getSelectedIndex();
                    WorkingPanel tab = (WorkingPanel) jTabbedPane.getComponent(tabIndex);
                    if(tab.getMousePosition()!=null) {
                        addIconToTab(tab, button);
                        tab.repaint();
                    }

                }
            });

            button.addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    super.mouseDragged(e);
                    selectedIconText = button.getText();

                    int tabIndex = jTabbedPane.getSelectedIndex();
                    WorkingPanel tab = (WorkingPanel) jTabbedPane.getComponent(tabIndex);

                    icon = iconBase.getIconObject(button.getText(), tab);
                    if (icon != null) {
                        icon.draw(getGraphics(), (int) (MouseInfo.getPointerInfo().getLocation().getX() - button.getWidth() / 3),
                                (int) (MouseInfo.getPointerInfo().getLocation().getY() - button.getHeight() / 3));
                    }
                    repaint();
                }
            });
        }
    }
    /*************************************************************************************
     *  - Method Name: addMenu()
     *  - Input Parameters : none
     *  - Return Type :none
     *  - Author : Sulabh
     *  - Creation Date : 03/06/2021
     *  - Desc: Adds buttons and action listeners of them in the menu panel.
     ***************************************************************************************/
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
            Random rand = new Random();
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            Color backgroundColor = new Color(r, g, b);
            tabName += tabIndex;
            tabIndex += 1;
            WorkingPanel workingPanel = new WorkingPanel();
            workingPanel.setBackground(backgroundColor);
            jTabbedPane.add(tabName, workingPanel);
        });
        buttonSave.addActionListener(new SaveFileManager(this));
        buttonLoad.addActionListener(new LoadFileManager(this));

    }
    /*************************************************************************************
     *  - Method Name: addIconToTab()
     *  - Input Parameters : WorkingPanel tab, JButton button.
     *  - Return Type :none
     *  - Author : Samarth
     *  - Creation Date : 03/13/2021
     *  - Desc: Add icons into the working panel after they are dropped.
     ***************************************************************************************/
    public void addIconToTab(WorkingPanel tab,JButton button){
        String selectedIconText = button.getText();
        icon = iconBase.getIconObject(selectedIconText,tab);

        if (selectedIconText.equals("(")){
            tab.isOpenParenthesis = true;
        }
        else if (selectedIconText.equals(")")){
            tab.isCloseParenthesis = true;
        }

        if (icon != null) {
            icon.setX((int) tab.getMousePosition().getX() - IconMain.width / 2);
            icon.setY((int) tab.getMousePosition().getY() - IconMain.height / 2);
            tab.iconList.put(icon, "");
        }
    }

    public static void main(String[] args)
    {
        new AppMain(windowTitle);
    }

}
