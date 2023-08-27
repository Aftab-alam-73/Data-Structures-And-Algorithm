public class ReverseNum {
    public static void main(String[] args) {
        System.out.println(reverseNum1(123));
        System.out.println(reverseNum2(123));
    }
    static int reverseNum1(int n){
        return helper(n,0);
    }
    static int helper(int n,int res)
    {
           if(n==0) return res;
        
         res= (res*10)+(n%10);
         return helper(n/10,res);
    }
    static int reverseNum2(int n){
        int rev = 0;
        while(n!=0){
            rev = rev*10 + n%10;
            n = n/10;
        }
        return rev;
    }
}
