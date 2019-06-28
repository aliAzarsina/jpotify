
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
    String AlbumName;
    String nameOfPlayListLabel;
    boolean istheplaylist;

    public MouseListenerSelf(boolean istheplaylist,String AlbumName,ArrayList<Music> musics,ArrayList<String> arrayList) {

        this.istheplaylist=istheplaylist;
        this.AlbumName=AlbumName;
        Album album=new Album("",new ArrayList<Music>(),Mantegh.currentAlbum);
        this.arrayList=arrayList;
        this.allMusics=musics;
        this.musics = musics;

        try {
            for (int i = 0; i < musics.size(); i++) {
                for (String str : arrayList) {

                    if (str.equals(musics.get(i).musicName)) {
                        musicPanels.add(musics.get(i).musicPanel);
                        currenAlbumMusics.add(musics.get(i));
                        break;
                    }
                }
            }
        }catch (Exception e2)
        {

        }



    }
    @Override
    public void mouseClicked(MouseEvent e) {
        Jpotify.clearCenterPanel();
        if(istheplaylist==true)
        {
            Mantegh.isthecurrentplaylist=true;
            Mantegh.thecurrentPlaylistisshowingmouselistener=this;
        }
        else
        {
            Mantegh.isthecurrentplaylist=false;
        }

        Album album=new Album("",new ArrayList<Music>(),Mantegh.currentAlbum);
        for (int i = 0; i < currenAlbumMusics.size(); i++) {
            Jpotify.addPanelToCenterPanel(musicPanels.get(i));
            album.musics.add(musicPanels.get(i).music);
            currenAlbumMusics.get(i).album=album;
        }

        Mantegh.currentAlbum=album;
        Mantegh.currentAlbumisShowing=currenAlbumMusics;





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
