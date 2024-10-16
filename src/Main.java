/*
 * Each number represents different color
 * in the board.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Example of a board, colors should start from 1 to n,
        // In the solution 0 represents queen.
        // int[][] board = {
        //     {1,1,2,2,2,3},
        //     {1,2,2,4,2,2},
        //     {1,2,4,4,4,2},
        //     {1,2,2,4,2,2},
        //     {1,6,2,2,2,6},
        //     {6,6,6,7,6,6}
        // };
        // int n = board.length;
        // Solver solver = new Solver(board, n);
        // if(solver.solve()){
        //     System.out.println();
        //     System.out.println("Queen is represented as 'Q' in the below board");
        //     solver.print();
        // }
        // else System.out.println("No Solution found.");      

        /* USER INPUT */
        try(Scanner sc = new Scanner(System.in))
        {
            System.out.print("Enter the size of board (n x n), required n value: ");
            int n = sc.nextInt();

            System.out.println("Enter each row in seperate line, and each value seperated by a single space.");
            int[][] board = new int[n][n];

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    board[i][j] = sc.nextInt();
                }
            }

            Solver solver = new Solver(board, n);
            if(solver.solve()){
                System.out.println();
                System.out.println("Queen is represented as 'Q' in the below board");
                solver.print();
            }
            else System.out.println("No Solution found.");      
        
        } catch(Exception e){
                System.out.println(e.getMessage());
        }    
    }
}