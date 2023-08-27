public class LongestPrefix {
    static class Node {
        Node[]children;
        boolean eow; // end of word
        Node()
        {
            children=new Node[26];
            for(int i=0;i<26;i++)
            {
                children[i]=null;
            }
            eow=false;
        }

    }
    private static Node head=new Node();

   static void  insert(String word)
    {
        Node temp=head;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            int ind=c-'a';
            if(temp.children[ind]==null){
                temp.children[ind]=new Node();

            }
            if(i==word.length()-1)
            {
                temp.children[ind].eow=true;
            }
            temp=temp.children[ind];
           
        }
    }

    static boolean search(String word)
    {
        Node temp=head;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            int ind=c-'a';
            if(temp.children[ind]!=null)
            {
                temp=temp.children[ind];
                if(i==word.length()-1 && temp.eow==true)
                {
                     return true;
                }
            }else{
                return false;
            }
        }
        return false;
    }
    static String ans="";
    static void longestPrefix(Node root, String prefix)
    {
        if(ans.length()<prefix.length())
        {
            ans = prefix;
        }
         for(int i=0;i<26;i++){
            if(root.children[i]!=null && root.children[i].eow){
                char c= (char) (i+'a');
                longestPrefix(root.children[i], prefix+c);
            }
         }
    }
    public static void main(String[] args) {
        String[]words={"a", "banana", "app", "appl", "ap", "apply","apple"};
        for(String word : words) {
            insert(word);
        }
        longestPrefix(head, "");
        System.out.println(ans);
    }
}
