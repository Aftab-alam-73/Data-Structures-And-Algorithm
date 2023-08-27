import java.util.HashMap;

public class GetSum {
    static boolean getSum(int arr[],int targetSum)
    {
        if(targetSum == 0) return true;
        if(targetSum<0) return false;
        for(int a:arr)
        {
            int remender=targetSum-a;
            if(getSum(arr, remender)){
                return true;
            }
        }
        return false;
    }
    static boolean getSum2(int arr[],int targetSum,HashMap<Integer,Boolean>map)
    {
        if(targetSum == 0) return true;
        if(targetSum<0) return false;
        if(map.containsKey(targetSum))
        {
            return map.get(targetSum);
        }
        for(int a:arr)
        {
            int remender=targetSum-a;
            if(getSum2(arr, remender,map)){
                map.put(targetSum, true);
                return true;
            }
        }
        map.put(targetSum, false);
        return false;
    }
    public static void main(String[] args) {
        int arr[]={2,4};
        int target=9990;
        // System.out.println(getSum(arr, target));
        System.out.println(getSum2(arr, target, new HashMap<Integer,Boolean>()));
    }
}
