import javax.swing.*;
import java.awt.*;


public class LeftPanel extends JPanel {

    public static JButton[] getIconsArray() {
        return iconsArray;
    }

    private static final JButton[] iconsArray = new JButton[6];
    GridLayout iconLayout = new GridLayout(6, 1);

    /**
     * Author: Samarth
     * Desc: Initiating the frame and configuring the properties for the frame
     */
    public LeftPanel() {
        initializeIcons();
        setLayout(iconLayout);
    }

    /**
     * Author: Samarth
     * Desc: Adds icons into the left panel.
     */
    public void initializeIcons() {

        JButton lessThan = new RoundButton("<");
        iconsArray[0] = lessThan;

        JButton greaterThan = new RoundButton(">");
        iconsArray[1] = greaterThan;

        JButton atTheRate = new RoundButton("@");
        iconsArray[2] = atTheRate;

        JButton hyphen = new RoundButton("-");
        iconsArray[3] = hyphen;

        JButton bars = new RoundButton("|-");
        iconsArray[4] = bars;

        JButton multipleOutputBars = new RoundButton("-|");
        iconsArray[5] = multipleOutputBars;

        for (JButton jButton : iconsArray) {
            this.add(jButton.getText(), jButton);
        }
    }

    /**
     * Author: Samarth
     * Desc: Disable open and close parenthesis icons in the left panel when they are used once.
     */
    public static void disableButtons(String iconText) {
        if (iconText.equals("(")) {
            iconsArray[0].setEnabled(false);
        } else if (iconText.equals(")")) {
            iconsArray[1].setEnabled(false);
        }
    }

}
