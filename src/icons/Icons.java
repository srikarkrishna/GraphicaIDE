package icons;

import interfaces.Icon;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Icons implements Icon {
    Rectangle2D containerComponent;
    Graphics2D graphics2D;
    //JLabel iconTypeLabel;
    String iconType;
    int width = 160, height = 50;
    int X, Y;

    public Icons(int X, int Y, String iconType){
        containerComponent = new Rectangle2D.Double(X, Y, this.width, this.height);
     // iconTypeLabel = new JLabel();
     // iconTypeLabel.setText(iconType);
     // iconTypeLabel.setBounds(X+width/2, Y+height/2,this.width, this.height);
        this.X = X;
        this.Y = Y;
        this.iconType = iconType;
    }


    public void draw(Graphics g){
        graphics2D = (Graphics2D) g;
        graphics2D.draw(containerComponent);
        //containerComponent.add();
        graphics2D.drawString(iconType, X+width/2, Y+height/2);
    }
}
