import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class Panel extends JPanel {
    
    private final int screenWidth = 650, screenHeight = 700;

    public Panel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setLayout(null);
        this.setDoubleBuffered(true);
        this.setBackground(Color.decode("#363636"));
    }

}
