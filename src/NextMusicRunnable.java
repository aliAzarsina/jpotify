import java.io.FileInputStream;

public class NextMusicRunnable implements Runnable{



    FileInputStream fileInputStream;
    Mantegh mantegh;
    Advanceplayer advanceplayer;
    PausablePlayer pausablePlayer;
    static String musicName;
    static  Album currentAlbum;


    public NextMusicRunnable(String musicName,Album album)
    {
        this.mantegh=MusicActionListener.mantegh;

        this.musicName=musicName;
        currentAlbum=album;

    }


    @Override
    public void run() {
        PausablePlayer.jsliderValue=0;


        int i = 0;
        for (Music music : currentAlbum.musics) {


            if (music.musicName.equals(musicName)) {
                if (i == currentAlbum.musics.size() - 1) {

                    try {
                        fileInputStream = new FileInputStream(currentAlbum.musics.get(0).musicName);
                        advanceplayer = new Advanceplayer(fileInputStream);



                        if(Mantegh.currentPausableplayer!=null)
                        {

                            Mantegh.currentPausableplayer.t=null;
                            Mantegh.currentPausableplayer.fileInputStream.close();

                        }

                        pausablePlayer = new PausablePlayer(fileInputStream, mantegh.jpotify, mantegh.jpotify.slider1, mantegh.jpotify.button12, mantegh.jpotify.button13, currentAlbum.musics.get(0).musicName);

                        SliderChangeListener.setPausablePlayer(pausablePlayer);

                        Mantegh.currentPausableplayer=pausablePlayer;

                        mantegh.jpotify.slider1.setMaximum(advanceplayer.calculateframes());
                        mantegh.jpotify.slider1.setMinimum(0);
                        fileInputStream.getChannel().position(0);
                        mantegh.makeThread(mantegh.currentthread, fileInputStream, pausablePlayer);
                        mantegh.jpotify.button12.addActionListener(new Actionlisten2(mantegh.currentthread));
                        mantegh.jpotify.button13.addActionListener(new Actionlisten(mantegh.currentthread));
                        mantegh.currentthread.start();

                        PreviousButtonActionListener.changeCurrentMusic(currentAlbum.musics.get(0));
                    } catch (Exception e1) {

                    }


                } else {
                    try {
                        fileInputStream = new FileInputStream(currentAlbum.musics.get(i + 1).musicName);
                        advanceplayer = new Advanceplayer(fileInputStream);



                        if(Mantegh.currentPausableplayer!=null)
                        {

                            Mantegh.currentPausableplayer.t=null;
                            Mantegh.currentPausableplayer.fileInputStream.close();

                        }

                        pausablePlayer = new PausablePlayer(fileInputStream, mantegh.jpotify, mantegh.jpotify.slider1, mantegh.jpotify.button12, mantegh.jpotify.button13, currentAlbum.musics.get(i + 1).musicName);

                        SliderChangeListener.setPausablePlayer(pausablePlayer);

                        Mantegh.currentPausableplayer=pausablePlayer;

                        mantegh.jpotify.slider1.setMaximum(advanceplayer.calculateframes());
                        mantegh.jpotify.slider1.setMinimum(0);
                        fileInputStream.getChannel().position(0);
                        mantegh.makeThread(mantegh.currentthread, fileInputStream, pausablePlayer);
                        mantegh.jpotify.button12.addActionListener(new Actionlisten2(mantegh.currentthread));
                        mantegh.jpotify.button13.addActionListener(new Actionlisten(mantegh.currentthread));
                        mantegh.currentthread.start();


                        PreviousButtonActionListener.changeCurrentMusic(currentAlbum.musics.get(i + 1));
                    } catch (Exception e1) {

                    }
                }

                i = 0;
                break;

            }
            i++;


        }

    }






    static public void changeCurrentAlbum(Album album)
    {
        currentAlbum=album;
    }

}
