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
    static HashMap<JLabel, ArrayList<String>> playlist2 = new HashMap<>();
    ArrayList<Album> playlistsArray = new ArrayList<>();
    static Album album;
    static Album albumPlayList;
    static Music music;
    static ArrayList<Music> musicArrayList = new ArrayList<>();
    static ArrayList<Music> musicArrayListPlayList = new ArrayList<>();



    static ArrayList<ArrayList<String>> musicsOfAlbums = new ArrayList<>();
    static ArrayList<String> allAlbumsName = new ArrayList<>();


    public Mantegh(final Jpotify jpotify) {


        timeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                    ChangeListener changeListener2 = null;
                    time++;

                    for (ChangeListener changeListener : Jpotify.slider1.getChangeListeners()) {
                        Jpotify.slider1.removeChangeListener(changeListener);
                        changeListener2 = changeListener;
                    }
                    Jpotify.slider1.setValue(Jpotify.slider1.getValue() + 41);
                    PausablePlayer.jsliderValue = Jpotify.slider1.getValue();

                    Jpotify.slider1.addChangeListener(Mantegh.currentPausableplayer);

                    System.out.println(time);

                }
            }
        });
        timeThread.start();
        timeThread.suspend();

        File file = new File(".\\bin\\allMusics\\allMusicList.txt");
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


                //ArrayList<String> musics=new ArrayList<>();
                JButton jButton = new JButton(line);
                FileInputStream fileInputStream = new FileInputStream(line);
                music = new Music(jButton, fileInputStream, this, album, line, nextMusicActionListener, previousButtonActionListener);
                music.setMusicPanel(new MusicPanel(new JLabel(line),new JLabel("mamali"),music.button,music));
//                        System.out.println("ssssssssss");
                System.out.println(line);
                music.musicName = line;
                music.button = new JButton(line);
                album.musics.add(music);
            }
            Jpotify.label29.addMouseListener(new MouseListenerMusiclist(album.musics));
        } catch (Exception e1) {
            e1.printStackTrace();
        }









        for (Music music1:album.musics) { // ali abdollahi method
                    if (allAlbumsName.size() == 0) {
                       allAlbumsName.add(music1.albumName);
                        ArrayList<String> strings=new ArrayList<>();
                     musicsOfAlbums.add(0,strings);
                     strings.add(music1.musicName);
                    }
                    else
                    {
                        boolean test=false;
                        for (int i = 0; i <allAlbumsName.size() ; i++)
                        {
                            if(music1.albumName.equals(allAlbumsName.get(i)))
                            {
                                test=true;
                                musicsOfAlbums.get(i).add(0,music1.musicName);
                            }
                        }
                        if(test==false)
                        {
                            allAlbumsName.add(music1.albumName);
                            ArrayList<String> strings=new ArrayList<>();
                            musicsOfAlbums.add(0,strings);
                            strings.add(music1.musicName);
                        }
                        test=false;
                    }

               }

               Jpotify.label31.addMouseListener(new MouseListenerAlbum(allAlbumsName,musicsOfAlbums,album.musics));





                                                                                                                                    
































        File file1 = new File(".\\bin\\playLists\\playListsAddresses.txt");
        playLists = new HashMap<>();
        ArrayList<String> playlistSongsAddress = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line;
            while ((line = br.readLine()) != null) {
                JLabel jLabel = new JLabel(line);

                String line1;
                File file2 = new File(line);



                try (BufferedReader brr = new BufferedReader(new FileReader(file2))) {
                    while ((line1 = brr.readLine()) != null) {
                         playlistSongsAddress.add(line1);
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                System.out.println("sddddddddddddddddddddddddddddddddddddddddddddddddddddd");
                playlist2.put(jLabel, playlistSongsAddress);
                //musicArrayList = new ArrayList<>();
                Jpotify.addPlayList(jLabel);
                jLabel.addMouseListener(new MouseListenerSelf(album.musics,playlistSongsAddress));
                playlistSongsAddress = new ArrayList<>();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

//        ArrayList<Music> allMusics = new ArrayList<>();
//        try (BufferedReader br = new BufferedReader(new FileReader(".\\bin\\allMusics\\allMusicList.txt"))) {
//            String line;
//
//            while ((line = br.readLine()) != null) {
//                album = new Album(line, musicArrayList, Mantegh.currentAlbum);
//                JButton jButton = new JButton(line);
//                FileInputStream fileInputStream = new FileInputStream(line);
//                music = new Music(jButton, fileInputStream, this, album,line, nextMusicActionListener, previousButtonActionListener);
//                allMusics.add(music);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        Jpotify.label29.addMouseListener(new MouseListenerMusiclist(allMusics));

        for (JLabel jLabel : playLists.keySet()) {
            Jpotify.addPlayList(jLabel);
        }
        System.out.println("mamali");
        for (Album album : playlistsArray)
            for (Music music : album.musics)
//                allMusics.add(music);


                //playlistsArray.get(0).musics.get(0).button = Jpotify.button1;
//        System.out.println("qqqqqqqqqqqqwwwwwwwwwwwwwrrrrrrrrrrtttttttttttt");
                this.jpotify = jpotify;
        previousButtonActionListener = new PreviousButtonActionListener(null, null, null, this);
        nextMusicActionListener = new NextMusicActionListener(null, null, null, this);

        jpotify.button11.addActionListener(previousButtonActionListener);
        jpotify.button15.addActionListener(nextMusicActionListener);
        ArrayList<ArrayList<Album>> PlaylistsAlbums = new ArrayList<>();

//        album1musics=new ArrayList<Music>();
//        album2musics=new ArrayList<Music>();
//        Album album1=new Album("helali",album1musics,currentAlbum);
//       Album album2=new Album("sib",album2musics,currentAlbum);
        ArrayList<Album> albumplaylist;

//       albums.add(album1);
//        albums.add(album2);
//        try {
//
//
//            FileInputStream inputStream = new FileInputStream(playlistsArray.get(0).musics.get(0).musicName);
//            Music music_aa = new Music(Jpotify.button1, inputStream, this, playlistsArray.get(0), playlistsArray.get(0).musics.get(0).musicName, nextMusicActionListener, previousButtonActionListener);
//            playlistsArray.get(0).musics.add(music_aa);
//            FileInputStream inputStream2 = new FileInputStream(".\\a_b.mp3");
//            Music music_ab = new Music(new JButton(), inputStream2, this, playlistsArray.get(0), ".\\a_b.mp3", nextMusicActionListener, previousButtonActionListener);
//            playlistsArray.get(0).musics.add(music_ab);
//
//
//        } catch (Exception e) {
//
//        }

    }


    public void setCurrentAlbum(Album album) {

        this.currentAlbum = album;

    }


    public Thread makeThread(Thread thread, FileInputStream fileInputStream, PausablePlayer pausablePlayer) {
        try {
            if (thread != null) {
                if (currentPausableplayer.t != null) {
                    currentPausableplayer.t.suspend();
                }

                thread.wait();
                Thread.sleep(20000);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }


        currentPausableplayer = pausablePlayer;
        currentthread = new Thread(pausablePlayer);
        return currentthread;
    }


}

