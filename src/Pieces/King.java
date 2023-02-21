package Pieces;
import Game.Spot;
import java.util.ArrayList;
import GUI.ChessGUI;



public class King extends Piece{

    /**
     * This is the King class which is the sub class of the Piece Class and represents
     * the King piece on the chess board. It can move 1 spot in any direction and is 
     * the most important piece on the board.
     */


    public King(String pieceID, String pieceColor, String imageID, int startX, int startY){
        super(pieceID, pieceColor, imageID, startX, startY);
    }

    public ArrayList<Spot> getPossibleMoves(Spot board[][], int x, int y){

        possibleMoves.clear();

        int[] posx = {x-1, x-1, x, x+1, x+1, x+1, x, x-1};
        int[] posy = {y, y+1, y+1, y+1, y, y-1, y-1, y-1};
        
        for(int i = 0; i <= 8; i++){
            if((posx[i] >= 0 && posx[i] < 8) && (posy[i] >= 0 && posy[i] < 8)){
                if(board[posx[i]][posy[i]].getPiece() == null){
                    possibleMoves.add(board[posx[i]][posy[i]]);
                } else if(board[posx[i]][posy[i]].getPiece() != null && !board[posx[i]][posy[i]].getPiece().getPieceColor().equals(this.getPieceColor())){
                    possibleMoves.add(board[posx[i]][posy[i]]);
                }
            } 
        }

        Spot[][] copy = ChessGUI.getCopyOfBoardState();
        for(int i = 0; i < possibleMoves.size(); i++){
            move(copy, copy[getStartX()][getStartY()], possibleMoves.get(i));
            if(isInCheck(copy)){
                possibleMoves.remove(possibleMoves.get(i));
            }
        }

        return possibleMoves;
    }

    public boolean isInCheck(Spot[][] board){
        return false;
    }
}
