

import javax.swing.*;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Music {
    JButton button;
    ArrayList<Music>musics;
    FileInputStream fileInputStream;
    Mantegh mantegh;
    Album album;
    String musicName;
    String reallyMusicName;
    NextMusicActionListener nextMusicActionListener;
    PreviousButtonActionListener previousButtonActionListener;
    MusicPanel musicPanel;
    String albumName="aa";

    public Music (JButton button,FileInputStream fileInputStream,Mantegh mantegh,Album album,String musicName,NextMusicActionListener nextMusicActionListener,PreviousButtonActionListener previousButtonActionListener)
    {
        this.nextMusicActionListener=nextMusicActionListener;
        this.previousButtonActionListener=previousButtonActionListener;
        this.musicName=musicName;
        this.album=album;
        this.mantegh=mantegh;
        this.fileInputStream=fileInputStream;
        this.musics=album.musics;
        this.button=button;

//        try {
//            Mp3File mp3file = new Mp3File(musicName);
//            ID3v1 id3v1Tag = null;
//            if (mp3file.hasId3v1Tag())
//                id3v1Tag = mp3file.getId3v1Tag();
//            if (id3v1Tag.getAlbum() != null)
//                albumName = id3v1Tag.getAlbum();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        setTheActionListener();
    }

    public void setMusicPanel(MusicPanel musicPanel) {
        this.musicPanel = musicPanel;
    }

    public void setTheActionListener()
    {
        button.addActionListener(new MusicActionListener(album,this,fileInputStream,mantegh,musicName,nextMusicActionListener,previousButtonActionListener));
        System.out.println("سسسسسسسسسسسسسسسسسسسس");

    }



}
