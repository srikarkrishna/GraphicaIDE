package icons;

import java.awt.*;

public class OpenParenthesisIcon extends IconMain {
    int outputPoint_X, outputPoint_Y;

    public OpenParenthesisIcon() {
        iconName = "openPrn_" + count;
        iconType = "(";
        totalInputs = 0;
        totalOutputs = 1;
    }

    /**
     * Author: Keshav
     * Desc: Describe the Open Parenthesis icon to draw on the GUI
     */
    public void draw(Graphics g, int x, int y) {
        this.outputPoint_X = x + width;
        this.outputPoint_Y = y + height / 2;
        outputPoint = new Point(outputPoint_X, outputPoint_Y);
        g.setColor(color);
        g.drawOval(x, y, width, height);
        g.drawString(iconType, x + width / 2, y + height / 2);
    }
}
