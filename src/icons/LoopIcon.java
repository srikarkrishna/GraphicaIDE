package icons;

import java.awt.*;

public class LoopIcon extends IconMain {
    int outputPoint_X, outputPoint_Y;
    int inputPoint_X, inputPoint_Y;

    public LoopIcon() {
        iconName = "loopIcn_" + count;
        iconType = "@";
        totalInputs = 2;
        totalOutputs = 2;
    }

    /**
     * Author: Keshav
     * Desc: Describe the Loop icon to draw on the GUI
     */
    public void draw(Graphics g, int x, int y) {

        this.outputPoint_X = x + width;
        this.outputPoint_Y = y + height / 2;
        outputPoint = new Point(outputPoint_X, outputPoint_Y);
        this.inputPoint_X = x;
        this.inputPoint_Y = y + height / 2;
        inputPoint = new Point(inputPoint_X, inputPoint_Y);
        g.setColor(color);
        g.drawOval(x, y, width, height);
        g.drawString(iconType, x + width / 2, y + height / 2);

    }
}
