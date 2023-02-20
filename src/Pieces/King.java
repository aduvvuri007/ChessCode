package Pieces;
import Game.Spot;
import java.util.ArrayList;
import java.util.Arrays;
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

    public  void move(Spot[][] boardState, Spot startSpot, Spot endSpot){
        ChessGUI.setPreviousBoardState(boardState);
        endSpot.setPiece(this);
        startSpot.removePiece(this);
    }

    public ArrayList<Spot> getPossibleMoves(Spot board[][], int x, int y){

        possibleMoves.clear();

        ArrayList<Spot> potentialMoves = new ArrayList<Spot>(Arrays.asList(board[x][y+1], board[x+1][y+1], board[x+1][y], board[x+1][y-1], board[x][y-1], board[x-1][y-1], board[x-1][y], board[x-1][y+1]));
        if(x == 0){
            potentialMoves.remove(board[x-1][y-1]);
            potentialMoves.remove(board[x-1][y]);
            potentialMoves.remove(board[x-1][y+1]);
        } else if(x == 7){
            potentialMoves.remove(board[x+1][y+1]);
            potentialMoves.remove(board[x+1][y-1]);
            potentialMoves.remove(board[x+1][y]);
        }

        if(y == 0){
            potentialMoves.remove(board[x+1][y-1]);
            potentialMoves.remove(board[x-1][y-1]);
            potentialMoves.remove(board[x][y-1]);
        } else if(y == 7){
            potentialMoves.remove(board[x][y+1]);
            potentialMoves.remove(board[x+1][y+1]);
            potentialMoves.remove(board[x-1][y+1]);
        }

        for(Spot spot: potentialMoves){
            if(spot.getPiece() != null && !spot.getPiece().getPieceColor().equals(this.getPieceColor())){
                potentialMoves.remove(spot);
            }
        }

        possibleMoves = potentialMoves;

        for(int i = 0; i < possibleMoves.size(); i++){
            Spot[][] copy = ChessGUI.getCopyOfBoardState();
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
