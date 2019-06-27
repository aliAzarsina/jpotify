import java.io.*;
import java.net.Socket;
import java.util.ArrayList;


public class ServerHandler implements Runnable {

    String work;
    static String musicNameYouWant;
    static String currenMusic;
    private Socket socket;

    public ServerHandler(Socket socket,String work) throws IOException{
        this.socket = socket;
        this.work = work;
        dos = new DataOutputStream(socket.getOutputStream());
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
        sharedlist.add("goli");
        sharedlist.add("kholi");
        System.out.println("mamalui");
        if(work.equals("recieveMusic"))
        {
            recievingMusic(musicNameYouWant);
        }
        else if(work.equals("sendCurrentMusic"))
        {
            sendingNewMusicName(currenMusic);
        }
        else if(work.equals("shareThePlayList"))
        {
            sendingSharedlist(sharedlist);
        }
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







    public void recievingMusic (String string)
    {

        try {
            dos.writeUTF("recievingfile");
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
