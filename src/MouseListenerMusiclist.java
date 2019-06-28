import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class MouseListenerMusiclist implements MouseListener {
    static ArrayList<MusicPanel> musicPanels = new ArrayList<>();
    static ArrayList<Music> musics;

    public MouseListenerMusiclist(ArrayList<Music> musicss) {
        musics = musicss;
        System.out.println("aliabd024");
        if(musicss.size()!=0) {
            for (int i = 0; i < musics.size(); i++) {
                musicPanels.add(musicss.get(i).musicPanel);
            }
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        Mantegh.isthecurrentplaylist=false;

        Jpotify.clearCenterPanel();
        Album album=new Album("",new ArrayList<Music>(),Mantegh.currentAlbum);

        if(musics.size()!=0)
        {for (int i = 0; i < musics.size(); i++) {

            Jpotify.addPanelToCenterPanel(musicPanels.get(i));
            album.musics.add(musics.get(i));
        }}

        Mantegh.currentAlbumisShowing=musics;
        Mantegh.currentAlbum=album;
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
