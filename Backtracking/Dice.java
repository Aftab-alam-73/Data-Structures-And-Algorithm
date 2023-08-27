import java.util.ArrayList;

public class Dice {
    static void dice(int target,String p)
    {
        if(target==0) {
            System.out.println(p);
            return;
        }
       for(int i=1;i<=6 && i<=target;i++)
       {
          dice(target-i,p+i);
       }
    }
    static ArrayList<String> diceRet(int target,String p)
    {       
        ArrayList<String> list = new ArrayList<>();
        if(target==0) {
            list.add(p);
            return list;    
        }
       for(int i=1;i<=6 && i<=target;i++)
       {
          list.addAll(diceRet(target-i,p+i));
       }
       return list;
    }
    public static void main(String[] args) {
        dice(4, "");
        System.out.println(diceRet(4, ""));
    }
}
