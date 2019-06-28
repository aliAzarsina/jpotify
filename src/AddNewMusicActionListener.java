//label128


import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

                Music music = new Music(jButton, fileInputStream, Jpotify.mantegh, Mantegh.album, line, Mantegh.nextMusicActionListener, Mantegh.previousButtonActionListener);
                music.setMusicPanel(new MusicPanel(new JLabel(line), new JLabel("mamali"), music.button, music));
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
