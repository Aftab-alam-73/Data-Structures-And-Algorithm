import java.util.ArrayList;

public class Numofways {
    static int pathCount (int row, int column )
    {
        if(row==2 || column==2)
        {
            return 1;
        }
        int count=0; 
        count+=pathCount(row+1 , column);
        count+=pathCount(row, column+1);
        return count;

    }
    static void paths(int row, int column,String path)
    {
        if(row==2 && column==2)
        {
            System.out.println(path);
            return;
        }
        if(column<2)
        {
            paths(row, column+1, path+"R");
        }
        if(row<2)
        {
            paths(row+1, column, path+"D");
        }
    }
    static ArrayList<String> pathsRet(int row, int column,String path)
    {
        ArrayList<String> list = new ArrayList<String>();
        if(row==2 && column==2)
        {
            list.add(path);
            return list;
        }
        if(column<2)
        {
            list.addAll(pathsRet(row, column+1, path+"R"));
        }
        if(row<2)
        {
            list.addAll(pathsRet(row+1, column, path+"D"));
        }
        return list;
    }
    static ArrayList<String> pathsDiagonalRet(int row, int column,String path)
    {
        ArrayList<String> list = new ArrayList<String>();
        if(row==2 && column==2)
        {
            list.add(path);
            return list;
        }
        if(column<2)
        {
            list.addAll(pathsDiagonalRet(row, column+1, path+"R"));
        }
        if(row<2)
        {
            list.addAll(pathsDiagonalRet(row+1, column, path+"D"));
        }
        if(row<2 && column<2)
        {
            list.addAll(pathsDiagonalRet(row+1, column+1, path+"V"));
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(pathCount(0, 0));
        paths(0, 0, "");
        System.out.println(pathsRet(0, 0, ""));
        System.out.println(pathsDiagonalRet(0,0,""));
    }
}
