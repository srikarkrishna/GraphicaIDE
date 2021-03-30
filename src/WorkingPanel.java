import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.Timer;
import icons.IconMain;

public class WorkingPanel extends JPanel {

    public boolean isCloseParenthesis, isOpenParenthesis;
    HashMap<IconMain, String> iconList = new HashMap<>();
    HashMap<IconMain, Set<IconMain>> connections = new HashMap<>();
    public WorkingPanel() {

        addIconActionListeners();
    }
    /*************************************************************************************
     *  - Method Name: paintComponent()
     *  - Input Parameters : Graphics
     *  - Return Type :none
     *  - Authors : Samarth
     *  - Creation Date : 03/12/2021
     *  - Desc: Paint the working panel on the right
     ***************************************************************************************/
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (IconMain icon : iconList.keySet()) {
            icon.draw(g, icon.getX(), icon.getY());
        }
        for (IconMain iconFrom : connections.keySet()) {
                Set<IconMain> set = connections.get(iconFrom);
                for(IconMain iconTo: set){
                   g.drawLine((int)iconFrom.getOutputPoint().getX(), (int)iconFrom.getOutputPoint().getY(),
                           (int)iconTo.getInputPoint().getX(), (int)iconTo.getInputPoint().getY());
                   g.drawRect((int)iconTo.getInputPoint().getX(), (int)iconTo.getInputPoint().getY(),10,10);
                }
        }

    }
    /*************************************************************************************
     *  - Method Name: isInsideRectangle()
     *  - Input Parameters : rect_x1,rect_y1,rect_x1,rect_x1, point_x, point_y
     *  - Return Type :boolean
     *  - Authors : Samarth
     *  - Creation Date : 03/14/2021
     *  - Desc: Check if a given point is inside the rectangle.
     ***************************************************************************************/
    public boolean isInsideRectangle(int h, int k, int point_x, int point_y) {
        h += 80;
        k += 25;
        int a = 80;
        int b = 25;
        double p = Math.pow(point_x - h, 2) / Math.pow(a, 2) + (Math.pow((point_y - k), 2) / Math.pow(b, 2));
        return p <= 1;
    }


    /*************************************************************************************
     *  - Method Name: addIconActionListeners()
     *  - Input Parameters : none
     *  - Return Type :boolean
     *  - Authors : Srikar, Sulabh
     *  - Creation Date : 03/14/2021
     *  - Desc: Check if a given point is inside the rectangle.
     ***************************************************************************************/
    public void addIconActionListeners() {

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                for (IconMain icon : iconList.keySet()) {
                    if (isInsideRectangle(icon.getX(), icon.getY(), e.getX(),e.getY())) {
                        icon.setX(e.getX() - IconMain.width / 2);
                        icon.setY(e.getY() - IconMain.height / 2);
                    }
                }
                repaint();
            }
        });

        this.addMouseListener(new MouseAdapter() {
            boolean isAlreadyOneClick;
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (isAlreadyOneClick) {
                    for (IconMain icon : iconList.keySet()) {
                        String value = iconList.get(icon);
                        if (isInsideRectangle(icon.getX(), icon.getY(), e.getX(),e.getY())) {
                            String name = JOptionPane.showInputDialog("Enter Value", value);
                            iconList.put(icon, name);
                        }
                    }
                    isAlreadyOneClick = false;
                } else {
                    isAlreadyOneClick = true;
                    Timer t = new Timer("doubleClickTimer", false);
                    t.schedule(new TimerTask() {

                        @Override
                        public void run() {
                            isAlreadyOneClick = false;
                        }
                    }, 500);
                }

                repaint();
            }
        });

        this.addMouseListener(new MouseAdapter() {
          boolean isOutputClicked = false;
          boolean isInputClicked = false;
            IconMain outputIcon=null;
            IconMain inputIcon=null;
            @Override
          public void mouseClicked(MouseEvent e) {
              super.mouseClicked(e);
              if(!isOutputClicked){
              for (IconMain oIcon : iconList.keySet()) {
                //  Point outputPoint = icon.getOutputPoint();
                  if (isInsideRectangle(oIcon.getX(), oIcon.getY(), e.getX(),e.getY())) {
                      outputIcon =oIcon;
                      isOutputClicked = true;
                  }
                  System.out.println(inputIcon+" "+outputIcon);
                  }
              }
              else{
                  isInputClicked = true;
              }
              if (isOutputClicked && isInputClicked) {
                  for (IconMain iIcon : iconList.keySet()) {
                      if (isInsideRectangle(iIcon.getX(), iIcon.getY(), e.getX(),e.getY())) {
                          inputIcon = iIcon;
                          System.out.println(inputIcon+" "+outputIcon);
                          if(inputIcon!=outputIcon) {
                              isConnectionValid(outputIcon, inputIcon);
                          }
                      }
                      isInputClicked = false;
                      isOutputClicked = false;

                  }
              }
          }

        });
    }

    private void isConnectionValid(IconMain outputIcon, IconMain inputIcon) {
        System.out.println("HELOOOOOO");
        if(outputIcon.getTotalOutputs()>0 && inputIcon.getTotalInputs()>0){
            if(connections.containsKey(outputIcon)) {
                connections.get(outputIcon).add(inputIcon);
            }
            else {
                Set<IconMain> set = new HashSet<>();
                set.add(inputIcon);
                connections.put(outputIcon,set);
            }
            if (!outputIcon.iconType.equals("- |")){
                outputIcon.setTotalOutputs(outputIcon.getTotalOutputs()-1);
            }
            if (!inputIcon.iconType.equals("| -")){
                inputIcon.setTotalInputs(inputIcon.getTotalInputs()-1);
            }
            repaint();
            System.out.println(connections.size());

        }
        else{
            JOptionPane.showMessageDialog(this, "This connection is not valid");
        }
    }
}

