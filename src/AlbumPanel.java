import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;

public class AlbumPanel extends JPanel {
    JPanel panel1;
    //    static JButton musicImageButton;
    static JLabel musicNameLable;
    static JLabel musicTagLable;
    static Music music;
    static Album album;
    JButton musicImageButton;
    String AlbumName;
    static int K = 0;

    public AlbumPanel (String AlbumNamee,ArrayList<String> albummusics,ArrayList<Music> allmusics){
        this.AlbumName=AlbumNamee;
        this.setBackground(new Color(0,0,0));
        System.out.println();

        musicImageButton=new JButton();
        ImageIcon ii = null;
        try {
            Mp3File mp3File = new Mp3File(albummusics.get(0));
            ID3v2 id3v2Tag;
            if (mp3File.hasId3v2Tag()) {
                id3v2Tag = mp3File.getId3v2Tag();
                byte[] imageData = id3v2Tag.getAlbumImage();
                if (imageData != null) {
                    BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageData));
                    File outputfile = new File(".\\bin\\images\\musicImages\\" + K + ".png");

                    ImageIO.write(image, "png", outputfile);
                    ii = new ImageIcon(".\\bin\\images\\musicImages\\" + K + ".png");
                    Image image1 = ii.getImage().getScaledInstance(250, 250,
                            Image.SCALE_SMOOTH);
                    ii = new ImageIcon(image1);
                }
                K++;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        musicImageButton.setIcon(ii);



        MouseListenerSelf mouseListenerSelf=new MouseListenerSelf(false,AlbumName,allmusics,albummusics);
        Mantegh.mouseListenersofalbums.add(mouseListenerSelf);
        musicImageButton.addMouseListener(mouseListenerSelf);


        musicNameLable = new JLabel();
        musicTagLable = new JLabel();

        //---- musicNameLable ----

        musicNameLable.setText(AlbumNamee);
        musicNameLable.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
        musicNameLable.setVerticalAlignment(SwingConstants.TOP);
        musicNameLable.setForeground(Color.white);

        //---- musicTagLable ----
        ID3v1 id3v1Tag = null;
        try {
            Mp3File mp3file = new Mp3File(albummusics.get(0));
            if (mp3file.hasId3v1Tag())
                id3v1Tag = mp3file.getId3v1Tag();
            if (id3v1Tag.getArtist() != null)
                musicTagLable.setText(id3v1Tag.getArtist());
        } catch (Exception e) {
            e.printStackTrace();
        }
        musicTagLable.setVerticalAlignment(SwingConstants.TOP);
        musicNameLable.setForeground(Color.white);

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
