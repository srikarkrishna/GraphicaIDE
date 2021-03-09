package icons;

import java.awt.*;
import interfaces.Icon;

public class OpenParenthesisIcon extends Icons implements Icon {
    private static final String iconType = "(";
    int width = 160,height=50;
    int x,y;
    public OpenParenthesisIcon(){
    }

    public void draw(Graphics g, int x, int y) {
        this.x = x;
        this.y = y;
        g.drawRect(x,y,width,height);
        g.drawString(iconType, x+width/2, y+height/2);
        g.drawOval(x + y - 20, y + 18, 10, 10);
    }
}
