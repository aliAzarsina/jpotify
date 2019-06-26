
import javazoom.jl.player.advanced.AdvancedPlayer;
import java.io.FileInputStream;
public class Advanceplayer extends AdvancedPlayer {

    public Advanceplayer(FileInputStream fileInputStream) throws Exception
    {
        super(fileInputStream);
    }

    public  int calculateframes()
    {
        int counter = 0;
        try {
            while (this.skipFrame()) {
                counter++;
            }
        } catch (Exception e) {

        }
        return counter;
    }




}