import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.Socket;
import java.util.ArrayList;

public class downloadMusicFromFriendMouseListener implements MouseListener {
    Socket socket;
    String userName;
    String muscName;
    public downloadMusicFromFriendMouseListener( String userName,String musicYouWantName) {
        this.userName = userName;
        muscName = musicYouWantName;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        try {
            for (int i = 0; i < ClientSide.ipList.size() ; i++) {
                ClientSide.recievingMusic(ClientSide.ipList.get(i),muscName,userName);
                System.out.println("#################################");
            }

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
