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
