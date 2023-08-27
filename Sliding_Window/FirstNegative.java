import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegative {
    // Time Complexity:O(n)
    static int[] printFirstNegativeInteger(int A[], int n, int k)
    {
        Queue<Integer>q = new LinkedList<>();
        int ansLength = n-k + 1;
        int ans[]=new int[ansLength];
        int i=0;
        int j=0;
        int idx=0;
        while(j<n){
           if(A[j]<0) q.add(A[j]);
            if(j-i+1<k)j++;
            else if(j-i+1==k){
                if(q.isEmpty()){
                    ans[idx]=0;
                }
                else{
                    ans[idx]=q.peek();
                    if(A[i]==q.peek()){
                        q.poll();
                    }
                }
                 i++;
                 j++;
                 idx++;
            }
        }
        return ans;
    }
    
    
// Time Complexity:O(nk)
    static ArrayList<Integer> getFirtNegative(int[] arr, int k) {
        int first = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = k - 1; i < arr.length; i++) {
            int ans = findNegative(arr, first, i);
            result.add(ans);
            first++;

        }
        return result;
    }

    static int findNegative(int[] arr, int first, int last) {
        for (int i = first; i <= last; i++) {
            if (arr[i] < 0)
                return arr[i];

        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 2;
        System.out.println(getFirtNegative(arr, k));
        System.out.println(Arrays.toString(printFirstNegativeInteger(arr,arr.length, k)));
       
    }
}