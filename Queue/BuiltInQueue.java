import java.util.LinkedList;
import java.util.Queue;

public class BuiltInQueue{
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue);
        System.out.println("Size of the queue: " + queue.size());
        // queue.clear();
        queue.poll();
        queue.remove();
        queue.offer(5);
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());
    }
}