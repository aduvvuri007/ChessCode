package Game;
import GUI.*;
import Pieces.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ChessGame {
    
    private String GAMEOVER = "Game Over";
    private String GAMEPLAY = "Game Play";

    public ChessGame(){
        ChessGUI window = new ChessGUI();
        window.setBounds(1600, 1200, 1600, 1200);
        window.setResizable(false);
        window.setDefaultCloseOperation(3);
        window.setVisible(true); 
    }

    public static void main(String [] args){

    }
}
