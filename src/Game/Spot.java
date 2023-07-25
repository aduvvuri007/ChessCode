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
    private JLabel content;
    private boolean isValidSpot, isCheck, isSelected;
    private String homeDirectory = System.getProperty("user.home");

    public Spot(GridLayout g, int x, int y, Piece piece){
        super(g);
        this.x = x;
        this.y = y;

        if ((x + y) % 2 == 0) {
            setBackground(new Color(219, 204, 182));
        } else {
            setBackground(new Color(99, 71, 30));;
        }

        if (piece != null){
            setPiece(piece);
        }
    }
    
    public Piece getPiece(){
        return this.piece;
    }

    public void setPiece(Piece p){
        this.piece = p;
        ImageIcon img = new ImageIcon(homeDirectory + "\\ChessCode\\Images\\" + p.getImageID());
        img.setImage(img.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
		content = new JLabel(img);
		this.add(content);
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
        this.setBackground(new Color(195, 208, 227));;
        isSelected = true;
    }

    public void deselect(){
        if ((this.x + this.y) % 2 == 0) {
            this.setBackground(new Color(219, 204, 182));
        } else {
            this.setBackground(new Color(99, 71, 30));;
        }
        isSelected = false;
    }

    public boolean isSelected(){
        return isSelected;
    }
}
