import javax.swing.*;
import java.awt.*;

/**
 * Author: Sneha,
 * Desc: Define Round button Class to customise round icons in the left panel
 */
public class RoundButton extends JButton {
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
        g.drawOval(50, 0, 170, 95);
    }
}
