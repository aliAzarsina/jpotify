import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MusicPanel extends JPanel {
    JPanel panel1;
    static JButton musicImageButton;
    JLabel musicNameLable;
    JLabel musicTagLable;
    Music music;
    static JLabel deleteMusic;
    static JButton addMusicToList;


    public MusicPanel (JLabel musicNameLable1, JLabel musicTagLable1, JButton musicImageButton11, Music music1){
        this.setBackground(new Color(102, 102, 102));
        System.out.println();
        music = music1;
        musicImageButton = musicImageButton11;
        musicImageButton.addActionListener(new MusicActionListener(music.album,music, music.fileInputStream,music.mantegh,music.musicName,music.mantegh.nextMusicActionListener,music.mantegh.previousButtonActionListener));
        musicNameLable = musicNameLable1;
        musicTagLable = musicTagLable1;
        deleteMusic = new JLabel();
        addMusicToList = new JButton();
        addMusicToList.addMouseListener(new AddMusicToListButton(music));

        deleteMusic.addMouseListener(new DeleteMusicListener(music1));


        this.setBackground(new Color(102, 102, 102));

        //---- musicNameLable ----
        musicNameLable.setText("Music Name");
        musicNameLable.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
        musicNameLable.setVerticalAlignment(SwingConstants.TOP);

        //---- musicTagLable ----
        musicTagLable.setText("DetailsOfMusic");
        musicTagLable.setVerticalAlignment(SwingConstants.TOP);

        //---- button1 ----
//        button1.setText("text");

        //---- deleteMusic ----
        deleteMusic.setIcon(new ImageIcon(".\\bin\\images\\appImages\\trashButton.png"));
        deleteMusic.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                label13MouseEntered(e);
//            }
//            @Override
//            public void mouseExited(MouseEvent e) {
//                label13MouseExited(e);
//            }
        });

        //---- addMusicToList ----
        addMusicToList.setBackground(new Color(102, 102, 102));
        addMusicToList.setIcon(new ImageIcon(".\\bin\\images\\appImages\\addButtonNoBackground.png"));
        addMusicToList.setBorder(null);
        addMusicToList.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                button4MouseEntered(e);
//            }
//            @Override
//            public void mouseExited(MouseEvent e) {
//                button4MouseExited(e);
//            }
        });

        GroupLayout thisLayout = new GroupLayout(this);
        this.setLayout(thisLayout);
        thisLayout.setHorizontalGroup(
                thisLayout.createParallelGroup()
                        .addGroup(thisLayout.createSequentialGroup()
                                .addGroup(thisLayout.createParallelGroup()
                                        .addComponent(musicNameLable, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(musicTagLable, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(thisLayout.createParallelGroup()
                                        .addComponent(deleteMusic, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addMusicToList, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(14, Short.MAX_VALUE))
                        .addComponent(musicImageButton, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
        );
        thisLayout.setVerticalGroup(
                thisLayout.createParallelGroup()
                        .addGroup(thisLayout.createSequentialGroup()
                                .addComponent(musicImageButton11, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(thisLayout.createParallelGroup()
                                        .addComponent(musicNameLable)
                                        .addComponent(addMusicToList, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(thisLayout.createParallelGroup()
                                        .addComponent(musicTagLable, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteMusic, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
        );
    }


}
