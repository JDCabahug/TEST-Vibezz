import javax.swing.JFrame;

public class Vibezz{
    public static void main(String [] args){

        JFrame jframe = new JFrame();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setTitle("Vibezz Music Player");

        Panel panel = new Panel();
        jframe.add(panel);
        
        jframe.pack();

        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
}
