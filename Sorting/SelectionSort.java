import java.util.Arrays;
// Time Complexity:O(n^2)
public class SelectionSort{
    static void selectionSortAscendingOrder(int arr[]){
        for(int i=0;i<arr.length;i++){
            int min=i;
            for(int j=i;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            if(min!=i)
            {
                int temp=arr[min];
                arr[min]=arr[i];
                arr[i]=temp;
            }
        }
    }
    static void selectionSortDescendingOrder(int arr[]){
        for(int i=0;i<arr.length;i++){
            int max=i;
            for(int j=i;j<arr.length;j++){
                if(arr[j]>arr[max]){
                    max=j;
                }
            }
            if(max!=i)
            {
                int temp=arr[max];
                arr[max]=arr[i];
                arr[i]=temp;
            }
        }
    }
    public static void main(String[] args) {
        int arr[]={3,5,6,1,8,2,7,4,1,4,5};
        selectionSortAscendingOrder(arr);
        System.out.println(Arrays.toString(arr));
        selectionSortDescendingOrder(arr);
        System.out.println(Arrays.toString(arr));
    }
}