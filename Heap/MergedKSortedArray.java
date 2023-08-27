import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergedKSortedArray {
    // First Approach.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        int[]array=new int[arr.length*arr[0].length];
        int i=0;
        for(int[]a:arr)
        {
          for(int j=0;j<a.length;j++){
            array[i]=a[j];
            i++;
          }
        }
        int n=array.length-1;
        for(int j=n/2;j>=0;j--){
            heapify(array, n, j);
        }

        for(int j=n;j>=0;j--)
        {
            swap(array,0,j);
            heapify(array, j-1, 0);
        }
        ArrayList<Integer> ans=new ArrayList<Integer>();
        for(int a:array){
          ans.add(a);
        }
        return ans;
    }
   public static void swap(int[]arr,int left,int right)
   {
       int temp=arr[left];
       arr[left]=arr[right];
       arr[right]=temp;
   }
    public static void heapify(int[] arr,int n,int i)
    {
         int largest = i;
         int left=2*i+1;
         int right=2*i+2;

        if(left<=n && arr[left]>arr[largest])
        {
            largest = left;
        }
        if(right<=n && arr[right]>arr[largest]){
            largest=right;
        }
        if(largest!=i)
        {
           int temp=arr[i];
           arr[i]=arr[largest];
           arr[largest]=temp;
           heapify(arr, n, largest);
        }
    }

    // Second Approach.
     public static ArrayList<Integer> mergeKArrays2(int[][] arr,int K) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                pq.add(arr[i][j]);
            }
        }
        ArrayList<Integer> ans=new ArrayList<Integer>();
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][]arr={{1,2,3,4},{2,2,3,4},
        {5,5,6,6},{7,8,9,9}};
        System.out.println(mergeKArrays(arr, 0));
        System.out.println(mergeKArrays2(arr, 0));
    }
}
