import java.util.LinkedList;
import java.util.Collections;
public class BuiltInLinkedlist {
    
    public static void main(String[] args) {
        LinkedList<Integer>list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("contians" + list.contains(2));
        System.out.println(list);
        list.addFirst(5);
        list.addLast(10);
        System.out.println(list);
        list.set(0, 11);
        System.out.println(list);

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
        Collections.sort(list);
        System.out.println(list);
    }
}
