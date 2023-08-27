public class WordSearch {
    static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    //I am passing index 1 becaluse i have found the first character and i have found the the second character so it will check its neighbors for second character.
                    if (dfs(board, i, j, word, 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean dfs(char[][] board, int row, int col, String word, int index) {
        if (index == word.length())
            return true;
        char c = board[row][col];
        board[row][col] = '*';
        if (row > 0 && board[row - 1][col] != '*' && board[row - 1][col] == word.charAt(index)) {
            if (dfs(board, row - 1, col, word, index + 1)) {
                return true;
            }
        }
        if (row < board.length - 1 && board[row + 1][col] != '*' && board[row + 1][col] == word.charAt(index)) {
            if (dfs(board, row + 1, col, word, index + 1)) {
                return true;
            }
        }
        if (col > 0 && board[row][col - 1] != '*' && board[row][col - 1] == word.charAt(index)) {
            if (dfs(board, row, col - 1, word, index + 1)) {
                return true;
            }
        }
        if (col < board[0].length - 1 && board[row][col + 1] != '*' && board[row][col + 1] == word.charAt(index)) {
            if (dfs(board, row, col + 1, word, index + 1)) {
                return true;
            }
        }
        board[row][col] = c;
        return false;

    }

    public static void main(String[] args) {
        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word = "ASADFCEESECBA";
        System.out.println(exist(board, word));
    }
}
