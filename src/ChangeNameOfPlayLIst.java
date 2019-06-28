import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ChangeNameOfPlayLIst implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        String input;
        input = JOptionPane.showInputDialog("the playList you want to change it?");
        if(!input.equals("sharedList")&&!input.equals("favoriteMusics")) {
            String name;
            name = JOptionPane.showInputDialog("new name?");
            for (int i = 0; i < Mantegh.labelsOfPlayLists.size(); i++) {
                if (input.equals(Mantegh.labelsOfPlayLists.get(i))) {
                    Mantegh.labelsOfPlayLists.get(i).setText(name);
                    try (FileWriter fw = new FileWriter(".\\bin\\" + name + ".txt", false);
                         BufferedWriter bw = new BufferedWriter(fw);
                         PrintWriter out = new PrintWriter(bw)) {

                        for (MusicPanel musicPanel:Mantegh.mouselistenersOfPlayLists.get(i).musicPanels) {
                            out.println(musicPanel.music.musicName);
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }


                    Mantegh.mouselistenersOfPlayLists.get(i).nameOfPlayListLabel = ".\\bin\\"+name+".txt";


                    try (FileWriter fw = new FileWriter(".\\bin\\playLists\\playListsAddresses.txt", false);
                         BufferedWriter bw = new BufferedWriter(fw);
                         PrintWriter out = new PrintWriter(bw)) {

                        for (MouseListenerSelf mouseListenerSelf:Mantegh.mouselistenersOfPlayLists) {
                            out.println(mouseListenerSelf.nameOfPlayListLabel);
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                }
            }




            Jpotify.panel7.removeAll();
            Jpotify.i = 0;
            for (int j = 0; j < Mantegh.labelsOfPlayLists.size(); j++) {
                Jpotify.addPlayList(Mantegh.labelsOfPlayLists.get(j));
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
