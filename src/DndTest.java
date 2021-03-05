import javax.swing.*;

/**
 * @author Kushal Paudyal
 * www.sanjaal.com/java
 * Last Modified On 07-14-2009
 *
 * This class demonstrates the ability to do
 * drag and drop of selected text between a text field
 * and a text area.
 *
 */
class DragAndDropDemo extends JFrame {
    private static final long serialVersionUID = 1L;

    public DragAndDropDemo()
    {
        super("www.sanjaal.com/java - Drag and Drop Demo");

        Box verticalBox = Box.createVerticalBox();

//        JTable table = new JTable(10,10);
//        table.setDragEnabled(true);
//        verticalBox.add(new JScrollPane(table));

        JTextPane table = new JTextPane();
        table.setDragEnabled(true);
        verticalBox.add(new JScrollPane(table));

        JTextArea textArea = new JTextArea(4, 25);
        textArea.setText("www.sanjaal.com/java is great.");
        textArea.setDragEnabled(true);
        verticalBox.add(new JScrollPane(textArea));

        JPanel panel=new JPanel();
        panel.add(verticalBox);
        getContentPane().add(panel);

        /**
         * Setting some common GUI Features
         */
        pack();
        setVisible(true);
        setLocation(200,200);
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * Testing the DragAndDrop GUI program.
     */
    public static void main(String[] args) {
        new DragAndDropDemo();

    }
}