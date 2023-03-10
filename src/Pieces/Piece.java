package Pieces;
import Game.Spot;
import java.util.ArrayList;
import GUI.ChessGUI;


/**
 * This is the piece abstract class. It is not an actual object but
 * is used to as a super class for every piece on the chess board.
 * It includes getter methods as well as an abstract method for each piece
 * in order to find out the possible moves that piece can make.
 * 
 */

public abstract class Piece {
    private String pieceColor;
    private String pieceID;
    private String imageID;
    private int startX, startY;
    private boolean captured;
    protected ArrayList<Spot> possibleMoves = new ArrayList<Spot>();

    public Piece(String pieceID, String pieceColor, String imageID, int startX, int startY){
        this.pieceID = pieceID;
        this.pieceColor = pieceColor;
        this.imageID = imageID;
        this.startX = startX;
        this.startY = startY;
    }

    public abstract ArrayList<Spot> getPossibleMoves(Spot board[][], int x, int y);
    
    public void move(Spot[][] boardState, Spot startSpot, Spot endSpot){
        ChessGUI.setPreviousBoardState(boardState);
        endSpot.setPiece(this);
        startSpot.removePiece(this);
    }

    public boolean isCaptured(){
        return this.captured;
    }

    public void setCaptured(boolean captured){
        this.captured = captured;
    }

    public String getPieceColor(){
        return this.pieceColor;
    }

    public String getPieceID(){
        return this.pieceID;
    }

    public String getImageID(){
        return this.imageID;
    }

    public int getStartX(){
        return this.startX;
    }

    public int getStartY(){
        return this.startY;
    }
}
