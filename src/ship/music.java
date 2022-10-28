package ship;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class music{
	Clip clip;
	URL soundURL[]= new URL[20];
	public music() {
		soundURL[0]= getClass().getResource("/music/m4.wav");
		soundURL[1]= getClass().getResource("/music/sh.wav");
		soundURL[2]= getClass().getResource("/music/e.wav");
	}
	
	public void setFile(int i) {
		try {
			AudioInputStream a=AudioSystem.getAudioInputStream(soundURL[i]);
			clip=AudioSystem.getClip();
			clip.open(a);
		}
		catch(Exception e) {
			
		}
	}
	public void play() {
		clip.start();
	}
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	public void stop() {
		clip.stop();
	}
	
		
}