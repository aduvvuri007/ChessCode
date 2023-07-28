package GUI;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.*;
import Game.Spot;
import Game.BlackTimer;
import Game.WhiteTimer;
import Game.Players;
import Pieces.*;


public class ChessGUI extends JFrame {

    private static Spot[][] board = new Spot[8][8];
    private static Spot[][] previousBoardState;
    private static King wKing;
    private static King bKing;

    private Pawn wPawn1;
    private Pawn wPawn2;
    private Pawn wPawn3;
    private Pawn wPawn4;
    private Pawn wPawn5;
    private Pawn wPawn6;
    private Pawn wPawn7; 
    private Pawn wPawn8; 

    private Pawn bPawn1;
    private Pawn bPawn2; 
    private Pawn bPawn3; 
    private Pawn bPawn4; 
    private Pawn bPawn5; 
    private Pawn bPawn6; 
    private Pawn bPawn7; 
    private Pawn bPawn8; 

    private Rook wRook1; 
    private Rook wRook2; 
    private Rook bRook1; 
    private Rook bRook2; 

    private Knight wKnight1; 
    private Knight wKnight2; 
    private Knight bKnight1;
    private Knight bKnight2;

    private Bishop wBishop1;
    private Bishop wBishop2; 
    private Bishop bBishop1;
    private Bishop bBishop2; 

    private Queen wQueen;
    private Queen bQueen;

    private static String currentMove = "WHITE";

    public ChessGUI(){
        super("Chess");
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(0, 5, 0, 5));
        JPanel gameboard = new JPanel(new GridLayout(8,8));

        wKing = new King("WK", "WHITE", "White_King.png", 7, 4);
        bKing = new King("BK", "BLACK", "Black_King.png", 0, 4);

        wPawn1 = new Pawn("WP1", "WHITE", "White_Pawn.png", 6, 0);
        wPawn2 = new Pawn("WP2", "WHITE", "White_Pawn.png", 6, 1);
        wPawn3 = new Pawn("WP3", "WHITE", "White_Pawn.png", 6, 2);
        wPawn4 = new Pawn("WP4", "WHITE", "White_Pawn.png", 6, 3);
        wPawn5 = new Pawn("WP5", "WHITE", "White_Pawn.png", 6, 4);
        wPawn6 = new Pawn("WP6", "WHITE", "White_Pawn.png", 6, 5);
        wPawn7 = new Pawn("WP7", "WHITE", "White_Pawn.png", 6, 6);
        wPawn8 = new Pawn("WP8", "WHITE", "White_Pawn.png", 6, 7);

        bPawn1 = new Pawn("BP1", "BLACK", "Black_Pawn.png", 1, 0);
        bPawn2 = new Pawn("BP2", "BLACK", "Black_Pawn.png", 1, 1);
        bPawn3 = new Pawn("BP3", "BLACK", "Black_Pawn.png", 1, 2);
        bPawn4 = new Pawn("BP4", "BLACK", "Black_Pawn.png", 1, 3);
        bPawn5 = new Pawn("BP5", "BLACK", "Black_Pawn.png", 1, 4);
        bPawn6 = new Pawn("BP6", "BLACK", "Black_Pawn.png", 1, 5);
        bPawn7 = new Pawn("BP7", "BLACK", "Black_Pawn.png", 1, 6);
        bPawn8 = new Pawn("BP8", "BLACK", "Black_Pawn.png", 1, 7);

        wRook1 = new Rook("WR1", "WHITE", "White_Rook.png", 7, 0);
        wRook2 = new Rook("WR2", "WHITE", "White_Rook.png", 7, 7);
        bRook1 = new Rook("BR1", "BLACK", "Black_Rook.png", 0, 0);
        bRook2 = new Rook("BR2", "BLACK", "Black_Rook.png", 0, 7);

        wKnight1 = new Knight("WKn1", "WHITE", "White_Knight.png", 7, 1);
        wKnight2 = new Knight("WKn2", "WHITE", "White_Knight.png", 7, 6);
        bKnight1 = new Knight("BKn1", "BLACK", "Black_Knight.png", 0, 1);
        bKnight2 = new Knight("BKn2", "BLACK", "Black_Knight.png", 0, 6);


