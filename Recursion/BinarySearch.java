public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        System.out.println(search(arr, 0, arr.length - 1, 7));
    }

    static boolean search(int[] arr, int start, int end, int target) {
        if (start > end) {
            return false;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == target)
            return true;
        else if (arr[mid] > target) {
            return search(arr, start, mid - 1, target);
        }
        return search(arr, mid + 1, end, target);
    }
}
