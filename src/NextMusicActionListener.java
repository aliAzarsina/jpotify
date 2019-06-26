import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.ArrayList;

public class NextMusicActionListener implements ActionListener {

   static Music music;
    FileInputStream fileInputStream;
    Mantegh mantegh;
    Advanceplayer advanceplayer;
    PausablePlayer pausablePlayer;
    static String musicName;
   static  Album currentAlbum;

     public NextMusicActionListener(Music music,String musicName,Album album,Mantegh mantegh)
     {
         this.mantegh=mantegh;
         this.music=music;
         this.musicName=musicName;
         currentAlbum=album;

     }




    @Override
    public void actionPerformed(ActionEvent e) {

         PausablePlayer.jsliderValue=0;

         try {
             if (Mantegh.currentPausableplayer != null)

             {
                 System.out.println("aaaaaaaaaaaaaaaaaaaaaaa" + Mantegh.currentPausableplayer.musicName);


                 Mantegh.currentPausableplayer.fileInputStream.close();
                 Mantegh.currentPausableplayer.t.suspend();
                 Mantegh.currentPausableplayer.t = null;
             }
         }
         catch (Exception e1)
         {e1.printStackTrace();}

         if(music!=null) {
             int i = 0;
             for (Music music : currentAlbum.musics) {

                 if (music.musicName.equals(this.music.musicName)) {
                     if (i == currentAlbum.musics.size() - 1) {

                         try {
                             fileInputStream = new FileInputStream(currentAlbum.musics.get(0).musicName);
                             advanceplayer = new Advanceplayer(fileInputStream);

                             if(Mantegh.currentPausableplayer!=null)
                             {
                                 System.out.println(Mantegh.currentPausableplayer.musicName+"hosseinali");
                                 Mantegh.currentPausableplayer.t=null;
                                 Mantegh.currentPausableplayer.fileInputStream.close();

                             }


                             pausablePlayer = new PausablePlayer(fileInputStream, mantegh.jpotify, mantegh.jpotify.slider1, mantegh.jpotify.button12, mantegh.jpotify.button13, currentAlbum.musics.get(0).musicName);
                             Mantegh.currentPausableplayer=pausablePlayer;
                             SliderChangeListener.setPausablePlayer(pausablePlayer);

                             mantegh.jpotify.slider1.setMaximum(advanceplayer.calculateframes());
                             mantegh.jpotify.slider1.setMinimum(0);
                             fileInputStream.getChannel().position(0);
                             mantegh.makeThread(mantegh.currentthread, fileInputStream, pausablePlayer);
                             mantegh.jpotify.button12.addActionListener(new Actionlisten2(mantegh.currentthread));
                             mantegh.jpotify.button13.addActionListener(new Actionlisten(mantegh.currentthread));
                             mantegh.currentAlbum = currentAlbum;
                             mantegh.currentthread.start();

                             changeCurrentMusic(currentAlbum.musics.get(0));
                             PreviousButtonActionListener.changeCurrentMusic(currentAlbum.musics.get(0));
                             NextMusicRunnable.changeCurrentAlbum(currentAlbum);

                         } catch (Exception e1) {

                         }


                     } else {
                         try {
                             fileInputStream = new FileInputStream(currentAlbum.musics.get(i + 1).musicName);
                             advanceplayer = new Advanceplayer(fileInputStream);
                             if(Mantegh.currentPausableplayer!=null)
                             {
                                 System.out.println(Mantegh.currentPausableplayer.musicName+"hosseinali");
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
                             mantegh.currentAlbum = currentAlbum;
                             mantegh.currentthread.start();

                             changeCurrentMusic(currentAlbum.musics.get(i + 1));
                             PreviousButtonActionListener.changeCurrentMusic(currentAlbum.musics.get(i + 1));

                             NextMusicRunnable.changeCurrentAlbum(currentAlbum);
                             NextMusicRunnable.musicName=currentAlbum.musics.get(i + 1).musicName;
                         } catch (Exception e1) {

                         }
                     }

                     i = 0;
                     break;

                 }
                 i++;


             }

         }



    }


    static public void changeCurrentAlbum(Album album)
    {
       currentAlbum=album;
    }
    static public void changeCurrentMusic(Music music1)
    {
        music=music1;
    }


}
