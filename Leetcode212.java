import java.util.Arrays;

public class Leetcode212 {

	public static void main(String[] args) {
		char[][] board = {{'o','a','a','n'},
						{'e','t','a','e'},
						{'i','h','k','r'},
						{'i','f','l','v'}};
						
		//char[][] board = {{'a'}};

		String[] words = {"oath","pea","eat","rain", "flvrkatao"};
		//String[] words = {"a"};

		boolean[][] visited = new boolean[board.length][board[0].length];
		
		for (int k = 0; k < words.length; k++) {
			boolean found = false;
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (findWords(board, words[k], visited, i, j, 0, board.length, board[0].length)) {
						System.out.println(words[k]);
						found = true;
						break;
					}
				}
				if (found) {
					break;
				}
			}
		}
	}

	private static boolean findWords(char[][] board, String word, boolean[][] visited, int i, int j, int k, int m, int n) {
		if (k == word.length()) {
			return true;
		}
		
		if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] == true) {
			return false;
		}

		if (board[i][j] == word.charAt(k)) {
			visited[i][j] = true;
			if(findWords(board, word, visited, i+1, j, k+1, m, n) ||
					findWords(board, word, visited, i-1, j, k+1, m, n) ||
					findWords(board, word, visited, i, j+1, k+1, m, n) || 
					findWords(board, word, visited, i, j-1, k+1, m, n)) {
				visited[i][j] = false;
				return true;
			}
			visited[i][j] = false;
		}

		return false;
	}
}
