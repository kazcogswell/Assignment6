
/**
 * Main method of TicTacToe
 *
 * @author Kaz Cogswell
 * @version 5/6/19
 */

import  java.util.Scanner;

public class Main
{ 

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Game ticTac = new Game();
                int row, column;
                 
        ticTac.build();
        System.out.println("Welcome to Tic-Tac-Toe");
        
        ticTac.printBoard(); 
      
        while(!ticTac.checkForWin() && !ticTac.checkFull()){
            System.out.println("Player " + ticTac.returnTurn() + ", enter an empty row.");
                row = sc.nextInt() - 1;
                System.out.println("Now an empty column.");
                column = sc.nextInt() - 1;
            while (!ticTac.placeMark(row, column));
            if(!ticTac.returnError() == true) { 
            
                if (ticTac.checkFull() && !ticTac.checkForWin())
                {
                    System.out.println("The game was a tie!");
                }
                else if(ticTac.checkForWin() == true)
                {
                    ticTac.end();
                } else if(ticTac.returnError() == true){
                    
                } else {
                    ticTac.changeTurn();
                    ticTac.printBoard();
                }
            } else {
                System.out.println("That spot is taken matey!");
                ticTac.fixError();
                ticTac.printBoard();
            }
    }
}
}

   
   
