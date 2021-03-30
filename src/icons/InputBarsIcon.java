package icons;
import java.awt.*;

public class InputBarsIcon extends IconMain {
    int inputPoint_X,inputPoint_Y;
    int outputPoint_X,outputPoint_Y;
    public InputBarsIcon(){
        iconType = "| -";
        totalOutputs = 1;
        totalInputs = Integer.MAX_VALUE;
    }
    /*************************************************************************************
     *  - Method Name: draw()
     *  - Input Parameters : Graphic object, int X, int Y
     *  - Return Type :void
     *  - Author : Sneha
     *  - Creation Date : 03/05/2021
     *  - Desc: Describe the bars icon with multiple input to draw on the GUI
     ***************************************************************************************/
    @Override
    public void draw(Graphics g, int x, int y) {
        this.inputPoint_X = x ;
        this.inputPoint_Y = y + height/2;
        inputPoint = new Point(inputPoint_X,inputPoint_Y);

        this.outputPoint_X = x + width;
        this.outputPoint_Y = y + height/2;
        outputPoint = new Point(outputPoint_X,outputPoint_Y);
        g.setColor(color);
        g.drawOval(x,y,width,height);
        g.drawString(iconType, x+width/2, y+height/2);
    }
}
