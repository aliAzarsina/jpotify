import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide {

    public static void main(String[] args) {
        try {
            ServerSocket servsock = new ServerSocket(13267);
            Socket socket;
            while (true) {
                System.out.println("Waiting...");
                try {
                    socket = servsock.accept();
                    ClientHandler simpleFileServer = new ClientHandler(servsock,socket);
                    Thread t = new Thread(simpleFileServer);
                    t.start();
                } catch (Exception e) {
                }
            }
        }catch (Exception e) {}
    }
}
