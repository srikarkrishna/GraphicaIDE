package icons;

import java.awt.*;

public class CloseParenthesisIcon extends IconMain {
    int inputPoint_X, inputPoint_Y;

    public CloseParenthesisIcon() {
        iconName = "closePrn_" + count;
        iconType = ")";
        totalInputs = 1;
        totalOutputs = 0;
    }

    /**
     * Author: Sneha
     * Desc: Describe the Closed Parenthesis icon to draw on the GUI
     */
    @Override
    public void draw(Graphics g, int x, int y) {
        this.inputPoint_X = x;
        this.inputPoint_Y = y + height / 2;
        inputPoint = new Point(inputPoint_X, inputPoint_Y);
        g.setColor(color);
        g.drawOval(x, y, width, height);
        g.drawString(iconType, x + width / 2, y + height / 2);
    }

}
