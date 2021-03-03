import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {
    JTabbedPane jTabbedPane;
    //BorderLayout borderLayoutRight;
    JTextArea jTextArea;
    JPanel tabPanel;
    public RightPanel() {
        //setSize(200, 200);
        //borderLayoutRight = new BorderLayout();
       // jTextArea =new JTextArea(200,200);
        tabPanel=new JPanel();
      //  tabPanel.add(jTextArea);
        System.out.println(getWidth()+" =w h= "+getHeight());
        jTabbedPane = new JTabbedPane();
        //jTabbedPane.setPreferredSize(new Dimension(900,540));
        jTabbedPane.add("Tab 1",tabPanel);
        add(jTabbedPane, BorderLayout.CENTER);
        //jTabbedPane.setBounds(10,10,getWidth()-10,getHeight()-10);
        jTabbedPane.setBackground(Color.ORANGE);
    }
}
