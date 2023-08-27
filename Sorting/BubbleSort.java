import java.util.Arrays;
// worst case Time Complexity: O(n^2)
// best case Time Complexity: O(n) if the array is already sorted .
public class BubbleSort {
    static void bubbleSort(int[]arr)
    {
        for(int i=0; i<arr.length-1; i++){
            boolean flag = true;
           for(int j=0;j<arr.length-1;j++){
               if(arr[j]>arr[j+1])
               {
                  flag=false;
                  int temp=arr[j+1];
                  arr[j+1]=arr[j];
                  arr[j]=temp;
               }
           }
           if(flag)break;
        }
    }
     public static void main(String[] args) {
        int arr[]={3,5,6,1,8,2,7,4,1,4,5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
       
        // System.out.println(Arrays.toString(arr));
    }
}