        wBishop1 = new Bishop("WB1", "WHITE", "White_Bishop.png", 7, 2);
        wBishop2 = new Bishop("WB2", "WHITE", "White_Bishop.png", 7, 5);
        bBishop1 = new Bishop("BB1", "BLACK", "Black_Bishop.png", 0, 2);
        bBishop2 = new Bishop("BB2", "BLACK", "Black_Bishop.png", 0, 5);

        wQueen = new Queen("WQ", "WHITE", "White_Queen.png", 7, 3);
        bQueen = new Queen("BQ", "BLACK", "Black_Queen.png", 0, 3);

        Piece[] pieces = {wPawn1, wPawn2, wPawn3, wPawn4, wPawn5, wPawn6, wPawn7, wPawn8,
                          bPawn1, bPawn2, bPawn3, bPawn4, bPawn5, bPawn6, bPawn7, bPawn8,
                          wRook1, wRook2, bRook1, bRook2, wKnight1, wKnight2, bKnight1, bKnight2,
                          wBishop1, wBishop2, bBishop1, bBishop2, wQueen, bQueen, wKing, bKing};

        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                board[i][j] = new Spot(new GridLayout(1, 1), i, j, null);
            }
        }

        for(int i = 0; i < pieces.length; i++){
            board[pieces[i].getStartX()][pieces[i].getStartY()].setPiece(pieces[i]);
        }

        MouseAdapter mouseHandler = new MouseAdapter() {
            private Spot lastClicked;
            private ArrayList<Spot> moves;
            public void mouseClicked(MouseEvent e) {
                if (lastClicked != null && lastClicked.isSelected()) {
                    lastClicked.deselect();
                    Spot s = (Spot) e.getSource();
                    if (s.isValidSpot()){
                        lastClicked.getPiece().move(board, board[lastClicked.getXPos()][lastClicked.getYPos()], s);
                        changeMove();
                        if (currentMove.equals("WHITE")){
                            BlackTimer.getBlackTimer().stop();
                            WhiteTimer.getWhiteTimer().start();
                        } else if (currentMove.equals("BLACK")){
                            WhiteTimer.getWhiteTimer().stop();
                            BlackTimer.getBlackTimer().start();
                        }
                    }
                    for (Spot n : moves){
                        if ((n.getXPos() + n.getYPos()) % 2 == 0) {
                            n.setBackground(new Color(219, 204, 182));
                        } else {
                            n.setBackground(new Color(99, 71, 30));;
                        }
                        n.removeValidSpot();
                    }
                } 
                if (e.getSource() instanceof Spot) {
                    Spot spot = (Spot) e.getSource();
                    if (spot.isSelected()){
                        spot.deselect();
                    } else if (!spot.isSelected()) {
                        spot.select();
                    }

                    if (spot.getPiece() != null){
                        moves = spot.getPiece().getPossibleMoves(board, spot.getXPos(), spot.getYPos());
                        moves.forEach(n -> n.setBackground(Color.YELLOW));
                        moves.forEach(n -> n.setValidSpot());
                    }

                    lastClicked = spot;
                }
            }
        };

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                gameboard.add(board[i][j]);
                board[i][j].addMouseListener(mouseHandler);
            }
        }

        
        Players players = new Players();

        panel.add(gameboard);
        panel.setBorder(new EmptyBorder(0, 0, 0, 200));
        panel.add(players, BorderLayout.EAST);
        this.add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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

    public static void changeMove(){
        if (currentMove.equals("WHITE")){
            currentMove = "BLACK";
        } else if (currentMove.equals("BLACK")) {
            currentMove = "WHITE";
        }
    }

    public static String getCurrentMove(){
        return currentMove;
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
        window.setBounds(1600, 1200, 1600, 1200);
        window.setResizable(false);
        window.setVisible(true); 
        BlackTimer.getBlackTimer().stop();
    }
}