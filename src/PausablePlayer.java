import com.sun.javafx.property.adapter.PropertyDescriptor;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class PausablePlayer implements Runnable ,ChangeListener {

    private final static int NOTSTARTED = 0;
    private final static int PLAYING = 1;
    private final static int PAUSED = 2;
    private final static int FINISHED = 3;
    private int lastPosition = 0;

    Thread t;
    static JFrame jFrame;
    JSlider jSlider;
    JButton button1;
    JButton button2;
    String musicName;
    Music music;
    static int shomarande = 0;
    private Advanceplayer player;
    private AudioDevice audio;
    FileInputStream fileInputStream;
    private final Object playerLock = new Object();
    int currentplace = 0;
    static int jsliderValue=0;

    private int playerStatus = NOTSTARTED;

    public PausablePlayer(final FileInputStream inputStream, JFrame frame, JSlider jSlider, JButton button, JButton button3, String musicName) throws Exception {

        this.music = music;

        button1 = button;
        button2 = button3;
        button1.addActionListener(new Actionlisten3(t));
        button2.addActionListener(new Actionlisten5(t));
        this.musicName = musicName;
        this.fileInputStream = inputStream;
        this.jSlider = jSlider;
        this.jFrame = frame;
        this.musicName = musicName;
        this.player = new Advanceplayer(inputStream);

        jSlider.addChangeListener(this);

        jFrame.setVisible(true);

    }



    public void run() {
        try {

            this.jSlider.setMinimum(0);
            jSlider.addChangeListener(this);

            jSlider.setMaximum(player.calculateframes());

            fileInputStream.getChannel().position(0);
            t=null;

            t = new Thread(new Run(fileInputStream, musicName, player,  player.calculateframes(),0,this,button1,button2,jSlider));
            button1.addActionListener(new Actionlisten5(t));
            button2.addActionListener(new Actionlisten3(t));
            fileInputStream.getChannel().position(0);

            t.start();
        } catch (Exception e) {
        }


    }



    public void stateChanged(ChangeEvent e) {


        JSlider source = (JSlider) e.getSource();
        if (!source.getValueIsAdjusting()) {
            try {
                int FPS = (int) source.getValue();
                Mantegh.timeThread.suspend();

                //  if(FPS-jsliderValue>120||FPS-jsliderValue<-120) {

                Jpotify.slider1.setValue(FPS);

                System.out.println("hosein        hoseinnnnnnnnnn");

                //if(t!=null)
                t.suspend();
                fileInputStream.close();
                Thread.sleep(600);
                t = null;
                fileInputStream = new FileInputStream(musicName);
                fileInputStream.getChannel().position(0);


                ActionListener[] actionListeners = button1.getActionListeners();
                for (ActionListener actionListener : actionListeners) {
                    button1.removeActionListener(actionListener);
                }
                ActionListener[] actionListeners2 = button2.getActionListeners();
                for (ActionListener actionListener : actionListeners2) {
                    button2.removeActionListener(actionListener);
                }


                t = new Thread(new Run(fileInputStream, musicName, player, player.calculateframes(), FPS, this, button1, button2, jSlider));
                fileInputStream.getChannel().position(0);
                button1.addActionListener(new Actionlisten5(t));
                button2.addActionListener(new Actionlisten3(t));
                t.start();

                //}

            } catch (Exception e1) {

                e1.printStackTrace();
            }

            Mantegh.timeThread.resume();


        }
    }


    class Run implements Runnable {

        FileInputStream fileInputStream;
        String musicName;
        Advanceplayer advanceplayer;
        int max;
        int min;
        PausablePlayer pausablePlayer;
        JButton button1;
        JButton button2;
        JSlider jSlider;

        public Run(FileInputStream fileInputStream1, String musicName1, Advanceplayer advancedPlayer1, int x, int y,PausablePlayer pausablePlayer,JButton button1,JButton button2,JSlider jSlider) {
            this.jSlider=jSlider;
            this.button1=button1;
            this.button2=button2;
            this.pausablePlayer=pausablePlayer;
            max = x;
            min = y;
            fileInputStream = fileInputStream1;
            musicName = musicName1;
            advanceplayer = advancedPlayer1;
        }

        @Override
        public void run() {
            try {


                System.out.println("sdsddddddddddddddddddssssssssssssslllllllllll");
                Mantegh.currentPausableplayer=this.pausablePlayer;
                fileInputStream.getChannel().position(0);
                advanceplayer=new Advanceplayer(fileInputStream);
                max=advanceplayer.calculateframes();
                fileInputStream.getChannel().position(0);

                if(max-min>50) {

                    Mantegh.timeThread.suspend();
                    Mantegh.time=min*24/1000;
                    Mantegh.timeThread.resume();

                    ChangeListener changeListener2=null;
                    for(ChangeListener changeListener:Jpotify.slider1.getChangeListeners())
                    { Jpotify.slider1.removeChangeListener(changeListener);
                        changeListener2=changeListener;
                    }


                    Jpotify.slider1.setValue(min);
                    Jpotify.slider1.addChangeListener(this.pausablePlayer);

                     ServerHandler.musicName=musicName;
                     ServerHandler.musicArtist="dddddddd";
                     ServerHandler.time="ssss";
                     ClientSide.sendingNewMusic();

                     Mantegh.musictime=max*24/1000;
                    advanceplayer.play(min, max);
                }


                fileInputStream.close();
                t=null;





                int i = 0;
                for (Music music : NextMusicActionListener.currentAlbum.musics) {


                    if (music.musicName.equals(musicName)) {
                        if (i == NextMusicActionListener.currentAlbum.musics.size() - 1) {

                            try {
                                fileInputStream = new FileInputStream(NextMusicActionListener.currentAlbum.musics.get(0).musicName);
                                NextMusicActionListener.musicName=NextMusicActionListener.currentAlbum.musics.get(0).musicName;

                                NextMusicActionListener.music=NextMusicActionListener.currentAlbum.musics.get(0);
                                PreviousButtonActionListener.music=NextMusicActionListener.currentAlbum.musics.get(0);

                                advanceplayer = new Advanceplayer(fileInputStream);
                                musicName=NextMusicActionListener.currentAlbum.musics.get(0).musicName;
                                this.pausablePlayer.musicName=NextMusicActionListener.currentAlbum.musics.get(0).musicName;

                                jSlider.addChangeListener(pausablePlayer);
                                t=null;
                                t=new Thread(new Run(fileInputStream,NextMusicActionListener.currentAlbum.musics.get(0).musicName,advanceplayer,advanceplayer.calculateframes(),0,pausablePlayer,button1,button2,jSlider));
                                button1.addActionListener(new Actionlisten5(t));
                                button2.addActionListener(new Actionlisten3(t));
                                fileInputStream.getChannel().position(0);
                                t.start();



                            } catch (Exception e1) {

                            }


                        } else {
                            try {


                                fileInputStream = new FileInputStream(NextMusicActionListener.currentAlbum.musics.get(i + 1).musicName);
                                advanceplayer = new Advanceplayer(fileInputStream);
                                musicName=NextMusicActionListener.currentAlbum.musics.get(i+1).musicName;
                                this.pausablePlayer.musicName=NextMusicActionListener.currentAlbum.musics.get(i+1).musicName;


                                ChangeListener [] changeListeners=jSlider.getChangeListeners();
                                for(ChangeListener changeListener:changeListeners)
                                {
                                    jSlider.removeChangeListener(changeListener);
                                }

                                t=null;
                                jSlider.addChangeListener(pausablePlayer);
                                t=new Thread(new Run(fileInputStream,NextMusicActionListener.currentAlbum.musics.get(i+1).musicName,advanceplayer,advanceplayer.calculateframes(),0,pausablePlayer,button1,button2,jSlider));
                                NextMusicActionListener.musicName=NextMusicActionListener.currentAlbum.musics.get(i+1).musicName;
                                NextMusicActionListener.music=NextMusicActionListener.currentAlbum.musics.get(i+1);
                                PreviousButtonActionListener.music=NextMusicActionListener.currentAlbum.musics.get(i+1);

                                ActionListener [] actionListeners=button1.getActionListeners();
                                for(ActionListener actionListener:actionListeners)
                                {
                                    button1.removeActionListener(actionListener);
                                }
                                ActionListener [] actionListeners2=button2.getActionListeners();
                                for(ActionListener actionListener:actionListeners2)
                                {
                                    button2.removeActionListener(actionListener);
                                }



                                button1.addActionListener(new Actionlisten5(t));
                                button2.addActionListener(new Actionlisten3(t));

                                fileInputStream.getChannel().position(0);
                                t.start();



                            } catch (Exception e1) {

                            }
                        }

                        i = 0;
                        break;

                    }
                    i++;


                }







































            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

    //
//   /* public void stateChanged(ChangeEvent e) {
//        JSlider source = (JSlider) e.getSource();
//        if (!source.getValueIsAdjusting()) {
//            try {
//                int FPS = (int) source.getValue();
//
//                System.out.println("hosseinali"+FPS+"    "+musicName);
//                System.out.println(FPS);
//                if(player1!=null)
//                {
//                    //System.out.println();
//                 player1.pause();
//                input.close();
//                Thread.sleep(600);
//                input = new FileInputStream(musicName);
//                input.getChannel().position(0);
//               player1.resume();
//                player1.play(input,FPS);}
//                /*else
//                {
//                    Mantegh.currentPausableplayer.player1.pause();
//                    input = new FileInputStream(musicName);
//                    input.getChannel().position(0);
//                    player1.play(input,FPS);
//
//                }*/
//
//
//            } catch (Exception e1) {}
//        }
//    }
//
//
//
//    /**
//     * Starts playback (resumes if paused)
//     */
//    public void play(final FileInputStream inputStream,final int x) throws JavaLayerException {
//        synchronized (playerLock) {
//
//            switch (playerStatus) {
//                case NOTSTARTED:
//                    final Runnable r = new Runnable() {
//                        public void run() {
//
//                            playInternal(inputStream,x);
//                        }
//                    };
//                    final Thread t = new Thread(r);
//                    t.setDaemon(true);
//                    t.setPriority(Thread.MAX_PRIORITY);
//                    playerStatus = PLAYING;
//                    t.start();
//                    break;
//                case PAUSED:
//                    resume();
//                    break;
//                default:
//
//                    final Runnable s = new Runnable() {
//                        public void run() {
//                            try {
//
//                                playInternal(inputStream, x);
//                                //System.out.println("mohammad");
//                            }
//                            catch (Exception e)
//                            {}
//                        }
//                    };
//
//
//                    final Thread f = new Thread(s);
//
//                    f.start();
//
//                    break;
//            }
//        }
//    }
//
//
//
//    private void playInternal(final FileInputStream inputStream,final int x) {
//
//        if (playerStatus == PLAYING) {
//
//            try {
//
//                player = new Advanceplayer(inputStream);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        try {
//
//            inputStream.getChannel().position(0);
//        }
//        catch (Exception e)
//        {
//
//
//        }
//
//        while (playerStatus != FINISHED) {
//             t = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//
//                        long x1=0;
//                        long y1=0;
//                        x1=System.currentTimeMillis();
//                        int y=player.calculateframes();
//                        inputStream.getChannel().position(0);
//                        player.play(x, y);
//
//                      y1=System.currentTimeMillis()-x1;
//
//                     int i=0;
//
//                            System.out.println(System.currentTimeMillis());
//                         Thread thread=new Thread(new NextMusicRunnable(musicName,Mantegh.currentAlbum));
//                       thread.start();
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//                    } catch (final Exception e) {
//
//                    }
//                }
//            });
//             button2.addActionListener(new Actionlisten3(t));
//            button1.addActionListener(new Actionlisten5(t));
//            t.start();
//
//            try {
//
//                t.join();
//
//            } catch (Exception e) {
//
//            }
//            try {
//
//
//                t.sleep(2);
//                //
//                //
//                //
//                //
//
//                ///
//                //
//                //
//                //
//                //
//                //
//            } catch (Exception e) {
//
//
//            }
//            // check if paused or terminated
//            synchronized (playerLock) {
//                while (playerStatus == PAUSED) {
//                    try {
//                        playerLock.wait();
//                    } catch (final InterruptedException e) {
//
//                        break;
//                    }
//                }
//            }
//        }
//        close();
//    }
//
//    /**
//     * Pauses playback. Returns true if new state is PAUSED.
//     */
//
//
//    public boolean pause() {
//        synchronized (playerLock) {
//            if (playerStatus == PLAYING) {
//                playerStatus = PAUSED;
//                AudioDevice out = audio;
//                if (out != null) {
//                    audio = null;
//
//                    out.close();
//                    lastPosition = out.getPosition();
//                }
//            }
//            return playerStatus == PAUSED;
//        }
//    }
//
//    /**
//     * Resumes playback. Returns true if the new state is PLAYING.
//     */
//    public boolean resume() {
//        synchronized (playerLock) {
//            if (playerStatus == PAUSED) {
//                playerStatus = PLAYING;
//                playerLock.notifyAll();
//            }
//            return playerStatus == PLAYING;
//        }
//    }
//
//    /**
//     * Stops playback. If not playing, does nothing
//     */
//   /* public void stop() {
//        synchronized (playerLock) {
//            playerStatus = FINISHED;
//            playerLock.notifyAll();
//        }
//    }*/
//
//
//
//
//    /**
//     * Closes the player, regardless of current state.
//     */
//    public void close() {
//        synchronized (playerLock) {
//            playerStatus = FINISHED;
//        }
//        try {
//            player.close();
//        } catch (final Exception e) {
//            // ignore, we are terminating anyway
//
//        }
//    }
//    static FileInputStream input;
//    PausablePlayer player1;
//
//    public void run()
//    {
//        try {
//
//            input =fileInputStream;
//
//            player1 = new PausablePlayer(input,jFrame,jSlider,button1,button2,musicName);
//
//            System.out.println("yaali"+shomarande);
//
//
//            shomarande++;
//                player1.play(input,0);
//
//                shomarande--;
//
//
//
//
//        } catch (final Exception e) {
//
//
//        }
//    }*/
//
//}
//
//
//
//
//
    class Actionlisten3 implements ActionListener
    {
        Thread thread;
        public Actionlisten3(Thread t)
        {
            thread=t;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            thread.resume();
            Mantegh.timeThread.resume();

        }
    }

    class Actionlisten5 implements ActionListener {
        Thread thread;

        public Actionlisten5(Thread t) {
            thread = t;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            thread.suspend();
            Mantegh.timeThread.suspend();


        }
    }

    abstract class ChangeListener1 implements ChangeListener {
        public String name;

    }
}