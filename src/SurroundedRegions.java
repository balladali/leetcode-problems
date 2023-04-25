/*
    Link: https://leetcode.com/problems/surrounded-regions
    Algorithm: DFS
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        int col = board[0].length;
        int row = board.length;
        for (int i = 0; i < col; i++) {
            flip(board, 0, i);
            flip(board, row - 1, i);
        }
        for (int i = 0; i < row; i++) {
            flip(board, i, 0);
            flip(board, i, col - 1);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void flip(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '*';
        flip(board, i - 1, j);
        flip(board, i + 1, j);
        flip(board, i, j - 1);
        flip(board, i, j + 1);
    }
}
