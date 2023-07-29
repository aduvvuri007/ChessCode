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

        if (ChessGUI.getCurrentMove().equals(this.getPieceColor())){
            int[] posx = {x-1, x-1, x, x+1, x+1, x+1, x, x-1};
            int[] posy = {y, y+1, y+1, y+1, y, y-1, y-1, y-1};
            
            for(int i = 0; i < 8; i++){
                if((posx[i] >= 0 && posx[i] < 8) && (posy[i] >= 0 && posy[i] < 8)){
                    if(board[posx[i]][posy[i]].getPiece() == null){
                        possibleMoves.add(board[posx[i]][posy[i]]);
                    } else if(board[posx[i]][posy[i]].getPiece() != null && !board[posx[i]][posy[i]].getPiece().getPieceColor().equals(this.getPieceColor())){
                        possibleMoves.add(board[posx[i]][posy[i]]);
                    }
                } 
            }

            //Short Castle
            if(this.getMoveCounter() == 0 && board[x][y + 1].getPiece() == null && board[x][y + 2].getPiece() == null){
                if (board[x][y + 3].getPiece() instanceof Rook && board[x][y + 3].getPiece().getMoveCounter() == 0){
                    board[x][y+2].setShortCastleMove();
                    possibleMoves.add(board[x][y+2]);
                }
            }
        }

        return possibleMoves;
    }

    public Spot getSpot(Spot[][] board){
        Spot s = null;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if(board[i][j].getPiece() != null && board[i][j].getPiece().equals(this)){
                    s = board[i][j];
                }
            }
        }
        return s;
    }

    public boolean isInCheck(Spot[][] board){
        //vertical 
        int x = getCurrentX();
        int y = getCurrentY();
        for(int i = x+1; i < 8; i++){
            if(board[i][y].getPiece() == null){
                continue;
            } else if(this.getPieceColor().equals(board[i][y].getPiece().getPieceColor())){
                break;
            } else {
                if(board[i][y].getPiece() instanceof Queen || board[i][y].getPiece() instanceof Rook){
                    return true;
                } else {
                    break;
                }
            }
        }

        for(int i = x-1; i >= 0; i--){
            if(board[i][y].getPiece() == null){
                continue;
            } else if(this.getPieceColor().equals(board[i][y].getPiece().getPieceColor())){
                break;
            } else {
                if(board[i][y].getPiece() instanceof Queen || board[i][y].getPiece() instanceof Rook){
                    return true;
                } else {
                    break;
                }
            }
        }

        //horizontal
        for(int i = y+1; i < 8; i++){
            if(board[x][i].getPiece() == null){
                continue;
            } else if (this.getPieceColor().equals(board[x][i].getPiece().getPieceColor())){
                break;
            } else {
                if(board[x][i].getPiece() instanceof Queen || board[x][i].getPiece() instanceof Rook){
                    return true;
                } else {
                    break;
                }
            }
        }

        for(int i = y-1; i >= 0; i--){
            if(board[x][i].getPiece() == null){
                continue;
            } else if (this.getPieceColor().equals(board[x][i].getPiece().getPieceColor())){
                break;
            } else {
                if(board[x][i].getPiece() instanceof Queen || board[x][i].getPiece() instanceof Rook){
                    return true;
                } else {
                    break;
                }
            }
        }

        //Diagonal
        int tempx = x + 1;
        int tempy = y + 1;
        while(tempx < 8 && tempy < 8){
            if(board[tempx][tempy].getPiece() == null){
                tempx++;
                tempy++;
            } else if(this.getPieceColor().equals(board[tempx][tempy].getPiece().getPieceColor())){
                break;
            } else {
                if(board[tempx][tempy].getPiece() instanceof Bishop || board[tempx][tempy].getPiece() instanceof Queen){
                    return true;
                } else {
                    break;
                }
            }
        }

        tempx = x - 1;
        tempy = y + 1;
        while(tempx >= 0 && tempy < 8){
            if(board[tempx][tempy].getPiece() == null){
                tempx--;
                tempy++;
            } else if(this.getPieceColor().equals(board[tempx][tempy].getPiece().getPieceColor())){
                break;
            } else {
                if(board[tempx][tempy].getPiece() instanceof Bishop || board[tempx][tempy].getPiece() instanceof Queen){
                    return true;
                } else {
                    break;
                }
            }
        }

        tempx = x - 1;
        tempy = y - 1;
        while(tempx >= 0 && tempy >= 0){
            if(board[tempx][tempy].getPiece() == null){
                tempx--;
                tempy--;
            } else if(this.getPieceColor().equals(board[tempx][tempy].getPiece().getPieceColor())){
                break;
            } else {
                if(board[tempx][tempy].getPiece() instanceof Bishop || board[tempx][tempy].getPiece() instanceof Queen){
                    return true;
                } else {
                    break;
                }
            }
        }

        tempx = x + 1;
        tempy = y - 1;
        while(tempx < 8 && tempy >= 0){
            if(board[tempx][tempy].getPiece() == null){
                tempx++;
                tempy--;
            } else if(this.getPieceColor().equals(board[tempx][tempy].getPiece().getPieceColor())){
                break;
            } else {
                if(board[tempx][tempy].getPiece() instanceof Bishop || board[tempx][tempy].getPiece() instanceof Queen){
                    return true;
                } else {
                    break;
                }
            }
        }  

        //Knights
        int[] posx = {x-1, x-2, x-2, x-1, x+1, x+2, x+2, x+1};
        int[] posy = {y+2, y+1, y-1, y-2, y-2, y-1, y+1, y+2};

        for(int i = 0; i < 8; i++){
            if((posx[i] >= 0 && posx[i] < 8) && (posy[i] >= 0 && posy[i] < 8)){
                if(board[posx[i]][posy[i]].getPiece() != null && !board[posx[i]][posy[i]].getPiece().getPieceColor().equals(this.getPieceColor()) && board[posx[i]][posy[i]].getPiece() instanceof Knight){
                    return true;
                }
            }
        }

        //Pawns
        int[] posX = {x-1, x-1, x, x+1, x+1, x+1, x, x-1};
        int[] posY = {y, y+1, y+1, y+1, y, y-1, y-1, y-1};
        
        for(int i = 0; i < 8; i++){
            if((posX[i] >= 0 && posX[i] < 8) && (posY[i] >= 0 && posY[i] < 8)){
                if(board[posX[i]][posY[i]].getPiece() != null && !board[posX[i]][posY[i]].getPiece().getPieceColor().equals(this.getPieceColor()) && board[posX[i]][posY[i]].getPiece() instanceof King){
                    return true;
                }
            } 
        }

        if(this.getPieceColor().equals("WHITE"))
		{
			if(x > 0 && y > 0 && board[x-1][y-1].getPiece() != null && board[x-1][y-1].getPiece().getPieceColor().equals("BLACK") && (board[x-1][y-1].getPiece() instanceof Pawn))
				return true;
			if(x > 0 && y < 7 && board[x-1][y+1].getPiece() != null && board[x-1][y+1].getPiece().getPieceColor().equals("BLACK") && (board[x-1][y+1].getPiece() instanceof Pawn))
				return true;
		}
		else
		{
			if(x < 7 && y > 0 && board[x+1][y-1].getPiece() !=null && board[x+1][y-1].getPiece().getPieceColor().equals("WHITE") && (board[x+1][y-1].getPiece() instanceof Pawn))
				return true;
			if(x < 7 && y < 7 && board[x+1][y+1].getPiece()!=null && board[x+1][y+1].getPiece().getPieceColor().equals("WHITE") && (board[x+1][y+1].getPiece() instanceof Pawn))
				return true;
		}

        return false;
    }
}
