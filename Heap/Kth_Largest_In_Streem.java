import java.util.Arrays;

public class Kth_Largest_In_Streem{
     static int[] kthLargest(int k, int[] arr, int n) {
        n=n-1;
        for(int i=n/2;i>=0;i--) {
            heapify(arr, n, i);
        }
        for(int j=n;j>=0;j--) {
           swap(arr, 0, j);
           heapify(arr, j-1, 0);
        }
     System.out.println(Arrays.toString(arr));
        k=k-1;
        int j=0;
        int[]ans=new int[n+1];
        for(int i=0;i<n+1;i++) {
            if(i-k>=0) {
              ans[j++]=arr[i-k];
            }else{
                ans[j++]=-1;
            }
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
public static void main(String[] args) {
    int[] arr = {3,4};
    int k=2;
    System.out.println(Arrays.toString(kthLargest(k, arr, arr.length)));
}
}