import javax.swing.*;
import java.awt.*;

public class MusicPanel extends JPanel {
    JPanel panel1;
    static JButton musicImageButton;
    JLabel musicNameLable;
    JLabel musicTagLable;
    Music music;

    public MusicPanel (JLabel musicNameLable1, JLabel musicTagLable1, JButton musicImageButton11, Music music1){
        this.setBackground(new Color(102, 102, 102));
        System.out.println();
        music = music1;
        musicImageButton = musicImageButton11;
        musicImageButton.addActionListener(new MusicActionListener(music.album,music, music.fileInputStream,music.mantegh,music.musicName,music.mantegh.nextMusicActionListener,music.mantegh.previousButtonActionListener));
        musicNameLable = musicNameLable1;
        musicTagLable = musicTagLable1;

        //---- musicImageButton ----
//        musicImageButton.setIcon(null);
//        musicImageButton.setBackground(new Color(0, 102, 102));
//        musicImageButton.setText("ImageOfMusic");
        //musicImageButton.addActionListener();

        //---- musicNameLable ----
        musicNameLable.setText("Music Name");
        musicNameLable.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
        musicNameLable.setVerticalAlignment(SwingConstants.TOP);

        //---- musicTagLable ----
        musicTagLable.setText("DetailsOfMusic");
        musicTagLable.setVerticalAlignment(SwingConstants.TOP);

        GroupLayout thisLayout = new GroupLayout(this);
        this.setLayout(thisLayout);
        thisLayout.setHorizontalGroup(
                thisLayout.createParallelGroup()
                        .addGroup(thisLayout.createSequentialGroup()
                                .addGroup(thisLayout.createParallelGroup()
                                        .addComponent(musicImageButton, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(musicNameLable, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(musicTagLable, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0))
        );
        thisLayout.setVerticalGroup(
                thisLayout.createParallelGroup()
                        .addGroup(thisLayout.createSequentialGroup()
                                .addComponent(musicImageButton, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(musicNameLable)
                                .addGap(0, 0, 0)
                                .addComponent(musicTagLable, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
        );
    }
}
