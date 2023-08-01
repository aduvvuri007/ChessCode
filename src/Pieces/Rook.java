package Pieces;
import Game.Spot;
import GUI.ChessGUI;
import java.util.ArrayList;

public class Rook extends Piece{
    /**
     * This is the Rook class which is a sub-class of the Piece class
     * and represents the rook piece on the chess board. It can move
     * in a any vertical and horizontal direction.
     */

    public Rook(String pieceID, String pieceColor, String imageID, int startX, int startY){
        super(pieceID, pieceColor, imageID, startX, startY);
    }

    public ArrayList<Spot> getPossibleMoves(Spot board[][], int x, int y){
        possibleMoves.clear();

        if (ChessGUI.getCurrentMove().equals(this.getPieceColor())){
            //Adding vertical moves
            for(int i = x+1; i < 8; i++){
                if(board[i][y].getPiece() == null){
                    possibleMoves.add(board[i][y]);
                } else if(board[i][y].getPiece() != null && !this.getPieceColor().equals(board[i][y].getPiece().getPieceColor())){
                    possibleMoves.add(board[i][y]);
                    break;
                } else if(board[i][y].getPiece() != null && this.getPieceColor().equals(board[i][y].getPiece().getPieceColor())){
                    break;
                }
            }

            for(int i = x-1; i >= 0; i--){
                if(board[i][y].getPiece() == null){
                    possibleMoves.add(board[i][y]);
                } else if(board[i][y].getPiece() != null && !this.getPieceColor().equals(board[i][y].getPiece().getPieceColor())){
                    possibleMoves.add(board[i][y]);
                    break;
                } else if(board[i][y].getPiece() != null && this.getPieceColor().equals(board[i][y].getPiece().getPieceColor())){
                    break;
                }
            }

            //Adding horizontal moves
            for(int i = y+1; i < 8; i++){
                if(board[x][i].getPiece() == null){
                    possibleMoves.add(board[x][i]);
                } else if(board[x][i].getPiece() != null && !this.getPieceColor().equals(board[x][i].getPiece().getPieceColor())){
                    possibleMoves.add(board[x][i]);
                    break;
                } else if(board[x][i].getPiece() != null && this.getPieceColor().equals(board[x][i].getPiece().getPieceColor())){
                    break;
                }
            }

            for(int i = y-1; i >= 0; i--){
                if(board[x][i].getPiece() == null){
                    possibleMoves.add(board[x][i]);
                } else if(board[x][i].getPiece() != null && !this.getPieceColor().equals(board[x][i].getPiece().getPieceColor())){
                    possibleMoves.add(board[x][i]);
                    break;
                } else if(board[x][i].getPiece() != null && this.getPieceColor().equals(board[x][i].getPiece().getPieceColor())){
                    break;
                }
            }
        }

        if (possibleMoves.size() > 0) {
            ArrayList<Spot> validMoves = new ArrayList<>();
        
            for (Spot move : possibleMoves) {
                int startX = getCurrentX();
                int startY = getCurrentY();
                int targetX = move.getXPos();
                int targetY = move.getYPos();
                Piece targetPiece = board[targetX][targetY].getPiece();
        
                // Simulate the move
                if (targetPiece != null){
                    board[targetX][targetY].removePiece();
                    board[targetX][targetY].setPiece(this);
                    board[startX][startY].removePiece();
                } else {
                    board[targetX][targetY].setPiece(this);
                    board[startX][startY].removePiece();
                }
        
                if (!ChessGUI.getKing(ChessGUI.getCurrentMove(), board).isInCheck(board)) {
                    validMoves.add(move);
                }
        
                if (targetPiece != null){
                    board[startX][startY].setPiece(this);
                    board[targetX][targetY].removePiece();
                    board[targetX][targetY].setPiece(targetPiece);
                } else {
                    board[startX][startY].setPiece(this);
                    board[targetX][targetY].removePiece();
                }
            }
            return validMoves;
        }

        return possibleMoves;
    } 
    
}
