import java.util.HashMap;

public class Fabonacci {
    // Without using dynamic programming
    static int fabnocai(int n) {
        if (n <= 2) {
            return 1;
        }
        return fabnocai(n - 1) + fabnocai(n - 2);
    }
 // Using dynamic programming
    static int fab(int n, HashMap<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n <= 2) {
            return 1;
        }
        int ans = fab(n - 1, map) + fab(n - 2, map);
        map.put(n, ans);
        return map.get(n);
    }
    // This is non recursive function here i am reducing the space complexity i am not using memoization means array to store the previous values.
    // Time Complexity:O(n)
    // Space Complexity:O(1)
    static long fab3(int n)
    {
        long preprev=0;
        long prev=1;
        long curr=0;
        for(int i=2;i<=n;i++){
            curr=prev+preprev;
            preprev=prev;
            prev=curr;
        }
        return prev;
    }
   

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = 50;
        // System.out.println("first one: " + fabnocai(n));
        // System.out.println("second one: " + fab(n, map));
        // System.out.println(fab3(8));
        // System.out.println(map);
       
    }
}