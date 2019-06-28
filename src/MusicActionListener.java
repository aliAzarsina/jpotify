import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.ArrayList;

public class MusicActionListener implements ActionListener {

    ArrayList<Music> musics;
    Music music;
    FileInputStream fileInputStream;
    static Mantegh mantegh;
    Album album;
    Advanceplayer advanceplayer;
    PausablePlayer pausablePlayer;
    String musicName;
    NextMusicActionListener nextMusicActionListener;
    PreviousButtonActionListener previousButtonActionListener;

    public MusicActionListener(Album album, Music music, FileInputStream fileInputStream,Mantegh mantegh,String musicName,NextMusicActionListener nextMusicActionListener,PreviousButtonActionListener previousButtonActionListener)
    {
        this.nextMusicActionListener=nextMusicActionListener;
        this.previousButtonActionListener=previousButtonActionListener;
        this.musicName=musicName;
        this.album=album;
        this.mantegh=mantegh;
        this.fileInputStream=fileInputStream;
        this.musics=album.musics;
        this.music=music;



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {


            for (int i = 0; i < Mantegh.allAlbumsName.size(); i++) {
                String string=Mantegh.allAlbumsName.get(i);

                if(string.equals(music.albumName))
                {
                    System.out.println("llllllllllllllllllllllllllllllllllllllllllllllllllllll");
                    ArrayList<String> musicName=Mantegh.musicsOfAlbums.get(i);
                    Mantegh.allAlbumsName.remove(i);
                    Mantegh.musicsOfAlbums.remove(i);
                    Mantegh.allAlbumsName.add(0,music.musicName);
                    Mantegh.musicsOfAlbums.add(0,musicName);
                }

            }

            //         for (int i = 0; i < MouseListenerMusiclist.musics.size(); i++) {
            //             String string=MouseListenerMusiclist.musics.get(i).musicName;

////                if(string.equals(music.musicName))
////                {
////                   Music music=MouseListenerMusiclist.musics.get(i);
////                   MouseListenerMusiclist.musics.remove(i);
////                   MouseListenerMusiclist.musics.add(0,music);
////                    System.out.println("llllllllllllllllllllllllllllllllllllllllllllllllsssssssssss");
////                   MusicPanel musicPanel=MouseListenerMusiclist.musicPanels.get(i);
////                   MouseListenerMusiclist.musicPanels.remove(i);
////                   MouseListenerMusiclist.musicPanels.add(0,musicPanel);
////
////                }
////
////            }




            NextMusicActionListener.currentAlbum=Mantegh.currentAlbum;
            PreviousButtonActionListener.currentAlbum=Mantegh.currentAlbum;
            NextMusicRunnable.currentAlbum=Mantegh.currentAlbum;

            //NextMusicActionListener.currentAlbum=music.album;
            //System.out.println("ججججججججججججججججججججججججججج");

            setCurrentAlbum();
            //
            //
            //
            //
            //
            //
            if(Mantegh.currentPausableplayer!=null)

            {
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaa"+Mantegh.currentPausableplayer.musicName);


                Mantegh.currentPausableplayer.fileInputStream.close();
                Mantegh.currentPausableplayer.t.suspend();
                Mantegh.currentPausableplayer.t=null;}

            fileInputStream=new FileInputStream(musicName);
            advanceplayer = new Advanceplayer(fileInputStream);
            if(Mantegh.currentPausableplayer!=null)
            {

                Mantegh.currentPausableplayer.t=null;
                Mantegh.currentPausableplayer.fileInputStream.close();

            }

            pausablePlayer = new PausablePlayer(fileInputStream, mantegh.jpotify, mantegh.jpotify.slider1, mantegh.jpotify.button12, mantegh.jpotify.button13,musicName);


            Mantegh.currentPausableplayer=pausablePlayer;


            SliderChangeListener.setPausablePlayer(pausablePlayer);
            SliderChangeListener.musicName(musicName);

            mantegh.jpotify.slider1.setMaximum(advanceplayer.calculateframes());
            mantegh.jpotify.slider1.setMinimum(0);
            fileInputStream.getChannel().position(0);
            mantegh.makeThread(mantegh.currentthread, fileInputStream,pausablePlayer);

            mantegh.jpotify.button12.addActionListener(new Actionlisten2(mantegh.currentthread));
            mantegh.jpotify.button13.addActionListener(new Actionlisten(mantegh.currentthread));
            mantegh.currentAlbum = album;

            PausablePlayer.shomarande=0;
            mantegh.currentthread.start();
            System.out.println("mohammad");
            NextMusicActionListener.changeCurrentMusic(music);
            //NextMusicRunnable.changeCurrentAlbum(album);

            PreviousButtonActionListener.changeCurrentMusic(music);

            NextMusicRunnable.musicName=music.musicName;
            Mantegh.currentAlbum=album;
            // PreviousButtonActionListener.changeCurrentAlbum(album);
            //NextMusicActionListener.changeCurrentAlbum(album);
            // NextMusicRunnable.changeCurrentAlbum(album);

        }
        catch (Exception e1)
        {

        }
    }


    public void setCurrentAlbum()
    {
        mantegh.setCurrentAlbum(album);
    }






}

