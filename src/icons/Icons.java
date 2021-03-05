package icons;

import interfaces.Icon;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Icons implements Icon {
    //JLabel iconTypeLabel;
    String iconType;
    int width = 160, height = 50;
    int X, Y;


    public Icons(){
        // containerComponent = new Rectangle2D.Double(X, Y, this.width, this.height);
     // iconTypeLabel = new JLabel();
     // iconTypeLabel.setText(iconType);
     // iconTypeLabel.setBounds(X+width/2, Y+height/2,this.width, this.height);
//        this.X = X;
//        this.Y = Y;
//        this.iconType = iconType;
    }


    public abstract void draw(Graphics g, int x, int y);
}
