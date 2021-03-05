package icons;

import java.awt.*;
import interfaces.Icon;

public class LoopIcon extends Icons implements Icon {
    private static final String iconType = "@";
    int width = 160,height=50;
    public LoopIcon(Graphics g, int x, int y){

//        super(x,y,iconType);
//        super.draw(g);
    }

    public void draw(Graphics g, int x, int y) {
        //this.width = width;
        //this.height =height;
        g.drawRect(x,y,width,height);
        g.drawString(iconType, x+100, y+20);
    }
}
