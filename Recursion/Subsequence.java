import java.util.ArrayList;

public class Subsequence {
    static void subsequence(String p,String up)
    {
        if(up.isEmpty())
        {
            System.out.println(p);
            return; 
        }
        subsequence(p+up.charAt(0), up.substring(1));
        subsequence(p, up.substring(1));
    }
    static ArrayList<String> subsequenceRet(String p,String up){
           ArrayList<String> list = new ArrayList<String>();
           if(up.isBlank())
           {
             list.add(p);
             return list;
           }
           list.addAll(subsequenceRet(p+up.charAt(0), up.substring(1)));
           list.addAll(subsequenceRet(p, up.substring(1)));
           return list;
    }

    public static void main(String[] args) {
        subsequence("", "abc");
        System.out.println(subsequenceRet(" ","abc"));
    }
    
}
