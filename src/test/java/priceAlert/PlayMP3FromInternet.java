package priceAlert;

import java.io.BufferedInputStream;
import java.net.URL;
import javazoom.jl.player.Player;

public class PlayMP3FromInternet {

    // Utility method to play song from internet
    public void playSong(String songUrl) {
        try {
            URL url = new URL(songUrl);
            BufferedInputStream bis = new BufferedInputStream(url.openStream());

            Player player = new Player(bis);
            player.play(); // plays the MP3 from the internet

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
