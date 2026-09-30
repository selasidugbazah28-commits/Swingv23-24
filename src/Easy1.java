import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Easy1 implements ActionListener {
    private JFrame mainFrame;
    private JLabel statusLabel;
    //private JPanel controlPanel;
    private JMenuBar mb;
    private JMenu file, edit, help;
    private JMenuItem cut, copy, paste, selectAll, button1, button2, button3, button4, button5;
    private JTextArea ta; //typing area
    private int WIDTH=800;
    private int HEIGHT=700;


    public Easy1() {
        prepareGUI();
    } // Prepare method

    public static void main(String[] args) {
        Easy1 swingControlDemo = new Easy1(); // Declare object
        swingControlDemo.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new GridLayout(2, 3)); // makes boxes in the frame that are the exact same dimensions

        //menu at top
        cut = new JMenuItem("cut");
        copy = new JMenuItem("copy");
        paste = new JMenuItem("paste");
        selectAll = new JMenuItem("selectAll");
        button1 = new JMenuItem("button 1");
        button2 = new JMenuItem("button 2");
        button3 = new JMenuItem("button 3");
        button4 = new JMenuItem("button 4");
        button5 = new JMenuItem("button 5");

        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);

        mb = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        mb.add(file);
        mb.add(edit);
        mb.add(help);
        //end menu at top

        ta = new JTextArea(); //use it starting with a J, not without it
        ta.setBounds(50, 5, WIDTH-100, HEIGHT-50);
        mainFrame.add(mb);  //add menu bar
       // mainFrame.add(ta);//add typing area
        mainFrame.setJMenuBar(mb); //set menu bar
        mainFrame.add(button1);
        mainFrame.add(button2);
        mainFrame.add(button3);
        mainFrame.add(button4);
        mainFrame.add(button5);



        statusLabel = new JLabel("", JLabel.CENTER); //after you click a button, an untypeable set of letters show up
        statusLabel.setSize(350, 100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
       // controlPanel = new JPanel();
       // controlPanel.setLayout(new BorderLayout()); //set the layout of the pannel

       // mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void showEventDemo() {

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");

        button1.setActionCommand("button 1");
        button2.setActionCommand("button 2");
        button3.setActionCommand("button 3");
        button4.setActionCommand("button 4");
        button5.setActionCommand("button 5");

        button1.addActionListener(new ButtonClickListener());
        button2.addActionListener(new ButtonClickListener());
        button3.addActionListener(new ButtonClickListener());
        button4.addActionListener(new ButtonClickListener());
        button5.addActionListener(new ButtonClickListener());

      //  controlPanel.add(button1, BorderLayout.WEST);
      //  controlPanel.add(button2, BorderLayout.CENTER);
      //  controlPanel.add(button3, BorderLayout.EAST);

        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cut)
            ta.cut();
        if (e.getSource() == paste)
            ta.paste();
        if (e.getSource() == copy)
            ta.copy();
        if (e.getSource() == selectAll)
            ta.selectAll();
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("OK")) {
                statusLabel.setText("Ok Button clicked.");
            } else if (command.equals("Submit")) {
                statusLabel.setText("Submit Button clicked.");
            } else {
                statusLabel.setText("Cancel Button clicked.");
            }
        }
    }
}
