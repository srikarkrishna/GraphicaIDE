package icons;

import java.awt.*;
import java.util.ArrayList;

public class LessThanIcon extends IconMain {
    int outputPoint_X,outputPoint_Y;
    int inputPoint_X,inputPoint_Y;
    public LessThanIcon(){
        iconType = "<";
        totalInputs = 1;
        totalOutputs = 2;
    }
    /*************************************************************************************
     *  - Method Name: draw()
     *  - Input Parameters : Graphic object, int X, int Y
     *  - Return Type :void
     *  - Author : Keshav
     *  - Creation Date : 03/05/2021
     *  - Desc: Describe the Less than icon to draw on the GUI
     ***************************************************************************************/
    public void draw(Graphics g, int x, int y) {
        this.outputPoint_X = x + width;
        this.outputPoint_Y = y + height/2;
        outputPoint = new Point(outputPoint_X,outputPoint_Y);

        this.inputPoint_X = x ;
        this.inputPoint_Y = y + height/2;
        inputPoint = new Point(inputPoint_X,inputPoint_Y);
        g.drawOval(x,y,width,height);
        g.drawString(iconType, x+width/2, y+height/2);
        //g.drawOval(x + 10, y + 18, 10, 10);
        //g.drawOval(x + width - 15, y + 5, 10, 10);
        //g.drawOval(x + width - 15, y + 35, 10, 10);
    }
}
