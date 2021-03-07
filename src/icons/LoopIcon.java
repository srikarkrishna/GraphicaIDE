package icons;

import java.awt.*;
import interfaces.Icon;

public class LoopIcon extends Icons implements Icon {
    private static final String iconType = "@";
    int width = 160,height=50;
    int x,y;
    public LoopIcon(){
    }

    public void draw(Graphics g, int x, int y) {
        this.x = x;
        this.y = y;
        g.drawRect(x,y,width,height);
        g.drawString(iconType, x+width/2, y+height/2);
        g.drawOval(x + 5, y + 5, 10, 10);
        g.drawOval(x + 5, y + 35, 10, 10);
        g.drawOval(x + width - 15, y + 5, 10, 10);
        g.drawOval(x + width - 15, y + 35, 10, 10);
    }
}
