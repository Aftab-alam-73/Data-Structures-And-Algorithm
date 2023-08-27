import java.util.ArrayList;

public class CustomStack{
    private int[] stack;
    private int default_size = 10;
    private int top=-1;
    CustomStack(){
        stack = new int[default_size];
    }
    CustomStack(int size){
        stack = new int[size];
    }
    public int push(int value)
    {
          if(isFull()){
            System.out.println("Stack is full");
            return -1;
          }  
          top++;
          stack[top] = value;
          return value;
    }
    public int pop(){
        if(isEmpty())
        {
            System.out.println("Stack is empty");
            return -1;
        }
        int num=stack[top];
        top--;
        return num;
    }
    public int peek()
    {
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }
    public boolean isFull()
    {
         return top==stack.length-1;
    }
    public boolean isEmpty()
    {
        return top == -1;
    }
    public int size(){
        return top+1;
    }
    public ArrayList<Integer> Display()
    {
        ArrayList<Integer> ans=new ArrayList<>();
        if(isEmpty())
        {
            return ans;
        }
        for(int i=0;i<=top;i++)
        {
            ans.add(stack[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        System.out.println(stack.size());
        System.out.println(stack.Display());
        System.out.println(stack.isEmpty());
    }
}