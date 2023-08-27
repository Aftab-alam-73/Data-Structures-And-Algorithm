import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
public class K_Largest_Elements{
    // First Approach.
   static int[] kLargest(int[] arr, int n, int k) {
      PriorityQueue<Integer> q = new PriorityQueue<Integer>();
      for(int i=0;i<k;i++){
          q.add(arr[i]); 
      }
      for(int i=k;i<arr.length;i++)
      {
          if(arr[i]>q.peek()){
            q.poll();
            q.add(arr[i]);
          }
      }
      int i=k-1;
      int ans[]=new int[k];
      while(!q.isEmpty())
      {
         ans[i]=q.poll();
         i--;
      }
      return ans;
    }
   // Second Approach.
   // Time complexity: O(nlogn)
  static int[] kLargest2(int[] arr, int n, int k) {
    PriorityQueue<Integer>q=new PriorityQueue(Collections.reverseOrder());
    
   for(int i=0;i<arr.length;i++){
       q.add(arr[i]);
   }
  int[]ans=new int[k];
   for(int i=0;i<k;i++){
     ans[i]=q.poll();
   }
 return ans;
}
    public static void main(String[] args) {
        int[]arr={1, 23, 12, 9, 30, 2, 50};
        int k=3;
        System.out.println(Arrays.toString(kLargest2(arr, arr.length, k)));
    }
}