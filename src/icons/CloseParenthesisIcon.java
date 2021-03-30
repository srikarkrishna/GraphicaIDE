package icons;

import java.awt.*;
import java.util.*;
public class CloseParenthesisIcon extends IconMain {

    int inputPoint_X,inputPoint_Y;
    public CloseParenthesisIcon(){

        iconType = ")";
        totalInputs = 1;
        totalOutputs = 0;
    }
    /*************************************************************************************
     *  - Method Name: draw()
     *  - Input Parameters : Graphic object, int X, int Y
     *  - Return Type :void
     *  - Author : Sneha
     *  - Creation Date : 03/05/2021
     *  - Desc: Describe the Closed Parenthesis icon to draw on the GUI
     ***************************************************************************************/
    @Override
    public void draw(Graphics g, int x, int y) {
        this.inputPoint_X = x ;
        this.inputPoint_Y = y + height/2;
        inputPoint = new Point(inputPoint_X,inputPoint_Y);
        g.drawOval(x, y, width, height);
        g.drawString(iconType, x+width/2, y+height/2);
    }

}
