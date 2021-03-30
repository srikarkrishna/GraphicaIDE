package icons;

import java.awt.*;

public class GreaterThanIcon  extends IconMain {
    int outputPoint_X,outputPoint_Y;
    int inputPoint_X,inputPoint_Y;
    public GreaterThanIcon(){
        iconType = ">";
        totalInputs = 2;
        totalOutputs = 1;
    }
    /*************************************************************************************
     *  - Method Name: draw()
     *  - Input Parameters : Graphic object, int X, int Y
     *  - Return Type :void
     *  - Author : Sneha
     *  - Creation Date : 03/05/2021
     *  - Desc: Describe the Greater than icon to draw on the GUI
     ***************************************************************************************/
    public void draw(Graphics g, int x, int y) {
        this.outputPoint_X = x + width;
        this.outputPoint_Y = y + height/2;
        outputPoint = new Point(outputPoint_X,outputPoint_Y);

        this.inputPoint_X = x ;
        this.inputPoint_Y = y + height/2;
        inputPoint = new Point(inputPoint_X,inputPoint_Y);
        g.setColor(color);
        g.drawOval(x,y,width,height);
        g.drawString(iconType, x+width/2, y+height/2);
        //g.drawOval(x + 5, y + 5, 10, 10);
        //g.drawOval(x+ 5, y + 35, 10, 10);
        //g.drawOval(x + width - 15, y + 18, 10, 10);
    }
}
