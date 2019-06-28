import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.Socket;

public class OthersSharelistsPanel extends JPanel {
    JLabel othersMusicName;
    JButton download;
    Socket socket;

    OthersSharelistsPanel(String musicName, Socket sockett) {
        othersMusicName = new JLabel();
        download = new JButton();
        socket = sockett;

        download.addMouseListener(new downloadMusicFromFriendMouseListener(socket));

        this.setPreferredSize(new Dimension(340, 30));
        this.setBackground(Color.black);

        //---- label1 ----
        othersMusicName.setText(musicName);
        othersMusicName.setForeground(Color.white);
        othersMusicName.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));

        //---- download ----
        download.setBackground(Color.black);
        download.setIcon(new ImageIcon(".\\Jpotify\\bin\\images\\appImages\\downloadButton.png"));
        download.setBorder(null);
//        download.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                button1MouseEntered(e);
//            }
//            @Override
//            public void mouseExited(MouseEvent e) {
//                button1MouseExited(e);
//            }
//        });

        GroupLayout thisPanelLayout = new GroupLayout(this);
        this.setLayout(thisPanelLayout);
        thisPanelLayout.setHorizontalGroup(
                thisPanelLayout.createParallelGroup()
                        .addGroup(thisPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(othersMusicName, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(download, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        thisPanelLayout.setVerticalGroup(
                thisPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, thisPanelLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(thisPanelLayout.createParallelGroup()
                                        .addComponent(othersMusicName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(download, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
    }
}

