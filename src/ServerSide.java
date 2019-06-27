import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide {

    public static void main(String[] args) {
        try {
            Jpotify jpotify= new Jpotify();
            jpotify.setVisible(true);
            Mantegh mantegh=new Mantegh(jpotify);
            ServerSocket servsock = new ServerSocket(13267);
            Socket socket;
            while (true) {
                System.out.println("Waiting...");
                try {
                    socket = servsock.accept();
                    OnlinePeoplePanel onlinePeoplePanel = new OnlinePeoplePanel("ali","music !!","artist !!","on");
                    Jpotify.addOnlinePeoplePanel(onlinePeoplePanel);
                    Jpotify.updateOnlinePeoplePanel();
                    System.out.println("dib dib dib");
                    ClientHandler simpleFileServer = new ClientHandler(servsock,socket);
                    Thread t = new Thread(simpleFileServer);
                    t.start();
                } catch (Exception e) {
                }
            }
        }catch (Exception e) {}
    }
}
