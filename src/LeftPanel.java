import icons.*;
import interfaces.Icon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class LeftPanel extends JPanel {

    public static JButton[] getIconsArray() {
        return iconsArray;
    }

    private static final JButton[] iconsArray = new JButton[7];
    GridLayout iconLayout = new GridLayout(7,1);

    /*************************************************************************************
     *  - public Constructor
     *  - Author : Samarth
     *  - Creation Date : 03/05/2021
     *  - Desc: Initiating the frame and configuring the properties for the frame
     ***************************************************************************************/
    public LeftPanel() {
        initializeIcons();
        setLayout(iconLayout);
    }
    /*************************************************************************************
     *  - Method Name: initializeIcons()
     *  - Input Parameters : none
     *  - Return Type :Icons
     *  - Author : Samarth
     *  - Creation Date : 03/07/2021
     *  - Desc: Adds icons into the left panel.
     ***************************************************************************************/
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

    public static void disableButtons(String iconText){
        if (iconText.equals("(")){
            iconsArray[0].setEnabled(false);
        }
        else if(iconText.equals(")")){
            iconsArray[1].setEnabled(false);
        }
    }

}
