public class Queens {
    static int queens(boolean[][]maze,int row){
        if(row==maze.length)
        {
            Display(maze);
            return 1;
        }
        int count = 0;
        for(int i=0;i<maze.length;i++)
        {
            if(isSafe(maze,row,i)){
                maze[row][i] =true;
                count+=queens(maze,row+1);
                maze[row][i] =false;
            }
        }
        return count;
    }
   static boolean isSafe(boolean[][]maze,int row,int col){
    //column from top to bottom 
    for(int i=0;i<row;i++)
    {
        if(maze[i][col])
        {
            return false;
        }
    }
    //Left diagonal
    int maxLeft=Math.min(row,col);
    for(int i=1;i<=maxLeft;i++){
       if(maze[row-i][col-i])
       {
        return false;
       }
    }
    //Right diagonal
    int maxRight=Math.min(row,maze.length-col-1);
    for(int i=1;i<=maxRight;i++){
        if(maze[row-i][col+i])
        {
            return false;
        }
    }
    return true;
   }
   static void Display(boolean[][]maze)
   {
     
       for(int i=0;i<maze.length;i++)
       {
           for(int j=0;j<maze.length;j++)
           {
              if(maze[i][j]){
                System.out.print("Q ");
              }else{
                System.out.print("X ");
              }
           }
           System.out.println();
       }
       System.out.println();
   }
    public static void main(String[] args) {
        int N=4;
        boolean[][]maze=new boolean[N][N];
        System.out.println(queens(maze,0));
    }
}
