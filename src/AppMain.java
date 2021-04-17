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
    Set<String> errorSet = new HashSet<>();
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
        loadButton.addActionListener(e -> fileManager.loadFile());
        JMenuItem compileButton = new JMenuItem("Compile");
        compileButton.addActionListener(e -> {
            visited = new HashSet<>();
          //  int selectedIndex = jTabbedPane.getSelectedIndex();
          //  WorkingPanel workingPanel = (WorkingPanel) jTabbedPane.getComponent(selectedIndex);

            boolean compileFlag = true;
            for(int idx = 0; idx <  jTabbedPane.getTabCount(); idx++)
            {
                WorkingPanel workingPanel = (WorkingPanel) jTabbedPane.getComponent(idx);
                boolean isSuccessfullyCompiled = compileTab(workingPanel.getConnections(), workingPanel, idx);
                if(!isSuccessfullyCompiled){
                    compileFlag = false;
                }
            }
            if(compileFlag){
                generateGraphCode();
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

    private void generateGraphCode() {
        StringBuilder finalCode = new StringBuilder("digraph G{\n");
        for(int idx = 0; idx <  jTabbedPane.getTabCount(); idx++) {
            WorkingPanel workingPanel = (WorkingPanel) jTabbedPane.getComponent(idx);
            finalCode.append(generateSubGraphCode(workingPanel.getConnections(),idx));
        }
        finalCode.append("\n}");
        JFrame generatedCodeFrame = new JFrame("Code Generator");
        JTextArea codeDisplay = new JTextArea();
        generatedCodeFrame.add(codeDisplay);
        codeDisplay.append(finalCode.toString());
        generatedCodeFrame.setSize(400,700);
        generatedCodeFrame.setVisible(true);
        System.out.println(finalCode.toString());
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
        if (icon != null) {
            if (selectedIconText.equals("(")) {
                icon.setX(60);
                icon.setY(60);
                IconMain.setCount(IconMain.getCount()+1);
                tab.iconList.put(icon, "");

            } else if (selectedIconText.equals(")")) {
                icon.setX(700);
                icon.setY(500);
                IconMain.setCount(IconMain.getCount()+1);
                tab.iconList.put(icon, "");
            } else {
                icon.setX((int) tab.getMousePosition().getX() - IconMain.width / 2);
                icon.setY((int) tab.getMousePosition().getY() - IconMain.height / 2);
                IconMain.setCount(IconMain.getCount()+1);
                tab.iconList.put(icon, "");

            }
        }
    }
    /*************************************************************************************
     *  - Method Name: compileTab()
     *  - Input Parameters : HashMap<IconMain, Set<IconMain>> connections, WorkingPanel workingPanel
     *  - Return Type : none
     *  - Authors : Srikar, Sulabh
     *  - Creation Date : 03/27/2021
     *  - Desc: Method for compilation of connections, shows error dialog and changes color of incomplete icons
     ***************************************************************************************/
    public boolean compileTab(HashMap<IconMain, Set<IconMain>> connections, WorkingPanel workingPanel, int tabIndex){
        StringBuilder errorDialog = new StringBuilder();
        HashMap<IconMain, String> iconList = workingPanel.iconList ;
        errorSet.clear();
        if (connections.isEmpty()){
            JOptionPane.showMessageDialog(this, "No connection detected, connect icons to validate them.");
            for (IconMain iconFrom : iconList.keySet()) {
                iconFrom.setColor(Color.RED);
                repaint();
            }
        }
        areConnectionsValid(iconList);
        for (IconMain iconFrom : connections.keySet()) {

            if(iconFrom.iconType.equals("@")){
               boolean looped = isLoopExist(iconFrom,iconFrom,connections);
                visited.clear();
               if(looped){
                   iconFrom.setColor(Color.BLACK);
               }
               else{
                   iconFrom.setColor(Color.RED);
                   errorSet.add("Loop is missing for @ icon/icons");
               }
            }
            if(iconFrom.iconType.equals("(")){
                 runLoopCheck(connections, iconFrom);
                System.out.println(iconList.size()+" "+visited.size());
                 for (IconMain icon : iconList.keySet()) {
                     if(!visited.contains(icon)) {
                         icon.setColor(Color.RED);
                         errorSet.add("Detected icon/icons out of main block");
                     }
                 }
                visited.clear();
            }
        }
        // Adding the error messages to a String so that we can display all errors in one dialog box
        for(String msg:errorSet){
            errorDialog.append(msg).append("in Space ").append(tabIndex + 1).append(", \n");
        }

        if (!errorDialog.toString().equals("")){
            JOptionPane.showMessageDialog(this, errorDialog.substring(0,errorDialog.length()-1));
            repaint();
            return false;
        }
        else {
            JOptionPane.showMessageDialog(this, "Space "+(tabIndex+1)+ " Compiled Successfully!");
            generateSubGraphCode(connections, tabIndex);
            repaint();
            return true;
        }
    }

    private String generateSubGraphCode(HashMap<IconMain, Set<IconMain>> connections, int tabIndex) {
        Set<String> visitedConnections = new HashSet<>();
        StringBuilder subGraph = new StringBuilder();
        for (IconMain iconFrom : connections.keySet()) {
            Set<IconMain> set = connections.get(iconFrom);
            for (IconMain iconTo : set) {
                if (iconFrom.iconName.startsWith("open")) {
                    subGraph.append("start ->").append(iconFrom.iconName).append(";\n");
                }
                if (iconTo.iconName.startsWith("close")) {
                    subGraph.append(iconTo.iconName).append(" -> end;\n");
                }
            }
        }
        subGraph.append("subgraph cluster_").append(tabIndex).append(" {");
        for (IconMain iconFrom : connections.keySet()) {
            Set<IconMain> set = connections.get(iconFrom);
            for (IconMain iconTo : set) {
                visitedConnections.add(iconFrom.iconName + "->" + iconTo.iconName+";");
            }
        }
        for(String graphCode: visitedConnections){
            subGraph.append("\n").append(graphCode);
        }
        subGraph.append("\n}\n");
        System.out.println(subGraph.toString());
        return subGraph.toString();
    }

    private void runLoopCheck(HashMap<IconMain, Set<IconMain>> connections, IconMain iconFrom) {
        visited.add(iconFrom);
        if(connections.containsKey(iconFrom)) {
            Set<IconMain> set = connections.get(iconFrom);

            for (IconMain iconTo : set) {
                while (!iconTo.iconType.equals(")")){
                    if(visited.contains(iconTo)){
                        break;
                    }
                    runLoopCheck(connections,iconTo);
                }
                visited.add(iconTo);
            }
        }
    }

    /*************************************************************************************
     *  - Method Name: isLoopExist()
     *  - Input Parameters : IconMain compareTo, IconMain iconFrom, HashMap<IconMain, Set<IconMain>> connections
     *  - Return Type : boolean
     *  - Authors : Srikar, Sulabh
     *  - Creation Date : 03/27/2021
     *  - Desc: iterates through all icons and validates them, shows error dialog and changes color of incomplete icons
     ***************************************************************************************/
    public boolean isLoopExist(IconMain compareTo, IconMain iconFrom, HashMap<IconMain, Set<IconMain>> connections) {
        boolean loopSeen = false;
        if(connections.containsKey(iconFrom)){
        Set<IconMain> set = connections.get(iconFrom);
            for (IconMain iconTo : set) {
                if (iconTo==compareTo) {
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

    /*************************************************************************************
     *  - Method Name: areConnectionsValid()
     *  - Input Parameters : HashMap<IconMain, String> iconList
     *  - Return Type :none
     *  - Authors : Samarth, Keshav
     *  - Creation Date : 03/28/2021
     *  - Desc: Iterating through all connections and adding error messages as well as changes colors of icons
     ***************************************************************************************/
    public void areConnectionsValid(HashMap<IconMain, String> iconList){
        try {
            for (IconMain iconFrom : iconList.keySet()) {

                if(iconFrom.iconType.equals("| -")){
                    if (iconFrom.getTotalOutputs() != 0){
                        iconFrom.setColor(Color.RED);
                        String msg = "Icon " + iconFrom.iconType +" "+ "has not completed all outputs" ;
                        errorSet.add(msg);
                    }
                }
                else if(iconFrom.iconType.equals("- |") ){
                    if (iconFrom.getTotalInputs() != 0){
                        iconFrom.setColor(Color.RED);
                        String msg = "Icon " + iconFrom.iconType +" "+ "has not completed all inputs" ;
                        errorSet.add(msg);
                    }
                }
                else{
                    if (iconFrom.getTotalOutputs() != 0){
                        iconFrom.setColor(Color.RED);
                        String msg = "Icon " + iconFrom.iconType +" "+ "has not completed all outputs" ;
                        errorSet.add(msg);
                    }
                    else if (iconFrom.getTotalInputs() != 0){
                        iconFrom.setColor(Color.RED);
                        String msg = "Icon " +  iconFrom.iconType +" "+ "has not completed all inputs" ;
                        errorSet.add(msg);
                    }
                    else {
                        iconFrom.setColor(Color.BLACK);
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args)
    {
        new AppMain(windowTitle);
    }

    @Override
    public void actionPerformed(ActionEvent e) { }
}
