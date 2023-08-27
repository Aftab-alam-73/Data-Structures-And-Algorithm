import java.util.Stack;
public class CloneStack{
   static void clonestack(Stack<Integer> st, Stack<Integer> cloned) {
        if(st.isEmpty()){
            return;
        }
        int num=st.pop();
        clonestack(st,cloned);
        cloned.push(num);
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<Integer>();
        Stack<Integer> cloned = new Stack<Integer>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st);
        System.out.println(cloned);
        clonestack(st, cloned);
        System.out.println(cloned);


    }
}