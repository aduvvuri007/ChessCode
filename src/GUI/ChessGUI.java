package GUI;
import javax.swing.*;
import java.awt.*;
import Game.Spot;


public class ChessGUI extends JFrame{

    private static JPanel gameboard = new JPanel(new GridLayout(8,8));
    private static Spot[][] board = new Spot[8][8];

    public ChessGUI(){
        super("Chess");

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                Spot spot = new Spot(new GridLayout(1, 1), i, j, null);
                gameboard.add(spot);
            }
        }
    }

    public static void main(String[] args){
        ChessGUI window = new ChessGUI();
        window.add(gameboard);
        window.setBounds(1200, 1200, 1200, 1200);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setVisible(true); 
    }
}
