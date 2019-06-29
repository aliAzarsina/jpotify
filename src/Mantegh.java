import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Mantegh {
    Jpotify jpotify;
    Thread currentthread;
    FileInputStream fileInputStream;
    Advanceplayer advanceplayer;
    PausablePlayer pausablePlayer;
    static PausablePlayer currentPausableplayer;
    static PreviousButtonActionListener previousButtonActionListener;
    static NextMusicActionListener nextMusicActionListener;
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

    static ArrayList<Music> currentAlbumisShowing;

    static ArrayList<MouseListenerSelf> mouselistenersOfPlayLists=new ArrayList<>();
    static ArrayList<JLabel> labelsOfPlayLists=new ArrayList<>();
    static boolean isthecurrentplaylist=false;
    static MouseListenerSelf thecurrentPlaylistisshowingmouselistener;

    static ArrayList<MouseListenerSelf> mouseListenersofalbums=new ArrayList<>();


    static String username="aliazarsina";
    static int musictime=0;






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
                    if(time<musictime)
                    {time++;}

                    for (ChangeListener changeListener : Jpotify.slider1.getChangeListeners()) {
                        Jpotify.slider1.removeChangeListener(changeListener);
                        changeListener2 = changeListener;
                    }
                    Jpotify.slider1.setValue(Jpotify.slider1.getValue() + 41);
                    PausablePlayer.jsliderValue = Jpotify.slider1.getValue();

                    Jpotify.slider1.addChangeListener(Mantegh.currentPausableplayer);



                    Jpotify.label10.setText(time/60+":"+time%60+"/"+musictime/60+":"+musictime%60);
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
                ImageIcon ii = null;
                String musicTitle = "no name";
                String musicArtist = "no artist name";
                String musicAlbum = "no album name";
                try {
                    Mp3File mp3file = new Mp3File(line);
                    ID3v2 id3v2Tag;
                    ID3v1 id3v1Tag = null;
                    if (mp3file.hasId3v1Tag())
                        id3v1Tag = mp3file.getId3v1Tag();
                    if (mp3file.hasId3v2Tag()) {
                        id3v2Tag = mp3file.getId3v2Tag();
                        if (id3v1Tag != null) {
                            musicTitle = id3v1Tag.getTitle();
                            musicArtist = id3v1Tag.getArtist();
                            musicAlbum = id3v1Tag.getAlbum();
                        }
                        byte[] imageData = id3v2Tag.getAlbumImage();
                        if (imageData != null) {
                            BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageData));
                            File outputfile = new File(".\\bin\\images\\musicImages\\" + musicTitle + ".png");
                            ImageIO.write(image, "png", outputfile);
                        }
                    }

                    ii = new ImageIcon(".\\bin\\images\\musicImages\\" + musicTitle + ".png");
                    Image image = ii.getImage().getScaledInstance(250, 250,
                            Image.SCALE_SMOOTH);
                    ii = new ImageIcon(image);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                playLists.put(jLabel, album);
                playlistsArray.add(album);

                File file1 = new File(line);
                album.name = line;
                JButton jButton;
                if (ii != null) {
                    jButton = new JButton(ii);
                    jButton.setText("");
                }
                else
                    jButton = new JButton("no music image");
                FileInputStream fileInputStream = new FileInputStream(line);
                music = new Music(jButton, fileInputStream, this, album, line, nextMusicActionListener, previousButtonActionListener);
                music.setMusicPanel(new MusicPanel(new JLabel(musicTitle),new JLabel(musicArtist + " . " + musicAlbum),music.button,music));
                music.musicName = line;
                music.button = new JButton(line);
                album.musics.add(music);
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        Jpotify.label29.addMouseListener(new MouseListenerMusiclist(album.musics));







        for (Music music1:album.musics) {
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
                        musicsOfAlbums.get(i).add(music1.musicName);
                    }
                }
                if(test==false)
                {
                    allAlbumsName.add(music1.albumName);
                    ArrayList<String> strings=new ArrayList<>();
                    musicsOfAlbums.add(strings);
                    strings.add(music1.musicName);
                }
                test=false;
            }

        }

        Jpotify.label31.addMouseListener(new MouseListenerAlbum(allAlbumsName,musicsOfAlbums,album.musics));

        Jpotify.label28.addMouseListener(new AddNewMusicActionListener());


        Jpotify.label18.addMouseListener(new AddNewSharedListButton());

        Jpotify.button14.addMouseListener(new ChangeNameOfPlayLIst());
        Jpotify.button16.addMouseListener(new DeletePlayList());
        Jpotify.button6.addMouseListener(new ChangethePlaceOfMusicsInPlayList());





        Thread clientThread = new Thread(new ClientSide());
        clientThread.start();


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

                playlist2.put(jLabel, playlistSongsAddress);
                Jpotify.addPlayList(jLabel);
                MouseListenerSelf mouseListenerSelf=new MouseListenerSelf(true,line,album.musics,playlistSongsAddress);
                jLabel.addMouseListener(mouseListenerSelf);
                mouselistenersOfPlayLists.add(mouseListenerSelf);
                mouseListenerSelf.nameOfPlayListLabel=jLabel.getText();
                labelsOfPlayLists.add(jLabel);
                playlistSongsAddress = new ArrayList<>();

                if(line.equals(".\\bin\\sharedList.txt")) {
                    for (int j = 0; j < mouseListenerSelf.currenAlbumMusics.size(); j++) {
                        ServerHandler.sharedlist.add(mouseListenerSelf.currenAlbumMusics.get(j).musicName);

                    }
                    for (int j = 0; j < ClientSide.ipList.size(); j++) {

                        ClientSide.sendingSharedList();

                    }
                }




            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        /////////اینجا تکست لیبل توکنایز شود با اری لیست labelsOfplaylists
        for (int i = 0; i < labelsOfPlayLists.size(); i++) {
            String name = "";
            StringTokenizer st = new StringTokenizer(labelsOfPlayLists.get(i).getText(), "\\");
            while (st.hasMoreTokens()) {
                name = st.nextToken();
            }
            st = new StringTokenizer(name, ".");
            String finalName = st.nextToken();
            labelsOfPlayLists.get(i).setText(finalName);
        }











        //System.out.println("fffffffffffffffffffffffff"+Mantegh.labelsOfPlayLists.get(0).getText());

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

