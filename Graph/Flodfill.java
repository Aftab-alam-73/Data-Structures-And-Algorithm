import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Flodfill {
    static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<int[]> q = new LinkedList<>();
        int initiaColor = image[sr][sc];
        q.add(new int[] { sr, sc });
        image[sr][sc] = newColor;
        while (!q.isEmpty()) {
            int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
            int row = q.peek()[0];
            int col = q.peek()[1];
            q.poll();
            for (int[] dirct : direction) {
                int newRow = row + dirct[0];
                int newCol = col + dirct[1];
                if (newRow >= 0 && newRow < image.length && newCol < image[0].length && newCol >= 0
                        && image[newRow][newCol] == initiaColor) {
                    image[newRow][newCol] = newColor;
                    q.add(new int[] { newRow, newCol });
                }
            }
        }
        return image;
    }

    static void dfs(int[][] image, int[][] ans, int row, int col, int initiaCol, int newColor) {

        ans[row][col] = newColor;

        int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] arr : direction) {
            int newRow = row + arr[0];
            int newCol = col + arr[1];
            if (newRow >= 0 && newRow < image.length && newCol < image[0].length && newCol >= 0   && image[newRow][newCol] == initiaCol && ans[newRow][newCol] !=newCol) {
                dfs(image,ans, newRow, newCol, initiaCol, newColor);
            }
        }
    }

    public static void main(String[] args) {
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int[][] ans = image;
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        // floodFill(image, sr, sc, newColor);
        dfs(image, ans, sr, sc, 1, newColor);
        for (int[] arr : ans) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
