import java.util.ArrayList;

public class Permutation {
    static void permutation(String p, String up){
        if(up.isEmpty ())
        {
            System.out.println(p);
            return;
        }
        for(int i=0;i<up.length();i++){
            char c = up.charAt(i);
            String newStr=up.substring(0,i)+up.substring(i+1);
            permutation(p+c, newStr);
        }
    }   
    static ArrayList<String> permutationRet(String p, String up){
        ArrayList<String> ret = new ArrayList<String>();
        if(up.isEmpty ())
        {
            ret.add(p);
            return ret;
        }
        for(int i=0;i<up.length();i++){
            char c = up.charAt(i);
            String newStr=up.substring(0,i)+up.substring(i+1);
           ret.addAll(permutationRet(p+c, newStr)) ;
        }
        return ret;
    }   

    public static void main(String[] args) {
        permutation("","ABC");
        System.out.println(permutationRet("", "ABC"));
    }
    
}
  