import java.util.Collections;
import java.util.PriorityQueue;
public class PriorityQ {
    public static void main(String[] args) {
        // By default it implements min heap if you want reverse it pass "Collections.reverseOrder()" in the constructor.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);
        pq.add(0);
        pq.remove();
        pq.poll();
        System.out.println(pq);
        for(int a: pq) {
            System.out.println(a);
        }
    }
}
