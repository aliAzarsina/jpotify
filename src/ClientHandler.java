import org.omg.PortableServer.THREAD_POLICY_ID;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

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

            if (checkRequest.equals("receiveFile")) {
                String fileName = is.readUTF();
                String userName = is.readUTF();
                if (Mantegh.username.equals(userName)) {

                    System.out.println("llllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");


                    try {

                        File myFile = new File(fileName);
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
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            } else if (checkRequest.equals("shareThePlayList")) {
                String username = is.readUTF();


                ObjectInputStream objectInputStream = new ObjectInputStream(is);
                Object object = objectInputStream.readObject();
                ArrayList<String> shareList = (ArrayList<String>) object;

                System.out.println(object + "qqqqqqqqqqqqqqqqqqqqqqqqqq");

                //System.out.println(panel.musicAddresses);
                //#########################################
                OnlinePeoplePanel onlinePeoplePanel2 = null;
                boolean isthere = false;
                for (int i = 0; i < Jpotify.onlinePeoplePanels.size(); i++) {
                    if (Jpotify.onlinePeoplePanels.get(i).userName2.equals(username)) {
                        isthere = true;
                        onlinePeoplePanel2 = Jpotify.onlinePeoplePanels.get(i);
                        break;
                    }
                }
                if (isthere) {
                    Jpotify.removeOnlinePeoplePanel(onlinePeoplePanel2);
                    onlinePeoplePanel2 = new OnlinePeoplePanel(username, musicName, musicArtist, lastSeen, sock);
                    onlinePeoplePanel2.musicAddresses = (ArrayList<String>) object;
                    onlinePeoplePanel2.setMusicNames(onlinePeoplePanel2.musicAddresses);
                    Jpotify.addOnlinePeoplePanel(onlinePeoplePanel2);
                    Jpotify.updateOnlinePeoplePanel();
                    onlinePeoplePanel2.setShareInit();
                } else {
                    OnlinePeoplePanel onlinePeoplePanel = new OnlinePeoplePanel(username, musicName, musicArtist, lastSeen, sock);
                    onlinePeoplePanel.musicAddresses = (ArrayList<String>) object;
                    onlinePeoplePanel.setMusicNames(onlinePeoplePanel.musicAddresses);
                    Jpotify.addOnlinePeoplePanel(onlinePeoplePanel);
                    Jpotify.updateOnlinePeoplePanel();
                    onlinePeoplePanel.setShareInit();

                }
                //###############################################

            } else if (checkRequest.equals("sendCurrentMusic")) {
                musicName = is.readUTF();
                musicArtist = is.readUTF();
                lastSeen = is.readUTF();
                String userName = is.readUTF();
                OnlinePeoplePanel onlinePeoplePanel2 = null;
                boolean isthere = false;
                for (int i = 0; i < Jpotify.onlinePeoplePanels.size(); i++) {
                    if (Jpotify.onlinePeoplePanels.get(i).userName2.equals(userName)) {
                        isthere = true;
                        onlinePeoplePanel2 = Jpotify.onlinePeoplePanels.get(i);
                        break;
                    }
                }
                if (isthere) {
                    Jpotify.removeOnlinePeoplePanel(onlinePeoplePanel2);
                    onlinePeoplePanel2 = new OnlinePeoplePanel(userName, musicName, musicArtist, lastSeen, sock);
                    Jpotify.addOnlinePeoplePanel(onlinePeoplePanel2);
                    System.out.println("dddddddddddddddddddddddddddddddddd" + musicName);
                    Jpotify.updateOnlinePeoplePanel();
                } else {
                    OnlinePeoplePanel onlinePeoplePanel = new OnlinePeoplePanel(userName, musicName, musicArtist, lastSeen, sock);
                    Jpotify.addOnlinePeoplePanel(onlinePeoplePanel);
                    Jpotify.updateOnlinePeoplePanel();
                }
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