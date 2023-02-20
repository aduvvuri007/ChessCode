package GUI;
import javax.swing.*;
import java.awt.*;
import Game.Spot;
import Pieces.*;;


public class ChessGUI extends JFrame{

    private static JPanel gameboard = new JPanel(new GridLayout(8,8));
    private static Spot[][] board = new Spot[8][8];
    private static Spot[][] previousBoardState;
    private static King wKing;
    private static King bKing;

    public ChessGUI(){
        super("Chess");

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                Spot spot = new Spot(new GridLayout(1, 1), i, j, null);
                gameboard.add(spot);
            }
        }

        wKing = new King("WK", "WHITE", "xxxx", 7, 4);
        bKing = new King("BK", "BLACK", "xxxx", 0, 4);

    }

    public static void setPreviousBoardState(Spot[][] boardState){
        previousBoardState = boardState;
    }

    public static Spot[][] getPreviousBoardState(){
        return previousBoardState;
    }

    public static Spot[][] getCurrentBoardState(){
        return board;
    }

    public static Spot[][] getCopyOfBoardState(){
        Spot[][] copy = board;
        return copy;
    }

    public static King getKing(String color){
        if(color.equals("WHITE")){
            return wKing;
        } else if(color.equals("BLACK")){
            return bKing;
        }
        return null;
    }

    public static void main(String[] args){
        ChessGUI window = new ChessGUI();
        window.add(gameboard);
        window.setBounds(1200, 1200, 1200, 1200);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setVisible(true); 
    }
}
