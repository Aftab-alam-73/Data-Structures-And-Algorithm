import java.util.Stack;

public class ReverseWord {
    static String reverseWords(String S) {
        String ans = "";
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '.') {
                while (!stack.isEmpty()) {
                    ans += stack.pop();
                }
                ans += '.';

            } else {

                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            ans += stack.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        String S = "i.like.this.program.very.much";
        System.out.println(reverseWords(S));
    }

}
