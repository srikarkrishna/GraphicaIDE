package icons;

import java.awt.*;
import java.util.ArrayList;

public class GreaterThanIcon  extends IconMain {
    private static final String iconType = ">";
    public GreaterThanIcon(){
//        inputPoints = new ArrayList<>();
//        outputPoints = new ArrayList<>();
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
//        inputPoints.clear();
//        outputPoints.clear();
//        outputPoints.add(new Point(x+width-15,y+18));
//        inputPoints.add(new Point(x+5,y+5));
//        inputPoints.add(new Point(x+5,y+35));
        //g.drawRect(x,y,width,height);
        g.drawOval(x,y,width,height);
        g.drawString(iconType, x+width/2, y+height/2);
        //g.drawOval(x + 5, y + 5, 10, 10);
        //g.drawOval(x+ 5, y + 35, 10, 10);
        //g.drawOval(x + width - 15, y + 18, 10, 10);
    }
}
