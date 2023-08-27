// This queue is implemented by the max heap.
class PriorityQueue {
    private int[] queue;
    private int size;
    private int index = -1;

    PriorityQueue() {
        queue = new int[5];
        size = 0;
    }

    public void add(int value) {
        if (isFull()) {
            int[] newQueue = new int[queue.length * 2];
            for (int i = 0; i < queue.length; i++) {
                newQueue[i] = queue[i];
            }
            queue = newQueue;
        }
        index++;
        queue[index] = value;
        size++;
        int i = index;
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (queue[parent] < queue[i]) {
                swap(queue, parent, i);
                i = parent;
            } else {
                break;
            }
        }

    }

    public int remove() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int num = queue[0];
        swap(queue, 0, index);
        size--;
        index--;
        int i = 0;
        while (2 * i + 1 <= index) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = left;
            if (right <= index && queue[right] >= queue[largest]) {
                largest = right;
            }
            if (queue[largest] > queue[i]) {
                swap(queue, largest, i);
                i = largest;
            } else {
                break;
            }
        }
        return num;
    }

    public void display() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(queue[i] + " ");
        }
    }

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull()
    {
        return index==queue.length-1;
    }
    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}

public class CustomPriorityQueue {
    public static void main(String[] args) {

        PriorityQueue pq = new PriorityQueue();
        pq.add(50);
        pq.add(55);
        pq.add(53);
        pq.add(52);
        pq.add(54);
        pq.add(59);
        pq.add(64);
        pq.display();
        System.out.println();
        // System.out.println(pq.size());
        // pq.remove();
        // pq.remove();
        // pq.remove();
        // pq.remove();
        // pq.remove();
        // pq.display();
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            int a = pq.remove();
            System.out.print(a + " ");
        }
    }
}
