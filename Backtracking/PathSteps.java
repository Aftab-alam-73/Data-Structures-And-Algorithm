import java.util.Arrays;

public class PathSteps {
    static void pathStep(boolean[][]maze,int r,int c,String path,int step,int[][]mat)
    {
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(path);
            mat[r][c] =step;
            for(int i=0;i<maze.length;i++){
                System.out.println(Arrays.toString(mat[i]));
            }
            System.out.println();
            return ;
        }
        if(maze[r][c]==true) return ;
        maze[r][c] =true;
        mat[r][c]=step;
        if(r>0)
        {
            pathStep(maze, r-1, c,path+'U',step+1,mat);
        }
        if(r<maze.length-1)
        {
            pathStep(maze, r+1, c,path+'D',step+1,mat);
        }
        if(c<maze[0].length-1 )
        {
            pathStep(maze, r, c+1,path+'R',step+1,mat);
        }
        if(c>0)
        {
           pathStep(maze, r, c-1,path+"L",step+1,mat);
        }
        maze[r][c] = false;
        mat[r][c] = 0;
        
    }
    public static void main(String[] args) {
        boolean[][]maze={
            {false,false,false},
            {false,false,false},
            {false,false,false}
        };
        int[][]mat=new int[maze.length][maze[0].length];
        pathStep(maze, 0, 0, "", 1, mat);
    }
}
