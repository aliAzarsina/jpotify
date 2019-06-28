/*
 * Created by JFormDesigner on Mon Jun 24 14:38:43 IRDT 2019
 */



import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;


/**
 * @author ali
 */
public class Jpotify extends JFrame {

    static String username;

    public Jpotify() {
        initComponents();
    }

    public static void main(String[]args){

        try {
            Jpotify jpotify= new Jpotify();
            jpotify.setVisible(true);
            jpotify.getContentPane().setBackground(Color.black);
            Mantegh mantegh=new Mantegh(jpotify);
            Thread serverThread = new Thread(new ServerSide());
            serverThread.start();
            serverThread.join(1000);
            Thread clientThread = new Thread(new ClientSide());
            clientThread.start();
        }
        catch (Exception e)
        {}

    }

    private void label2MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void button14MouseEntered(MouseEvent e) {
        button14.setIcon(new ImageIcon(".\\bin\\images\\appImages\\addToSharedlistButtonSelected.png"));
    }

    private void button14MouseExited(MouseEvent e) {
        button14.setIcon(new ImageIcon(".\\bin\\images\\appImages\\addToSharedlistButton.png"));
    }

    private void button16MouseEntered(MouseEvent e) {
        button16.setIcon(new ImageIcon(".\\bin\\images\\appImages\\addToFavaritesButtonSelected.png"));
    }

    private void button16MouseExited(MouseEvent e) {
        button16.setIcon(new ImageIcon(".\\bin\\images\\appImages\\addToFavaritesButton.png"));
    }

    private void button11MouseEntered(MouseEvent e) {
        button11.setIcon(new ImageIcon(".\\bin\\images\\appImages\\previuseButtonImageIconSelected.png"));
    }

    private void button11MouseExited(MouseEvent e) {
        button11.setIcon(new ImageIcon(".\\bin\\images\\appImages\\previuseButtonImageIcon.png"));
    }

    private void button12MouseEntered(MouseEvent e) {
        button12.setIcon(new ImageIcon(".\\bin\\images\\appImages\\pauseButtonImageIconSelected.png"));
    }

    private void button12MouseExited(MouseEvent e) {
        button12.setIcon(new ImageIcon(".\\bin\\images\\appImages\\pauseButtonImageIcon.png"));
    }

    private void button13MouseEntered(MouseEvent e) {
        button13.setIcon(new ImageIcon(".\\bin\\images\\appImages\\playButtonImageIconSelected.png"));
    }

    private void button13MouseExited(MouseEvent e) {
        button13.setIcon(new ImageIcon(".\\bin\\images\\appImages\\playButtonImageIcon.png"));
    }

    private void button15MouseEntered(MouseEvent e) {
        button15.setIcon(new ImageIcon(".\\bin\\images\\appImages\\nextButtonImageIconSelected.png"));
    }

    private void button15MouseExited(MouseEvent e) {
        button15.setIcon(new ImageIcon(".\\bin\\images\\appImages\\nextButtonImageIcon.png"));
    }

    private void button16MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void button6MouseEntered(MouseEvent e) {
        button6.setIcon(new ImageIcon(".\\bin\\images\\appImages\\repeatButtonImageIconSelected.png"));
    }

    private void button6MouseExited(MouseEvent e) {
        button6.setIcon(new ImageIcon(".\\bin\\images\\appImages\\repeatButtonImageIcon.png"));
    }

    private void button5MouseEntered(MouseEvent e) {
        button5.setIcon(new ImageIcon(".\\bin\\images\\appImages\\shuffleButtonImageIconSelected.png"));
    }

    private void button5MouseExited(MouseEvent e) {
        button5.setIcon(new ImageIcon(".\\bin\\images\\appImages\\shuffleButtonImageIcon.png"));
    }

    private void button3MouseEntered(MouseEvent e) {
        button3.setIcon(new ImageIcon(".\\bin\\images\\appImages\\othersSharedlistButtonSelected.png"));
    }

    private void button3MouseExited(MouseEvent e) {
        button3.setIcon(new ImageIcon(".\\bin\\images\\appImages\\othersSharedlistButton.png"));
    }

    private void button2MouseEntered(MouseEvent e) {
        button2.setIcon(new ImageIcon(".\\bin\\images\\appImages\\downloadButtonSelected.png"));
    }

