//import javax.swing.*;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.util.ArrayList;
//
//public class MouseListenerMusiclist implements MouseListener {
//    ArrayList<MusicPanel> musicPanels = new ArrayList<>();
//    ArrayList<Music> musics;
//
//    public MouseListenerMusiclist(ArrayList<Music> musicss) {
//        musics = musicss;
//        for (int i = 0; i < musics.size(); i++) {
//            System.out.println("alasjlkjdsls");
//            musicPanels.add(new MusicPanel(new JLabel(musics.get(i).musicName), new JLabel("mamali"),musics.get(i).button,musics.get(i)));
//            System.out.println(musics.get(i).musicName+"ppppppppppppppppppppppppkkkkk");
//        }
//    }
//    @Override
//    public void mouseClicked(MouseEvent e) {
//        Jpotify.clearCenterPanel();
//        System.out.println(musics.size()+"bbbbbvvvvvvvvvvvvv");
//        for (int i = 0; i < musics.size(); i++) {
//            System.out.println(musics.get(i).musicName);
//            Jpotify.addPanelToCenterPanel(musicPanels.get(i));
//        }
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//
//    }
//}
