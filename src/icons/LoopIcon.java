package icons;

import java.awt.*;
import interfaces.Icon;

public class LoopIcon extends Icons {
    private static final String iconType = "@";

    public LoopIcon(Graphics g, int x, int y){

        super(x,y,iconType);
        super.draw(g);
    }

//    @Override
//    public void draw(Graphics g) {
//        g.drawRect(x,y,160,50);
//        g.drawString(iconType, x+100, y+20);
//    }
}
