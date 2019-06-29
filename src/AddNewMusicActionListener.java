//label128


import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.*;

public class AddNewMusicActionListener implements MouseListener{


    @Override
    public void mouseClicked(MouseEvent e) {

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            String line=selectedFile.getAbsolutePath();
            try {
                JButton jButton = new JButton(line);
                FileInputStream fileInputStream = new FileInputStream(line);

                String musicTitle = "no name";
                String musicArtist = "no artist name";
                String musicAlbum = "no album name";

                Mp3File mp3file = new Mp3File(line);
                ID3v1 id3v1Tag = null;
                if (mp3file.hasId3v1Tag())
                    id3v1Tag = mp3file.getId3v1Tag();
                if (id3v1Tag != null) {
                    musicTitle = id3v1Tag.getTitle();
                    musicArtist = id3v1Tag.getArtist();
                    musicAlbum = id3v1Tag.getAlbum();
                }

                Music music = new Music(jButton, fileInputStream, Jpotify.mantegh, Mantegh.album, line, Mantegh.nextMusicActionListener, Mantegh.previousButtonActionListener);
                MusicPanel mm = new MusicPanel(new JLabel(musicTitle),new JLabel(musicArtist + " . " + musicAlbum),music.button,music);
                ImageIcon ii = null;
                try {
                    Mp3File mp3file1 = new Mp3File(line);
                    ID3v2 id3v2Tag;
                    if (mp3file1.hasId3v2Tag()) {
                        id3v2Tag = mp3file.getId3v2Tag();
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

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                if (ii != null) {
                    jButton.setIcon(ii);
                    music.button = jButton;
                    music.button.setText("");
                }
                else
                    music.button.setText("no image !!");
                music.setMusicPanel(mm);
                music.musicName = line;
                music.button = new JButton(line);
                MouseListenerMusiclist.musics.add(0,music);
                MouseListenerMusiclist.musicPanels.add(0,music.musicPanel);
                for (int i = 0; i <Mantegh.allAlbumsName.size() ; i++) {
                    if(music.albumName.equals(Mantegh.allAlbumsName.get(i)))
                    {
                        Mantegh.musicsOfAlbums.get(i).add(music.musicName);
                    }
                }


                for(MouseListenerSelf mouseListenerSelf:Mantegh.mouseListenersofalbums)
                {
                    if(mouseListenerSelf.AlbumName.equals(music.albumName))
                    {

                        mouseListenerSelf.currenAlbumMusics.add(music);
                        mouseListenerSelf.musicPanels.add(music.musicPanel);
                    }
                }

                Jpotify.clearCenterPanel();
                for (Music music1 : Mantegh.currentAlbumisShowing)
                    Jpotify.addPanelToCenterPanel(music1.musicPanel);


                try (FileWriter fw = new FileWriter(".\\bin\\allMusics\\allMusicList.txt", false);
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter out = new PrintWriter(bw)) {

                    for(Music music1:Mantegh.album.musics)
                    {
                        System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
                        out.println(music1.musicName);}
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                Jpotify.clearCenterPanel();
                for (int i = 0; i < Mantegh.currentAlbumisShowing.size(); i++) {
                    Jpotify.addPanelToCenterPanel(Mantegh.currentAlbumisShowing.get(i).musicPanel);
                }

            }catch (Exception e1)
            {}




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
