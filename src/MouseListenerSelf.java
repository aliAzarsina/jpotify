
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public  class MouseListenerSelf implements MouseListener {
    ArrayList<Music> musics = new ArrayList<>();
    JButton jButton;
    ArrayList<MusicPanel> musicPanels = new ArrayList<>();


    ArrayList<Music> allMusics;
    ArrayList<String> arrayList;
    ArrayList<Music> currenAlbumMusics=new ArrayList<>();

    public MouseListenerSelf(ArrayList<Music> musics,ArrayList<String> arrayList) {
        Album album=new Album("",new ArrayList<Music>(),Mantegh.currentAlbum);
        this.arrayList=arrayList;
        this.allMusics=musics;
        this.musics = musics;
        for (String str:arrayList) {
            for (int i = 0; i < musics.size(); i++) {
                System.out.println(str + "hhh");
                System.out.println();
                System.out.println(musics.get(i));
                if (str.equals(musics.get(i).musicName)) {
                    musicPanels.add(musics.get(i).musicPanel);
                    currenAlbumMusics.add(musics.get(i));
                }
            }
        }
        System.out.println("yahossein         "+"            ssssssssss"+"  ");


//        jPanel.setBackground(Color.red);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        Jpotify.clearCenterPanel();

        Album album=new Album("",new ArrayList<Music>(),Mantegh.currentAlbum);
        System.out.println(musics.size()+"hoseinnnnnnnnnnnnnn");
        for (int i = 0; i < currenAlbumMusics.size(); i++) {
            Jpotify.addPanelToCenterPanel(musicPanels.get(i));
            album.musics.add(currenAlbumMusics.get(i));
            currenAlbumMusics.get(i).album=album;
        }
        Mantegh.currentAlbum=album;

//        jPanel.validate();
//        jPanel.repaint();
//        Jpotify.addPlayList(new JLabel("salam"));
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
