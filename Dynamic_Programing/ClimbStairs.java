// link:https://leetcode.com/problems/climbing-stairs/submissions/
import java.util.HashMap;

public class ClimbStairs {
    static int climbStairs(int n) {
        return dp(n, new HashMap<Integer, Integer>());
    }

    static int dp(int n, HashMap<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0 || n == 1) { 
            return 1;
        }
        int ans = dp(n - 1, map) + dp(n - 2, map);
        map.put(n, ans);
        return map.get(n);
    }
  public static void main(String[] args) {
     System.out.println(climbStairs(30));
  }
}
