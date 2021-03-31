import icons.IconMain;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class AppMain extends JFrame implements ActionListener {
    final static String windowTitle = "GRAPHICAL IDE";
    LeftPanel lPanel;
    JTabbedPane jTabbedPane;
    JMenuBar menuBar;
    IconMain icon;
    String selectedIconText;
    IconFactory iconBase;
    JSplitPane horizontalPane;
    JSplitPane verticalPane;
    FileManager fileManager;
    static int tabIndex=2;
    Set<IconMain> visited;
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
        menuBar = new JMenuBar();
        addMenuItems();
        horizontalPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, lPanel, jTabbedPane);
        verticalPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, menuBar, horizontalPane);
        horizontalPane.setResizeWeight(0.2);
        verticalPane.setResizeWeight(0.03);
        add(verticalPane);
        setSize(1280, 720);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        verticalPane.resetToPreferredSizes();
        horizontalPane.resetToPreferredSizes();
        horizontalPane.setEnabled(false);
        verticalPane.setEnabled(false);
        addPanelActionListeners();
        createWorkSpace();
    }


    public void paintComponents(Graphics g) {
        super.paintComponents(g);
    }

    private void createWorkSpace() {
        WorkingPanel workingPanel = new WorkingPanel();
        jTabbedPane.add("Space 1", workingPanel);
        workingPanel.setBackground(Color.ORANGE);
       // WorkingPanel tab = (WorkingPanel) jTabbedPane.getComponent(tabIndex);
//        icon = iconBase.getIconObject("(",workingPanel);
//        icon = iconBase.getIconObject(")",workingPanel);
        addIconToTab(workingPanel, "(");
        addIconToTab(workingPanel, ")");



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

        iconBase = new IconFactory();

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
                        addIconToTab(tab, button.getText());
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
     *  - Method Name: createMenuBar()
     *  - Input Parameters : none
     *  - Return Type :none
     *  - Author : Sulabh, Sneha
     *  - Creation Date : 03/06/2021
     *  - Desc: Adds buttons and action listeners of them in the menu panel.
     ***************************************************************************************/
    private void addMenuItems(){
        menuBar.setLayout(new FlowLayout(FlowLayout.CENTER));
        menuBar.setBackground(Color.BLUE);
        JMenuItem newTabButton = new JMenuItem("New Tab");
        newTabButton.addActionListener(e ->
        {
            String tabName = "Space ";
            Random rand = new Random();
            float r = (float) (rand.nextFloat() / 2f + 0.5);
            float g = (float) (rand.nextFloat() / 2f + 0.5);
            float b = (float) (rand.nextFloat() / 2f + 0.5);
            Color backgroundColor = new Color(r, g, b);
            tabName += tabIndex;
            tabIndex += 1;
            WorkingPanel workingPanel = new WorkingPanel();
            workingPanel.setBackground(backgroundColor);
            jTabbedPane.add(tabName, workingPanel);
            addIconToTab(workingPanel, "(");
            addIconToTab(workingPanel, ")");
        });
        JMenuItem saveButton = new JMenuItem("Save");
        fileManager = new FileManager(this);
        saveButton.addActionListener(e -> fileManager.saveFile());
        JMenuItem loadButton = new JMenuItem("Load");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileManager.loadFile();
            }
        });
        JMenuItem compileButton = new JMenuItem("Compile");
        compileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visited = new HashSet<>();
                int selectedIndex = jTabbedPane.getSelectedIndex();
                WorkingPanel workingPanel = (WorkingPanel) jTabbedPane.getComponent(selectedIndex);
                compileTab(workingPanel.getConnections(), workingPanel);
            }
        });
        newTabButton.setPreferredSize(new Dimension(150,40));
        loadButton.setPreferredSize(new Dimension(150,40));
        saveButton.setPreferredSize(new Dimension(150,40));
        compileButton.setPreferredSize(new Dimension(150,40));
        menuBar.add(newTabButton);
        menuBar.add(saveButton);
        menuBar.add(loadButton);
        menuBar.add(compileButton);
    }
    /*************************************************************************************
     *  - Method Name: addIconToTab()
     *  - Input Parameters : WorkingPanel tab, JButton button.
     *  - Return Type :none
     *  - Author : Samarth
     *  - Creation Date : 03/13/2021
     *  - Desc: Add icons into the working panel after they are dropped.
     ***************************************************************************************/
    public void addIconToTab(WorkingPanel tab, String selectedIconText){
        icon = iconBase.getIconObject(selectedIconText,tab);
//        if (selectedIconText.equals("(")){
//            tab.isOpenParenthesis = true;
//        }
//        else if (selectedIconText.equals(")")){
//            tab.isCloseParenthesis = true;
//        }
        if (icon != null) {
            if (selectedIconText.equals("(")) {
                icon.setX(60);
                icon.setY(60);
                tab.iconList.put(icon, "");
            } else if (selectedIconText.equals(")")) {
                icon.setX(700);
                icon.setY(500);
                tab.iconList.put(icon, "");
            } else {
                icon.setX((int) tab.getMousePosition().getX() - IconMain.width / 2);
                icon.setY((int) tab.getMousePosition().getY() - IconMain.height / 2);
                tab.iconList.put(icon, "");
            }
        }
    }

    public void compileTab(HashMap<IconMain, Set<IconMain>> connections, WorkingPanel workingPanel){
        // should return whether all shapes are connected or not
        // left to implement
        // allShapesConnected()
//        System.out.println(connections);
        HashMap<IconMain, String> iconList = workingPanel.iconList ;
        if (connections.isEmpty()){
            JOptionPane.showMessageDialog(this, "No connection detected, connect icons to validate them.");
            for (IconMain iconFrom : iconList.keySet()) {
                iconFrom.setColor(Color.RED);
                repaint();
            }
        }
        for (IconMain iconFrom : connections.keySet()) {
            if(iconFrom.iconType.equals("@")){
               boolean looped = isLoopExist(iconFrom,iconFrom,connections);
               visited.clear();
//               System.out.println("looped= "+looped);
               if(looped){
                   iconFrom.setColor(Color.BLACK);
               }
               else{
                   iconFrom.setColor(Color.RED);
               }
            }
        }
        areConnectionsValid(iconList);
        repaint();

    }
    public boolean isLoopExist(IconMain compareTo, IconMain iconFrom, HashMap<IconMain, Set<IconMain>> connections) {
//        System.out.println("looped");
        boolean loopSeen = false;
//        System.out.println("Start=" + iconFrom);
        if(connections.containsKey(iconFrom)){
        Set<IconMain> set = connections.get(iconFrom);

     //   if (){
            for (IconMain iconTo : set) {
//                System.out.println("IconFrom=" + iconFrom);
//                System.out.println("IconTo=" + iconTo);
                if (iconTo==compareTo) {
//                    System.out.println("Came here");
                    return true;
                } else {
                    if (!visited.contains(iconTo)) {
                        visited.add(iconTo);
                        loopSeen = isLoopExist(compareTo, iconTo, connections);
                    }
                }
                if(loopSeen){
                    return true;
                }
            }
        }
        return false;
    }


    public void areConnectionsValid(HashMap<IconMain, String> iconList){
        String errorDialog = "";
        Set<String> errorSet = new HashSet<>();

        // Iterating through all connections and adding error messages as well as changing colors

        try {
            for (IconMain iconFrom : iconList.keySet()) {
//                Set<IconMain> set = iconList.get(iconFrom);
                if (iconFrom.getTotalOutputs() != 0){
                    iconFrom.setColor(Color.RED);
                    String msg = "Icon " + iconFrom.iconType +" "+ "has not completed all outputs" ;
                    errorSet.add(msg);
                }
                if (iconFrom.getTotalInputs() != 0){
                    iconFrom.setColor(Color.RED);
                    String msg = "Icon " +  iconFrom.iconType +" "+ "has not completed all inputs" ;
                    errorSet.add(msg);
                }
//                for(IconMain iconTo: set){
//                    if (iconTo.getTotalInputs() != 0){
//                        iconTo.setColor(Color.RED);
//                        String msg = "Icon " + iconTo.iconType +" "+ "has not completed all inputs" ;
//                        errorSet.add(msg);
//                    }
//                    if (iconTo.getTotalOutputs() != 0){
//                        iconTo.setColor(Color.RED);
//                        String msg = "Icon " + iconTo.iconType +" "+ "has not completed all outputs" ;
//                        errorSet.add(msg);
//                    }
//                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        // Adding the error messages to a String so that we can display all errors in one dialog box
        for(String msg:errorSet){
            errorDialog = errorDialog + msg + ", \n";
        }
        if (!errorDialog.equals("")){
            JOptionPane.showMessageDialog(this, errorDialog);
        }
        else {
            JOptionPane.showMessageDialog(this, "Compiled Successfully!");
        }

    }


    public static void main(String[] args)
    {
        new AppMain(windowTitle);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
