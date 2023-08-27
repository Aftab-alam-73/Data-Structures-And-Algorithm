public class SkipWord {
    static String skipWord(String p, String up, String word)
    {
        if(up.isEmpty())
        {
            return p;
        }

        if(up.startsWith(word)){
           return skipWord(p, up.substring(word.length()), word);
        }
        return skipWord(p+up.charAt(0), up.substring(1), word);
    }
    public static void main(String[] args) {
        String str="AftabHow are Aftab you Aftab";
        System.out.println(skipWord("", str, "Aftab"));
    }
}