    private void button2MouseExited(MouseEvent e) {
        button2.setIcon(new ImageIcon(".\\bin\\images\\appImages\\downloadButton.png"));
    }

    private void label29MouseEntered(MouseEvent e) {
        label29.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
        label29.setForeground(new Color(0,171,242));
    }

    private void label29MouseExited(MouseEvent e) {
        label29.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
        label29.setForeground(Color.white);
    }

    private void label31MouseEntered(MouseEvent e) {
        label31.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
        label31.setForeground(new Color(0,171,242));
    }

    private void label31MouseExited(MouseEvent e) {
        label31.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
        label31.setForeground(Color.white);
    }

    private void label1MouseEntered(MouseEvent e) {
        label1.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
        label1.setForeground(new Color(0,171,242));
    }

    private void label1MouseExited(MouseEvent e) {
        label1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
        label1.setForeground(Color.white);
    }

    private void label28MouseEntered(MouseEvent e) {
        label28.setIcon(new ImageIcon(".\\bin\\images\\appImages\\addButtonNoBackgroundSelected.png"));
    }

    private void label28MouseExited(MouseEvent e) {
        label28.setIcon(new ImageIcon(".\\bin\\images\\appImages\\addButtonNoBackground.png"));
    }

    private void label30MouseEntered(MouseEvent e) {
        label30.setIcon(new ImageIcon(".\\bin\\images\\appImages\\addButtonNoBackgroundSelected.png"));
    }

    private void label30MouseExited(MouseEvent e) {
        label30.setIcon(new ImageIcon(".\\bin\\images\\appImages\\addButtonNoBackground.png"));
    }

    private void label18MouseEntered(MouseEvent e) {
        label18.setIcon(new ImageIcon(".\\bin\\images\\appImages\\addButtonNoBackgroundSelected.png"));
    }

    private void label18MouseExited(MouseEvent e) {
        label18.setIcon(new ImageIcon(".\\bin\\images\\appImages\\addButtonNoBackground.png"));
    }

    private void label12MouseEntered(MouseEvent e) {
        label12.setIcon(new ImageIcon(".\\bin\\images\\appImages\\userButton.png"));
    }

    private void label12MouseExited(MouseEvent e) {
        label12.setIcon(new ImageIcon(".\\bin\\images\\appImages\\userButtonSelected.png"));
    }

    private void label13MouseEntered(MouseEvent e) {
        label13.setIcon(new ImageIcon(".\\bin\\images\\appImages\\trashButtonSelected.png"));
    }

    private void label13MouseExited(MouseEvent e) {
        label13.setIcon(new ImageIcon(".\\bin\\images\\appImages\\userButton.png"));
    }

    private void button4MouseEntered(MouseEvent e) {
        button4.setIcon(new ImageIcon(".\\bin\\images\\appImages\\addButtonNoBackgroundSelected.png"));
    }

