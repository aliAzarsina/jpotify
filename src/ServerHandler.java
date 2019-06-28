import java.io.*;
import java.net.Socket;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class ServerHandler implements Runnable {

    String work;
    static String musicNameYouWant;
    static String currenMusic;
    private Socket socket;
//    static HashMap<String, String> request = new HashMap<>();
    static ArrayList<ArrayList<String>> request = new ArrayList<>();
    public ServerHandler(Socket socket) throws IOException{
        this.socket = socket;
        dos = new DataOutputStream(socket.getOutputStream());
    }

    public void setWork(String work) {
        this.work = work;
    }

    static ArrayList<String> sharedlist=new ArrayList<>();


    public final static int FILE_SIZE = 20000000; // file size temporary hard coded
    DataOutputStream dos;
    InputStream iss;
    FileOutputStream fos = null;
    BufferedOutputStream bos = null;

    int bytesRead;
    int current = 0;

    public void run() {
        while (request.size() == 0) {
            System.out.print("");
            // void
        }
        String str = request.get(0).get(0);
        Scanner scn = new Scanner(str);
        work = scn.nextLine();
        if (work.equals("receiveMusic")) {
            receivingMusic(request.get(0).get(2));
        }
//        BufferedReader buffer = new BufferedReader();

        sharedlist.add("goli");
        sharedlist.add("kholi");
        request.remove(request.get(0));
    }







    public void sendingNewMusicName(String string)
    {

        try {
            dos.writeUTF("sendingmusic");
            dos.writeUTF(string);
        }
        catch (Exception e)
        { }

    }


    public void sendingSharedlist(ArrayList<String> sharedlist)
    {

        try {
            dos.writeUTF("sendingsharedlist");
            ObjectOutputStream ob = new ObjectOutputStream(dos);
            ob.writeObject(sharedlist);
        }
        catch (Exception e)
        {
        }
    }







    public void receivingMusic (String string)
    {

        try {
            dos.writeUTF("receivingFile");
            dos.writeUTF(string);
            String path = ".\\bin\\OthersSharedList\\" + string + ".mp3";
            // receive file
            byte[] mybytearray = new byte[FILE_SIZE];
            InputStream is = socket.getInputStream();
            fos = new FileOutputStream(path);
            bos = new BufferedOutputStream(fos);
            bytesRead = is.read(mybytearray, 0, mybytearray.length);
            current = bytesRead;

            do {
                bytesRead = is.read(mybytearray, current, (mybytearray.length - current));
                if (bytesRead >= 0) current += bytesRead;
            } while (bytesRead > -1);

            bos.write(mybytearray, 0, current);
            bos.flush();
            System.out.println("File " +" downloaded (" + current + " bytes read)");
            Thread.sleep(20000);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {

            try {
                if (fos != null) fos.close();
                if (bos != null) bos.close();
                if (socket != null) socket.close();
            }
            catch (Exception e)
            {}
        }
    }
}
