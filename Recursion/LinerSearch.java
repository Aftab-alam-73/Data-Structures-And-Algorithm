import java.util.ArrayList;

public class LinerSearch {
    public static void main(String[] args) {
        int[] search = { 2, 3, 5, 4, 5, 6, 7, 5 };
        System.out.println(search(search, 0, 8));
        System.out.println(AllIndexes(search, 0, 5));
        System.out.println(AllIndexes(search, 0, 5, new ArrayList<Integer>()));
    }

    static boolean search(int[] arr, int index, int target) {

        if (index == arr.length)
            return false;
        if (arr[index] == target)
            return true;
        return search(arr, index + 1, target);
    }

    static ArrayList<Integer> AllIndexes(int[] arr, int index, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        if (index == arr.length)
            return list;
        if (arr[index] == target)
            list.add(index);
        list.addAll(AllIndexes(arr, index + 1, target));
        return list;

    }

    static ArrayList<Integer> AllIndexes(int[] arr, int index, int target, ArrayList<Integer> list) {

        if (index == arr.length)
            return list;
        if (arr[index] == target)
            list.add(index);
       return AllIndexes(arr, index + 1, target);
       

    }
}
