import java.util.Arrays;
import java.util.Stack;
public class NextGreater {
    public static long[] nextLargerElement(long[] arr, int n)
    { 
       Stack<Integer> stack = new Stack<Integer>();
       long[]result = new long[n];
    
       for(int i = 0; i < n; i++){
         if(stack.isEmpty())
         {
            stack.push(i);
            continue;
         }
          if(arr[i]<arr[stack.peek()] ){
            stack.push(i);
          }
          else{
              while(!stack.isEmpty() && arr[stack.peek()]<arr[i]  ){
                  int index = stack.pop();
                  result[index] = arr[i];
                }
                stack.push(i);      
            }
        }
       while(!stack.isEmpty()){
          int ind=stack.pop();
          result[ind] = -1;
       }
       return result;
    } 
   
    public static void main(String[] args) {
        long[] arr = {6, 8, 0, 1, 3};
        System.out.println(Arrays.toString(nextLargerElement(arr, arr.length)));
    }
    
}
