import java.util.ArrayList;

public class PathObstical {
    static int pathWithObstical(boolean[][]maze,int r,int c)
    {
        if(r==maze.length-1 && c==maze[0].length-1){
            return 1;
        }
        if(maze[r][c]==true) return 0;
        maze[r][c] =true;
        int count = 0;
        if(r>0)
        {
            count+=pathWithObstical(maze, r-1, c);
        }
        if(r<maze.length-1)
        {
            count+=pathWithObstical(maze, r+1, c);
        }
        if(c<maze[0].length-1 )
        {
            count+=pathWithObstical(maze, r, c+1);
        }
        if(c>0)
        {
            count+=pathWithObstical(maze, r, c-1);
        }
        maze[r][c] = false;
        return count;
    }
    static void pathWithObsticalPath(boolean[][]maze,int r,int c,String path)
    {
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(path);
            return ;
        }
        if(maze[r][c]==true) return ;
        maze[r][c] =true;
        if(r>0)
        {
            pathWithObsticalPath(maze, r-1, c,path+'U');
        }
        if(r<maze.length-1)
        {
            pathWithObsticalPath(maze, r+1, c,path+'D');
        }
        if(c<maze[0].length-1 )
        {
            pathWithObsticalPath(maze, r, c+1,path+'R');
        }
        if(c>0)
        {
           pathWithObsticalPath(maze, r, c-1,path+"L");
        }
        maze[r][c] = false;
        
    }
    static ArrayList<String> pathWithObsticalPathRet(boolean[][]maze,int r,int c,String path)
    {
        ArrayList<String> list = new ArrayList<String>();
        if(r==maze.length-1 && c==maze[0].length-1){
            list.add(path);
            return list;
        }
        if(maze[r][c]==true) return list ;
        maze[r][c] =true;
        if(r>0)
        {
            list.addAll(pathWithObsticalPathRet(maze, r-1, c,path+'U'));
        }
        if(r<maze.length-1)
        {
            list.addAll(pathWithObsticalPathRet(maze, r+1, c,path+'D'));
        }
        if(c<maze[0].length-1 )
        {
            list.addAll(pathWithObsticalPathRet(maze, r, c+1,path+'R'));
        }
        if(c>0)
        {
           list.addAll(pathWithObsticalPathRet(maze, r, c-1,path+"L"));
        }
        maze[r][c] = false;
        return list;
    }
    public static void main(String[] args) {
        boolean[][]maze={
            {false,false,false},
            {false,true,false},
            {false,false,false}
        };
        System.out.println(pathWithObstical(maze, 0, 0));
        pathWithObsticalPath(maze, 0, 0, "");
        System.out.println(pathWithObsticalPathRet(maze, 0, 0, ""));
    }
}
