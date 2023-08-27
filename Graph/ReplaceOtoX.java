public class ReplaceOtoX {
    static char[][] fill(int n, int m, char a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 'O' && isSurrounded(i, j, a)) {
                    a[i][j] = 'X';
                }
            }
        }
        return a;
    }

    static boolean isSurrounded(int row, int col, char[][] arr) {
        boolean flag1 = false;
        for (int i = 0; i < row; i++) {
            if (arr[i][col] == 'X') {
                flag1 = true;
            }
        }
        boolean flag2 = false;
        for (int i = row + 1; i < arr.length; i++) {
            if (arr[i][col] == 'X') {
                flag2 = true;
            }
        }
        boolean flag3 = false;
        for (int i = col - 1; i >= 0; i--) {
            if (arr[row][i] == 'X') {
                flag3 = true;
            }
        }
        boolean flag4 = false;
        for (int i = col + 1; i < arr[0].length; i++) {
            if (arr[row][i] == 'X') {
                flag4 = true;
            }
        }
        return (flag1 && flag2 && flag3 && flag4);
    }

    public static void main(String[] args) {
        char[][] arr = { { 'X', 'X', 'X', 'X' },
                         { 'X', 'O', 'X', 'X' },
                         { 'X', 'O', 'O', 'X' },
                         { 'X', 'O', 'X', 'X' },
                         { 'X', 'X', 'O', 'O' } 
                        };
        fill(5, 4, arr) ;
        for(char[]a:arr)               
        {
            for(int i=0;i<a.length;i++)
            {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }
}
