import javax.swing.*;
import java.awt.*;


public class LeftPanel extends JPanel {

    public static JButton[] getIconsArray() {
        return iconsArray;
    }

    private static final JButton[] iconsArray = new JButton[6];
    GridLayout iconLayout = new GridLayout(6,1);

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

//        JButton openBracket = new RoundButton("(");
//        iconsArray[0] = openBracket;
//
//        JButton closeBracket = new RoundButton(")");
//        iconsArray[1] = closeBracket;

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
    /*************************************************************************************
     *  - Method Name: disableButtons()
     *  - Input Parameters : String iconText
     *  - Return Type :none
     *  - Authors : Samarth
     *  - Creation Date : 03/13/2021
     *  - Desc: disable open and close parenthesis icons in the left panel when they are used once.
     ***************************************************************************************/
    public static void disableButtons(String iconText){
        if (iconText.equals("(")){
            iconsArray[0].setEnabled(false);
        }
        else if(iconText.equals(")")){
            iconsArray[1].setEnabled(false);
        }
    }

}
