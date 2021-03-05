import icons.*;
import interfaces.Icon;

import javax.swing.*;
import java.awt.*;


public class LeftPanel extends JPanel {

    Icons openParenthesisIcon;
    Icons closeParenthesisIcon;
    Icons greaterThanIcon;
    Icons lessThanIcon;
    Icons loopIcon;
    Icons barsIcon;
    Icons hyphenIcon;

    public LeftPanel() {
        setSize(100, 100);
        setLayout(null);
        repaint();
    }

    public void paintComponent(Graphics g) {
        int startX = 20, startY = 70, bufferSpace = 70;
        super.paintComponent(g);
        openParenthesisIcon = new OpenParenthesisIcon(g, startX, startY);
//        openParenthesisIcon.draw(g);
        closeParenthesisIcon = new CloseParenthesisIcon(g, startX, startY+bufferSpace);
//        closeParenthesisIcon.draw(g);
        greaterThanIcon = new GreaterThanIcon(g, startX, startY+(2*bufferSpace));
//        greaterThanIcon.draw(g);
        lessThanIcon = new LessThanIcon(g, startX, startY+(3*bufferSpace));
//        lessThanIcon.draw(g);
        loopIcon = new LoopIcon(g, startX, startY+(4*bufferSpace));
//        loopIcon.draw(g);
        barsIcon = new BarsIcon(g, startX, startY+(5*bufferSpace));
//        barsIcon.draw(g);
        hyphenIcon = new HyphenIcon(g, startX, startY+(6*bufferSpace));
//        hyphenIcon.draw(g);
    }
}
