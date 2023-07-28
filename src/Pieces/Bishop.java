package Pieces;
import Game.Spot;
import GUI.ChessGUI;
import java.util.ArrayList;

public class Bishop extends Piece{
    /**
     * This is the Bishop class which is a sub-class of the Piece class
     * and represents the bishop piece on the chess board. It can move
     * in any diagonal direction
     */

    public Bishop(String pieceID, String pieceColor, String imageID, int startX, int startY){
        super(pieceID, pieceColor, imageID, startX, startY);
    }

    public ArrayList<Spot> getPossibleMoves(Spot board[][], int x, int y){
        possibleMoves.clear();

        if (ChessGUI.getCurrentMove().equals(this.getPieceColor())){
            //Adding moves for all digonal directions
            int tempx = x + 1;
            int tempy = y + 1;
            while(tempx < 8 && tempy < 8){
                if(board[tempx][tempy].getPiece() == null){
                    possibleMoves.add(board[tempx][tempy]);
                } else if(board[tempx][tempy].getPiece() != null && !this.getPieceColor().equals(board[tempx][tempy].getPiece().getPieceColor())){
                    possibleMoves.add(board[tempx][tempy]);
                    break;
                } else if(board[tempx][tempy].getPiece() != null && this.getPieceColor().equals(board[tempx][tempy].getPiece().getPieceColor())){
                    break;
                }
                tempx++;
                tempy++;
            }

            tempx = x - 1;
            tempy = y + 1;
            while(tempx >= 0 && tempy < 8){
                if(board[tempx][tempy].getPiece() == null){
                    possibleMoves.add(board[tempx][tempy]);
                } else if(board[tempx][tempy].getPiece() != null && !this.getPieceColor().equals(board[tempx][tempy].getPiece().getPieceColor())){
                    possibleMoves.add(board[tempx][tempy]);
                    break;
                } else if(board[tempx][tempy].getPiece() != null && this.getPieceColor().equals(board[tempx][tempy].getPiece().getPieceColor())){
                    break;
                }
                tempx--;
                tempy++;
            }

            tempx = x - 1;
            tempy = y - 1;
            while(tempx >= 0 && tempy >= 0){
                if(board[tempx][tempy].getPiece() == null){
                    possibleMoves.add(board[tempx][tempy]);
                } else if(board[tempx][tempy].getPiece() != null && !this.getPieceColor().equals(board[tempx][tempy].getPiece().getPieceColor())){
                    possibleMoves.add(board[tempx][tempy]);
                    break;
                } else if(board[tempx][tempy].getPiece() != null && this.getPieceColor().equals(board[tempx][tempy].getPiece().getPieceColor())){
                    break;
                }
                tempx--;
                tempy--;
            }

            tempx = x + 1;
            tempy = y - 1;
            while(tempx < 8 && tempy >= 0){
                if(board[tempx][tempy].getPiece() == null){
                    possibleMoves.add(board[tempx][tempy]);
                } else if(board[tempx][tempy].getPiece() != null && !this.getPieceColor().equals(board[tempx][tempy].getPiece().getPieceColor())){
                    possibleMoves.add(board[tempx][tempy]);
                    break;
                } else if(board[tempx][tempy].getPiece() != null && this.getPieceColor().equals(board[tempx][tempy].getPiece().getPieceColor())){
                    break;
                }
                tempx++;
                tempy--;
            }
        }

        //Accounts for checks

        return possibleMoves;
    } 
    
}
