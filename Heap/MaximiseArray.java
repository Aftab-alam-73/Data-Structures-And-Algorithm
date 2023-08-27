import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MaximiseArray {
    static ArrayList<Integer> maximizeArray(int[] arr1, int[] arr2, int n) {

        ArrayList<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Integer[] arr3 = new Integer[n * 2];

        int c = 0;

        for (int i = 0; i < n; i++) {

            arr3[c] = arr2[i];
            c += 1;

        }

        for (int i = 0; i < n; i++) {

            arr3[c] = arr1[i];
            c += 1;
        }
        Arrays.sort(arr3, Collections.reverseOrder());

        for (Integer num : arr3) {
            set.add(num);
            if (set.size() == n)
                break;
        }

        for (int x : arr2) {
            if (set.contains(x)) {
                result.add(x);
                set.remove(x);
            }
        }

        for (int x : arr1) {
            if (set.contains(x)) {
                result.add(x);
                set.remove(x);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[] Arr1 = { 7, 4, 8, 0, 1 };
        int[] Arr2 = { 9, 7, 2, 3, 6 };
        System.out.println(maximizeArray(Arr1, Arr2, Arr1.length));
    }
}
