import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Mantegh {
    Jpotify jpotify;
    Thread currentthread;
    FileInputStream fileInputStream;
    Advanceplayer advanceplayer;
    PausablePlayer pausablePlayer;
    //Album currentAlbum;
    ArrayList<Music> album1musics;
    ArrayList<Music> album2musics;
    static PausablePlayer currentPausableplayer;
    PreviousButtonActionListener previousButtonActionListener;
    NextMusicActionListener nextMusicActionListener;
    //static ArrayList<ChangeListener1>changeListeners=new ArrayList<>();
//    ArrayList<Album> albums = new ArrayList<>();
    static Album currentAlbum;
    static PausablePlayer currentPusableplayer;
    static int time = 0;
    static Thread timeThread;

    static HashMap<JLabel, Album> playLists;
    ArrayList<Album>playlistsArray=new ArrayList<>();
    static Album album;
    static Music music;
    static ArrayList<Music> musicArrayList = new ArrayList<>();


    public Mantegh(final Jpotify jpotify)
    {



        timeThread=new Thread(new Runnable() {
            @Override
            public void run() {
                while(true)
                {
                    try {
                        Thread.sleep(1000);
                    }
                    catch (Exception e)
                    {
                    }
                    ChangeListener changeListener2=null;
                    time++;

                    for(ChangeListener changeListener:Jpotify.slider1.getChangeListeners())
                    { Jpotify.slider1.removeChangeListener(changeListener);
                    changeListener2=changeListener;
                    }
                    Jpotify.slider1.setValue(Jpotify.slider1.getValue()+41);
                    PausablePlayer.jsliderValue=Jpotify.slider1.getValue();

                    Jpotify.slider1.addChangeListener(Mantegh.currentPausableplayer);

                    System.out.println(time);

                }
            }
        });
        timeThread.start();
        timeThread.suspend();

        File file = new File(".\\bin\\playLists\\playListsAddresses.txt");
        playLists = new HashMap<>();


        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {

                album = new Album(line, musicArrayList, Mantegh.currentAlbum);
                JLabel jLabel = new JLabel(line);



                playLists.put(jLabel, album);
                playlistsArray.add(album);

                File file1 = new File(line);
                album.name = line;
//                System.out.println(line+"hasannnnnn");

                try (BufferedReader brr = new BufferedReader(new FileReader(file1))) {
                    String line1;


                    //ArrayList<String> musics=new ArrayList<>();
                    while ((line1 = brr.readLine()) != null) {
                        JButton jButton = new JButton(line1);
                        FileInputStream fileInputStream = new FileInputStream(line1);

                        music = new Music(jButton, fileInputStream, this, album, line1, nextMusicActionListener, previousButtonActionListener);
//                        System.out.println("ssssssssss");
                        System.out.println(line1);
                        music.musicName = line1;
                        music.button = new JButton(line1);
                        album.musics.add(music);


                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
//                System.out.println(album.musics.size()+"aliiiiiiiiiiiiiiiiiii");
                musicArrayList=new ArrayList<>();
                jLabel.addMouseListener(new MouseListenerSelf(album.musics));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<Music> centerMusics = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(".\\bin\\allMusics\\allMusicList.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                Jpotify.addSongToList(new JLabel(line));
            }
        } catch (Exception e) {}

        for(JLabel jLabel: playLists.keySet()) {
            Jpotify.addPlayList(jLabel);
        }
        System.out.println("mamali");
//        for (Album album:playlistsArray)
//            for (Music music:album.musics)
//                centerMusics.add(music);
//        Jpotify.label29.addMouseListener(new MouseListenerMusiclist(centerMusics));



        //playlistsArray.get(0).musics.get(0).button = Jpotify.button1;
//        System.out.println("qqqqqqqqqqqqwwwwwwwwwwwwwrrrrrrrrrrtttttttttttt");
        this.jpotify = jpotify;
        previousButtonActionListener=new PreviousButtonActionListener(null,null,null,this);
        nextMusicActionListener=new NextMusicActionListener(null,null,null,this);

        jpotify.button11.addActionListener(previousButtonActionListener);
        jpotify.button15.addActionListener(nextMusicActionListener);
        ArrayList<ArrayList<Album>> PlaylistsAlbums=new ArrayList<>();

//        album1musics=new ArrayList<Music>();
//        album2musics=new ArrayList<Music>();
//        Album album1=new Album("helali",album1musics,currentAlbum);
//       Album album2=new Album("sib",album2musics,currentAlbum);
        ArrayList<Album> albumplaylist;

//       albums.add(album1);
//        albums.add(album2);
       try {


            FileInputStream inputStream = new FileInputStream(playlistsArray.get(0).musics.get(0).musicName);
            Music music_aa = new Music(Jpotify.button1,inputStream,this,playlistsArray.get(0),playlistsArray.get(0).musics.get(0).musicName,nextMusicActionListener,previousButtonActionListener);
            playlistsArray.get(0).musics.add(music_aa);
            FileInputStream inputStream2 = new FileInputStream(".\\a_b.mp3");
            Music music_ab = new Music(new JButton(),inputStream2,this,playlistsArray.get(0),".\\a_b.mp3",nextMusicActionListener,previousButtonActionListener);
           playlistsArray.get(0).musics.add(music_ab);


       }
       catch (Exception e)
       {

        }

    }




    public void setCurrentAlbum(Album album)
    {

        this.currentAlbum=album;

    }


    public Thread makeThread (Thread thread,FileInputStream fileInputStream,PausablePlayer pausablePlayer)
    { try
    {
        if(thread!=null)
        {
            if( currentPausableplayer.t!=null)
            {currentPausableplayer.t.suspend();}

            thread.wait();
        Thread.sleep(20000);}
       }
        catch (Exception e2)
        {
           e2.printStackTrace();
        }


        currentPausableplayer=pausablePlayer;
        currentthread=new Thread(pausablePlayer) ;
        return currentthread;
    }



    }

