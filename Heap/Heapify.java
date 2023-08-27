public class Heapify {
    static void heapify(int arr[], int n, int i) {
        int largest = i;
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;
        if (leftIndex <= n && arr[leftIndex] > arr[largest]) {
            largest = leftIndex;
        }
        if (rightIndex <= n && arr[rightIndex] > arr[largest]) {
            largest = rightIndex;
        }
        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, n, largest);
        }
    }
    
    static void heapSort(int arr[]) {
        int n = arr.length - 1;
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i - 1, 0);
        }
    }
    
    static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    } 
    
    public static void main(String[] args) {
        int[] arr = {-1, 10, 30, 50, 20, 35, 15};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
