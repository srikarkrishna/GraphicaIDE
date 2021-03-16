package icons;

import java.awt.*;
import java.util.*;

import interfaces.Icon;

public class CloseParenthesisIcon extends Icons {

    private static final String iconType = ")";
//    int width = 160,height=50;
    int x,y;
    int inputPoint_X,inputPoint_Y;

    public CloseParenthesisIcon(){

        inputPoints = new ArrayList<>();
        outputPoints = new ArrayList<>();

        this.inputPoint_X = super.X + 10;
        this.inputPoint_Y = super.Y + 18;

        inputPoints.add(inputPoint_X);
        inputPoints.add(inputPoint_Y);

    }
    /*************************************************************************************
     *  - Method Name: draw()
     *  - Input Parameters : Graphic object, int X, int Y
     *  - Return Type :void
     *  - Author : Sneha
     *  - Creation Date : 03/05/2021
     *  - Desc: Describe the Closed Parenthesis icon to draw on the GUI
     ***************************************************************************************/
    @Override
    public void draw(Graphics g, int x, int y) {
        this.x = x;
        this.y = y;
        g.drawRect(x,y,width,height);
        g.drawString(iconType, x+width/2, y+height/2);
        g.drawOval(x + 10, y + 20, 10, 10);

//        this.inputPoint_X = super.X + 10;
//        this.inputPoint_Y = super.Y + 18;
//        System.out.println("Current value for X" + this.x);
    }

//    @Override
//    public void setInputPoint_X() { }

}
