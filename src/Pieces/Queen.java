package Pieces;
import Game.Spot;
import GUI.ChessGUI;
import java.util.ArrayList;



public class Queen extends Piece{
    /**
     * This is the Queen class which is a subclass of the Piece Class.
     * It represents the Queen Piece on the chess board and can move
     * up, down, left, right and in any diagonal direction. It is the
     * most powerful piece on the board.
     */


    public Queen(String pieceID, String pieceColor, String imageID, int startX, int startY){
        super(pieceID, pieceColor, imageID, startX, startY);
    }

    public ArrayList<Spot> getPossibleMoves(Spot board[][], int x, int y){
        possibleMoves.clear();

        //Adding moves that the queen can move up

        return possibleMoves;
    } 

    public void move(Spot[][] boardState, Spot startSpot, Spot endSpot){
        ChessGUI.setPreviousBoardState(boardState);
        endSpot.setPiece(this);
        startSpot.removePiece(this);
    }
}
