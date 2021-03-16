package icons;

import interfaces.Icon;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/*************************************************************************************
 *  - public Class
 *  - Author : Sneha
 *  - Creation Date : 03/05/2021
 *  - Desc: Describe the abstract Icons class to build each icon class and to track the icons connected in the workspace.
 ***************************************************************************************/
public abstract class Icons implements Icon, java.io.Serializable {
    public static int width = 160, height=50;
    String iconType;
    int X, Y;

    protected ArrayList<Integer> inputPoints;
    protected ArrayList<Integer> outputPoints;
//    int inputPoint_X;
//    int inputPoint_Y;

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public ArrayList<Integer> getInputPoints() {
        return inputPoints;
    }

    public ArrayList<Integer> getOutputPoints() {
        return outputPoints;
    }

    public void setX(int x) {
        this.X = x;
    }

    public void setY(int y) {
        this.Y = y;
    }


    public Icons(){

    }
    /*************************************************************************************
     *  - Method Name: draw()
     *  - Input Parameters : Graphic object, int X, int Y
     *  - Return Type :void
     *  - Author : Sneha
     *  - Creation Date : 03/05/2021
     *  - Description : abstract method to build individual icons on the GUI
     ***************************************************************************************/
   public abstract void draw(Graphics g, int x, int y);
}
