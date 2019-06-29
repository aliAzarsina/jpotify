import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteMusicListener implements MouseListener {

    Music music;
    public DeleteMusicListener(Music music)
    {
        this.music=music;
    }



    @Override
    public void mouseClicked(MouseEvent e) {


        if (Mantegh.isthecurrentplaylist == true) {
            for (int i = 0; i < Mantegh.thecurrentPlaylistisshowingmouselistener.currenAlbumMusics.size(); i++) {

                if (Mantegh.thecurrentPlaylistisshowingmouselistener.currenAlbumMusics.get(i).musicName.equals(music.musicName)) {
                    Mantegh.thecurrentPlaylistisshowingmouselistener.currenAlbumMusics.remove(i);
                    Mantegh.thecurrentPlaylistisshowingmouselistener.musicPanels.remove(i);
                }
            }

            try (FileWriter fw = new FileWriter( Mantegh.thecurrentPlaylistisshowingmouselistener.AlbumName , false);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {

                for (Music music : Mantegh.thecurrentPlaylistisshowingmouselistener.currenAlbumMusics) {
                    out.println(music.musicName);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++"+Mantegh.thecurrentPlaylistisshowingmouselistener.AlbumName);

            if (Mantegh.thecurrentPlaylistisshowingmouselistener.AlbumName.equals(".\\bin\\sharedList.txt")) {
                ServerHandler.sharedlist.remove(music.musicName);
                for (int j = 0; j < ClientSide.ipList.size(); j++) {
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println(ServerHandler.sharedlist);
                    ClientSide.sendingSharedList();
                }
            }


            Jpotify.clearCenterPanel();
            for (Music music : Mantegh.currentAlbumisShowing)
                Jpotify.addPanelToCenterPanel(music.musicPanel);

        } else {
            if (Mantegh.mouseListenersofalbums != null) ;
            for (int k = 0; k < Mantegh.mouseListenersofalbums.size(); k++) {
                if (Mantegh.mouseListenersofalbums.get(k).AlbumName.equals(music.albumName)) {
                    for (int j = 0; j < Mantegh.mouseListenersofalbums.get(k).musicPanels.size(); j++) {
                        if (Mantegh.mouseListenersofalbums.get(k).musicPanels.get(j).music.musicName.equals(music.musicName)) {
                            Mantegh.mouseListenersofalbums.get(k).musicPanels.remove(j);
                            Mantegh.mouseListenersofalbums.get(k).currenAlbumMusics.remove(k);
                        }
                    }
                }


                for (int j = 0; j < MouseListenerMusiclist.musicPanels.size(); j++) {

                    if (MouseListenerMusiclist.musicPanels.get(j).music.musicName.equals(music.musicName)) {
                        MouseListenerMusiclist.musicPanels.remove(j);
                        MouseListenerMusiclist.musics.remove(j);
                    }

                }
                try (FileWriter fw = new FileWriter(".\\bin\\allMusics\\allMusicList.txt", false);
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter out = new PrintWriter(bw)) {

                    for (MusicPanel musicPanel : MouseListenerMusiclist.musicPanels) {
                        out.println(musicPanel.music.musicName);
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }


                for (int i = 0; i < Mantegh.mouselistenersOfPlayLists.size(); i++) {

                    for (int j = 0; j < Mantegh.mouselistenersOfPlayLists.get(i).currenAlbumMusics.size(); j++) {
                        if (Mantegh.mouselistenersOfPlayLists.get(i).currenAlbumMusics.get(j).musicName.equals(music.musicName)) {
                            Mantegh.mouselistenersOfPlayLists.get(i).musicPanels.remove(j);
                            Mantegh.mouselistenersOfPlayLists.get(i).currenAlbumMusics.remove(j);

                            try (FileWriter fw = new FileWriter(Mantegh.mouselistenersOfPlayLists.get(i).AlbumName, false);
                                 BufferedWriter bw = new BufferedWriter(fw);
                                 PrintWriter out = new PrintWriter(bw)) {

                                for (Music music : Mantegh.mouselistenersOfPlayLists.get(i).currenAlbumMusics) {
                                    out.println(music.musicName);
                                }
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }

                        }
                    }
                }


                for (int i = 0; i < ServerHandler.sharedlist.size(); i++) {
                    if(ServerHandler.sharedlist.get(i).equals(music.musicName)) {
                        ServerHandler.sharedlist.remove(i);
                        break;
                    }
                }

                for (int j = 0; j < ClientSide.ipList.size(); j++) {

                    ClientSide.sendingSharedList();

                }


                Jpotify.clearCenterPanel();
                for (Music music : Mantegh.currentAlbumisShowing)
                    Jpotify.addPanelToCenterPanel(music.musicPanel);


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
