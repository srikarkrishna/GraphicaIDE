import icons.*;
import interfaces.Icon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class LeftPanel extends JPanel {
//    Icons openParenthesisIcon;
//    Icons closeParenthesisIcon;
//    Icons greaterThanIcon;
//    Icons lessThanIcon;
//    Icons loopIcon;
//    Icons barsIcon;
//    Icons hyphenIcon;
    interfaces.Icon icon = new BarsIcon();
    public static JButton[] getIconsArray() {
        return iconsArray;
    }

    private static final JButton[] iconsArray = new JButton[7];
    GridLayout iconLayout = new GridLayout(7,1);


    public LeftPanel() {


        initializeIcons();
        addIconActionListeners();
        setLayout(iconLayout);
    }

    public void initializeIcons(){

        JButton openBracket = new JButton("(");
        iconsArray[0] = openBracket;

        JButton closeBracket = new JButton(")");
        iconsArray[1] = closeBracket;

        JButton lessThan = new JButton("<");
        iconsArray[2] = lessThan;

        JButton greaterThan = new JButton(">");
        iconsArray[3] = greaterThan;

        JButton atTheRate = new JButton("@");
        iconsArray[4] = atTheRate;

        JButton hyphen = new JButton("-");
        iconsArray[5] = hyphen;

        JButton bars = new JButton("||");
        iconsArray[6] = bars;


        for (JButton jButton : iconsArray) {
            this.add(jButton.getText(), jButton);
        }

    }

    public void addIconActionListeners(){

        for (JButton button : iconsArray) {

            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    String selectedIconText = button.getText();
                }
            });


            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    if (button.getText().equals("||")) {
                            icon.draw(getGraphics(), (int) (MouseInfo.getPointerInfo().getLocation().getX() - 80),
                                    (int) (MouseInfo.getPointerInfo().getLocation().getY() - 130));
                           // repaint();
                    }
                }
            });
        }
    }

}
