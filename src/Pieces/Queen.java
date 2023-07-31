package Pieces;
import Game.Spot;
import GUI.ChessGUI;
import java.util.ArrayList;



public class Queen extends Piece{
    /**
     * This is the Queen class which is a subclass of the Piece Class.
     * It represents the Queen Piece on the chess board and can move
     * up, down, left, right and in any diagonal direction. It is the
     * most powerful piece on the board.
     */


    public Queen(String pieceID, String pieceColor, String imageID, int startX, int startY){
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

            //Adding moves that queen can move diagonally
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

        if (ChessGUI.getKing(ChessGUI.getCurrentMove(), board).isInCheck(board) && possibleMoves.size() > 0) {
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
