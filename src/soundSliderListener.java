import javazoom.jl.player.advanced.AdvancedPlayer;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class soundSliderListener implements ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
        int value = Jpotify.slider2.getValue();
        //Jpotify.setVolume(value);
    }
}
