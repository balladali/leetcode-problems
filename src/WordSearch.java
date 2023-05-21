/*
    Link: https://leetcode.com/problems/word-search
    Algorithm: Backtracking
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] wordChars = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == wordChars[0] && check(board, wordChars, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, char[] wordChars, int i, int j, int pos) {
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || pos == wordChars.length || board[i][j] != wordChars[pos]) {
            return false;
        }
        if (pos == wordChars.length - 1) {
            return true;
        }
        char s = board[i][j];
        board[i][j] = '.';
        if (check(board, wordChars, i - 1, j, pos + 1) ||
                check(board, wordChars, i + 1, j, pos + 1) ||
                check(board, wordChars, i, j - 1, pos + 1) ||
                check(board, wordChars, i, j + 1, pos + 1)) {
            return true;
        }
        board[i][j] = s;
        return false;
    }
}
