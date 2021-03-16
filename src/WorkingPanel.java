import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.Timer;

import icons.Icons;

public class WorkingPanel extends JPanel {

    HashMap<Icons,String> iconList = new HashMap<>();
    public WorkingPanel() {
        addIconActionListeners();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Icons icon : iconList.keySet()){
//            System.out.println(icon.getX()+""+icon.getY());
//            icon.draw(g, icon.getX()-380, icon.getY()-160);

//            icon.draw(g, icon.getX() - Icons.width/2  , icon.getY() - Icons.height/2);
            icon.draw(g, icon.getX(), icon.getY());
//            g.drawRect(1,1,50,50);

        }
   }

   public boolean checkPoint(int rect_x1, int rect_y1, int rect_x2, int rect_y2, int point_x, int point_y){
       return (point_x > rect_x1 && point_x < rect_x2) && (point_y > rect_y1 && point_y < rect_y2);
   }

    public void addIconActionListeners(){

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                int point_x = e.getX();
                int point_y = e.getY();

                for(Icons icon:iconList.keySet()){

                   // Icons icon = iconList.get(i);
                    int icon_x1 = icon.getX() - Icons.width/2;
//                    int icon_x1 = icon.getX();
                    int icon_x2 = icon.getX() + Icons.width/2;
                    int icon_y1 = icon.getY() - Icons.height/2;
//                    int icon_y1 = icon.getY();
                    int icon_y2 = icon.getY() + Icons.height/2;

                    if (checkPoint(icon_x1,icon_y1,icon_x2,icon_y2,point_x,point_y)){
                        System.out.println(icon);
                        icon.setX(e.getX() - Icons.width/2);
                        icon.setY(e.getY() - Icons.height/2);
                    }
                }
                repaint();
            }
        });


        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);

                int point_x = e.getX();
                int point_y = e.getY();

                for(Icons icon:iconList.keySet()){

                    // Icons icon = iconList.get(i);
//                    int icon_x1 = icon.getX() - Icons.width/2;
                    int icon_x1 = icon.getX();
                    int icon_x2 = icon.getX() + Icons.width;
//                    int icon_y1 = icon.getY() - Icons.height/2;
                    int icon_y1 = icon.getY();
                    int icon_y2 = icon.getY() + Icons.height;

                    if (checkPoint(icon_x1,icon_y1,icon_x2,icon_y2,point_x,point_y)){
                        System.out.println(icon);
                        icon.setX(e.getX() - Icons.width/2);
                        icon.setY(e.getY() - Icons.height/2);
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
                    System.out.println("Double hey");
                    int point_x = e.getX();
                    int point_y = e.getY();
                    for(Icons icon:iconList.keySet()){
                        String value = iconList.get(icon);
                        int icon_x1 = icon.getX();
                        int icon_x2 = icon.getX() + Icons.width;
                        int icon_y1 = icon.getY();
                        int icon_y2 = icon.getY() + Icons.height;
                        if (checkPoint(icon_x1,icon_y1,icon_x2,icon_y2,point_x,point_y)){
                            String name=JOptionPane.showInputDialog("Enter Value",value);
                            iconList.put(icon,name);
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


    }

}
