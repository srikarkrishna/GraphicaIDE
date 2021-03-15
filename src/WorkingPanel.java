import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;
import icons.Icons;

public class WorkingPanel extends JPanel {

    ArrayList<Icons> iconList = new ArrayList<>();
    public WorkingPanel() {
        addIconActionListeners();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i=0; i < iconList.size(); i ++ ){
            Icons icon = iconList.get(i);
            System.out.println(icon.getX()+""+icon.getY());
            icon.draw(g, icon.getX()-380, icon.getY()-160);
//            icon.draw(g, icon.getX(), icon.getY());

        }
   }

    public void addIconActionListeners(){


    }

}
