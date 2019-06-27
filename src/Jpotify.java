/*
 * Created by JFormDesigner on Mon Jun 24 14:38:43 IRDT 2019
 */



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;


/**
 * @author ali
 */
public class Jpotify extends JFrame {
    public Jpotify() {
        initComponents();
    }

    public static void main(String[]args){

        try {
            Jpotify jpotify= new Jpotify();
            jpotify.setVisible(true);
            Mantegh mantegh=new Mantegh(jpotify);
        }
        catch (Exception e)
        {}

    }

    private void label2MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - ali
        panel1 = new JPanel();
        panel6 = new JPanel();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        panel7 = new JPanel();
        label20 = new JLabel();
        label18 = new JLabel();
        panel13 = new JPanel();
        scrollPane3 = new JScrollPane();
        panel14 = new JPanel();
        label27 = new JLabel();
        label28 = new JLabel();
        label29 = new JLabel();
        panel2 = new JPanel();
        panel8 = new JPanel();
        panel12 = new JPanel();
        label21 = new JLabel();
        textField1 = new JTextField();
        scrollPane2 = new JScrollPane();
        panel9 = new JPanel();
        panel18 = new JPanel();
        label17 = new JLabel();
        label19 = new JLabel();
        button1 = new JButton();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel11 = new JPanel();
        slider1 = new JSlider();
        button11 = new JButton();
        button12 = new JButton();
        button13 = new JButton();
        button15 = new JButton();
        button5 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("E:\\AP_FinalProject\\Jpotify\\bin\\images\\appImages\\jpotifyLogo.png").getImage());
        setTitle("Jpotify");
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setMaximizedBounds(new Rectangle(0, 0, 1920, 1080));
        setName("MainFrame");
        setMinimumSize(new Dimension(1000, 600));
        setBackground(Color.black);
        Container contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(15, 15, 15));
            panel1.setBorder(null);

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


            //======== panel6 ========
            {
                panel6.setBackground(Color.black);

                //---- label1 ----
                label1.setText("P L A Y L I S T S");
                label1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
                label1.setHorizontalAlignment(SwingConstants.CENTER);
                label1.setForeground(Color.white);

                //======== scrollPane1 ========
                {
                    scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                    scrollPane1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

                    //======== panel7 ========
                    {
                        panel7.setBackground(new Color(15, 15, 15));
                        panel7.setLayout(new GridLayout(12, 1));

                        //---- label20 ----
                        label20.setText("PlaylistName");
                        label20.setIconTextGap(0);
                        label20.setAlignmentY(0.0F);
                        label20.setAlignmentX(5.0F);
                        label20.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
                        label20.setForeground(Color.white);
                        panel7.add(label20);
                    }
                    scrollPane1.setViewportView(panel7);
                }

                //---- label18 ----
                label18.setIcon(new ImageIcon("E:\\AP_FinalProject\\Jpotify\\bin\\images\\appImages\\addButtonNoBackground.png"));

                GroupLayout panel6Layout = new GroupLayout(panel6);
                panel6.setLayout(panel6Layout);
                panel6Layout.setHorizontalGroup(
                        panel6Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label18, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12))
                                .addGroup(panel6Layout.createSequentialGroup()
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                );
                panel6Layout.setVerticalGroup(
                        panel6Layout.createParallelGroup()
                                .addGroup(panel6Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(panel6Layout.createParallelGroup()
                                                .addGroup(panel6Layout.createSequentialGroup()
                                                        .addComponent(label18, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE))
                );
            }

            //======== panel13 ========
            {
                panel13.setBackground(Color.black);

                //======== scrollPane3 ========
                {

                    //======== panel14 ========
                    {
                        panel14.setBackground(new Color(12, 12, 12));
                        panel14.setLayout(new GridLayout(8, 1));

                        //---- label27 ----
                        label27.setText("MusicName");
                        label27.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
                        label27.setVerticalAlignment(SwingConstants.TOP);
                        label27.setForeground(Color.white);
                        panel14.add(label27);
                    }
                    scrollPane3.setViewportView(panel14);
                }

                //---- label28 ----
                label28.setIcon(new ImageIcon("E:\\AP_FinalProject\\Jpotify\\bin\\images\\appImages\\addButtonNoBackground.png"));

                //---- label29 ----
                label29.setText("M U S I C L I S T");
                label29.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
                label29.setForeground(Color.white);

                GroupLayout panel13Layout = new GroupLayout(panel13);
                panel13.setLayout(panel13Layout);
                panel13Layout.setHorizontalGroup(
                        panel13Layout.createParallelGroup()
                                .addComponent(scrollPane3)
                                .addGroup(panel13Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(label28, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(label29, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                panel13Layout.setVerticalGroup(
                        panel13Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel13Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(panel13Layout.createParallelGroup()
                                                .addComponent(label28)
                                                .addComponent(label29, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
                );
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                    .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(panel13, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(0, 0, 0))
            );
            panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                    .addComponent(panel13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            );
        }

        //======== panel2 ========
        {
            panel2.setBackground(new Color(15, 15, 15));

            //======== panel8 ========
            {
                panel8.setBackground(Color.black);

                //======== panel12 ========
                {
                    panel12.setBackground(new Color(15, 15, 15));

                    //---- label21 ----
                    label21.setIcon(new ImageIcon("E:\\AP_FinalProject\\Jpotify\\bin\\images\\appImages\\searchImageIcon.png"));

                    //---- textField1 ----
                    textField1.setBackground(Color.black);
                    textField1.setForeground(Color.white);
                    textField1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
                    textField1.setToolTipText("Search");
                    textField1.setDisabledTextColor(Color.white);
                    textField1.setCaretColor(Color.lightGray);
                    textField1.setBorder(null);

                    GroupLayout panel12Layout = new GroupLayout(panel12);
                    panel12.setLayout(panel12Layout);
                    panel12Layout.setHorizontalGroup(
                            panel12Layout.createParallelGroup()
                                    .addGroup(panel12Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(label21, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                            .addGap(3, 3, 3))
                    );
                    panel12Layout.setVerticalGroup(
                            panel12Layout.createParallelGroup()
                                    .addGroup(panel12Layout.createSequentialGroup()
                                            .addGap(3, 3, 3)
                                            .addGroup(panel12Layout.createParallelGroup()
                                                    .addComponent(label21, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(panel12Layout.createSequentialGroup()
                                                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                            .addGap(3, 3, 3)))
                                            .addContainerGap())
                    );
                }

                GroupLayout panel8Layout = new GroupLayout(panel8);
                panel8.setLayout(panel8Layout);
                panel8Layout.setHorizontalGroup(
                        panel8Layout.createParallelGroup()
                                .addGroup(panel8Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(panel12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(462, Short.MAX_VALUE))
                );
                panel8Layout.setVerticalGroup(
                        panel8Layout.createParallelGroup()
                                .addGroup(panel8Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(panel12, 34, 34, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                );
            }

            //======== scrollPane2 ========
            {
                scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

                //======== panel9 ========
                {
                    panel9.setBackground(Color.black);
                    panel9.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel9.getLayout()).columnWidths = new int[] {220, 220, 210, 0};
                    ((GridBagLayout)panel9.getLayout()).rowHeights = new int[] {290, 290, 290, 290, 270, 0};
                    ((GridBagLayout)panel9.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
                    ((GridBagLayout)panel9.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                    //======== panel18 ========
                    {
                        panel18.setBackground(new Color(102, 102, 102));

                        //---- label17 ----
                        label17.setText("Music Name");
                        label17.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
                        label17.setVerticalAlignment(SwingConstants.TOP);

                        //---- label19 ----
                        label19.setText("DetailsOfMusic");
                        label19.setVerticalAlignment(SwingConstants.TOP);

                        //---- button1 ----
                        button1.setText("text");

                        GroupLayout panel18Layout = new GroupLayout(panel18);
                        panel18.setLayout(panel18Layout);
                        panel18Layout.setHorizontalGroup(
                                panel18Layout.createParallelGroup()
                                        .addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panel18Layout.createSequentialGroup()
                                                .addGroup(panel18Layout.createParallelGroup()
                                                        .addComponent(label17, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label19, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                        );
                        panel18Layout.setVerticalGroup(
                                panel18Layout.createParallelGroup()
                                        .addGroup(panel18Layout.createSequentialGroup()
                                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label17)
                                                .addGap(0, 0, 0)
                                                .addComponent(label19, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                        );
                    }
                    panel9.add(panel18, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 20, 10), 0, 0));
                }
                scrollPane2.setViewportView(panel9);
            }

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                                    .addGap(18, 18, 18))
                            .addComponent(panel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                    .addComponent(panel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                                    .addGap(18, 18, 18))
            );
        }

        //======== panel3 ========
        {
            panel3.setBackground(new Color(15, 15, 15));

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                            .addGap(0, 198, Short.MAX_VALUE)
            );
            panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
            );
        }

        //======== panel4 ========
        {
            panel4.setBackground(Color.black);

            //======== panel11 ========
            {
                panel11.setMaximumSize(new Dimension(300, 51));
                panel11.setBackground(Color.black);
                panel11.setPreferredSize(new Dimension(300, 47));

                //---- button11 ----
                button11.setIcon(new ImageIcon("E:\\AP_FinalProject\\Jpotify\\bin\\images\\appImages\\previuseButtonImageIcon.png"));
                button11.setBackground(Color.black);

                //---- button12 ----
                button12.setBackground(Color.black);
                button12.setSelectedIcon(null);
                button12.setForeground(Color.white);
                button12.setIcon(new ImageIcon("E:\\AP_FinalProject\\Jpotify\\bin\\images\\appImages\\pauseButtonImageIcon.png"));

                //---- button13 ----
                button13.setIcon(new ImageIcon("E:\\AP_FinalProject\\Jpotify\\bin\\images\\appImages\\playButtonImageIcon.png"));
                button13.setBackground(Color.black);

                //---- button15 ----
                button15.setIcon(new ImageIcon("E:\\AP_FinalProject\\Jpotify\\bin\\images\\appImages\\nextButtonImageIcon.png"));
                button15.setBackground(Color.black);

                //---- button5 ----
                button5.setBackground(Color.black);
                button5.setIcon(new ImageIcon("E:\\AP_FinalProject\\Jpotify\\bin\\images\\appImages\\shuffleButtonImageIcon.png"));

                GroupLayout panel11Layout = new GroupLayout(panel11);
                panel11.setLayout(panel11Layout);
                panel11Layout.setHorizontalGroup(
                        panel11Layout.createParallelGroup()
                                .addGroup(panel11Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(slider1, GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                                        .addContainerGap())
                                .addGroup(panel11Layout.createSequentialGroup()
                                        .addGap(172, 172, 172)
                                        .addComponent(button11, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button12, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button13, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button15, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 367, Short.MAX_VALUE)
                                        .addComponent(button5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addGap(19, 19, 19))
                );
                panel11Layout.setVerticalGroup(
                        panel11Layout.createParallelGroup()
                                .addGroup(panel11Layout.createSequentialGroup()
                                        .addGap(0, 0, 0)
                                        .addGroup(panel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(button11, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button12, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button13, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button15, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                        .addGap(6, 6, 6)
                                        .addComponent(slider1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0))
                );
            }

            GroupLayout panel4Layout = new GroupLayout(panel4);
            panel4.setLayout(panel4Layout);
            panel4Layout.setHorizontalGroup(
                    panel4Layout.createParallelGroup()
                            .addGroup(panel4Layout.createSequentialGroup()
                                    .addGap(208, 208, 208)
                                    .addComponent(panel11, GroupLayout.PREFERRED_SIZE, 701, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(189, Short.MAX_VALUE))
            );
            panel4Layout.setVerticalGroup(
                    panel4Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                                    .addContainerGap(9, Short.MAX_VALUE)
                                    .addComponent(panel11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addComponent(panel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, 0)
                                .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - ali
    private JPanel panel1;
    private JPanel panel6;
    private JLabel label1;
    private JScrollPane scrollPane1;
    static JPanel panel7;
    private JLabel label20;
    private JLabel label18;
    private JPanel panel13;
    private JScrollPane scrollPane3;
    static JPanel panel14;
    private JLabel label27;
    private JLabel label28;
    static JLabel label29;
    private JPanel panel2;
    private JPanel panel8;
    private JPanel panel12;
    private JLabel label21;
    private JTextField textField1;
    private JScrollPane scrollPane2;
    static JPanel panel9;
    private JPanel panel18;
    private JLabel label17;
    private JLabel label19;
    static JButton button1;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel11;
    static JSlider slider1;
    static JButton button11;
    static JButton button12;
    static JButton button13;
    static JButton button15;
    static JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    static int i = 0;

    public static void addPlayList(JLabel newLabel) {
        //---- label2 ----
        panel7.add(newLabel, new GridBagConstraints(0, i, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));
        i++;

        panel7.validate();
        panel7.repaint();
    }

    static int addSongToListCounter = 0;

    public static void addSongToList(JLabel newLabel) {
        //---- label2 ----
        panel14.add(newLabel, new GridBagConstraints(0, addSongToListCounter, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));
        addSongToListCounter++;

        panel14.validate();
        panel14.repaint();
    }

    static int X = 0;
    static int Y = 0;

    public static void addPanelToCenterPanel(JPanel jPanel) {
        if(X>3)
        {
            X=0;
            Y++;
        }
        panel9.add(jPanel, new GridBagConstraints(X, Y, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 15, 34), 0, 0));
        X++;
        panel9.validate();
        panel9.repaint();

    }

    public static void clearCenterPanel() {
        panel9.removeAll();
        X = 0;
        Y = 0;
    }

    public static void sendLableToUP () {
        panel7.removeAll();
    }

    public static void clearSongList() {
        panel14.removeAll();
        X = 0;
        Y = 0;
    }
}



class Actionlisten implements ActionListener
{
    Thread thread;
    public Actionlisten(Thread t)
    {
        thread=t;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        thread.suspend();

    }
}
class Actionlisten2 implements ActionListener
{
    Thread thread;
    public Actionlisten2(Thread t)
    {
        thread=t;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        thread.resume();

    }
}
