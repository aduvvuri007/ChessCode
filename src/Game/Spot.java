package Game;
import Pieces.*;
import java.awt.*;
import javax.swing.*;

/**
 * This is the Spot Class
 * It represents one of the 64 spots that are on a chess board.
 * It has a x and y position, can store a piece and has either a 
 * white or black color.
 * 
 */

public class Spot extends JPanel{
    private int x, y;
    private Piece piece;
    private boolean isValidSpot, isCheck, isSelected;

    public Spot(int x, int y, Piece piece){
        this.x = x;
        this.y = y;

        if ((x + y) % 2 == 0) {
            setBackground(new Color(99, 71, 30));
        } else {
            setBackground(new Color(219, 204, 182));
        }

        if (piece != null){
            setPiece(piece);
        }
    }
    
    public Piece getPiece(){
        return this.piece;
    }

    public void setPiece(Piece piece){
        this.piece = piece;
    }

    public int getXPos(){
        return this.x;
    }

    public int getYPos(){
        return this.y;
    }

    public void removePiece(Piece piece){
        this.piece = null;
    }

    public void obtainPiece(Piece piece){
        this.piece = piece;
    }

    public boolean isValidSpot(){
        return this.isValidSpot;
    }

    public void setValidSpot(){
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        isValidSpot = true;
    }

    public void removeValidSpot(){
        this.setBorder(BorderFactory.createLineBorder(Color.RED));
        isValidSpot = false;
    }

    public boolean isInCheck(){
        return isCheck;
    }

    public void setCheck(){
        this.setBorder(BorderFactory.createLineBorder(Color.RED));
        isCheck = true;
    }

    public void removeCheck(){
        this.setBorder(null);
        isCheck = false;
    }

    public void select(){
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        isSelected = true;
    }

    public void deselect(){
        this.setBorder(null);
        isSelected = false;
    }

    public boolean isSelected(){
        return isSelected;
    }
}
