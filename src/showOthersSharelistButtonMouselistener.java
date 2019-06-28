import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.Socket;
import java.util.ArrayList;

public class showOthersSharelistButtonMouselistener implements MouseListener {
    ArrayList<String> musicName;
    Socket socket;
    showOthersSharelistButtonMouselistener (ArrayList<String> musicPath, ArrayList<String> musicName, Socket socket) {
        this.socket = socket;
        this.musicName = musicName;

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        SharelistFrame sharelistFrame = new SharelistFrame();
        sharelistFrame.setVisible(true);
        for (int i = 0; i < musicName.size(); i++) {
            OthersSharelistsPanel othersSharelistsPanel = new OthersSharelistsPanel(musicName.get(i),socket);
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
