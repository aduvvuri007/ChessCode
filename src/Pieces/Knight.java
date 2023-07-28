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

        if (ChessGUI.getCurrentMove().equals(this.getPieceColor())){
            int[] posx = {x-1, x-2, x-2, x-1, x+1, x+2, x+2, x+1};
            int[] posy = {y+2, y+1, y-1, y-2, y-2, y-1, y+1, y+2};

            for(int i = 0; i < 8; i++){
                if((posx[i] >= 0 && posx[i] < 8) && (posy[i] >= 0 && posy[i] < 8)){
                    if(board[posx[i]][posy[i]].getPiece() == null){
                        possibleMoves.add(board[posx[i]][posy[i]]);
                    } else if(board[posx[i]][posy[i]].getPiece() != null && !board[posx[i]][posy[i]].getPiece().getPieceColor().equals(this.getPieceColor())){
                        possibleMoves.add(board[posx[i]][posy[i]]);
                    }
                }
            }
        }

        //Accounts for checks

        return possibleMoves;
    }
}
