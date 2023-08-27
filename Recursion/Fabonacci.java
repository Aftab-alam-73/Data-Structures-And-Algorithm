public class Fabonacci {
    public static void main(String[] args) {
        System.out.println(fabonacci(4));
    }
    static int fabonacci(int n)
    {
        if(n<2)
        {
            return n;
        }
        return fabonacci(n-1)+fabonacci(n-2);
    }
}
