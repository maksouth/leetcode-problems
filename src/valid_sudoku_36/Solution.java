package valid_sudoku_36;

class Solution {
    private static final char DOT = '.';

    public boolean isValidSudoku(char[][] board) {
        int[] columns = new int[9];
        int[] rows = new int[9];
        int[] blocks = new int[9];

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (haveSeen(columns, j, board[i][j]) ||
                        haveSeen(rows, i, board[i][j]) ||
                        haveSeen(blocks, i / 3 * 3 + j / 3, board[i][j]))
                    return false;

        return true;
    }

    private boolean haveSeen(int[] array, int index, char value) {
        if (value == DOT) return false;
        int bit = 1 << (value - '0');
        if ((array[index] & bit) != 0) return true;
        array[index] |= bit;
        return false;
    }
}