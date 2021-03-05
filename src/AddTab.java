import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;
        import java.io.*;
        public class AddTab{
            JTabbedPane tab;
            public static void main(String[] args){
                AddTab ar = new AddTab();
            }

            public AddTab(){
                JFrame frame = new JFrame("Add Tab Frame");

                JPanel panel = new JPanel();
                JPanel panel1  = new JPanel();

                JSplitPane sl = new JSplitPane(SwingConstants.HORIZONTAL, panel1, panel);

                JButton button = new JButton("New");
                JButton button1 = new JButton("Load");
                JButton button2 = new JButton("Save");
                panel1.add(button);
                panel1.add(button1);
                panel1.add(button2);

                button.addActionListener(new MyAction());

                tab = new JTabbedPane();
                tab.add(new JPanel(), "Space 1");
                tab.setTabPlacement(JTabbedPane.RIGHT);

                panel.add(tab);
                frame.add(sl);
                frame.setSize(400, 400);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }

            public class MyAction implements ActionListener{
                int i=2;
                public void actionPerformed(ActionEvent e){
                    String str = e.getActionCommand();
                    if(str.equals("New")){
                        String st = "Space ";
                        st += i;
                        i+=1;
                        if(!st.equals("")){
                            JPanel panel2 = new JPanel();
                            tab.add(st, panel2);
                        }
                    }
                }
            }
        }