public class Trie{
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

   static void  insert(String word)// O(l) where l is the length of the string.
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

    static boolean search(String word)// O(l) where l is the length of the string.
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

    public static void main(String[] args) {
        String []words={"the","a","there","their","any"};

        for(String word : words)
        {
            insert(word);
        }
        System.out.println(search("the"));
        System.out.println(search("there"));
        System.out.println(search("theree"));
        System.out.println(search("any"));
    }
}