import java.util.PriorityQueue;
import java.util.Stack;
public class SortStack{
    static Stack<Integer> sort(Stack<Integer>s)
    {
       PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
       while(!s.isEmpty())
       {
           queue.add(s.pop());
       }
    //    System.out.println("PriorityQueue:"+queue);
       while(!queue.isEmpty()){
        s.push(queue.poll());
       }
       return s;
    }
    // using recursion.
    static Stack<Integer> Sort(Stack<Integer>s){
        remove(s);
        return s;
    }
    static void remove(Stack<Integer>s){
        if(s.isEmpty()) return;
         int top=s.pop();
         remove(s);
         insert(s,top);
    }
    static void insert(Stack<Integer>s,int element)
    {
         if(s.isEmpty() || s.peek()<=element) 
         {
            s.push(element);
            return;
         }
         int top=s.pop();
         insert(s, element);
         s.push(top);
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(41);
        s.push(3);
        s.push(32);
        s.push(2);
        s.push(11);
        for(int a:s)
        {
            System.out.println(a);
        }
        // System.out.println(s);
        // // System.out.println(sort(s));
        // System.out.println(Sort(s));
    }
}