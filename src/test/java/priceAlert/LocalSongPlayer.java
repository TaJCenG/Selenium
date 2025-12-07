package priceAlert;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class LocalSongPlayer {

    public static void playSong(String filePath) {
        try {
            if (filePath.toLowerCase().endsWith(".wav")) {
                // Handle WAV using Java Sound API
                File songFile = new File(filePath);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(songFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();

                // Keep program alive until song finishes
                Thread.sleep(clip.getMicrosecondLength() / 1000);

            } else if (filePath.toLowerCase().endsWith(".mp3")) {
                // Handle MP3 using JLayer
                FileInputStream fis = new FileInputStream(filePath);
                Player player = new Player(fis);
                player.play();

            } else {
                System.out.println("Unsupported file format. Please use .wav or .mp3");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

