public class WordBreak {
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
    static boolean wordBreak(String key)
    {
        if(key=="")
        {
            return true;
        }
        for(int i=1; i<=key.length(); i++){
            String firstPart=key.substring(0,i);
            String secondPart=key.substring(i);
           
            if(search(firstPart) && wordBreak(secondPart)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String[] words={"ilike","sam","samsung","mobile"};
        String key="ilikesamsung";
        for(String word : words)
        {
            insert(word);
        }
        for(String word : words)
        {
            // System.out.println(search(word));
        }
        System.out.println(wordBreak(key));
    }
    
}
