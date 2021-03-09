package icons;

import java.awt.*;
import interfaces.Icon;

public class HyphenIcon extends Icons implements Icon {
    private static final String iconType = "-";
    int width = 160,height=50;
    int x,y;
    public HyphenIcon(){

    }

    public void draw(Graphics g, int x, int y) {
        this.x = x;
        this.y = y;
        g.drawRect(x,y,width,height);
        g.drawString(iconType, x+width/2, y+height/2);
        g.drawOval(x + 10, y + 18, 10, 10);
        g.drawOval(x + width - 15, y + 18, 10, 10);
    }
}
