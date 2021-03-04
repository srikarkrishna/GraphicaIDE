import icons.*;
import interfaces.Icon;

import javax.swing.*;
import java.awt.*;

public class Test extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        interfaces.Icon openParenthesisIcon = new OpenParenthesisIcon(190,120);
        openParenthesisIcon.draw(g);
        interfaces.Icon closeParenthesisIcon = new CloseParenthesisIcon(190, 350);
        closeParenthesisIcon.draw(g);
        interfaces.Icon greaterThanIcon = new GreaterThanIcon(190, 520);
        greaterThanIcon.draw(g);
        interfaces.Icon lessThanIcon = new LessThanIcon(400, 120);
        lessThanIcon.draw(g);
        interfaces.Icon loopIcon = new LoopIcon(400, 350);
        loopIcon.draw(g);
        interfaces.Icon barsIcon = new BarsIcon(400, 520);
        barsIcon.draw(g);
        Icon hyphenIcon = new HyphenIcon(610, 120);
        hyphenIcon.draw(g);
    }

    public static void main(String[] args){
        JFrame jframe = new JFrame();
        Test t1 = new Test();
        jframe.setVisible(true);
        jframe.setSize(1000,1000);
        jframe.add(t1);
    }
}
