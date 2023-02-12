package Game;

public class Board {

    //creating a board which is just an array of Spot objects

    Spot[][] board = new Spot[8][8];

    public Board(){
        resetBoard();
    }

    public void resetBoard(){
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[0].length; col++){
                board[row][col] = new Spot(row, col, null);
            }
        }

        //initialize all pieces on the chess board
        
    }



}

