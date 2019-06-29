import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class OnlinePeoplePanel extends JPanel{

    JLabel userName;
    JLabel lastMusic;
    JLabel lastMusicArtist;
    JLabel lastSeen;
    JButton downloadMusic;
    static JButton getSharelist;
    static Socket socket;
    ArrayList<String> musicNames = new ArrayList<>();
     ArrayList<String> musicAddresses = new ArrayList<>();
    String userName2;////////

    int time = 0;
    int time2 = 0;

    public OnlinePeoplePanel(String userNamee, String lastMusicc, String lastMusicArtistt, int lastSeenn, Socket sockett) {
        socket = sockett;
        userName = new JLabel(userNamee);
        lastMusic = new JLabel(lastMusicc);
        userName2=userNamee;
        lastMusicArtist = new JLabel(lastMusicArtistt);
        lastSeen = new JLabel(lastSeenn + "");
        time = lastSeenn;
        downloadMusic = new JButton();
        downloadMusic.addMouseListener(new downloadMusicFromFriendMouseListener(userName2,lastMusicc));
        getSharelist = new JButton();



        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                if (time != 0) {
                    try {
                        while (true) {
                            Thread.sleep(10000);
                            time2++;
                            lastSeen.setText(time2 + "m");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
        /////////////////////////////////
//        ArrayList<String> temp = new ArrayList<>();
//                for (int i = 0; i < musicAddresses.size(); i++) {
//                    String name = "";
//                    StringTokenizer st = new StringTokenizer(musicAddresses.get(i), "\\");
//                    while (st.hasMoreTokens()) {
//                        name = st.nextToken();
//                    }
//                    st = new StringTokenizer(name, ".");
//                    String finalName = st.nextToken();
//                    temp.add(i, finalName);
//                }
//                musicNames = temp;
//        getSharelist.addMouseListener(new showOthersSharelistButtonMouselistener(musicAddresses,musicNames,socket));
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(musicAddresses);
//        System.out.println(musicNames);




        setBackground(Color.BLACK);

        //---- userName ----
        userName.setText(userNamee);
        userName.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
        userName.setForeground(Color.white);

        //---- lastSeen ----
        if (time == 0)
            lastSeen.setText("online");
        lastSeen.setForeground(Color.white);

        //---- lastMusic ----
        lastMusic.setText(lastMusicc);
        lastMusic.setForeground(Color.lightGray);

        //---- lastMusicArtist ----
        lastMusicArtist.setText(lastMusicArtistt);
        lastMusicArtist.setForeground(Color.lightGray);

        //---- downloadMusic ----
        downloadMusic.setSelectedIcon(new ImageIcon(".\\bin\\images\\appImages\\downloadMusic.png"));
        downloadMusic.setBackground(Color.black);
        downloadMusic.setIcon(new ImageIcon(".\\bin\\images\\appImages\\downloadMusic.png"));
        downloadMusic.setBorderPainted(false);
        downloadMusic.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button2MouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button2MouseExited(e);
            }
        });

        //---- getSharelist ----
        getSharelist.setBackground(Color.black);
        getSharelist.setSelectedIcon(new ImageIcon(".\\bin\\images\\appImages\\othersSharedlistButton.png"));
        getSharelist.setForeground(Color.white);
        getSharelist.setIcon(new ImageIcon(".\\bin\\images\\appImages\\othersSharedlistButton.png"));
        getSharelist.setBorderPainted(false);
        getSharelist.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button3MouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button3MouseExited(e);
            }
        });

        GroupLayout panel15Layout = new GroupLayout(this);
        this.setLayout(panel15Layout);
        panel15Layout.setHorizontalGroup(
                panel15Layout.createParallelGroup()
                        .addGroup(panel15Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel15Layout.createParallelGroup()
                                        .addComponent(userName, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lastMusic, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panel15Layout.createSequentialGroup()
                                                .addComponent(lastMusicArtist, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(getSharelist, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
                                .addGap(3, 3, 3)
                                .addGroup(panel15Layout.createParallelGroup()
                                        .addComponent(downloadMusic, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lastSeen, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel15Layout.setVerticalGroup(
                panel15Layout.createParallelGroup()
                        .addGroup(panel15Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel15Layout.createParallelGroup()
                                        .addComponent(userName, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lastSeen, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lastMusic, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(panel15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lastMusicArtist, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(getSharelist, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(downloadMusic, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3))
        );

    }

     void setShareInit() {
        getSharelist.addMouseListener(new showOthersSharelistButtonMouselistener(musicAddresses,musicNames,socket, userName2));
    }

    public void setMusicNames(ArrayList<String> musicAddresses) {
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < musicAddresses.size(); i++) {
            String name = "";
            StringTokenizer st = new StringTokenizer(musicAddresses.get(i), "\\");
            while (st.hasMoreTokens()) {
                name = st.nextToken();
            }
            st = new StringTokenizer(name, ".");
            String finalName = st.nextToken();
            temp.add(i, finalName);
        }
        musicNames = temp;

    }

    private void button3MouseEntered(MouseEvent e) {
        getSharelist.setIcon(new ImageIcon(".\\bin\\images\\appImages\\othersSharedlistButtonSelected.png"));
    }

    private void button3MouseExited(MouseEvent e) {
        getSharelist.setIcon(new ImageIcon(".\\bin\\images\\appImages\\othersSharedlistButton.png"));
    }

    private void button2MouseEntered(MouseEvent e) {
        downloadMusic.setIcon(new ImageIcon(".\\bin\\images\\appImages\\downloadButtonSelected.png"));
    }

    private void button2MouseExited(MouseEvent e) {
        downloadMusic.setIcon(new ImageIcon(".\\bin\\images\\appImages\\downloadButton.png"));
    }
}
