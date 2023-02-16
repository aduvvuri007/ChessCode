package Pieces;
import Game.Spot;
import java.util.ArrayList;

public class King extends Piece{
    
    private int x, y;

    public King(String pieceID, String pieceColor, String imageID, int x, int y){
        super(pieceID, pieceColor, imageID);
        this.x = x;
        this.y = y;
    }

    public void move(Spot startSpot, Spot endSpot){
        endSpot.setPiece(this);
        startSpot.removePiece(this);
    }

    public ArrayList<Spot> getPossibleMoves(Spot board[][], int x, int y){
        return possibleMoves;
    }

    public boolean isInCheck(Spot[][] board){
        return false;
    }
}
