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
    
    private int moveCounter = 0;
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
                if (moveCounter == 0 && board[x+1][y].getPiece() == null && board[x+2][y].getPiece() == null){
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
                    if (board[x-1][y+1].getPiece() != null && !board[x-1][y+1].getPiece().getPieceColor().equals(this.getPieceColor())){
                        possibleMoves.add(board[x+1][y-1]);
                    }
                }
    
                //Capturing with en passant (will need to account for king being in check)
                if (y == 0){
                    if (board[x][y+1].getPiece() instanceof Pawn && !board[x][y+1].getPiece().getPieceColor().equals(this.getPieceColor())){
                        if (((Pawn)board[x][y+1].getPiece()).canBeCapturedWithEnPassant(board, x, y+1)){
                            possibleMoves.add(board[x+1][y+1]);
                        }
                    }
                } else if (y == 7){
                    if (board[x][y-1].getPiece() instanceof Pawn && !board[x][y-1].getPiece().getPieceColor().equals(this.getPieceColor())){
                        if (((Pawn)board[x][y-1].getPiece()).canBeCapturedWithEnPassant(board,x, y-1)){
                            possibleMoves.add(board[x+1][y-1]);
                        }
                    }
                } else {
                    if (board[x][y+1].getPiece() instanceof Pawn || board[x][y-1].getPiece() instanceof Pawn){
                        if (((Pawn)board[x][y+1].getPiece()).canBeCapturedWithEnPassant(board, x+1, y) && !board[x][y+1].getPiece().getPieceColor().equals(this.getPieceColor())){
                            possibleMoves.add(board[x+1][y+1]);
                        } else if (((Pawn)board[x][y-1].getPiece()).canBeCapturedWithEnPassant(board, x, y-1) && !board[x][y-1].getPiece().getPieceColor().equals(this.getPieceColor())) {
                            possibleMoves.add(board[x+1][y-1]);
                        }
                    }
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
    
                //Capturing with en passant (will need to account for king being in check)
                if (y == 0){
                    if (board[x][y+1].getPiece() instanceof Pawn && !board[x][y+1].getPiece().getPieceColor().equals(this.getPieceColor())){
                        if (((Pawn)board[x][y+1].getPiece()).canBeCapturedWithEnPassant(board, x, y+1)){
                            possibleMoves.add(board[x-1][y+1]);
                        }
                    }
                } else if (y == 7){
                    if (board[x][y-1].getPiece() instanceof Pawn && !board[x][y-1].getPiece().getPieceColor().equals(this.getPieceColor())){
                        if (((Pawn)board[x][y-1].getPiece()).canBeCapturedWithEnPassant(board,x, y-1)){
                            possibleMoves.add(board[x-1][y-1]);
                        }
                    }
                } else {
                    if (board[x][y+1].getPiece() instanceof Pawn || board[x][y-1].getPiece() instanceof Pawn){
                        if (((Pawn)board[x][y+1].getPiece()).canBeCapturedWithEnPassant(board, x, y+1) && !board[x][y+1].getPiece().getPieceColor().equals(this.getPieceColor())){
                            possibleMoves.add(board[x-1][y+1]);
                        } else if (((Pawn)board[x][y-1].getPiece()).canBeCapturedWithEnPassant(board, x, y-1) && !board[x][y-1].getPiece().getPieceColor().equals(this.getPieceColor())) {
                            possibleMoves.add(board[x-1][y-1]);
                        }
                    }
                }
            }
        } else {
            return possibleMoves;
        }

    

        //Accounts for checks
        Spot[][] copy = ChessGUI.getCopyOfBoardState();
        for(int i = 0; i < possibleMoves.size(); i++){
            move(copy, copy[x][y], possibleMoves.get(i));
            if(this.getPieceColor().equals("WHITE")){
                if(ChessGUI.getKing("WHITE").isInCheck(copy)){
                    possibleMoves.get(i).removePiece();
                    possibleMoves.remove(possibleMoves.get(i));
                }
            } else if (this.getPieceColor().equals("BLACK")) {
                if(ChessGUI.getKing("BLACK").isInCheck(copy)){
                    possibleMoves.get(i).removePiece();
                    possibleMoves.remove(possibleMoves.get(i));
                }
            }
            possibleMoves.get(i).removePiece();
        }

        copy[x][y].setPiece(this);

        return possibleMoves;
    }

    public void move(Spot[][] boardState, Spot startSpot, Spot endSpot){
        endSpot.setPiece(this);
        startSpot.removePiece();
        moveCounter += 1;
    } 

    //Mainly used for en passant
    public boolean canBeCapturedWithEnPassant(Spot[][] boardState, int currentX, int currentY){
        if (((Pawn) boardState[currentX][currentY].getPiece()).getMoveCounter() == 1 && Math.abs(currentY - boardState[currentX][currentY].getPiece().getStartY()) == 2 && currentX == boardState[currentX][currentY].getPiece().getStartX() && !ChessGUI.getPreviousBoardState()[currentX][currentY].equals(boardState[currentX][currentY])){
            return true;
        }
        return false;
    }

    public int getMoveCounter(){
        return moveCounter;
    }
}
