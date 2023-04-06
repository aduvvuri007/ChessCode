package Game;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Players extends JPanel{

    private JLabel whitePlayer, blackPlayer;
    private static WhiteTimer whiteTimer;
    private static BlackTimer blackTimer;


    public Players(){
        super(new GridLayout(2, 1, 0, 1));
        this.setBorder(new EmptyBorder(0, 0, 5, 0));
        blackTimer = new BlackTimer();
        whiteTimer = new WhiteTimer();
        blackPlayer = new JLabel("<html>Black<br>Time: <html>");
        whitePlayer = new JLabel("<html>White<br>Time: <html>");
        blackPlayer.setFont(new Font("Monospaced", Font.BOLD, 50));
        whitePlayer.setFont(new Font("Monospaced", Font.BOLD, 50));
        blackTimer.setFont(new Font("Monospaced", Font.BOLD, 50));
        whiteTimer.setFont(new Font("Monospaced", Font.BOLD, 50));
        this.add(blackPlayer, BorderLayout.CENTER);
        this.add(blackTimer);
        this.add(whitePlayer, BorderLayout.CENTER);
        this.add(whiteTimer);
        Dimension size = whiteTimer.getPreferredSize();
        whiteTimer.setBounds(100, 100, size.width, size.height);
        blackTimer.setBounds(100, 100, size.width, size.height);
    }
}
