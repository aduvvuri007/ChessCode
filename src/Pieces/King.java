package Pieces;
import Game.Spot;
import java.util.ArrayList;
import java.util.Arrays;

import GUI.ChessGUI;

public class King extends Piece{
    
    private int x, y;

    public King(String pieceID, String pieceColor, String imageID, int x, int y){
        super(pieceID, pieceColor, imageID);
        this.x = x;
        this.y = y;
    }

    public void move(Spot[][] boardState, Spot startSpot, Spot endSpot){
        endSpot.setPiece(this);
        startSpot.removePiece(this);
    }

    public ArrayList<Spot> getPossibleMoves(Spot board[][], int x, int y){
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
            if(spot.getPiece() != null){
                potentialMoves.remove(spot);
            }
        }

        possibleMoves = potentialMoves;
        return possibleMoves;
    }

    public boolean isInCheck(Spot[][] board){
        return false;
    }
}
