import javax.swing.*;
import java.awt.*;

/*************************************************************************************
 *  - public Class
 *  - Author : Sneha
 *  - Creation Date : 03/26/2021
 *  - Desc: Class to display round icons
 ***************************************************************************************/
public class RoundButton  extends JButton {
    public RoundButton(String label) {
        super(label);
        setPreferredSize(new Dimension(30, 10));
        setContentAreaFilled(false);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(50, 0, 160,     70);
    }
}
