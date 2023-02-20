package Pieces;
import Game.Spot;
import GUI.ChessGUI;
import java.util.ArrayList;

public class Knight extends Piece{
    
    /**
     * This is the Knight class which is a sub class of the Piece Class.
     * It represents the knight piece on the chess board and can move in 
     * an L shape. It can also jump over other pieces.
     */

     public Knight(String pieceID, String pieceColor, String imageID, int startX, int startY){
        super(pieceID, pieceColor, imageID, startX, startY);
    }

    public ArrayList<Spot> getPossibleMoves(Spot board[][], int x, int y){
        possibleMoves.clear();
        return possibleMoves;
    }

    public void move(Spot[][] boardState, Spot startSpot, Spot endSpot){
        ChessGUI.setPreviousBoardState(boardState);
        endSpot.setPiece(this);
        startSpot.removePiece(this);
    }
}
