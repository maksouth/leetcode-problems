package surrounded_regions_130;

class Solution {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            markNotTouch(i, 0, board);
            markNotTouch(i, board[0].length - 1, board);
        }

        for (int i = 0; i < board[0].length; i++) {
            markNotTouch(0, i, board);
            markNotTouch(board.length - 1, i, board);
        }

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'A') board[i][j] = 'O';
    }

    private void markNotTouch(int i, int j, char[][] board) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) return;
        if (board[i][j] != 'O') return;

        board[i][j] = 'A';
        markNotTouch(i - 1, j, board);
        markNotTouch(i, j + 1, board);
        markNotTouch(i + 1, j, board);
        markNotTouch(i, j - 1, board);
    }
}
