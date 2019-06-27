import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientSide implements Runnable{
    static ArrayList<String> ipList = new ArrayList<>();
    static String currentMusicName=new String();
    static ArrayList<String> sharedList=new ArrayList<>();
    static String musicName = "";
    static String work = "";
    Mantegh mantegh;
    Jpotify jpotify;

//    public ClientSide () {
//        this.mantegh = mantegh;
//        this.jpotify = jpotify;
//    }

    @Override
    public void run(){
        File file = new File(".\\bin\\ipList.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                ipList.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Scanner scn=new Scanner(System.in);
//        String work=scn.nextLine();

//        ipList.add("localhost");
//        ipList.add("192.168.1.41");
//        ipList.add("localhost");
        try {
            while (true) {
                Socket socket = null;
                for (int i = 0; i < ipList.size(); i++) {
                    socket = new Socket(ipList.get(i), 13267);
//                    ServerHandler.musicNameYouWant=musicYouWant;
                }
                if (work.equals("sendCurrentMusic")) {
                    sendingNewMusic();
                }
                else if (work.equals("shareThePlayList")) {
                    sendingSharedList();
                }
                else if (work.equals("recieveMusic")) {
//            String musicName = scn.nextLine();
                    recievingMusic(socket, musicName);
                } else {
                    System.out.println("Unknown message received from client");
                }
                Thread.sleep(30000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static public void sendingSharedList()
    {
        try {
            for (int i = 0; i < ipList.size(); i++) {
                Socket socket = new Socket(ipList.get(i), 13267);
                ServerHandler.sharedlist=sharedList;
                ServerHandler serverHandler = new ServerHandler(socket, "shareThePlayList");
                Thread t = new Thread(serverHandler);
                t.start();

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    static public void sendingNewMusic()
    {

        try {
            for (int i = 0; i < ipList.size(); i++) {
                Socket socket = new Socket(ipList.get(i), 13267);
                ServerHandler.currenMusic=currentMusicName;
                ServerHandler serverHandler = new ServerHandler(socket, "sendCurrentMusic");
                Thread t = new Thread(serverHandler);
                t.start();

            }
        }
        catch (Exception e)
        {

        }

    }


    static public void recievingMusic(Socket socket,String musicYouWant) {
        try {
            ServerHandler serverHandler = new ServerHandler(socket, "");
            Thread t = new Thread(serverHandler);
            t.start();
        }
        catch (Exception e)
        {}
    }





}
