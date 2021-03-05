package icons;

import java.awt.*;
import interfaces.Icon;

public class CloseParenthesisIcon extends Icons implements Icon {

    private static final String iconType = ")";
    int width = 160,height=50;

    public CloseParenthesisIcon(){

//        super(x,y,iconType);
//        super.draw(g);
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        //this.width = width;
        //this.height =height;
        g.drawRect(x,y,width,height);
        g.drawString(iconType, x+100, y+20);
    }
}
