package icons;

import java.awt.*;

public class LessThanIcon extends IconMain {
    private static final String iconType = "<";
    int x,y;
    public LessThanIcon(){
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
        this.x = x;
        this.y = y;
        g.drawRect(x,y,width,height);
        g.drawString(iconType, x+width/2, y+height/2);
        g.drawOval(x + 10, y + 18, 10, 10);
        g.drawOval(x + width - 15, y + 5, 10, 10);
        g.drawOval(x + width - 15, y + 35, 10, 10);
    }
}
