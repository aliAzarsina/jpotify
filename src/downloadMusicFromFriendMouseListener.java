import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.Socket;
import java.util.ArrayList;

public class downloadMusicFromFriendMouseListener implements MouseListener {
    Socket socket;
    public downloadMusicFromFriendMouseListener(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        try {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(0,"receiveMusic"); // order
            temp.add(1,"localhost"); // host
            temp.add(2,"123"); // name
            ServerHandler.request.add(0,temp);
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
