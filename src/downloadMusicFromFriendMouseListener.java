import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class downloadMusicFromFriendMouseListener implements MouseListener {

    public downloadMusicFromFriendMouseListener() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        try {
            Thread clientThread = new Thread(new ClientSide());
            ClientSide.work = "recieveMusic";
            clientThread.start();
        } catch (Exception e1) {
            e1.printStackTrace();
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
