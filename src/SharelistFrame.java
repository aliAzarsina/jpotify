/*
 * Created by JFormDesigner on Fri Jun 28 00:16:07 IRDT 2019
 */

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author ali
 */
public class SharelistFrame extends JFrame {
    public SharelistFrame() {
        initComponents();
    }

    private void button1MouseEntered(MouseEvent e) {
        button1.setIcon(new ImageIcon(".\\Jpotify\\bin\\images\\appImages\\downloadButtonSelected.png"));
    }

    private void button1MouseExited(MouseEvent e) {
        button1.setIcon(new ImageIcon(".\\Jpotify\\bin\\images\\appImages\\downloadButton.png"));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - ali
        scrollPane1 = new JScrollPane();
        panel1 = new JPanel();
        panel2 = new JPanel();
        label1 = new JLabel();
        button1 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(" Jpotify _ ShareList");
        setIconImage(new ImageIcon(".\\bin\\images\\appImages\\jpotifyLogo.png").getImage());
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

            //======== panel1 ========
            {
                panel1.setBackground(new Color(51, 51, 51));

                // JFormDesigner evaluation mark
                panel1.setBorder(new javax.swing.border.CompoundBorder(
                        new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                                java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                panel1.setLayout(new GridBagLayout());
                ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {356, 0};
                ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {22, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 30, 0};
                ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 1.0E-4};
                ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //======== panel2 ========
                {
                    panel2.setPreferredSize(new Dimension(340, 30));
                    panel2.setBackground(Color.black);

                    //---- label1 ----
                    label1.setText("text");
                    label1.setForeground(Color.white);
                    label1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));

                    //---- button1 ----
                    button1.setBackground(Color.black);
                    button1.setIcon(new ImageIcon(".\\Jpotify\\bin\\images\\appImages\\downloadButton.png"));
                    button1.setBorder(null);
                    button1.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            button1MouseEntered(e);
                        }
                        @Override
                        public void mouseExited(MouseEvent e) {
                            button1MouseExited(e);
                        }
                    });

                    GroupLayout panel2Layout = new GroupLayout(panel2);
                    panel2.setLayout(panel2Layout);
                    panel2Layout.setHorizontalGroup(
                            panel2Layout.createParallelGroup()
                                    .addGroup(panel2Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap())
                    );
                    panel2Layout.setVerticalGroup(
                            panel2Layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                            .addGap(2, 2, 2)
                                            .addGroup(panel2Layout.createParallelGroup()
                                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                            .addContainerGap())
                    );
                }
                panel1.add(panel2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 2, 0), 0, 0));
            }
            scrollPane1.setViewportView(panel1);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1)
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 548, GroupLayout.PREFERRED_SIZE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - ali
    static JScrollPane scrollPane1;
    static JPanel panel1;
    static JPanel panel2;
    static JLabel label1;
    static JButton button1;
    static ArrayList<OthersSharelistsPanel> othersSharelistsPanels = new ArrayList<>();
    // JFormDesigner - End of variables declaration  //GEN-END:variables
//    int I
    void  addPanel (OthersSharelistsPanel othersSharelistsPanel) {
        othersSharelistsPanels.add(othersSharelistsPanel);
    }
    void updatePanels () {
        panel1.removeAll();
        for (int i = 0; i < othersSharelistsPanels.size(); i++) {
            panel1.add(othersSharelistsPanels.get(i), new GridBagConstraints(0, i, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 2, 0), 0, 0));
        }
        panel1.validate();
        panel1.repaint();
        scrollPane1.validate();
        scrollPane1.repaint();
    }
}
