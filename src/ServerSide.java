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
                    System.out.println("Accepted connection : " + socket);
                    ClientHandler simpleFileServer = new ClientHandler(servsock, socket, true); //change it
                    Thread t = new Thread(simpleFileServer);
                    t.start();
                    t.join(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
        }
    }

}
