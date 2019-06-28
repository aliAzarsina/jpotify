import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ClientSide implements Runnable {
    static ArrayList<String> ipList = new ArrayList<>();
    static ArrayList<String> ipName = new ArrayList<>();
    static String currentMusicName = new String();
    static ArrayList<String> sharedList = new ArrayList<>();
    static HashMap<String, String> requestFromServers = new HashMap<>(); // ip, request protocol
    static String musicName = "";
    static String work = null;
    Mantegh mantegh;
    Jpotify jpotify;
    String username;
    JButton downloadButton = new JButton();
    static String order;

    public ClientSide() {
//        this.username = username;
//        this.jpotify = jpotify;
    }

    public static void setMusicName(String musicName) {
        ClientSide.musicName = musicName;
    }

    @Override
    public void run() {

        File file = new File(".\\bin\\ipList.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                ipList.add(line);
                requestFromServers.put(line, "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        file = new File(".\\bin\\ipName.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                ipName.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            while (true) {
                Socket socket = null;
                while (work == null) {
                    System.out.print("");
                }

                for (int i = 0; i < ipList.size(); i++) {
                    socket = new Socket(ipList.get(i), 13267);

                    if (work.equals("sendCurrentMusic")) {
                        sendingNewMusic();
                    } else if (work.equals("shareThePlayList")) {
                        sendingSharedList();
                    } else if (work.equals("receiveMusic")) {
//                        String musicName = scn.nextLine();
                        recievingMusic(socket, musicName); // music name is music address
                    } else {
                        System.out.println("Unknown message received from client");
                    }
                }
                work = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static public void sendingSharedList() {
        try {
            for (int i = 0; i < ipList.size(); i++) {
                Socket socket = new Socket(ipList.get(i), 13267);
                ServerHandler.sharedlist = sharedList;
                ServerHandler serverHandler = new ServerHandler(socket, "shareThePlayList");
                Thread t = new Thread(serverHandler);
                t.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static public void sendingNewMusic() {

        try {
            for (int i = 0; i < ipList.size(); i++) {
                Socket socket = new Socket(ipList.get(i), 13267);
                ServerHandler.currenMusic = currentMusicName;
                ServerHandler serverHandler = new ServerHandler(socket, "sendCurrentMusic");
                Thread t = new Thread(serverHandler);
                t.start();

            }
        } catch (Exception e) {

        }

    }


    static public void recievingMusic(Socket socket, String musicYouWant) {
        try {
            ServerHandler serverHandler = new ServerHandler(socket, "receiveMusic");
            ServerHandler.musicNameYouWant = musicYouWant;
            Thread t = new Thread(serverHandler);
            t.start();
        } catch (Exception e) {
        }
    }


}