    private void button4MouseExited(MouseEvent e) {
        button4.setIcon(new ImageIcon(".\\bin\\images\\appImages\\addButtonNoBackground.png"));
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
        label28 = new JLabel();
        label29 = new JLabel();
        panel14 = new JPanel();
        label30 = new JLabel();
        label31 = new JLabel();
        panel10 = new JPanel();
        label2 = new JLabel();
        panel2 = new JPanel();
        panel8 = new JPanel();
        panel12 = new JPanel();
        label21 = new JLabel();
        textField1 = new JTextField();
        label9 = new JLabel();
        label12 = new JLabel();
        scrollPane2 = new JScrollPane();
        panel9 = new JPanel();
        panel18 = new JPanel();
        label17 = new JLabel();
        label19 = new JLabel();
        button1 = new JButton();
        label13 = new JLabel();
        button4 = new JButton();
        panel3 = new JPanel();
        scrollPane3 = new JScrollPane();
        panel5 = new JPanel();
        panel15 = new JPanel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        button2 = new JButton();
        button3 = new JButton();
        panel4 = new JPanel();
        panel11 = new JPanel();
        slider1 = new JSlider();
        button11 = new JButton();
        button12 = new JButton();
        button13 = new JButton();
        button15 = new JButton();
        button5 = new JButton();
        button14 = new JButton();
        button16 = new JButton();
        button6 = new JButton();
        label10 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        panel16 = new JPanel();
        label11 = new JLabel();
        slider2 = new JSlider();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(".\\bin\\images\\appImages\\jpotifyLogo.png").getImage());
        setTitle("Jpotify");
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setMaximizedBounds(new Rectangle(0, 0, 1920, 1080));
        setName("MainFrame");
        setMinimumSize(new Dimension(1000, 600));
        setBackground(Color.black);
        Container contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(Color.black);
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
                label1.setForeground(Color.white);
                label1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        label1MouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        label1MouseExited(e);
                    }
                });

                //======== scrollPane1 ========
                {
                    scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                    scrollPane1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

                    //======== panel7 ========
                    {
                        panel7.setBackground(new Color(15, 15, 15));
                        panel7.setLayout(new GridBagLayout());
                        ((GridBagLayout)panel7.getLayout()).columnWidths = new int[] {0, 0};
                        ((GridBagLayout)panel7.getLayout()).rowHeights = new int[] {30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 0};
                        ((GridBagLayout)panel7.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                        ((GridBagLayout)panel7.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                        //---- label20 ----
                        label20.setText("   PlaylistName");
                        label20.setIconTextGap(0);
                        label20.setAlignmentY(0.0F);
                        label20.setAlignmentX(5.0F);
                        label20.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
                        label20.setForeground(Color.white);
                        label20.setVerticalAlignment(SwingConstants.BOTTOM);
                        panel7.add(label20, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                                new Insets(0, 0, 0, 0), 0, 0));
                    }
                    scrollPane1.setViewportView(panel7);
                }

                //---- label18 ----
                label18.setIcon(new ImageIcon(".\\bin\\images\\appImages\\addButtonNoBackground.png"));
                label18.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        label18MouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        label18MouseExited(e);
                    }
                });

                GroupLayout panel6Layout = new GroupLayout(panel6);
                panel6.setLayout(panel6Layout);
                panel6Layout.setHorizontalGroup(
                        panel6Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label18, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1))
                                .addGroup(panel6Layout.createSequentialGroup()
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                );
                panel6Layout.setVerticalGroup(
                        panel6Layout.createParallelGroup()
                                .addGroup(panel6Layout.createSequentialGroup()
                                        .addGroup(panel6Layout.createParallelGroup()
                                                .addComponent(label18, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                        .addGap(12, 12, 12)
                                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
                );
            }

            //======== panel13 ========
            {
                panel13.setBackground(Color.black);

                //---- label28 ----
                label28.setIcon(new ImageIcon(".\\bin\\images\\appImages\\addButtonNoBackground.png"));
                label28.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        label28MouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        label28MouseExited(e);
                    }
                });

                //---- label29 ----
                label29.setText("M U S I C L I S T");
                label29.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
                label29.setForeground(Color.white);
                label29.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        label29MouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        label29MouseExited(e);
                    }
                });

                GroupLayout panel13Layout = new GroupLayout(panel13);
                panel13.setLayout(panel13Layout);
                panel13Layout.setHorizontalGroup(
                        panel13Layout.createParallelGroup()
                                .addGroup(panel13Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(label28, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(label29, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                        .addContainerGap())
                );
                panel13Layout.setVerticalGroup(
                        panel13Layout.createParallelGroup()
                                .addGroup(panel13Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(panel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(label28)
                                                .addComponent(label29, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                                        .addGap(6, 6, 6))
                );
            }

            //======== panel14 ========
            {
                panel14.setBackground(Color.black);

                //---- label30 ----
                label30.setIcon(new ImageIcon(".\\bin\\images\\appImages\\addButtonNoBackground.png"));
                label30.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        label30MouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        label30MouseExited(e);
                    }
                });

                //---- label31 ----
                label31.setText("A L B U M L I S T");
                label31.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
                label31.setForeground(Color.white);
                label31.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        label31MouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        label31MouseExited(e);
                    }
                });

                GroupLayout panel14Layout = new GroupLayout(panel14);
                panel14.setLayout(panel14Layout);
                panel14Layout.setHorizontalGroup(
                        panel14Layout.createParallelGroup()
                                .addGroup(panel14Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(label30, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(label31, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                        .addContainerGap())
                );
                panel14Layout.setVerticalGroup(
                        panel14Layout.createParallelGroup()
                                .addGroup(panel14Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(panel14Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(label30)
                                                .addComponent(label31, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(9, Short.MAX_VALUE))
                );
            }

            //======== panel10 ========
            {
                panel10.setBackground(Color.black);

                //---- label2 ----
                label2.setText("music image");
                label2.setForeground(Color.white);

                GroupLayout panel10Layout = new GroupLayout(panel10);
                panel10.setLayout(panel10Layout);
                panel10Layout.setHorizontalGroup(
                        panel10Layout.createParallelGroup()
                                .addGroup(panel10Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                panel10Layout.setVerticalGroup(
                        panel10Layout.createParallelGroup()
                                .addGroup(panel10Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                            .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel14, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel13, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            );
            panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                    .addGap(0, 0, 0)
                                    .addComponent(panel13, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(panel14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(panel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(0, 0, 0)
                                    .addComponent(panel10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
                    label21.setIcon(new ImageIcon(".\\bin\\images\\appImages\\searchImageIcon.png"));

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

                //---- label9 ----
                label9.setText("UserName");
                label9.setForeground(Color.white);
                label9.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
                label9.setHorizontalAlignment(SwingConstants.CENTER);

                //---- label12 ----
                label12.setIcon(new ImageIcon(".\\bin\\images\\appImages\\userButton.png"));
                label12.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        label12MouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        label12MouseExited(e);
                    }
                });

                GroupLayout panel8Layout = new GroupLayout(panel8);
                panel8.setLayout(panel8Layout);
                panel8Layout.setHorizontalGroup(
                        panel8Layout.createParallelGroup()
                                .addGroup(panel8Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(panel12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 429, Short.MAX_VALUE)
                                        .addComponent(label12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(3, 3, 3)
                                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                );
                panel8Layout.setVerticalGroup(
                        panel8Layout.createParallelGroup()
                                .addGroup(panel8Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(panel8Layout.createParallelGroup()
                                                .addGroup(GroupLayout.Alignment.TRAILING, panel8Layout.createSequentialGroup()
                                                        .addComponent(label12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGap(15, 15, 15))
                                                .addGroup(panel8Layout.createSequentialGroup()
                                                        .addGroup(panel8Layout.createParallelGroup()
                                                                .addComponent(panel12, 34, 34, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(label9))
                                                        .addContainerGap())))
                );
            }

            //======== scrollPane2 ========
            {
                scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                scrollPane2.setBorder(null);

                //======== panel9 ========
                {
                    panel9.setBackground(Color.black);
                    panel9.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel9.getLayout()).columnWidths = new int[] {225, 225, 225, 200, 0};
                    ((GridBagLayout)panel9.getLayout()).rowHeights = new int[] {305, 305, 305, 305, 305, 305, 305, 305, 305, 305, 280, 0};
                    ((GridBagLayout)panel9.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0E-4};
                    ((GridBagLayout)panel9.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0E-4};

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

                        //---- label13 ----
                        label13.setIcon(new ImageIcon(".\\bin\\images\\appImages\\trashButton.png"));
                        label13.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseEntered(MouseEvent e) {
                                label13MouseEntered(e);
                            }
                            @Override
                            public void mouseExited(MouseEvent e) {
                                label13MouseExited(e);
                            }
                        });

                        //---- button4 ----
                        button4.setBackground(new Color(102, 102, 102));
                        button4.setIcon(new ImageIcon(".\\bin\\images\\appImages\\addButtonNoBackground.png"));
                        button4.setBorder(null);
                        button4.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseEntered(MouseEvent e) {
                                button4MouseEntered(e);
                            }
                            @Override
                            public void mouseExited(MouseEvent e) {
                                button4MouseExited(e);
                            }
                        });

                        GroupLayout panel18Layout = new GroupLayout(panel18);
                        panel18.setLayout(panel18Layout);
                        panel18Layout.setHorizontalGroup(
                                panel18Layout.createParallelGroup()
                                        .addGroup(panel18Layout.createSequentialGroup()
                                                .addGroup(panel18Layout.createParallelGroup()
                                                        .addComponent(label17, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label19, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panel18Layout.createParallelGroup()
                                                        .addComponent(label13, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(14, Short.MAX_VALUE))
                                        .addComponent(button1, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        );
                        panel18Layout.setVerticalGroup(
                                panel18Layout.createParallelGroup()
                                        .addGroup(panel18Layout.createSequentialGroup()
                                                .addComponent(button1, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(panel18Layout.createParallelGroup()
                                                        .addComponent(label17)
                                                        .addComponent(button4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panel18Layout.createParallelGroup()
                                                        .addComponent(label19, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label13, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
                        );
                    }
                    panel9.add(panel18, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 25, 25), 0, 0));
                }
                scrollPane2.setViewportView(panel9);
            }

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                            .addComponent(panel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrollPane2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)
            );
            panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                    .addComponent(panel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                                    .addGap(0, 0, 0))
            );
        }

        //======== panel3 ========
        {
            panel3.setBackground(new Color(15, 15, 15));

            //======== scrollPane3 ========
            {
                scrollPane3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                scrollPane3.setBorder(null);

                //======== panel5 ========
                {
                    panel5.setBackground(new Color(15, 15, 15));
                    panel5.setBorder(null);
                    panel5.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel5.getLayout()).columnWidths = new int[] {0, 0};
                    ((GridBagLayout)panel5.getLayout()).rowHeights = new int[] {52, 102, 102, 102, 102, 102, 102, 100, 0};
                    ((GridBagLayout)panel5.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                    ((GridBagLayout)panel5.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
                    System.out.println(panel5);
                    //======== panel15 ========
                    {
                        panel15.setBackground(Color.black);

                        //---- label5 ----
                        label5.setText("Ali");
                        label5.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
                        label5.setForeground(Color.white);

                        //---- label6 ----
                        label6.setText("2m");
                        label6.setForeground(Color.white);

                        //---- label7 ----
                        label7.setText("music name");
                        label7.setForeground(Color.lightGray);

                        //---- label8 ----
                        label8.setText("music artist");
                        label8.setForeground(Color.lightGray);

                        //---- button2 ----
                        button2.setSelectedIcon(new ImageIcon(".\\bin\\images\\appImages\\downloadButton.png"));
                        button2.setBackground(Color.black);
                        button2.setIcon(new ImageIcon(".\\bin\\images\\appImages\\downloadButton.png"));
                        button2.setBorderPainted(false);
                        button2.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseEntered(MouseEvent e) {
                                button2MouseEntered(e);
                            }
                            @Override
                            public void mouseExited(MouseEvent e) {
                                button2MouseExited(e);
                            }
                        });

                        //---- button3 ----
                        button3.setBackground(Color.black);
                        button3.setSelectedIcon(new ImageIcon(".\\bin\\images\\appImages\\othersSharedlistButton.png"));
                        button3.setForeground(Color.white);
                        button3.setIcon(new ImageIcon(".\\bin\\images\\appImages\\othersSharedlistButton.png"));
                        button3.setBorderPainted(false);
                        button3.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseEntered(MouseEvent e) {
                                button3MouseEntered(e);
                            }
                            @Override
                            public void mouseExited(MouseEvent e) {
                                button3MouseExited(e);
                            }
                        });

                        GroupLayout panel15Layout = new GroupLayout(panel15);
                        panel15.setLayout(panel15Layout);
                        panel15Layout.setHorizontalGroup(
                                panel15Layout.createParallelGroup()
                                        .addGroup(panel15Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(panel15Layout.createParallelGroup()
                                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(panel15Layout.createSequentialGroup()
                                                                .addComponent(label8, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(button3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(3, 3, 3)
                                                .addGroup(panel15Layout.createParallelGroup()
                                                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        );
                        panel15Layout.setVerticalGroup(
                                panel15Layout.createParallelGroup()
                                        .addGroup(panel15Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(panel15Layout.createParallelGroup()
                                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addGroup(panel15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                                .addGap(3, 3, 3))
                        );
                    }
//                    panel5.add(panel15, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
//                            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
//                            new Insets(0, 0, 2, 0), 0, 0));
                }
                scrollPane3.setViewportView(panel5);
            }

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                            .addComponent(scrollPane3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
            );
            panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                            .addComponent(scrollPane3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
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
                button11.setIcon(new ImageIcon(".\\bin\\images\\appImages\\previuseButtonImageIcon.png"));
                button11.setBackground(Color.black);
                button11.setBorderPainted(false);
                button11.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        button11MouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        button11MouseExited(e);
                    }
                });

                //---- button12 ----
                button12.setBackground(Color.black);
                button12.setSelectedIcon(null);
                button12.setForeground(Color.white);
                button12.setIcon(new ImageIcon(".\\bin\\images\\appImages\\pauseButtonImageIcon.png"));
                button12.setBorderPainted(false);
                button12.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        button12MouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        button12MouseExited(e);
                    }
                });

                //---- button13 ----
                button13.setIcon(new ImageIcon(".\\bin\\images\\appImages\\playButtonImageIcon.png"));
                button13.setBackground(Color.black);
                button13.setBorderPainted(false);
                button13.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        button13MouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        button13MouseExited(e);
                    }
                });

                //---- button15 ----
                button15.setIcon(new ImageIcon(".\\bin\\images\\appImages\\nextButtonImageIcon.png"));
                button15.setBackground(Color.black);
                button15.setBorderPainted(false);
                button15.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        button15MouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        button15MouseExited(e);
                    }
                });

                //---- button5 ----
                button5.setBackground(Color.black);
                button5.setIcon(new ImageIcon(".\\bin\\images\\appImages\\shuffleButtonImageIcon.png"));
                button5.setBorderPainted(false);
                button5.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        button5MouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        button5MouseExited(e);
                    }
                });

                //---- button14 ----
                button14.setIcon(new ImageIcon(".\\bin\\images\\appImages\\addToSharedlistButton.png"));
                button14.setBackground(Color.black);
                button14.setBorderPainted(false);
                button14.setSelectedIcon(new ImageIcon(".\\bin\\images\\appImages\\addToSharedlistButtonSelected.png"));
                button14.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        button14MouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        button14MouseExited(e);
                    }
                });

                //---- button16 ----
                button16.setIcon(new ImageIcon(".\\bin\\images\\appImages\\addToFavaritesButton.png"));
                button16.setBackground(Color.black);
                button16.setBorderPainted(false);
                button16.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button16MouseClicked(e);
                        button16MouseClicked(e);
                        button16MouseClicked(e);
                    }
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        button16MouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        button16MouseExited(e);
                    }
                });

                //---- button6 ----
                button6.setBackground(Color.black);
                button6.setIcon(new ImageIcon(".\\bin\\images\\appImages\\repeatButtonImageIcon.png"));
                button6.setBorderPainted(false);
                button6.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        button6MouseEntered(e);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        button6MouseExited(e);
                    }
                });

                //---- label10 ----
                label10.setText("1:12 / 5:15");
                label10.setForeground(Color.white);

                GroupLayout panel11Layout = new GroupLayout(panel11);
                panel11.setLayout(panel11Layout);
                panel11Layout.setHorizontalGroup(
                        panel11Layout.createParallelGroup()
                                .addGroup(panel11Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(panel11Layout.createParallelGroup()
                                                .addComponent(slider1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(GroupLayout.Alignment.TRAILING, panel11Layout.createSequentialGroup()
                                                        .addComponent(button14, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(button16, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 366, Short.MAX_VALUE)
                                                        .addComponent(button11, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(button12, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(button13, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(button15, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
                                                        .addComponent(label10, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(button6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(button5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
                                        .addContainerGap())
                );
                panel11Layout.setVerticalGroup(
                        panel11Layout.createParallelGroup()
                                .addGroup(panel11Layout.createSequentialGroup()
                                        .addGroup(panel11Layout.createParallelGroup()
                                                .addGroup(panel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(button5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button12, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button13, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button15, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(button11, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                                .addComponent(button6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button14, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button16, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label10, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(slider1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                );
            }

            //---- label3 ----
            label3.setText("music name");
            label3.setForeground(Color.white);
            label3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
            label3.setVerticalAlignment(SwingConstants.TOP);

            //---- label4 ----
            label4.setText("music artist");
            label4.setForeground(Color.white);
            label4.setFont(new Font("Segoe UI", Font.PLAIN, 16));

            //======== panel16 ========
            {
                panel16.setBackground(Color.black);

                //---- label11 ----
                label11.setIcon(new ImageIcon(".\\bin\\images\\appImages\\speakerButton.png"));
                label11.setBackground(Color.black);

                //---- slider2 ----
                slider2.setBackground(Color.black);

                GroupLayout panel16Layout = new GroupLayout(panel16);
                panel16.setLayout(panel16Layout);
                panel16Layout.setHorizontalGroup(
                        panel16Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel16Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(slider2, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label11, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                );
                panel16Layout.setVerticalGroup(
                        panel16Layout.createParallelGroup()
                                .addGroup(panel16Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(panel16Layout.createParallelGroup()
                                                .addComponent(label11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(panel16Layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(slider2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
                                        .addGap(14, 14, 14))
                );
            }

            GroupLayout panel4Layout = new GroupLayout(panel4);
            panel4.setLayout(panel4Layout);
            panel4Layout.setHorizontalGroup(
                    panel4Layout.createParallelGroup()
                            .addGroup(panel4Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel4Layout.createParallelGroup()
                                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
                                    .addGap(12, 12, 12)
                                    .addComponent(panel11, GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(panel16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(14, 14, 14))
            );
            panel4Layout.setVerticalGroup(
                    panel4Layout.createParallelGroup()
                            .addGroup(panel4Layout.createSequentialGroup()
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panel4Layout.createParallelGroup()
                                            .addComponent(panel16, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(panel4Layout.createSequentialGroup()
                                                    .addGroup(panel4Layout.createParallelGroup()
                                                            .addGroup(panel4Layout.createSequentialGroup()
                                                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                                    .addGap(0, 0, 0)
                                                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                                            .addComponent(panel11, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                                                    .addGap(0, 0, Short.MAX_VALUE)))
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
                                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, 0)
                                .addComponent(panel4, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
        );
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - ali
    static JPanel panel1;
    static JPanel panel6;
    static JLabel label1;
    static JScrollPane scrollPane1;
    static JPanel panel7;
    static JLabel label20;
    static JLabel label18;
    static JPanel panel13;
    static JLabel label28;
    static JLabel label29;
    static JPanel panel14;
    static JLabel label30;
    static JLabel label31;
    static JPanel panel10;
    static JLabel label2;
    static JPanel panel2;
    static JPanel panel8;
    static JPanel panel12;
    static JLabel label21;
    static JTextField textField1;
    static JLabel label9;
    static JLabel label12;
    static JScrollPane scrollPane2;
    static JPanel panel9;
    static JPanel panel18;
    static JLabel label17;
    static JLabel label19;
    static JButton button1;
    static JLabel label13;
    static JButton button4;
    static JPanel panel3;
    static JScrollPane scrollPane3;
    static JPanel panel5;
    static JPanel panel15;
    static JLabel label5;
    static JLabel label6;
    static JLabel label7;
    static JLabel label8;
    static JButton button2;
    static JButton button3;
    static JPanel panel4;
    static JPanel panel11;
    static JSlider slider1;
    static JButton button11;
    static JButton button12;
    static JButton button13;
    static JButton button15;
    static JButton button5;
    static JButton button14;
    static JButton button16;
    static JButton button6;
    static JLabel label10;
    static JLabel label3;
    static JLabel label4;
    static JPanel panel16;
    static JLabel label11;
    static JSlider slider2;
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

    static ArrayList<OnlinePeoplePanel> onlinePeoplePanels = new ArrayList<>();

    public static void addOnlinePeoplePanel(OnlinePeoplePanel onlinePeoplePanel) {
        onlinePeoplePanels.add(onlinePeoplePanel);
    }

    public static void removeOnlinePeoplePanel(OnlinePeoplePanel onlinePeoplePanel) {
        onlinePeoplePanels.remove(onlinePeoplePanel);
    }

    public static void updateOnlinePeoplePanel () {


        panel5.removeAll();
        for (int j = 0; j < onlinePeoplePanels.size(); j++) {
            panel5.add(onlinePeoplePanels.get(j), new GridBagConstraints(0, j, 1, 1, 0.0, 0.0,
                    GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 2, 0), 0, 0));
            onlinePeoplePanels.get(j).validate();
            onlinePeoplePanels.get(j).repaint();
        }
        panel5.validate();
        panel5.repaint();
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
