import java.util.Arrays;

public class Solver{
    private Block[][] boardObj;
    private int[][] board;
    private int n;

    Solver(int[][] board, int n){
        this.board = board;
        this.n = n;
        build(board);
    }

    private void build(int[][] board){
        boardObj = new Block[n][n];

        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                boardObj[i][j] = new Block(board[i][j]);
            }
        }
    }
    public void print(){
        for(int[] row : board){
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
    public void printObj(){
        for(Block[] row : boardObj){
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
    public boolean solveOptimize(){
        // Need to be coded




        return false;
    }
    public boolean solve(){
        if(solveHelper(0)) return true;
        return false;
    }
    private boolean solveHelper(int r){
        if(r == n){
            return true;
        }

        for(int j=0; j<n; j++){
            if(isSafe(r, j)){
                int prev = board[r][j];

                addQueen(r, j);
                if(solveHelper(r+1)) return true;
                rmQueen(r, j, prev);
            }
        }

        return false;
    }
    private void addQueen(int r, int c){
        // x added to region
        floodfill(r, c, board[r][c], new boolean[n][n], true);

        // x added to column
        for(int row = 0; row<n; row++){
            boardObj[row][c].addx();    
        }

        // x added to row
        for(int col=0; col<board[0].length; col++){
            boardObj[r][col].addx();
        }

        // x added to four courners
        if(r>0 && c>0) boardObj[r-1][c-1].addx();
        if(r<n-1 && c>0) boardObj[r+1][c-1].addx();
        if(r>0 && c<n-1) boardObj[r-1][c+1].addx();
        if(r<n-1 && c<n-1) boardObj[r+1][c+1].addx();
        
        board[r][c] = 0; // 0 - queen
        
    }
    private void rmQueen(int r, int c, int q){
        
        board[r][c] = q;
        
        // x removed from region
        floodfill(r, c, board[r][c], new boolean[n][n], false);

        // x removed from column
        for(int row = 0; row<n; row++){
            boardObj[row][c].delx();    
        }

        // x removed from row
        for(int col=0; col<n; col++){
            boardObj[r][col].delx();
        }
        
        // x removed from four corners
        if(r>0 && c>0) boardObj[r-1][c-1].delx();
        if(r<n-1 && c>0) boardObj[r+1][c-1].delx();
        if(r>0 && c<n-1) boardObj[r-1][c+1].delx();
        if(r<n-1 && c<n-1) boardObj[r+1][c+1].delx();
    }
    private void floodfill(int r, int c, int curr, boolean[][] vis, boolean isIncr){
        if(isOutOfBounds(r, c)) return;
        if(board[r][c] != curr) return;
        if(vis[r][c]) return;

        if(isIncr)boardObj[r][c].addx();
        else boardObj[r][c].delx();
        vis[r][c] = true;

        floodfill(r-1, c, curr, vis, isIncr);
        floodfill(r, c-1, curr, vis, isIncr);
        floodfill(r+1, c, curr, vis, isIncr);
        floodfill(r, c+1, curr, vis, isIncr);
    }
    private boolean isSafe(int r, int c){

        if(isOutOfBounds(r, c)) return false;
        if(boardObj[r][c].getXcount() > 0) return false;

        return true;
    }
    private boolean isOutOfBounds(int i, int j){
        return (i < 0 || i >= board.length || j < 0 || j >= board[0].length);
    }
}