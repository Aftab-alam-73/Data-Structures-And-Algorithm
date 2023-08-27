// for zero based indexing : parent= (i-1)/2
// left child= 2*i+1.
// right child=2*i+2.

// for 1 based indexing : parent= i/2.
// left child=2*i.
// right child=2*i+1.

public class Heap{
    private static int[]arr=new int[100];;
    private static int index=0;
    private static int size=0;

   
    public static void insert(int data)
    {
        index++;
        arr[index]=data;
        size++;
        while(index>1)
        {
            int parent=index/2;
            if(arr[parent]<arr[index]){
                int temp=arr[parent];
                arr[parent]=arr[index];
                arr[index]=temp;
            }else{
                return;
            }
        }
    }
    public static int remove() {
        if (index == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }
        int num = arr[1];
        swap(arr, 1, index);
        index--;
        size--;
        int i = 1;
        while (2 * i <= index) { 
            int leftIndex = 2 * i;
            int rightIndex = 2 * i + 1;
            int swapindex = leftIndex;  // Initialize with the left child by default
            
            if (rightIndex <= index && arr[rightIndex] > arr[leftIndex]) {
                swapindex = rightIndex;
            }
    
            if (arr[swapindex] > arr[i]) {
                swap(arr, swapindex, i);
                i = swapindex;
            } else {
                break;
            }
        }
        return num;
    }
    
    static void swap(int[]arr,int left,int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }
    public static void display()
    {
        if(size==0){
           System.out.println("Heap is empty");
           return;
        }
        for(int i=1;i<=index;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static int size()
    {
        System.out.println("Size of heap is " + size);
        return size;
    }
    public static void main(String[] args) {
        insert(50);
        insert(55);
        insert(53);
        insert(52);
        insert(54);
        display();
        System.out.println();
        System.out.println("Deleted element:"+ remove());
        System.out.println("Deleted element:"+ remove());
        System.out.println("Deleted element:"+ remove());
        System.out.println("Deleted element:"+ remove());
        // System.out.println("Deleted element:"+ remove());
        insert(466);
        display();
        System.out.println();
        size();
    }
}