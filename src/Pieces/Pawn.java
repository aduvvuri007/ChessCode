package Pieces;
import Game.Spot;
import java.util.ArrayList;

public class Pawn extends Piece {

    /**
     * @param pieceID - the id of the piece to be used in code
     * @param pieceColor - the color of the piece
     * @param imageID - the id for an image of the piece
     * 
     * This is the Pawn class which is a sub class of the piece class.
     * It can move 1 or 2 spots (2 spots only when it is the pawn's first move)
     * It can capture a piece diagonally and with en passant
     */
    
    public Pawn(String pieceID, String pieceColor, String imageID){
        super(pieceID, pieceColor, imageID);
    }

    public ArrayList<Spot> getPossibleMoves(Spot board[][], int x, int y){
        return possibleMoves;
    }
}
