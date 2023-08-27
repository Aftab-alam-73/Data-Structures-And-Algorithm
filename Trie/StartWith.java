public class StartWith {
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
   static boolean startWith(String prefix)
   {
        Node temp=head;
        for(int i=0;i<prefix.length();i++)
        {
            int ind=prefix.charAt(i)-'a';
            if(temp.children[ind]==null)
            {
                return false;
            }
            temp=temp.children[ind];
        }
        return true;
   }

   public static void main(String[] args) {
     String []words={"apple","app","mango","man","women"};
     for(String word : words)
     {
        insert(word);
     }
     String prefix="moon";
     System.out.println(startWith(prefix));
   }
}
