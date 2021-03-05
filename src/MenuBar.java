import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar implements ActionListener {
    public int i = 2;

    public MenuBar() {
        // setSize(width,height/10);
        // setLayout(null);
        JButton buttonNew = new JButton("New");
        JButton buttonLoad = new JButton("Load");
        JButton buttonSave = new JButton("Save");
        this.add(buttonNew);
        this.add(buttonLoad);
        this.add(buttonSave);

        buttonNew.addActionListener(this::actionPerformed);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println("NEW CLICKED");
        String str = e.getActionCommand();
        if (str.equals("New")) {
            String st = "Space ";
            st += i;
            i += 1;
            JPanel panel2 = new JPanel();
            RightPanel.jTabbedPane.add(st, panel2);
        }
    }
}
