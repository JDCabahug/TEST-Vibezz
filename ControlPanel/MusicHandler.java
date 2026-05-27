package ControlPanel;

import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.*;

public class MusicHandler {

    private ArrayList<Playlist> playlists = new ArrayList<>();
    private Clip clip;

    public MusicHandler() {
        //Playlist 1
        Playlist p1 = new Playlist("Playlist 1"); //ichange lang ang path kung asa nakabutang ang file
        p1.addSong (new Song("Edamame", "BBNO$ & Rich Brian", "C:/Users/Administrator/Downloads/Music/edamame.mp3", "C:/Images/edamame.png"));
        p1.addSong (new Song("Violet", "Connor Price (feat. Killa)", "C:/Users/Administrator/Downloads/Music/violet.mp3", "C:/Images/violet.png"));
        p1.addSong (new Song("Snowman", "Sia", "C:/Users/Administrator/Downloads/Music/snowman.mp3", "C:/Images/snowman.png"));
        p1.addSong (new Song("party at the club bug!", "spellcasting", "C:/Users/Administrator/Downloads/Music/partyattheclubbug.mp3", "C:/Images/partyattheclubbug.png"));
        p1.addSong (new Song("Innocence", "Daniel Caesar", "C:/Users/Administrator/Downloads/Music/innocence.mp3", "C:/Images/innocence.png"));
        p1.addSong (new Song("Landed In Brooklyn", "Khantrast", "C:/Users/Administrator/Downloads/Music/landedinbrooklyn.mp3", "C:/Images/landedinbrooklyn.png"));
        p1.addSong (new Song("Paint The Town Red", "Doja Cat", "C:/Users/Administrator/Downloads/Music/paintthetownred.mp3", "C:/Images/paintthetownred.png"));
        p1.addSong (new Song("Flamenco House", "Iapix", "C:/Users/Administrator/Downloads/Music/flamencohouse.mp3", "C:/Images/flamencohouse.png"));

        //Drake Playlist
        Playlist dk = new Playlist("ICE MAN");
        dk.addSong (new Song("Firm Friends", "Drake", "C:/Users/Administrator/Downloads/Music/Firm Friends.mp3", "C:/Images/Iceman.png"));
        dk.addSong (new Song("2 Hard 4 The Radio", "Drake", "C:/Users/Administrator/Downloads/Music/2 Hard 4 The Radio.mp3", "C:/Images/Iceman.png"));
        dk.addSong (new Song("B's On The Table (feat. 21 Savage)", "Drake", "C:/Users/Administrator/Downloads/Music/B's On The Table (feat. 21 Savage).mp3", "C:/Images/Iceman.png"));
        dk.addSong (new Song("Burning Bridges", "Drake", "C:/Users/Administrator/Downloads/Music/Burning Bridges.mp3", "C:/Images/Iceman.png"));
        dk.addSong (new Song("Don’t Worry", "Drake", "C:/Users/Administrator/Downloads/Music/Don’t Worry.mp3", "C:/Images/Iceman.png"));
        dk.addSong (new Song("Dust", "Drake", "C:/Users/Administrator/Downloads/Music/Dust.mp3", "C:/Images/Iceman.png"));
        dk.addSong (new Song("Janice STFU", "Drake", "C:/Users/Administrator/Downloads/Music/Janice STFU.mp3", "C:/Images/Iceman.png"));
        dk.addSong (new Song("Little Birdie", "Drake", "C:/Users/Administrator/Downloads/Music/Little Birdie.mp3", "C:/Images/Iceman.png"));
        dk.addSong (new Song("Make Them Cry", "Drake", "C:/Users/Administrator/Downloads/Music/Make Them Cry.mp3", "C:/Images/Iceman.png"));
        dk.addSong (new Song("Make Them Know", "Drake", "C:/Users/Administrator/Downloads/Music/Make Them Know.mp3", "C:/Images/Iceman.png"));
        dk.addSong (new Song("Make Them Pay", "Drake", "C:/Users/Administrator/Downloads/Music/Make Them Pay.mp3", "C:/Images/Iceman.png"));
        dk.addSong (new Song("Make Them Remember", "Drake", "C:/Users/Administrator/Downloads/Music/Make Them Remember.mp3", "C:/Images/Iceman.png"));
        dk.addSong (new Song("National Treasures", "Drake", "C:/Users/Administrator/Downloads/Music/National Treasures.mp3", "C:/Images/Iceman.png"));
        dk.addSong (new Song("Plot Twist", "Drake", "C:/Users/Administrator/Downloads/Music/Plot Twist.mp3", "C:/Images/Iceman.png"));
        dk.addSong (new Song("Ran To Atlanta (feat. Future & Molly Santana)", "Drake", "C:/Users/Administrator/Downloads/Music/Ran To Atlanta (feat. Future & Molly Santana).mp3", "C:/Images/Iceman.png"));
        dk.addSong (new Song("Shabang", "Drake", "C:/Users/Administrator/Downloads/Music/Shabang.mp3", "C:/Images/Iceman.png"));
        dk.addSong (new Song("What Did I Miss", "Drake", "C:/Users/Administrator/Downloads/Music/What Did I Miss.mp3", "C:/Images/Iceman.png"));
        dk.addSong (new Song("Whisper My Name", "Drake", "C:/Users/Administrator/Downloads/Music/Whisper My Name.mp3", "C:/Images/Iceman.png"));
        //dk.addSong (new Song("", "Drake", "C:/Music/.mp3", "C:/Images/Iceman.png"));

        playlists.add(p1);
        playlists.add(dk);
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
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

    
}
