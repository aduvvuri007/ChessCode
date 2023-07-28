package Pieces;
import Game.Spot;
import java.util.ArrayList;


/**
 * This is the piece abstract class. It is not an actual object but
 * is used to as a super class for every piece on the chess board.
 * It includes getter methods as well as an abstract method for each piece
 * in order to find out the possible moves that piece can make.
 * 
 */

public abstract class Piece implements Cloneable{
    private String pieceColor;
    private String pieceID;
    private String imageID;
    private int startX, startY;
    private int currentX, currentY;
    private boolean captured;
    protected ArrayList<Spot> possibleMoves = new ArrayList<Spot>();

    public Piece(String pieceID, String pieceColor, String imageID, int startX, int startY){
        this.pieceID = pieceID;
        this.pieceColor = pieceColor;
        this.imageID = imageID;
        this.startX = startX;
        this.startY = startY;
        this.currentX = startX;
        this.currentY = startY;
    }

    public abstract ArrayList<Spot> getPossibleMoves(Spot board[][], int x, int y);
    
    public void move(Spot startSpot, Spot endSpot){
        setCurrentX(endSpot.getXPos());
        setCurrentY(endSpot.getYPos());
        if (endSpot.getPiece() != null){
            endSpot.removePiece();
        }
        endSpot.setPiece(this);
        startSpot.removePiece();
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

    public void setCurrentX(int x){
        this.currentX = x;
    }

    public void setCurrentY(int y){
        this.currentY = y;
    }

    public int getCurrentX(){
        return this.currentX;
    }

    public int getCurrentY(){
        return this.currentY;
    }

    public Piece getCopy() throws CloneNotSupportedException{
        return (Piece) this.clone();
    }
}
