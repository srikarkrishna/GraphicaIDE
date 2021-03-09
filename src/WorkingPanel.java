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
   }

    public void addIconActionListeners(){


    }

}
