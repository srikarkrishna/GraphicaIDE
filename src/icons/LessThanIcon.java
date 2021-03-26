package icons;

import java.awt.*;
import java.util.ArrayList;

public class LessThanIcon extends IconMain {
    private static final String iconType = "<";
    public LessThanIcon(){
        inputPoints = new ArrayList<>();
        outputPoints = new ArrayList<>();
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
        inputPoints.clear();
        outputPoints.clear();
        inputPoints.add(new Point(x+10,y+18));
        outputPoints.add(new Point(x+width-15,y+5));
        outputPoints.add(new Point(x+width-15,y+35));
        //g.drawRect(x,y,width,height);
        g.drawOval(x,y,width,height);
        g.drawString(iconType, x+width/2, y+height/2);
        //g.drawOval(x + 10, y + 18, 10, 10);
        //g.drawOval(x + width - 15, y + 5, 10, 10);
        //g.drawOval(x + width - 15, y + 35, 10, 10);
    }
}
