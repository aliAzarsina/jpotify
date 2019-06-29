import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


///همان پلی لیست است اشتباه تایپی بود



public class AddNewSharedListButton implements MouseListener {
    String name;





    @Override
    public void mouseClicked(MouseEvent e) {
        name = JOptionPane.showInputDialog("the playList you want to add it?");
        ArrayList<String> strings=new ArrayList<>();
        MouseListenerSelf mouseListenerSelf=new MouseListenerSelf(true,"notAlbum", new ArrayList<Music>(),strings );

        JLabel jLabel=new JLabel(".\\bin\\"+name+".txt");
        Mantegh.mouselistenersOfPlayLists.add(mouseListenerSelf);

        jLabel.addMouseListener(mouseListenerSelf);
        Mantegh.playlist2.put(jLabel,strings);
        mouseListenerSelf.nameOfPlayListLabel=jLabel.getText();


        // tokenize//

//            String name = "";
//            StringTokenizer st = new StringTokenizer(mouseListenerSelf.nameOfPlayListLabel, "\\");
//            while (st.hasMoreTokens()) {
//                name = st.nextToken();
//            }
//            st = new StringTokenizer(name, ".");
//            String finalName = st.nextToken();
//            mouseListenerSelf.nameOfPlayListLabel = finalName;
//



        Mantegh.labelsOfPlayLists.add(jLabel);
        Jpotify.addPlayList(jLabel);

        try (FileWriter fw = new FileWriter(mouseListenerSelf.nameOfPlayListLabel, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.print("");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try (FileWriter fw = new FileWriter(".\\bin\\playLists\\playListsAddresses.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
             out.println(mouseListenerSelf.nameOfPlayListLabel);
        } catch (IOException e1) {
            e1.printStackTrace();
        }




        //



    }



    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
