
public class Leetcode130 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'O','O','O'},{'O','O','O'},{'O','O','O'},{'O','O','O'}};
		
		for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || i == board.length-1 || j == 0 || j == board[0].length-1) {
                    if (board[i][j] == 'O')
                    board[i][j] = '1';
                }
            }
        }
        
        for (int i = 1; i < board.length-1; i++) {
            for (int j = 1; j < board[0].length-1; j++) {
                if (board[i][j] == 'O') {
                    if (((j-1) == 0 && board[i][j-1] == 'X') || 
                    	((j+1) == board[0].length-1 && board[i][j+1] == 'X') || 
                    	((i-1) == 0 && board[i-1][j] == 'X') || 
                    	((i+1) == board.length-1 && board[i][j-1] == 'X')) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || i == board.length-1 || j == 0 || j == board[0].length-1) {
                    if (board[i][j] == '1') {
                        board[i][j] = 'O';
                    }
                }
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
            	System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
	}
}
