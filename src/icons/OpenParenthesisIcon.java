package icons;

import java.awt.*;
import java.util.ArrayList;

public class OpenParenthesisIcon extends IconMain {
    private static final String iconType = "(";
    int outputPoint_X,outputPoint_Y;
    public OpenParenthesisIcon(){
        outputPoints = new ArrayList<>();
    }
    /*************************************************************************************
     *  - Method Name: draw()
     *  - Input Parameters : Graphic object, int X, int Y
     *  - Return Type :void
     *  - Author : Keshav
     *  - Creation Date : 03/05/2021
     *  - Desc: Describe the Open Parenthesis icon to draw on the GUI
     ***************************************************************************************/
    public void draw(Graphics g, int x, int y) {
        this.outputPoint_X = x + width - 20;
        this.outputPoint_Y = y + 18;
        outputPoints.clear();
        outputPoints.add(new Point(outputPoint_X,outputPoint_Y));
        g.drawRect(x,y,width,height);
        g.drawString(iconType, x+width/2, y+height/2);
        g.drawOval(x + width - 20, y + 18, 10, 10);
    }
}
