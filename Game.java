/**
 * The game functions for TicTacToe.
 *
 * @author Kaz Cogswell
 * @version 5/5/19
 */


public class Game {

    public char[][] board;
    public char turn;
    public boolean error;
    public String playerTurn;
    enum Turns{
        X, O, EMPTY;
    }

        public void build() {
        board = new char[3][3];
        turn = 'X';
        
        Turns tX = Turns.X;
        Turns tO = Turns.O;
        Turns tE = Turns.EMPTY;
        
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
        
    public char returnTurn()
    {
        return turn;
    }
    
    public void printBoard() {
        System.out.println("~~~~~~~~");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
            System.out.println("~~~~~~~~");
        }
    }
    
    
    public boolean checkForThree(char c1, char c2, char c3) {
        return (c1 != '-' && c1 == c2 && c2 == c3);
    }
    
    public boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (checkForThree(board[i][0], board[i][1], board[i][2]) == true) {
                return true;
            }
        }
        return false;
    }

    public boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (checkForThree(board[0][i], board[1][i], board[2][i]) == true) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDiag() {
        return (checkForThree(board[0][0], board[1][1], board[2][2]) == true || checkForThree(board[0][2], board[1][1], board[2][0]) == true);
    }

    public boolean checkForWin() {
        return (checkRows() || checkColumns() || checkDiag());
    }

    public boolean checkFull() {
        boolean full = true;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    full = false;
                }
            }
        }
        return full;
    }
    
    
    public boolean returnError(){
        return error;
    }
    
    public boolean fixError(){
        error = false;
        return error;
    }
    
    public void changeTurn() {
        if (turn == 'X') {
            turn = 'O';
        }
        else {
            turn = 'X';
        }
    }

    public boolean placeMark(int row, int column) {
        if ((row >= 0) && (row < 3)) {
            if ((column >= 0) && (column < 3)) {
                if (board[row][column] == '-') {
                    board[row][column] = turn;
                    return true;
                } else if (board[row][column] == 'X' || board[row][column] == 'O'){
                    error = true;
                    return true;
                }
            }
        }
        return false;
    }
    
    public void end(){
                printBoard();
                System.out.println(turn +" wins this game!");
    }
}