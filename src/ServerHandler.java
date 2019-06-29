import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.nio.Buffer;
import java.text.SimpleDateFormat;
import java.util.*;


public class ServerHandler implements Runnable {

    static String currentMusicAddress = "";

    String work;
     String musicNameYouWant;
    static String currenMusic;
    private Socket socket;



    static  String musicName;
    static  String musicArtist;
    static String time;
    //    static HashMap<String, String> request = new HashMap<>();
    static ArrayList<ArrayList<String>> request = new ArrayList<>();

    String userName;



    public ServerHandler(Socket socket, String Order) throws IOException {
        this.socket = socket;
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+socket);
        dos = new DataOutputStream(socket.getOutputStream());
        work=Order;
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$");
    }

    public void setWork(String work) {
        this.work = work;
    }

    static ArrayList<String> sharedlist = new ArrayList<>();


    public final static int FILE_SIZE = 20000000; // file size temporary hard coded
    DataOutputStream dos;
    InputStream iss;
    FileOutputStream fos = null;
    BufferedOutputStream bos = null;

    int bytesRead;
    int current = 0;

    public  void setMusicNameYouWant(String musicNameYouWant) {
        this.musicNameYouWant = musicNameYouWant;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void run() {

        if (work.equals("receiveMusic")) {
            receivingMusic(musicNameYouWant);
        } else if (work.equals("sendCurrentMusic")) {
            sendCurrentMusic();
        } else if (work.equals("shareThePlayList")) {
            sendingSharedlist(sharedlist);
        } else {
            System.out.println("ClientSide : unknown message receieved");
        }

//            sharedlist.add("goli");
//            sharedlist.add("kholi");
//        request.remove(request.get(0));
        try {
            Thread.sleep(15000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void sendCurrentMusic() {

        try {
            dos.writeUTF("sendCurrentMusic");
            dos.writeUTF(musicName);
            dos.writeUTF(musicArtist);
            dos.writeUTF(new Date().getTime() + "");
            dos.writeUTF(Mantegh.username);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void sendingSharedlist(ArrayList<String> sharedlist) {
        try {
            dos.writeUTF("shareThePlayList");
            dos.writeUTF(Mantegh.username);
            ObjectOutputStream ob = new ObjectOutputStream(dos);
            ob.writeObject(sharedlist);
        } catch (Exception e) {
        }
    }


    public void receivingMusic(String string) {

        try {
            dos.writeUTF("receiveFile");
            dos.writeUTF(string);
            dos.writeUTF(userName);
            Thread.sleep(5000);

                String name = "";
                StringTokenizer st = new StringTokenizer(string, "\\");
                while (st.hasMoreTokens()) {
                    name = st.nextToken();
                }
                st = new StringTokenizer(name, ".");
                String finalName = st.nextToken();


            String path = ".\\bin\\OthersSharedList\\" + finalName + ".mp3";
            // receive file
            byte[] mybytearray = new byte[FILE_SIZE];
            InputStream is = socket.getInputStream();
            fos = new FileOutputStream(path);
            bos = new BufferedOutputStream(fos);
            bytesRead = is.read(mybytearray, 0, mybytearray.length);
            current = bytesRead;

            do {
                bytesRead = is.read(mybytearray, current, (mybytearray.length - current));
                if (bytesRead >= 0) current += bytesRead;
            } while (bytesRead > -1);

            bos.write(mybytearray, 0, current);
            bos.flush();
            System.out.println("File " + " downloaded (" + current + " bytes read)");
            Thread.sleep(20000);













                JButton jButton = new JButton(path);
                FileInputStream fileInputStream = new FileInputStream(path);

                String musicTitle = "no name";
                String musicArtist = "no artist name";
                String musicAlbum = "no album name";

                Mp3File mp3file = new Mp3File(path);
                ID3v1 id3v1Tag = null;
                if (mp3file.hasId3v1Tag())
                    id3v1Tag = mp3file.getId3v1Tag();
                if (id3v1Tag != null) {
                    musicTitle = id3v1Tag.getTitle();
                    musicArtist = id3v1Tag.getArtist();
                    musicAlbum = id3v1Tag.getAlbum();
                }

                Music music = new Music(jButton, fileInputStream, Jpotify.mantegh, Mantegh.album, path, Mantegh.nextMusicActionListener, Mantegh.previousButtonActionListener);
                MusicPanel mm = new MusicPanel(new JLabel(musicTitle), new JLabel(musicArtist + " . " + musicAlbum), music.button, music);
                ImageIcon ii = null;
                try {

                    Mp3File mp3file1 = new Mp3File(path);
                    ID3v2 id3v2Tag;
                    if (mp3file1.hasId3v2Tag()) {
                        id3v2Tag = mp3file.getId3v2Tag();
                        byte[] imageData = id3v2Tag.getAlbumImage();
                        if (imageData != null) {System.out.println();
                            BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageData));
                            File outputfile = new File(".\\bin\\images\\musicImages\\" + musicTitle + ".png");
                            ImageIO.write(image, "png", outputfile);
                        }
                    }

                    ii = new ImageIcon(".\\bin\\images\\musicImages\\" + musicTitle + ".png");
                    Image image = ii.getImage().getScaledInstance(250, 250,
                            Image.SCALE_SMOOTH);
                    ii = new ImageIcon(image);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                if (ii != null) {
                    System.out.println();
                    jButton.setIcon(ii);
                    music.button = jButton;
                    music.button.setText("");
                } else
                    music.button.setText("no image !!");
                music.setMusicPanel(mm);
                music.musicName = path;
                music.button = new JButton(path);
                MouseListenerMusiclist.musics.add(0, music);
                MouseListenerMusiclist.musicPanels.add(0, music.musicPanel);
                for (int i = 0; i < Mantegh.allAlbumsName.size(); i++) {
                    if (music.albumName.equals(Mantegh.allAlbumsName.get(i))) {
                        Mantegh.musicsOfAlbums.get(i).add(music.musicName);
                    }
                }

                boolean isThere = true;
                for (MouseListenerSelf mouseListenerSelf : Mantegh.mouseListenersofalbums) {

                    if (mouseListenerSelf.AlbumName.equals(music.albumName)) {
                        isThere = false;

                        mouseListenerSelf.currenAlbumMusics.add(music);
                        mouseListenerSelf.musicPanels.add(music.musicPanel);
                    }
                }
                if (isThere) {
                    ArrayList<String> musicsOfAlbum = new ArrayList<>();
                    musicsOfAlbum.add(music.musicName);
                    AlbumPanel albumPanel = new AlbumPanel(music.albumName, musicsOfAlbum, Mantegh.album.musics);
                    MouseListenerAlbum.albumPanels.add(albumPanel);
                }


                Jpotify.clearCenterPanel();
                for (Music music1 : Mantegh.currentAlbumisShowing)
                    Jpotify.addPanelToCenterPanel(music1.musicPanel);


                try (FileWriter fw = new FileWriter(".\\bin\\allMusics\\allMusicList.txt", false);
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter out = new PrintWriter(bw)) {

                    for (Music music1 : Mantegh.album.musics) {

                        out.println(music1.musicName);
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                Jpotify.clearCenterPanel();
                for (int i = 0; i < Mantegh.currentAlbumisShowing.size(); i++) {
                    Jpotify.addPanelToCenterPanel(Mantegh.currentAlbumisShowing.get(i).musicPanel);
                }












        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (fos != null) fos.close();
                if (bos != null) bos.close();
                if (socket != null) socket.close();
            } catch (Exception e) {
            }
        }
    }
}
