import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ChangethePlaceOfMusicsInPlayList implements MouseListener{


    @Override
    public void mouseClicked(MouseEvent e) {
        String input;
        input = JOptionPane.showInputDialog("index of the current place?");
        String input2;
        input2 = JOptionPane.showInputDialog("index of the current place?");

        MusicPanel musicPanel=Mantegh.thecurrentPlaylistisshowingmouselistener.musicPanels.get(Integer.parseInt(input));
        Music music=Mantegh.thecurrentPlaylistisshowingmouselistener.currenAlbumMusics.get(Integer.parseInt(input));
        Mantegh.thecurrentPlaylistisshowingmouselistener.musicPanels.remove(Integer.parseInt(input));
        Mantegh.thecurrentPlaylistisshowingmouselistener.currenAlbumMusics.remove(Integer.parseInt(input));
        Mantegh.thecurrentPlaylistisshowingmouselistener.currenAlbumMusics.add(Integer.parseInt(input2),music);
        Mantegh.thecurrentPlaylistisshowingmouselistener.musicPanels.add(Integer.parseInt(input2),musicPanel);

        try (FileWriter fw = new FileWriter(Mantegh.thecurrentPlaylistisshowingmouselistener.nameOfPlayListLabel, false);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            for (Music music1:Mantegh.thecurrentPlaylistisshowingmouselistener.currenAlbumMusics) {
                out.println(music1.musicName);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }


        Jpotify.clearCenterPanel();
        for (Music music1 : Mantegh.currentAlbumisShowing)
            Jpotify.addPanelToCenterPanel(music1.musicPanel);

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
