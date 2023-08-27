import java.util.ArrayList;

class Queue{
   private int[]queue;
   private static  int Deafault_size=10;
   private int end=-1;
   private int size=0;
   Queue()
   {
     this(Deafault_size);
   }
   Queue(int size)
   {
    Deafault_size=size;
    queue=new int[Deafault_size];
   }
   public boolean add(int value){
      if(isFull())
      {
        System.out.println("Queue is full");
        return false;
      }
      queue[++end] = value;
       size++;
      return true;
   }
   public int remove()
   {
      if(isEmpty())
      {
        System.out.println("Queue is empty");
        return -1;
      }
      int num=queue[0];
      for(int i=0; i<queue.length-1; i++){
         queue[i] = queue[i+1];
      }
      end--;
      size--;
      return num;
   }
   public ArrayList<Integer> Display()
   {
      ArrayList<Integer> num = new ArrayList<Integer>();
      if(isEmpty())
      {
        return num;
      }
      for(int i=0;i<=end;i++){
        num.add(queue[i]);
      }
      return num;
   }
   public void clear(){
      queue=new int[Deafault_size];
      size=0;
      end=-1;
   }
   public boolean isFull()
   {
       return end==queue.length-1;
   }
   public boolean isEmpty(){
    return end == -1;
   }
   public int size(){
    return size;
   }
}
public class CustomQueue {
    public static void main(String[] args) {
        Queue q=new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println("Size is " + q.size());

        System.out.println(q.Display());
        // q.remove();
        // q.remove();
        q.clear();
        System.out.println("Size is " + q.size());
        // q.remove();
        // q.remove();
        // q.remove();
        // q.remove();
        System.out.println(q.Display());
    }
    
}
