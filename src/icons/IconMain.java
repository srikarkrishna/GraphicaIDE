package icons;

import interfaces.Icon;
import java.awt.*;

/*************************************************************************************
 *  - public Class
 *  - Author : Sneha
 *  - Creation Date : 03/05/2021
 *  - Desc: Describe the abstract Icons class to build each icon class and to track the icons connected in the workspace.
 ***************************************************************************************/
public abstract class IconMain implements Icon, java.io.Serializable {
    public static int width = 160, height=70;
    public String iconType;
    int X, Y;


    protected int totalInputs;
    protected int totalOutputs;
    protected Point outputPoint;
    protected Point inputPoint;

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    protected Color color = Color.black;


    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int getTotalInputs() {
        return totalInputs;
    }

    public int getTotalOutputs() {
        return totalOutputs;
    }

    public Point getOutputPoint() {
        return outputPoint;
    }

    public Point getInputPoint() {
        return inputPoint;
    }

    public void setTotalInputs(int totalInputs) {
        this.totalInputs = totalInputs;
    }

    public void setTotalOutputs(int totalOutputs) {
        this.totalOutputs = totalOutputs;
    }

    public void setX(int x) {
        this.X = x;
    }

    public void setY(int y) {
        this.Y = y;
    }


    public IconMain(){
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
