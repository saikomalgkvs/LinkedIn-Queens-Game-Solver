/*
 * Each number represents different color
 * in the board.
 */

public class Main {
    public static void main(String[] args) {
        int[][] board = {
            {1,1,1,2,2,3,3},
            {1,4,4,2,2,3,5},
            {1,4,2,2,3,3,5},
            {2,2,2,3,3,6,7},
            {2,3,3,3,3,6,7},
            {3,3,3,6,6,6,7},
            {3,6,6,6,7,7,7}
        };
        int n = board.length;
        Solver solver = new Solver(board, n);
        if(solver.solve()) solver.print();        
    }
}