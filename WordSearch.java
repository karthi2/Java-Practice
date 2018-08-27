
public class WordSearch {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "SECCFS";

		char[][] visited = new char[board.length][board[0].length];
		WordSearch wordSearch = new WordSearch();
		System.out.println(wordSearch.exist(board, word, visited));
	}

	private boolean search (char[][] board, int i, int j, String word, int k, char[][] visited) {
		boolean result = false;
		if (k == word.length()) {
			return true;
		}

		if (i < 0 || i > board.length || j < 0 || j > board[0].length) {
			return false;
		}

		if ((i+1) < board.length && 
				board[i+1][j] == word.charAt(k) && visited[i+1][j] != '1') {
			visited[i+1][j] = '1';
			result = search(board, i+1, j, word, k+1, visited);
			if (result == true) {
				return result;
			}
			visited[i+1][j] = '0';
		} 
		
		if ((i-1) >= 0 && 
				board[i-1][j] == word.charAt(k) && visited[i-1][j] != '1') {
			visited[i-1][j] = '1';
			result = search(board, i-1, j, word, k+1, visited);
			if (result == true) {
				return result;
			}
			visited[i-1][j] = '0';
		} 
		
		if ((j+1) < board[0].length &&
				board[i][j+1] == word.charAt(k) && visited[i][j+1] != '1') {
			visited[i][j+1] = '1';
			result = search(board, i, j+1, word, k+1, visited);
			if (result == true) {
				return result;
			}
			visited[i][j+1] = '0';
		} 
		
		if ((j-1) >= 0 &&
				board[i][j-1] == word.charAt(k) && visited[i][j-1] != '1') {
			visited[i][j-1] = '1';
			result = search(board, i, j-1, word, k+1, visited);
			if (result == true) {
				return result;
			}
			visited[i][j-1] = '0';
		}

		return false;
	}

	public boolean exist(char[][] board, String word, char[][] visited) {
		if (board == null || word == null) {
			return false;
		}

		int k = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(k)) {
					visited[i][j] = '1';
					boolean result = search(board, i, j, word, k+1, visited);
					if (result == true) {
						return result;
					}
					visited[i][j] = '0';
				}
			}
		}

		return false;
	}
}
