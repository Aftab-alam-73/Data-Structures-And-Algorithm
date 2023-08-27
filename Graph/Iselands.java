import java.util.LinkedList;
import java.util.Queue;

public class Iselands {
    static void dfs(char[][] grid, int row, int col) {
        if (grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        int[] rows = { -1, 1, 0, 0, -1, -1, 1, 1 };
        int[] cols = { 0, 0, -1, 1, -1, 1, -1, 1 };
        for (int i = 0; i < 8; i++) {
            int newRow = row + rows[i];
            int newCol = col + cols[i];
            if (newRow >= 0 && newRow <= grid.length - 1 && newCol >= 0 && newCol <= grid[0].length - 1) {
                dfs(grid, newRow, newCol);
            }
        }
    }

    static void bfs(char[][] grid, int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        int[][] direction = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };
        grid[row][col]='0';
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            row = curr[0];
            col = curr[1];
           
            for (int[] dir : direction) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == '1') {
                    grid[newRow][newCol] = '0';
                    q.add(new int[]{newRow, newCol});
                }
            }
        }
    }
    public static void main(String[] args) {
        char[][] grid = { { '0', '1', '1', '1', '0', '0', '0' }, { '0', '0', '1', '1', '0', '1', '0' } };
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    // dfs(grid,i,j);
                    bfs(grid, i, j);
                    count++;
                }

            }
        }
        System.out.println("Number of Iselands: " + count);
    }
}
