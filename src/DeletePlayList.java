import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DeletePlayList implements MouseListener {
    String name;
    @Override
    public void mouseClicked(MouseEvent e) {
        name = JOptionPane.showInputDialog("the playList you want to delete it?");

        if(!name.equals("sharedList")&&!name.equals("favoriteMusics")) {
            for (int i = 0; i < Mantegh.mouselistenersOfPlayLists.size(); i++) {

                if (Mantegh.mouselistenersOfPlayLists.get(i).nameOfPlayListLabel.equals(".\\bin\\"+name+".txt")) {
                    Mantegh.playlist2.remove(Mantegh.labelsOfPlayLists.get(i));
                    Mantegh.labelsOfPlayLists.remove(i);
                    Mantegh.mouselistenersOfPlayLists.remove(i);
                    Jpotify.panel7.removeAll();
                    Jpotify.i = 0;
                    for (int j = 0; j < Mantegh.labelsOfPlayLists.size(); j++) {
                        Jpotify.addPlayList(Mantegh.labelsOfPlayLists.get(j));
                    }

                    try (FileWriter fw = new FileWriter(".\\bin\\playLists\\playListsAddresses.txt", false);
                         BufferedWriter bw = new BufferedWriter(fw);
                         PrintWriter out = new PrintWriter(bw)) {

                        for (MouseListenerSelf mouseListenerSelf : Mantegh.mouselistenersOfPlayLists) {
                            out.println( mouseListenerSelf.nameOfPlayListLabel );
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }


            }
        }

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
