package icons;
import java.awt.*;
import java.util.ArrayList;

public class OutputBarsIcon extends IconMain {
    private static final String iconType = "- |";
    public OutputBarsIcon(){
        inputPoints = new ArrayList<>();
        outputPoints = new ArrayList<>();
    }
    /*************************************************************************************
     *  - Method Name: draw()
     *  - Input Parameters : Graphic object, int X, int Y
     *  - Return Type :void
     *  - Author : Sneha
     *  - Creation Date : 03/05/2021
     *  - Desc: Describe the bars icon with multiple outputs to draw on the GUI
     ***************************************************************************************/
    @Override
    public void draw(Graphics g, int x, int y) {
        inputPoints.clear();
        outputPoints.clear();
        inputPoints.add(new Point(x+10,y+10));
        outputPoints.add(new Point(x+width-20,y+10));
//        g.drawRect(x,y,width,height);
        g.drawOval(x,y,width,height);
        g.drawString(iconType, x+width/2, y+height/2);
//        g.fillRect(x + 10, y + 10, 10, height - 20);
//        g.fillRect(x + width - 20, y + 10, 10, height - 20);
    }
}
