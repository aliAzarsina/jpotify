import org.omg.PortableServer.THREAD_POLICY_ID;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class ClientHandler implements Runnable {

    public final static int SOCKET_PORT = 13267;  // you may change this
    public final static String FILE_TO_SEND = ".\\bin\\MySharedList\\123.mp3";  // you may change this
    private ServerSocket servsock = null;
    Socket sock = null;
    static String musicName = "";
    static String musicArtist = "";
    static String lastSeen = "";
    OnlinePeoplePanel panel;


    public ClientHandler(ServerSocket serverSocket, Socket socket, boolean isNew) {
        servsock = serverSocket;
        sock = socket;
    }

    @Override
    public void run() {

        ArrayList<String> sharedlist = new ArrayList<>();
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        OutputStream os = null;
        DataInputStream is = null;
        boolean anotherRequest = true;

        try {
            is = new DataInputStream(sock.getInputStream());
            String checkRequest;
            checkRequest = is.readUTF();

            System.out.println("serverSide@ New request : " + checkRequest);

            if (checkRequest.equals("receiveMusic")) {
                String fileName = is.readUTF();
                System.out.println(fileName + "****************** request from the server");
                File myFile = new File(FILE_TO_SEND);
                byte[] mybytearray = new byte[(int) myFile.length()];
                fis = new FileInputStream(myFile);
                bis = new BufferedInputStream(fis);
                bis.read(mybytearray, 0, mybytearray.length);
                os = sock.getOutputStream();
                System.out.println("Sending " + FILE_TO_SEND + "(" + mybytearray.length + " bytes)");
                os.write(mybytearray, 0, mybytearray.length);
                os.flush();
                Thread.sleep(10000);
                System.out.println("Done.");
            } else if (checkRequest.equals("shareThePlayList")) {
                ObjectInputStream objectInputStream = new ObjectInputStream(is);
                ArrayList<String> shareList = (ArrayList<String>) objectInputStream.readObject();
                panel.musicAddresses = shareList;
                OnlinePeoplePanel.setMusicNames(sharedlist);
                OnlinePeoplePanel onlinePeoplePanel = new OnlinePeoplePanel("ALI AA", "lastMUSIC", "lastARTIST", "2m", sock);
                Jpotify.addOnlinePeoplePanel(onlinePeoplePanel);
                Jpotify.updateOnlinePeoplePanel();
                panel = onlinePeoplePanel;
                OnlinePeoplePanel.setShareInit();

            } else if (checkRequest.equals("sendCurrentMusic")) {
                musicName = is.readUTF();
                musicArtist = is.readUTF();
                lastSeen = is.readUTF();

                Jpotify.removeOnlinePeoplePanel(panel);
                OnlinePeoplePanel onlinePeoplePanel = new OnlinePeoplePanel("Ali A",musicName,musicArtist,lastSeen,sock);
                Jpotify.addOnlinePeoplePanel(onlinePeoplePanel);
                System.out.println("dddddddddddddddddddddddddddddddddd"+musicName);
                Jpotify.updateOnlinePeoplePanel();
            } else
                System.out.println("serverSde : Unknown order received ");


        } catch (Exception e) {
        } finally {
            try {
                if (bis != null) bis.close();
                if (os != null) os.close();
                if (sock != null) sock.close();
            } catch (Exception e1) {
            }
        }

    }

}