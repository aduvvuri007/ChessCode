package Pieces;
import Game.Spot;
import GUI.ChessGUI;
import java.util.ArrayList;

public class Pawn extends Piece {

    /**
     * @param pieceID - the id of the piece to be used in code
     * @param pieceColor - the color of the piece
     * @param imageID - the id for an image of the piece
     * 
     * This is the Pawn class which is a sub class of the piece class.
     * It can move 1 or 2 spots (2 spots only when it is the pawn's first move)
     * It can capture a piece diagonally and with en passant
     */
    private int moveCounter = 0;
    private int startX, startY;
    
    public Pawn(String pieceID, String pieceColor, String imageID, int startX, int startY){
        super(pieceID, pieceColor, imageID);
        this.startX = startX;
        this.startY = startY;
    }

    public ArrayList<Spot> getPossibleMoves(Spot board[][], int x, int y){

        //Moving straight up for first move only (will have to add if king will be in check or not)
        if (moveCounter == 0 && board[x][y+1].getPiece() == null && board[x][y+2].getPiece() == null){
            possibleMoves.add(board[x][y+1]);
            possibleMoves.add(board[x][y+2]);
        }

        //Moving normally (will need to account for king being in check as well as potentially promoting pawns)
        if(board[x][y+1].getPiece() == null){
            possibleMoves.add(board[x][y+1]);
        }

        //Capturing normally (will need to account for king being in check as well as potentially promoting pawns)
        if (x == 0){
            if (board[x+1][y+1].getPiece() != null && !board[x+1][y+1].getPiece().getPieceColor().equals(this.getPieceColor())){
                possibleMoves.add(board[x+1][y+1]);
            }
        } else if (x == 7){
            if (board[x-1][y+1].getPiece() != null){
                possibleMoves.add(board[x-1][y+1]);
            }
        } else {
            if (board[x+1][y+1].getPiece() != null && !board[x+1][y+1].getPiece().getPieceColor().equals(this.getPieceColor())){
                possibleMoves.add(board[x+1][y+1]);
            }
            if (board[x-1][y+1].getPiece() != null && !board[x-1][y+1].getPiece().getPieceColor().equals(this.getPieceColor())){
                possibleMoves.add(board[x-1][y+1]);
            }
        }

        //Capturing with en passant (will need to account for king being in check)
        if (x == 0){
            if (board[x+1][y].getPiece() instanceof Pawn && !board[x+1][y].getPiece().getPieceColor().equals(this.getPieceColor())){
                if (((Pawn)board[x+1][y].getPiece()).canBeCapturedWithEnPassant(board, x+1, y)){
                    possibleMoves.add(board[x+1][y]);
                }
            }
        } else if (x == 7){
            if (board[x-1][y].getPiece() instanceof Pawn && !board[x-1][y].getPiece().getPieceColor().equals(this.getPieceColor())){
                if (((Pawn)board[x-1][y].getPiece()).canBeCapturedWithEnPassant(board, x-1, y)){
                    possibleMoves.add(board[x-1][y]);
                }
            }
        } else {
            if (board[x+1][y].getPiece() instanceof Pawn || board[x-1][y].getPiece() instanceof Pawn){
                if (((Pawn)board[x+1][y].getPiece()).canBeCapturedWithEnPassant(board, x+1, y) && !board[x+1][y].getPiece().getPieceColor().equals(this.getPieceColor())){
                    possibleMoves.add(board[x+1][y]);
                } else if (((Pawn)board[x-1][y].getPiece()).canBeCapturedWithEnPassant(board, x-1, y) && !board[x-1][y+1].getPiece().getPieceColor().equals(this.getPieceColor())) {
                    possibleMoves.add(board[x-1][y]);
                }
            }
        }

        return possibleMoves;

    }

    public void move(Spot[][] boardState, Spot startSpot, Spot endSpot){
        ChessGUI.setPreviousBoardState(boardState);
        endSpot.setPiece(this);
        startSpot.removePiece(this);
        moveCounter += 1;
    }

    //Mainly used for en passant
    public boolean canBeCapturedWithEnPassant(Spot[][] boardState, int currentX, int currentY){
        if (this.moveCounter == 1 && currentY - startY == 2 && currentX == startX && !ChessGUI.getPreviousBoardState()[currentX][currentY].equals(boardState[currentX][currentY])){
            return true;
        }
        return false;
    }
}
