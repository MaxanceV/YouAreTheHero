package MainLaunch;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import InterfaceGame.CreatorToolDialog;
import Univers.Enum.ECompetence;

public class SoundManager {
	
	private static Clip currentClip;
	
	
	public static void playSound(String soundFile) {
        stopSound(); // Stop any previously playing sound

        try {
            URL soundURL = SoundManager.class.getClassLoader().getResource(soundFile);
            if (soundURL == null) {
                return; // No sound file to play
            }
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundURL);
            currentClip = AudioSystem.getClip();
            currentClip.open(audioInput);
            currentClip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
	
	public static void playSoundCompetence(ECompetence competence) {
		String filePathRelative = "sons/competences/" + competence.getId()+".wav";
		playSoundEffect(filePathRelative);
	} 
	
	public static void playSoundEffect(String filePath) {
        try {
        	URL soundURL = SoundManager.class.getClassLoader().getResource(filePath);
        	if (soundURL == null) {
        		return; // No sound file to play
        	}
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(soundURL);
            clip.open(inputStream);
            clip.start();  // Jouer une seule fois
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void stopSound() {
        if (currentClip != null && currentClip.isRunning()) {
            currentClip.stop();
            currentClip.close();
            currentClip = null;
        }
    }
}
