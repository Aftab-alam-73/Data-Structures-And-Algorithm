import java.util.Arrays;

public class MaxAndMin {
    static int[] getMaxAndMin(int[] arr, int index, int min, int max) {
        if (arr.length == index) {
            return new int[] { min, max };
        }
        min = arr[index] < min ? arr[index] : min;
        max = arr[index] > max ? arr[index] : max;
        return getMaxAndMin(arr, index + 1, min, max);

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 0, 4, 9, 5, 6, 7, 8 };
        System.out.println(Arrays.toString(getMaxAndMin(arr, 0, Integer.MAX_VALUE, Integer.MIN_VALUE)));
    }

}
