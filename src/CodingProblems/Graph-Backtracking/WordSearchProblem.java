public class WordSearchProblem {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (check(board, row, col, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean check(char[][] board, int row, int col, int searchIndex, String word) {
        if (searchIndex == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || word.charAt(searchIndex) != board[row][col]) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        if (check(board, row + 1, col, searchIndex + 1, word) ||
                check(board, row - 1, col, searchIndex + 1, word) ||
                check(board, row, col + 1, searchIndex + 1, word) ||
                check(board, row, col - 1, searchIndex + 1, word)) {
            return true;
        }

        board[row][col] = temp;
        return false;
    }
}
