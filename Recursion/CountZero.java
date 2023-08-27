public class CountZero {
    public static void main(String[] args) {
        System.out.println(countZero(1002030000000000000L));
    }
    static int countZero(long n){
       return helper(n,0);
    }
    static int helper(long n,int count){
        if(n==0){
            return count;
        }
        if(n%10==0)
        {
            count++;
        }
        return helper(n/10,count);
    }
}
