import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ServerSide implements Runnable {
    static HashMap<Socket, OnlinePeoplePanel> onlinePeoplePanelHashMap = new HashMap<>();

    @Override
    public void run() {
        try {
            ServerSocket servsock = new ServerSocket(13267);
            Socket socket;
            while (true) {
                System.out.println("Waiting...");
                try {
                    socket = servsock.accept();
                    OnlinePeoplePanel onlinePeoplePanel = new OnlinePeoplePanel("ALI AA","lastMUSIC","lastARTIST","2m",socket);
                    Jpotify.addOnlinePeoplePanel(onlinePeoplePanel);
                    Jpotify.updateOnlinePeoplePanel();
                    onlinePeoplePanelHashMap.put(socket,onlinePeoplePanel);
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
