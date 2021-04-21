package icons;

import java.awt.*;

public class InputBarsIcon extends IconMain {
    int inputPoint_X, inputPoint_Y;
    int outputPoint_X, outputPoint_Y;

    public InputBarsIcon() {
        iconName = "inputBar_" + count;
        iconType = "| -";
        totalOutputs = 1;
        totalInputs = Integer.MAX_VALUE;
    }

    /**
     * Author: Keshav
     * Desc: Describe the input bars icon(|-) with multiple input and single output to draw on the GUI
     */
    @Override
    public void draw(Graphics g, int x, int y) {
        this.inputPoint_X = x;
        this.inputPoint_Y = y + height / 2;
        inputPoint = new Point(inputPoint_X, inputPoint_Y);
        this.outputPoint_X = x + width;
        this.outputPoint_Y = y + height / 2;
        outputPoint = new Point(outputPoint_X, outputPoint_Y);
        g.setColor(color);
        g.drawOval(x, y, width, height);
        g.drawString(iconType, x + width / 2, y + height / 2);
    }
}
