import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class AddMusicToListButton implements MouseListener {

    Music music;

    public AddMusicToListButton(Music music)
    {
        this.music=music;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        String input;

        input = JOptionPane.showInputDialog("the playList you want to add it?");

        for (int i = 0; i <Mantegh.mouselistenersOfPlayLists.size() ; i++) {
            System.out.println(Mantegh.mouselistenersOfPlayLists.get(i).nameOfPlayListLabel);

            if(Mantegh.mouselistenersOfPlayLists.get(i).nameOfPlayListLabel.equals(".\\bin\\"+input+".txt"))
            {
                boolean isthere=false;
                for (Music music1:Mantegh.mouselistenersOfPlayLists.get(i).currenAlbumMusics)
                {
                    if(music1.musicName.equals(music.musicName))
                    {
                        isthere=true;
                    }

                }

                if(isthere!=true)

                {System.out.println("yaalimadadi");
                Mantegh.mouselistenersOfPlayLists.get(i).currenAlbumMusics.add(0,music);
                Mantegh.mouselistenersOfPlayLists.get(i).musicPanels.add(0,music.musicPanel);
            try (FileWriter fw = new FileWriter(".\\bin\\"+input+".txt", false);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {

                for(Music music1:Mantegh.mouselistenersOfPlayLists.get(i).currenAlbumMusics)
                { out.println(music1.musicName);}
                if (input.equals("sharedList"))
                {
                    System.out.println("ddddddddddddddddddddddddddddddddddddddd");
                    //for (int j = 0; j < Mantegh.mouselistenersOfPlayLists.get(i).currenAlbumMusics.size(); j++) {
                             ServerHandler.sharedlist.add(music.musicName);
                    //}
                    for (int j = 0; j < ClientSide.ipList.size(); j++) {
                        ClientSide.sendingSharedList();
                    }

                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }}
            break;

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
