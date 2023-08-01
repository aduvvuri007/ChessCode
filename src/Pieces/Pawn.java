package Pieces;
import Game.Spot;
import GUI.ChessGUI;
import java.util.ArrayList;

public class Pawn extends Piece {

    /**
     * This is the Pawn class which is a sub class of the piece class.
     * It can move 1 or 2 spots (2 spots only when it is the pawn's first move)
     * It can capture a piece diagonally and with en passant
     */
    
    private String color;
    
    public Pawn(String pieceID, String pieceColor, String imageID, int startX, int startY){
        super(pieceID, pieceColor, imageID, startX, startY);
        color = pieceColor;
    }

    public ArrayList<Spot> getPossibleMoves(Spot board[][], int x, int y){

        possibleMoves.clear();

        if(ChessGUI.getCurrentMove().equals(color)){
            if(getPieceColor().equals("BLACK")){
                //Moving straight up for first move only (will have to add if king will be in check or not)
                if (x == 1 && board[2][y].getPiece() == null && board[3][y].getPiece() == null){
                    possibleMoves.add(board[x+2][y]);
                }
    
                //Moving normally (will need to account for king being in check as well as potentially promoting pawns)
                if(board[x+1][y].getPiece() == null){
                    possibleMoves.add(board[x+1][y]);
                }
    
                //Capturing normally (will need to account for king being in check as well as potentially promoting pawns)
                if (y == 0){
                    if (board[x+1][y+1].getPiece() != null && !board[x+1][y+1].getPiece().getPieceColor().equals(this.getPieceColor())){
                        possibleMoves.add(board[x+1][y+1]);
                    }
                } else if (y == 7){
                    if (board[x+1][y-1].getPiece() != null && !board[x+1][y-1].getPiece().getPieceColor().equals(this.getPieceColor())){
                        possibleMoves.add(board[x+1][y-1]);
                    }
                } else {
                    if (board[x+1][y+1].getPiece() != null && !board[x+1][y+1].getPiece().getPieceColor().equals(this.getPieceColor())){
                        possibleMoves.add(board[x+1][y+1]);
                    }
                    if (board[x+1][y-1].getPiece() != null && !board[x+1][y-1].getPiece().getPieceColor().equals(this.getPieceColor())){
                        possibleMoves.add(board[x+1][y-1]);
                    }
                }
    
                //NEed to rewrite en passant (will need to account for king being in check)
                if (canCaptureWithEnPassant(board, x, y) != null){
                    possibleMoves.add(canCaptureWithEnPassant(board, x, y));
                    canCaptureWithEnPassant(board, x, y).setEnPassantMove();
                } 
    
            } else if(getPieceColor().equals("WHITE")){
                //Moving straight up for first move only (will have to add if king will be in check or not)
                if (x == 6 && board[5][y].getPiece() == null && board[4][y].getPiece() == null){
                    possibleMoves.add(board[4][y]);
                }
    
                //Moving normally (will need to account for king being in check as well as potentially promoting pawns)
                if(board[x-1][y].getPiece() == null){
                    possibleMoves.add(board[x-1][y]);
                }
    
                //Capturing normally (will need to account for king being in check as well as potentially promoting pawns)
                if (y == 0){
                    if (board[x-1][y+1].getPiece() != null && !board[x-1][y+1].getPiece().getPieceColor().equals(this.getPieceColor())){
                        possibleMoves.add(board[x-1][y+1]);
                    }
                } else if (y == 7){
                    if (board[x-1][y-1].getPiece() != null && !board[x-1][y-1].getPiece().getPieceColor().equals(this.getPieceColor())){
                        possibleMoves.add(board[x-1][y-1]);
                    }
                } else {
                    if (board[x-1][y+1].getPiece() != null && !board[x-1][y+1].getPiece().getPieceColor().equals(this.getPieceColor())){
                        possibleMoves.add(board[x-1][y+1]);
                    }
                    if (board[x-1][y-1].getPiece() != null && !board[x-1][y-1].getPiece().getPieceColor().equals(this.getPieceColor())){
                        possibleMoves.add(board[x-1][y-1]);
                    }
                }
    
                //Need to rewrite En Passant Code 
                if (canCaptureWithEnPassant(board, x, y) != null){
                    possibleMoves.add(canCaptureWithEnPassant(board, x, y));
                    canCaptureWithEnPassant(board, x, y).setEnPassantMove();
                } 
            }
        } else {
            return possibleMoves;
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

    public Spot canCaptureWithEnPassant(Spot[][] board, int x, int y){
        if(ChessGUI.getCurrentMove().equals("WHITE") && x == 3){
            if((y < 7 && board[3][y+1].getPiece() instanceof Pawn && board[3][y+1].hasJustMoved() && board[3][y+1].getPiece().getPieceColor().equals("BLACK") && board[3][y+1].getPiece().getMoveCounter() == 1)){
                return board[2][y+1];
            } 
            if (y > 0 && board[3][y-1].getPiece() instanceof Pawn && board[3][y-1].hasJustMoved() && board[3][y-1].getPiece().getPieceColor().equals("BLACK") && board[3][y-1].getPiece().getMoveCounter() == 1){
                return board[2][y-1];
            }
        } else if (ChessGUI.getCurrentMove().equals("BLACK") && x == 4) {
            if((y < 7 && board[4][y+1].getPiece() instanceof Pawn && board[4][y+1].hasJustMoved() && board[4][y+1].getPiece().getPieceColor().equals("WHITE") && board[4][y+1].getPiece().getMoveCounter() == 1)){
                return board[5][y+1];
            }
            if ((y > 0 && board[4][y-1].getPiece() instanceof Pawn && board[4][y-1].hasJustMoved() && board[4][y-1].getPiece().getPieceColor().equals("WHITE") && board[4][y-1].getPiece().getMoveCounter() == 1)){
                return board[5][y-1];
            }
        }
        return null;
    }
}
