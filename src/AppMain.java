import icons.BarsIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AppMain extends JFrame{
    final static String windowTitle = "GRAPHICAL IDE";
    LeftPanel lPanel;
    RightPanel rPanel;
    MenuBar menuBar;
    BorderLayout borderLayoutLeft;
    interfaces.Icon icon = new BarsIcon();


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
        addPanelActionListeners();
    }
    public static void main(String args[])
    {
        JFrame jframe = new AppMain(windowTitle);
    }

    public void addPanelActionListeners(){

        JButton []iconsArray = LeftPanel.getIconsArray();
      for(int i=0; i< iconsArray.length;i++) {
          JButton button = iconsArray[i];
          button.addMouseListener(new MouseAdapter() {
              @Override
              public void mouseReleased(MouseEvent e) {
                  super.mouseClicked(e);
                  if(RightPanel.jTabbedPane.contains(e.getPoint())){
                      System.out.println("Hello panel");
                  }
                  System.out.println("haa"+e.getX()+" "+e.getY());

                  String selectedIconText = button.getText();
              }
          });
          button.addMouseMotionListener(new MouseAdapter() {
              @Override
              public void mouseDragged(MouseEvent e) {
                  super.mouseDragged(e);
                  //  System.out.println(button.getText()+" Main");
                  if(button.getText().equals("||")) {
                      //     if(isClicked)
                    //  System.out.println(button.getText());

                      icon.draw(getGraphics(), (int) (MouseInfo.getPointerInfo().getLocation().getX()-button.getWidth()/3),
//                                        - button.getLocationOnScreen().getX()),
                              (int) (MouseInfo.getPointerInfo().getLocation().getY()-button.getHeight()/3));
//                                        - button.getLocationOnScreen().getY()));
                      repaint();
                  }
              }
          });
      }
    }
}
