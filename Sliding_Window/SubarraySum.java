import java.util.ArrayList;
// Link:https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1?page=1&difficulty[]=0&company[]=Amazon&company[]=Microsoft&company[]=Flipkart&category[]=sliding-window&sortBy=submissions
public class SubarraySum {
    
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        int start=0;
        
        int sum=0;
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            sum=arr[i]+sum;
            
                while(sum>s && i>start){
                    sum-=arr[start];
                    start++;
                }
                if(sum==s){
                    ans.add(start+1);
                    ans.add(i+1);
                    return ans;
                }
            
        
        }  
        ans.add(-1);
        return ans;
    }
    public static void main(String[] args) {
        int arr[]= {1,2,3,7,5};
        int s=12;
        System.out.println(subarraySum(arr,arr.length,s));
    }
    
}
