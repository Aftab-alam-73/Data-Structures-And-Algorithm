public class MaxSum{
    static int getMax(int[]arr,int k){
        int max=0;
        int  sum=0;
        for(int i=0;i<k;i++){
          sum+=arr[i];
        }
        max=sum;
        int j=0;
        for(int i=k;i<arr.length;i++){
             sum=sum-arr[j]+arr[i];
             j++;
              max=Math.max(max,sum);
        }
        return max;
    }
    public static void main(String[] args) {
        int []arr={2,5,1,8,2,9,1};
        int k=4;
        int ans=getMax(arr, k);
        System.out.println(ans);
    }
}