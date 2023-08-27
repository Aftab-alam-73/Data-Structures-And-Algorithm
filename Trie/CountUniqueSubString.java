public class CountUniqueSubString {
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

    static int countNode(Node root){
        if(root==null)
        {
            return 0;
        }
        int count=0;
        for(int i=0;i<26;i++)
        {
            if(root.children[i]!=null)
            {
                count+=countNode( root.children[i]);
               
                
            }
        }
        return count+1;
    }

    public static void main(String[] args) {
        String str="apple";
        for(int i=0;i<str.length();i++)
        {
            insert(str.substring(i));
        }
        
        System.out.println(countNode(head));
    }
}
