import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.io.FileInputStream;

public class SliderChangeListener implements ChangeListener {

    static PausablePlayer player1;
    static FileInputStream input;
    static String musicName;
    @Override
    public void stateChanged(ChangeEvent e) {


    }


    static void setPausablePlayer(PausablePlayer pausablePlayer)
    {
        player1=pausablePlayer;
    }

    static void fileInputStream (FileInputStream fileInputStream)
    {
        input=fileInputStream;
    }
    static void musicName (String musicName1)
    {
        musicName=musicName1;
    }


}
