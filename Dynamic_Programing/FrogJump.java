public class FrogJump{
    static int min=Integer.MAX_VALUE;
    static int energy=0;
    public static int frogJump(int n, int heights[]) {

        int dp[]=new int[n+1];

        dp[0]=0;

        dp[1]=0;

        for(int i=2;i<=n;i++){

            int twojump=Integer.MAX_VALUE;

            int onejump=Math.abs(heights[i-1]-heights[i-2])+dp[i-1]; //difference between 1 jump and total of pvs value

             if(i>2) // no point in checking for index=2 as we cant go back by 2 steps

                twojump=Math.abs(heights[i-1]-heights[i-3])+dp[i-2];

            dp[i]= Math.min(onejump,twojump);//need to choose the min

        }

        return dp[n];

    }

    public static void main(String[] args) {
        int[]arr={4 ,8 ,3, 10, 4 ,4 };
        int n=arr.length-1;
        int ans=frogJump(n, arr);
        System.out.println(ans);
    }
}