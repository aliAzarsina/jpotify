import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide implements Runnable {

    @Override
    public void run() {
        try {
            ServerSocket servsock = new ServerSocket(13267);
            Socket socket;
            while (true) {
                System.out.println("Waiting...");
                try {
                    socket = servsock.accept();
                    OnlinePeoplePanel onlinePeoplePanel = new OnlinePeoplePanel("ali", "music !!", "artist !!", "on");
                    Jpotify.addOnlinePeoplePanel(onlinePeoplePanel);
                    Jpotify.updateOnlinePeoplePanel();
                    ClientHandler simpleFileServer = new ClientHandler(servsock, socket);
                    Thread t = new Thread(simpleFileServer);
                    t.start();
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
        }
    }

}
