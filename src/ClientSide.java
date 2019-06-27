import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientSide {
    static ArrayList<String> ipList = new ArrayList<>();
    static String currentMusicName=new String();
    static ArrayList<String> sharedList=new ArrayList<>();
    static String musicName=new String();

    public static void main(String[] args) throws IOException {
        Scanner scn=new Scanner(System.in);
        String work=scn.nextLine();

//        ipList.add("localhost");
//        ipList.add("192.168.1.41");
        ipList.add("localhost");

        if(work.equals("sendCurrentMusic"))
        {
            sendingNewMusic();
        }
        if(work.equals("shareThePlayList"))
        {
            sendingSharedList();
        }
        if(work.equals("recieveMusic"))
        {
            String musicName = scn.nextLine();
            recievingMusic(ipList.get(0),musicName);
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


    static public void recievingMusic(String ip,String musicYouWant) {
        try {
            Socket socket = new Socket(ip, 13267);
            ServerHandler.musicNameYouWant=musicYouWant;
            ServerHandler serverHandler = new ServerHandler(socket, "recieveMusic");
            Thread t = new Thread(serverHandler);
            t.start();
        }
        catch (Exception e)
        {}
    }





}
