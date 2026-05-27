package ControlPanel;

import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.*;

//Music Database
public class MusicHandler {

    private final ArrayList<Song> playlist1 = new ArrayList<>();
    private Clip clip;
    
    public MusicHandler() {
        //ichange lang ang path
        Song track1 = new Song("Edamame", "BBNO$ & Rich Brian", "C:/Music/edamame.mp3", "C:/Images/edamame.png");
        Song track2 = new Song("Violet", "Connor Price (feat. Killa)", "C:/Music/violet.mp3", "C:/Images/violet.png");
        Song track3 = new Song("Snowman", "Sia", "C:/Music/snowman.mp3", "C:/Images/snowman.png");
        Song track4 = new Song("party at the club bug!", "spellcasting", "C:/Music/partyattheclubbug.mp3", "C:/Images/partyattheclubbug.png");
        Song track5 = new Song("Innocence", "Daniel Caesar", "C:/Music/innocence.mp3", "C:/Images/innocence.png");
        Song track6 = new Song("Landed In Brooklyn", "Khantrast", "C:/Music/landedinbrooklyn.mp3", "C:/Images/landedinbrooklyn.png");
        Song track7 = new Song("Paint The Town Red", "Doja Cat", "C:/Music/paintthetownred.mp3", "C:/Images/paintthetownred.png");
        Song track8 = new Song("Flamenco House", "Iapix", "C:/Music/flamencohouse.mp3", "C:/Images/flamencohouse.png");
        //Song track10 = new Song("Ice Man", "Drake", "C:/Music/iceman.mp3", "C:/Images/iceman.png");

        playlist1.add(track1);
        playlist1.add(track2);
        playlist1.add(track3);
        playlist1.add(track4);
        playlist1.add(track5);
        playlist1.add(track6);
        playlist1.add(track7);
        playlist1.add(track8);
        //playlist.add(track9);
        
    }

    public void play(Song song) {
        try {
            // Stop any currently playing song
            if (clip != null && clip.isRunning()) {
                clip.stop();
                clip.close();
            }

            AudioInputStream audio = AudioSystem.getAudioInputStream(new File(song.getAudioPath()));
            AudioFormat baseFormat = audio.getFormat();
            AudioFormat decodedFormat = new AudioFormat(
                AudioFormat.Encoding.PCM_SIGNED,
                baseFormat.getSampleRate(),
                16,
                baseFormat.getChannels(),
                baseFormat.getChannels() * 2,
                baseFormat.getSampleRate(),
                false
            );
            AudioInputStream decoded = AudioSystem.getAudioInputStream(decodedFormat, audio);
            clip = AudioSystem.getClip();
            clip.open(decoded);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public ArrayList<Song> getPlaylist() {
        return playlist;
    }
}
