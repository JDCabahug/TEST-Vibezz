import Main.Panel;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;

/*
//for testing the audio playback
import ControlPanel.MusicHandler;
import ControlPanel.Playlist;
import ControlPanel.Song;
*/

public class Vibezz{
    public static void main(String [] args){
        /*
        //audio playback test
        MusicHandler music = new MusicHandler();
        //To make a list 
        for (Playlist p : music.getPlaylists()) {
            System.out.println("Playlist: " + p.getName());
            for (Song s : p.getSongs()) {
                System.out.println("  - " + s.getTitle() + " by " + s.getArtist());
            }
        }
        // Test Play (1st get: playlist index, 2nd: song index within the playlist)
        music.play(music.getPlaylists().get(1).getSongs().get(0)); 
        */
        
        JFrame jframe = new JFrame();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setTitle("Vibezz Music Player");
        jframe.setUndecorated(true);

        Panel panel = new Panel();
        jframe.add(panel);
        
        jframe.pack();

        jframe.setShape(new RoundRectangle2D.Double(0, 0, jframe.getWidth(), jframe.getHeight(), 100, 100));
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
}
