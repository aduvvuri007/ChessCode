package Game;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Players extends JPanel{
    private JLabel color;
    private Timer whiteTimer;
    private Timer blackTimer;

    public Players(){
        super(new GridLayout(2, 1, 0, 1));
        this.setBorder(new EmptyBorder(0, 0, 5, 0));
        this.add(new JLabel("White"));
        this.add(new JLabel("Time: "));
        this.add(new JLabel("Black"));
        this.add(new JLabel("Time: "));
        Font displayFont = new Font("Monospaced", Font.BOLD, 16);
        whiteTimer = null;
        blackTimer = null;

    }
}
