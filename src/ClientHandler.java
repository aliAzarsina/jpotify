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
    static String musicName=new String();


    public ClientHandler(ServerSocket serverSocket, Socket socket) {
        servsock = serverSocket;
        sock = socket;
    }

    @Override
    public void run() {



        ArrayList<String> sharedlist=new ArrayList<>();


        FileInputStream fis = null;
        BufferedInputStream bis = null;
        OutputStream os = null;
        DataInputStream is = null;



        try {
            System.out.println("Accepted connection : " + sock);
            is = new DataInputStream(sock.getInputStream());
            String checkRequest;
            checkRequest = is.readUTF();



            if(checkRequest.equals("receivingFile"))
            {
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
                Thread.sleep(20000);
                System.out.println("Done.");

            }
            if(checkRequest.equals("sendingsharedlist"))
            {

                ObjectInputStream objectInputStream = new ObjectInputStream(is);
                objectInputStream.readObject();
            }

            if(checkRequest.equals("sendingmusic"))
            {
                musicName= is.readUTF();
                System.out.println(musicName);
            }


        } catch(Exception e){
        } finally{
            try {
                if (bis != null) bis.close();
                if (os != null) os.close();
                if (sock != null) sock.close();
            } catch (Exception e1) {
            }
        }



    }

}