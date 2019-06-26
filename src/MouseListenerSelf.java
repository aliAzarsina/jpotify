
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public  class MouseListenerSelf implements MouseListener {
    ArrayList<Music> musics = new ArrayList<>();
    JButton jButton;
    ArrayList<MusicPanel> musicPanels = new ArrayList<>();

    public MouseListenerSelf(ArrayList<Music> musics) {
        this.musics = musics;
        for (int i = 0; i < musics.size(); i++) {
            System.out.println("alasjlkjdsls");
            musicPanels.add(new MusicPanel(new JLabel(musics.get(i).musicName), new JLabel("mamali"),musics.get(i).button,musics.get(i)));
            System.out.println(musics.get(i).musicName+"qqqqqqqqqqqqqqqqqqqqqqqq");
        }
//        jPanel.setBackground(Color.red);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        Jpotify.clearCenterPanel();
        System.out.println(musics.size()+"hoseinnnnnnnnnnnnnn");
        for (int i = 0; i < musics.size(); i++) {
            System.out.println(musics.get(i).musicName);
            Jpotify.addPanelToCenterPanel(musicPanels.get(i));
        }

//        jPanel.validate();
//        jPanel.repaint();
//        Jpotify.addPlayList(new JLabel("salam"));
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
