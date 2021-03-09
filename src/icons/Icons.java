package icons;

import interfaces.Icon;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Icons implements Icon {
    String iconType;
    int width = 160, height = 50;
    int X, Y;


    public Icons(){

    }

   public abstract void draw(Graphics g, int x, int y);
}
