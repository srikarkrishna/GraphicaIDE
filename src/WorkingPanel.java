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
                   g.drawLine((int)iconFrom.getOutputPoints().get(0).getX(), (int)iconFrom.getOutputPoints().get(0).getY(),
                           (int) iconTo.getInputPoints().get(0).getX(), (int)iconTo.getInputPoints().get(0).getY());
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
    public boolean isInsideRectangle(int rect_x1, int rect_y1, int rect_x2, int rect_y2, int point_x, int point_y) {
        return (point_x > rect_x1 && point_x < rect_x2) && (point_y > rect_y1 && point_y < rect_y2);
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
                int point_x = e.getX();
                int point_y = e.getY();
                for (IconMain icon : iconList.keySet()) {
                    int icon_x1 = icon.getX();
                    int icon_x2 = icon.getX() + IconMain.width;
                    int icon_y1 = icon.getY();
                    int icon_y2 = icon.getY() + IconMain.height;
                    if (isInsideRectangle(icon_x1, icon_y1, icon_x2, icon_y2, point_x, point_y)) {
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
                    int point_x = e.getX();
                    int point_y = e.getY();
                    for (IconMain icon : iconList.keySet()) {
                        String value = iconList.get(icon);
                        int icon_x1 = icon.getX();
                        int icon_x2 = icon.getX() + IconMain.width;
                        int icon_y1 = icon.getY();
                        int icon_y2 = icon.getY() + IconMain.height;
                        if (isInsideRectangle(icon_x1, icon_y1, icon_x2, icon_y2, point_x, point_y)) {
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
            IconMain outputIcon=null;
            @Override
          public void mouseClicked(MouseEvent e) {
              super.mouseClicked(e);
              for (IconMain icon : iconList.keySet()) {
                  ArrayList<Point> outputs = icon.getOutputPoints();
                  int output_x1;
                  int output_y1;

                  if (outputs != null) {
                      for (Point outputPoint : outputs) {
                          output_x1 = (int) outputPoint.getX();
                          output_y1 = (int) outputPoint.getY();
                          if (isInsideRectangle(output_x1 - 10, output_y1 - 10, output_x1 + 10, output_y1 + 10, e.getX(), e.getY())) {
                              outputIcon =icon;
                              isOutputClicked = true;
                              break;
                          }

                      }
                  }
              }
              if (isOutputClicked) {
                  for (IconMain icon : iconList.keySet()) {
                      int input_x1;
                      int input_y1;
                      ArrayList<Point> inputs = icon.getInputPoints();
                      if (inputs != null) {
                          for (Point inputPoint : inputs) {
                              input_x1 = (int) inputPoint.getX();
                              input_y1 = (int) inputPoint.getY();

                              if (isInsideRectangle(input_x1 - 10, input_y1 - 10, input_x1 + 10, input_y1 + 10, e.getX(), e.getY())) {
                                  if(connections.containsKey(outputIcon)){
                                      connections.get(outputIcon).add(icon);
                                  }
                                  else {
                                      Set<IconMain> set = new HashSet<>();
                                      set.add(icon);
                                      connections.put(outputIcon,set);
                                  }
                                  repaint();
                                  break;
                              }
                          }
                      }
                  }
              }
          }

        });
    }
}

