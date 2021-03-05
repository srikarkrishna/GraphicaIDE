import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import icons.Icons;

public class RightPanel extends JPanel {
    public static JTabbedPane jTabbedPane;
    //BorderLayout borderLayoutRight;
    JTextArea jTextArea;
    public JPanel tabPanel;
    ArrayList<Icons> iconList = new ArrayList<>();
    public RightPanel() {
        //setSize(200, 200);
        //borderLayoutRight = new BorderLayout();
       // jTextArea =new JTextArea(200,200);
        tabPanel=new JPanel();
      //  tabPanel.add(jTextArea);
        System.out.println(getWidth()+" =w h= "+getHeight());
        jTabbedPane = new JTabbedPane();
        //jTabbedPane.setPreferredSize(new Dimension(900,540));
        jTabbedPane.addTab("Space 1",tabPanel);
        //tabPanel.setBounds(200,200,900,900);
        System.out.println(tabPanel.contains(500,500)+" "+tabPanel.getBounds());
        //jTabbedPane.setBounds(200,200,200,200 ) ;
        add(jTabbedPane, BorderLayout.CENTER);
        jTabbedPane.setTabPlacement(JTabbedPane.RIGHT);
        //jTabbedPane.setBounds(10,10,getWidth()-10,getHeight()-10);
        tabPanel.setBackground(Color.ORANGE);
        setVisible(true);

    }
}
