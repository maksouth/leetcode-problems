package word_search_79;

class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0 || word.length() == 0) return false;

        int height = board.length;
        int width =  board[0].length;

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                if (board[i][j] == word.charAt(0))
                    if (hasWord(i, j, word, 0, board, visited))
                        return true;

        return false;
    }

    private boolean hasWord(int currentRow, int currentColumn, String word, int wordPosition, char[][] board, boolean[][] visited) {
        if (currentRow < 0 || currentRow >= board.length
                || currentColumn < 0 || currentColumn >= board[0].length
                || wordPosition >= word.length())
            return false;
        if (visited[currentRow][currentColumn]) return false;
        if (board[currentRow][currentColumn] != word.charAt(wordPosition)) return false;
        if (wordPosition == word.length() - 1) return true;


        visited[currentRow][currentColumn] = true;

        boolean result = hasWord(currentRow-1, currentColumn, word, wordPosition + 1, board, visited)
                || hasWord(currentRow+1, currentColumn, word, wordPosition + 1, board, visited)
                || hasWord(currentRow, currentColumn - 1, word, wordPosition + 1, board, visited)
                || hasWord(currentRow, currentColumn + 1, word, wordPosition + 1, board, visited);

        visited[currentRow][currentColumn] = false;
        return result;
    }
}