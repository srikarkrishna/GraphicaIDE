package icons;

import interfaces.Icon;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
/*************************************************************************************
 *  - public Class
 *  - Author : Sneha
 *  - Creation Date : 03/05/2021
 *  - Desc: Describe the abstract Icons class to build each icon class and to track the icons connected in the workspace.
 ***************************************************************************************/
public abstract class Icons implements Icon {
    String iconType;
    int X, Y;


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
