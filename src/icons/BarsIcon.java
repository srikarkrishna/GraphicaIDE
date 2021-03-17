package icons;
import java.awt.*;
public class BarsIcon extends IconMain {
    private static final String iconType = "||";
    int x,y;
    public BarsIcon(){

    }
    /*************************************************************************************
     *  - Method Name: draw()
     *  - Input Parameters : Graphic object, int X, int Y
     *  - Return Type :void
     *  - Author : Sneha
     *  - Creation Date : 03/05/2021
     *  - Desc: Describe the bars icon to draw on the GUI
     ***************************************************************************************/
    @Override
    public void draw(Graphics g, int x, int y) {
        this.x = x;
        this.y = y;
        g.drawRect(x,y,width,height);
        g.drawString(iconType, x+width/2, y+height/2);
        g.fillRect(x + 10, y + 10, 10, height - 20);
        g.fillRect(x + width - 20, y + 10, 10, height - 20);
    }
}
