import java.util.ArrayList;
class Stack{
    static class Node{
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
        }
    }
 private  Node head;
 private  Node tail;
 private  int size=0;

  public int push(int data)
  {
      Node newNode = new Node(data);
      if(isEmpty()){
         head=tail=newNode;
         size++;
         return data;
      }
      tail.next=newNode;
      tail=tail.next;
      size++;
      return data;
  }
  public int pop(){
     if(isEmpty()){
        System.out.println("Stack is empty!");
        return -1;
     }
     int num=tail.data;
     if(head.next==null){
        head=tail=null;
        size--;
        return num;
     }
     Node temp=head;
     while(temp.next!=null)
     {
         if(temp.next.next==null){
            break;
         }
         temp=temp.next;
     }
     temp.next=null;
     tail=temp;
     size--;
     return num;
  }
  public int peek()
  {
     if(isEmpty()){
        System.out.println("Stack is empty!");
        return -1;
     }
     return tail.data;
  }
  public ArrayList<Integer> Display()
  {
    ArrayList<Integer>ans=new ArrayList<>();
    if(isEmpty()){
        return ans;
    }
    Node temp=head;
    while(temp!=null)
    {
        ans.add(temp.data);
        temp=temp.next;
    }
    return ans;
  }
  public boolean isEmpty(){
    return head==null;
  }
  public int size(){
    return size;
  }
}
public class ListImplement{


  public static void main(String[] args) {
      Stack stack=new Stack();
      stack.push(1);
      stack.push(2);
      stack.push(3);
      stack.push(4);
      stack.push(5);
      stack.pop();
      stack.pop();
      stack.pop();
      stack.pop();
      stack.pop();
      stack.push(10);
      System.out.println(stack.Display());
      System.out.println(stack.peek());
      System.out.println(stack.size());
  }
}