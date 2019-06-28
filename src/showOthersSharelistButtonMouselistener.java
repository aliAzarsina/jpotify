import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.Socket;
import java.util.ArrayList;

public class showOthersSharelistButtonMouselistener implements MouseListener {
    showOthersSharelistButtonMouselistener (ArrayList<String> musicPath, ArrayList<String> musicName, Socket socket) {
        SharelistFrame sharelistFrame = new SharelistFrame();
        sharelistFrame.setVisible(true);
        for (int i = 0; i < musicName.size(); i++) {

            OthersSharelistsPanel othersSharelistsPanel = new OthersSharelistsPanel(musicName.get(i),socket);
        }

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        SharelistFrame sharelistFrame = new SharelistFrame();
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
