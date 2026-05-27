package ControlPanel;

import java.util.ArrayList;

public class Playlist {
    private String name;
    private final ArrayList<Song> songs = new ArrayList<>();

    public Playlist(String name) {
        this.name = name;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public String getName() { return name; }
    public ArrayList<Song> getSongs() { return songs; }
}
