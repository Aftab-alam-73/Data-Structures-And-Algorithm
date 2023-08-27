import java.util.HashMap;
// Problem: finding the number of ways to reach from the top left corner to the bottom right corner in a grid where i can move only down and right.

// Note : i am not storing kdy as row+column because it row is 4 and column is 23 it will become 423 and when  row is 42 and column is 3 then it will become 423 too. so it is not the good idea so we separate row and column with an ',' operator like this "42,3","4,23"
public class GridTraveler {
    static int numberOfWays(int row,int col)
    {
        if(row==0 || col==0)return 0;
        if(row==1 || col==1)return 1;
        return  numberOfWays(row-1, col)+numberOfWays(row, col-1);
    }
    static int numberOfWays2(int row, int col, HashMap<String,Integer>map) {
       String key=row+","+col;
       if(row==0 || col==0)return 0;
        if(row==1 || col==1)return 1;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int n= numberOfWays2(row-1, col,map)+numberOfWays2(row, col-1,map);
        map.put(key, n);
        return map.get(key);
    }
    public static void main(String[] args) {
        System.out.println(numberOfWays(0, 1));
        System.out.println(numberOfWays2(3, 3,new HashMap<String,Integer>()));
    }

}
