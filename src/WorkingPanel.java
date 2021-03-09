import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;
import icons.Icons;

public class WorkingPanel extends JPanel {
    //public TabPanel tabPanel;
//    ArrayList<Icons> iconList = new ArrayList<>();
    public WorkingPanel() {
        System.out.print("Hello Panle");
//       // addTab("Space 1",tabPanel);
//        System.out.println(tabPanel.contains(500,500)+" "+tabPanel.getBounds());
//        tabPanel.setBackground(Color.ORANGE);
//        setVisible(true);
//
    }
//    public void addNewTab() {
//        tabPanel=new TabPanel();
//    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
   }
//
//    public void addIcon(double X,double Y,Icons icon) {
//        icon.draw(getGraphics(),(int)X,(int)Y);
//        repaint();
//    }
}
