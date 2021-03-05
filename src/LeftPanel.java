import icons.*;
import interfaces.Icon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class LeftPanel extends JPanel {
    boolean isClicked = false;
//    Icons openParenthesisIcon;
//    Icons closeParenthesisIcon;
//    Icons greaterThanIcon;
//    Icons lessThanIcon;
//    Icons loopIcon;
//    Icons barsIcon;
//    Icons hyphenIcon;
    interfaces.Icon icon = new BarsIcon();
    public static JButton[] getIconsArray() {
        return iconsArray;
    }

    private static final JButton[] iconsArray = new JButton[7];
    GridLayout iconLayout = new GridLayout(7,1);


    public LeftPanel() {
//        setSize(100, 100);
//        setLayout(null);
//        repaint();

        initializeIcons();
        addIconActionListeners();
        setLayout(iconLayout);
    }

    public void initializeIcons(){

        JButton openBracket = new JButton("(");
        iconsArray[0] = openBracket;

        JButton closeBracket = new JButton(")");
        iconsArray[1] = closeBracket;

        JButton lessThan = new JButton("<");
        iconsArray[2] = lessThan;

        JButton greaterThan = new JButton(">");
        iconsArray[3] = greaterThan;

        JButton atTheRate = new JButton("@");
        iconsArray[4] = atTheRate;

        JButton hyphen = new JButton("-");
        iconsArray[5] = hyphen;

        JButton bars = new JButton("||");
        iconsArray[6] = bars;


        for(int i=0; i< iconsArray.length;i++){
//            JButton button = iconsArray[i];
//            this.add(button.getText(),button);
            this.add(iconsArray[i].getText(),iconsArray[i]);
        }

    }

    public void addIconActionListeners(){

        for(int i=0; i< iconsArray.length;i++){

            JButton button = iconsArray[i];
           // System.out.println(button.getText());
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    isClicked =true;
                    //System.out.println(e.getX()+" "+e.getY());

                    String selectedIconText = button.getText();
                }
            });

//            button.addMouseMotionListener(new MouseAdapter() {
//                @Override
//                public void mouseDragged(MouseEvent e) {
//                    super.mouseDragged(e);
//                    System.out.println(button.getText());
//                  if(button.getText().equals("||"))
//                    {
//                   //     if(isClicked)
//                        System.out.println(button.getText());
//
//                        icon.draw(getGraphics(), (int)(MouseInfo.getPointerInfo().getLocation().getX()-80),
////                                        - button.getLocationOnScreen().getX()),
//                                (int)(MouseInfo.getPointerInfo().getLocation().getY()-130));
////                                        - button.getLocationOnScreen().getY()));
//                        repaint();
//                    }
//                }
//            });

            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mouseDragged(e);
                   // System.out.println(button.getText());
                    if(button.getText().equals("||"))
                    {
                        isClicked =true;
                        if(isClicked) {
                   //         System.out.println("Hello");

//                            interfaces.Icon icon = new BarsIcon();
                            icon.draw(getGraphics(), (int) (MouseInfo.getPointerInfo().getLocation().getX() - 80),
//                                        - button.getLocationOnScreen().getX()),
                                    (int) (MouseInfo.getPointerInfo().getLocation().getY() - 130));
//                                        - button.getLocationOnScreen().getY()));
                            repaint();
                        }
                    }
                }
            });
        }
    }


    public void paintComponent(Graphics g) {

//        int startX = 20, startY = 70, bufferSpace = 70;
        super.paintComponent(g);
    }
//        openParenthesisIcon = new OpenParenthesisIcon(g, startX, startY);
//        openParenthesisIcon.setDragEnabled(true);
//
////        openParenthesisIcon.draw(g);
//        closeParenthesisIcon = new CloseParenthesisIcon(g, startX, startY+bufferSpace);
////        closeParenthesisIcon.draw(g);
//        greaterThanIcon = new GreaterThanIcon(g, startX, startY+(2*bufferSpace));
////        greaterThanIcon.draw(g);
//        lessThanIcon = new LessThanIcon(g, startX, startY+(3*bufferSpace));
////        lessThanIcon.draw(g);
//        loopIcon = new LoopIcon(g, startX, startY+(4*bufferSpace));
////        loopIcon.draw(g);
//        barsIcon = new BarsIcon(g, startX, startY+(5*bufferSpace));
////        barsIcon.draw(g);
//        hyphenIcon = new HyphenIcon(g, startX, startY+(6*bufferSpace));
////        hyphenIcon.draw(g);
//    }
}
