package Game;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Players extends JPanel{
    private JLabel color;
    private Time whiteTimer;
    private Time blackTimer;

    public Players(){
        super(new GridLayout(2, 1, 0, 1));
        this.setBorder(new EmptyBorder(0, 0, 5, 0));
        JLabel blackPlayer = new JLabel("<html>Black<br>Time: <html>");
        JLabel whitePlayer = new JLabel("<html>White<br>Time: <html>");
        blackPlayer.setFont(new Font("Monospaced", Font.BOLD, 50));
        whitePlayer.setFont(new Font("Monospaced", Font.BOLD, 50));
        this.add(blackPlayer, BorderLayout.CENTER);
        this.add(whitePlayer, BorderLayout.CENTER);
        whiteTimer = null;
        blackTimer = null;

    }
}
