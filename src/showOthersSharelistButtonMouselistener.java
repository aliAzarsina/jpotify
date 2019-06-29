import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.Socket;
import java.util.ArrayList;

public class showOthersSharelistButtonMouselistener implements MouseListener {
    ArrayList<String> musicName;
    ArrayList<String> musicPath;
    Socket socket;
    String username;
    showOthersSharelistButtonMouselistener (ArrayList<String> musicPath, ArrayList<String> musicName, Socket socket,String usernamee) {
        this.socket = socket;
        this.musicName = musicName;
        this.musicPath = musicPath;
        System.out.println(musicName);
        System.out.println(musicPath);
        username = usernamee;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        SharelistFrame sharelistFrame = new SharelistFrame();
        sharelistFrame.setVisible(true);
        for (int i = 0; i < musicName.size(); i++) {
            OthersSharelistsPanel othersSharelistsPanel = new OthersSharelistsPanel(musicName.get(i) ,musicPath.get(i),socket,username);
            sharelistFrame.addPanel(othersSharelistsPanel);
            sharelistFrame.updatePanels();
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

//    void set
}
