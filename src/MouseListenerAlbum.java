import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public  class MouseListenerAlbum implements MouseListener {
    ArrayList<Music> musics = new ArrayList<>();
    JButton jButton;
    ArrayList<AlbumPanel> albumPanels= new ArrayList<>();
    ArrayList<ArrayList<String>> musicsOfAlbums;
    ArrayList<String> albums;
    ArrayList<Music> allmusics;

    public MouseListenerAlbum(ArrayList<String> albums,ArrayList<ArrayList<String>> musicsOfAlbums,ArrayList<Music> allmusics) {

        this.albums=albums;
        this.musicsOfAlbums=musicsOfAlbums;
        this.allmusics=allmusics;




    }
    @Override
    public void mouseClicked(MouseEvent e) {
        Jpotify.clearCenterPanel();
        for (int i = 0; i <albums.size() ; i++) {

            AlbumPanel albumPanel=new AlbumPanel(musicsOfAlbums.get(i),allmusics);

            albumPanels.add(albumPanel);
        }
        for (int i = 0; i < albums.size(); i++) {
            Jpotify.addPanelToCenterPanel(albumPanels.get(i));
        }

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
