import javax.swing.*;
import java.awt.*;
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

    public AlbumPanel (String AlbumName,ArrayList<String> albummusics,ArrayList<Music> allmusics){
        this.AlbumName=AlbumName;
        this.setBackground(new Color(102, 102, 102));
        System.out.println();

        musicImageButton=new JButton();
        MouseListenerSelf mouseListenerSelf=new MouseListenerSelf(false,AlbumName,allmusics,albummusics);
        Mantegh.mouseListenersofalbums.add(mouseListenerSelf);
        musicImageButton.addMouseListener(mouseListenerSelf);


        musicNameLable = new JLabel("sssss");
        musicTagLable = new JLabel("sadfafdfsd");

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
