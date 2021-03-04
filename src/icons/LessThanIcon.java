package icons;

import java.awt.*;
import interfaces.Icon;

public class LessThanIcon implements Icon {
    private static final String iconType = "<";
    private int x,y;

    public LessThanIcon(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(x,y,200,40);
        g.drawString(iconType, x+100, y+20);
    }
}
