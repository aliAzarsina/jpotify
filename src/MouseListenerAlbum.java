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

        try {
            this.albums = albums;
            this.musicsOfAlbums = musicsOfAlbums;
            this.allmusics = allmusics;

            for (int i = 0; i < albums.size(); i++) {

                AlbumPanel albumPanel = new AlbumPanel(albums.get(i), musicsOfAlbums.get(i), allmusics);

                albumPanels.add(albumPanel);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }






    }
    @Override
    public void mouseClicked(MouseEvent e) {
        Jpotify.clearCenterPanel();

        for (int i = 0; i < albums.size(); i++) {
            Jpotify.addPanelToCenterPanel(albumPanels.get(i));
        }

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
