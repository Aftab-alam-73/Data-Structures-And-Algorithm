
//Link:https://leetcode.com/problems/min-cost-climbing-stairs/
public class MinCost {
   static  int[] dp;
    static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        return Math.min(minCost(cost, n-1), minCost(cost, n-2));
    }
    private static int minCost(int[] cost, int n) {
        if (n < 0) return 0;
        if (n==0 || n==1) return cost[n];
        if (dp[n] != 0) return dp[n];
        dp[n] = cost[n] + Math.min(minCost(cost, n-1), minCost(cost, n-2));
        return dp[n];
    }
    public static void main(String[] args) {
        int[]cost={0,0,1,1};
       int minCosts= minCostClimbingStairs(cost);
        System.out.println(minCosts);
    }
}
