import java.util.ArrayList;

public class PhonePad{
    static void pad(String p,String up)
    {
         if(up.isBlank())
         {
            System.out.println(p);
            return;
         }
         int digit=up.charAt(0)-'0'; 
         for(int i=(digit-1)*3;i<digit*3;i++)
         {
             char c=(char) ('a'+i);
             pad(p+c, up.substring(1));
             
         }
    }
    static  ArrayList<String> padRet(String p,String up)
    {
        ArrayList<String> list = new ArrayList<>();
         if(up.isBlank())
         {
            list.add(p);
            return list;
         }
         int digit=up.charAt(0)-'0'; 
         for(int i=(digit-1)*3;i<digit*3;i++)
         {
             char c=(char) ('a'+i);
            list.addAll(padRet(p+c, up.substring(1))) ;
             
         }
         return list;
    }
    public static void main(String[] args) {
        pad("", "12");
        System.out.println(padRet("", "123").size());
    }
}