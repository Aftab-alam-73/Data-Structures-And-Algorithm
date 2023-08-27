public class Skipchar {
    static String skipchar(String p,String up)
    {
        if (up.isEmpty())
        {
            return p;
        }
        char ch=up.charAt(0);
        if(ch == 'a')
        {
           return skipchar(p, up.substring(1));
        }
        return skipchar(p+ch, up.substring(1));
    }
    public static void main(String[] args) {
        String str="aftab";
        System.out.println(skipchar("", str));
    }
}
