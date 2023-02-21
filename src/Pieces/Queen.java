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

        //Accounts for checks
        Spot[][] copy = ChessGUI.getCopyOfBoardState();
        for(int i = 0; i < possibleMoves.size(); i++){
            move(copy, copy[getStartX()][getStartY()], possibleMoves.get(i));
            if(this.getPieceColor().equals("WHITE")){
                if(ChessGUI.getKing("WHITE").isInCheck(copy)){
                    possibleMoves.remove(possibleMoves.get(i));
                } else if(ChessGUI.getKing("BLACK").isInCheck(copy)){
                    possibleMoves.remove(possibleMoves.get(i));
                }
            }
        }

        return possibleMoves;
    } 
    
}
