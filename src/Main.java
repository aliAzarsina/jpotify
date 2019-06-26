import java.awt.*;
import java.awt.GridLayout;
import java.awt.Container;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.*;
import java.awt.Container;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.GroupLayout.Alignment.*;

// create a class ScrollPanel
// extending JFrame
public class Main extends JFrame {

    // Declaration of objects of the
    // JScrollPane class
    JScrollPane scrollpane;

    // Constructor of ScrollPanel class
    public Main()
    {

        // used to call super class
        // variables and methods
        super("JScrollPane Demonstration");

        // Function to set size of JFrame.
        setSize(1000, 1000);

        // Function to set Default
        // close operation of JFrame.
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container myPanel = getContentPane();

        GroupLayout groupLayout = new GroupLayout(myPanel);
        groupLayout.setAutoCreateGaps(true);
        //groupLayout.setAutoCreateContainerGaps(true);
        myPanel.setLayout(groupLayout);



        init( groupLayout);
        pack();
        setVisible(true);
        // Function to set
        // visible of JFrame.

    }

    // class init
    public void init(GroupLayout groupLayout)
    {

        // Declaration of objects
        // of JRadioButton class.
        JButton okButton = new JButton("OK");
        JButton form[][] = new JButton[15][5];

        // to contain a string count
        String counts[] = {"", "1 star", "2 star",
                "3 star", "4 star", "5 star"};

        // to contain a string value
        String categories[] = {"Geeks", "Language", "Java",
                "Sudo Placement", "Python",
                "CS Subject", "Operating System",
                "Data Structure", "Algorithm",
                "PHP language", "JAVASCRIPT",
                "C Sharp" };

        // Declaration of objects
        // of the JPanel class.
        JPanel p = new JPanel();
        JPanel c = new JPanel();

        // Function to set size of JFrame.
        p.setSize(1000, 600);

        // Function to set Layout of JFrame.
        GridLayout g=new GridLayout(18,1,10,0);
        p.setLayout(g);
        //g.setRows(20);
        // for loop
        for (int row = 0; row < 16; row++) {

            // Declaration of objects
            // of ButtonGroup class
            ButtonGroup bg = new ButtonGroup();

            for (int col = 0; col < 1; col++)
            {

                // If condition
                if (row == 0) {

                    // add new Jlabel
                    p.add(new JLabel("hasan"));
                }
                else if(row ==1)
                {
                    JPanel paneladd=new JPanel();
                    paneladd.setLayout(new GridLayout());

                    form[row -1 ][col ] = new JButton();
                    form[row -1][col ].setBackground(Color.black);
                    form[row - 1][col ].setText("alie");
                    paneladd.add(form[row -1 ][col ]);


                    p.add( paneladd);

                }
                else if(row==4)
                {
                    JPanel paneladd=new JPanel();
                    paneladd.setLayout(new GridLayout());
                    paneladd.add(new JTextField(""));
                    //paneladd.add(new JButton("ss"));
                    p.add(paneladd);
                }
                else if(row==5)
                {
                    JPanel paneladd=new JPanel();
                    paneladd.setLayout(new GridLayout());
                    paneladd.add(new JButton(""));
                    //paneladd.add(new JButton("ss"));
                    p.add(paneladd);
                }
                else {
                    // If condition
                    if (col == 100)
                    {

                        // add new Jlabel
                        // p.add(new JLabel(categories[row - 1]));
                    }



                    else
                    {
                        form[row -1 ][col ] = new JButton();
                        form[row -1][col ].setBackground(Color.black);
                        form[row - 1][col ].setText("alie");



                        // add form in ButtonGroup
                        bg.add(form[row - 1][col ]);

                        // add form in JFrame
                        p.add(form[row - 1][col ]);
                    }
                }
            }
        }

        // Declaration of objects
        // of scrollpane class.
        JButton b1 = new JButton("Button One");
        JButton b2 = new JButton("Button Two");
        JButton b3 = new JButton("Button Three");
        Panel panel=new Panel();
        panel.setBounds(40,80,200,200);
        panel.setBackground(Color.gray);
        Button c2=new Button("search");
        JTextArea c1=new JTextArea("search");
        c1.setBounds(2,2,2,2);
        c1.setBackground(Color.yellow);

        c2.setBounds(10,10,10,10);
        c2.setBackground(Color.green);
        panel.add(c1); panel.add(c2);
        JPanel panel2=new JPanel();
        p. setBackground(Color.black);


        scrollpane = new JScrollPane(p);
        scrollpane.setSize(20, 20);
        p.add(new JButton());
        JPanel panel3=new JPanel();

        scrollpane. setBackground(Color.green);
        //panel3.add(scrollpane);
        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(LEADING).addComponent(b2).addComponent(scrollpane))
                .addGroup(groupLayout.createParallelGroup(LEADING).addComponent(panel).addComponent(panel2))
                .addGroup(groupLayout.createParallelGroup(LEADING).addComponent(new JButton()).addComponent(panel3))

        );

        groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup(BASELINE).addComponent(b2).addComponent(panel).addComponent(panel3).addComponent(new JButton()))
                .addGroup(groupLayout.createParallelGroup(BASELINE).addComponent(scrollpane).addComponent(panel2))

        );


        // to get content pane
        // getContentPane().add(scrollpane, BorderLayout.WEST);
    }

    // Main Method
    public static void main(String args[])
    {
        new Main();
    }
}
