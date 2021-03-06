package icons;

import interfaces.Icon;

import java.awt.*;

/**
 * Author: Sneha,
 * Desc: Describe the abstract Icons class to build each icon class and to track the icons connected in the workspace.
 */
public abstract class IconMain implements Icon, java.io.Serializable {
    public static int width = 160, height = 70;
    public String iconType;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        IconMain.count = count;
    }

    public static int count = 0;
    int X, Y;

    public String getIconName() {
        return iconName;
    }

    public String iconName;

    protected int totalInputs;
    protected int totalOutputs;
    protected Point outputPoint;
    protected Point inputPoint;

    public void setColor(Color color) {
        this.color = color;
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


    public IconMain() {
    }

    /**
     * Author: Sneha,
     * Desc: Abstract method to build individual icons on the GUI
     */
    public abstract void draw(Graphics g, int x, int y);
}
