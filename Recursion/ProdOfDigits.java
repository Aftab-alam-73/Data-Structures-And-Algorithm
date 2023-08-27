public class ProdOfDigits {
    public static void main(String[] args) {
        System.out.println(prodOfDigits(1235));
    }
    static int prodOfDigits(int n)
    {
        if(n==0)
        {
            return 1;
        }
        return (n%10)*prodOfDigits(n/10);
    }
}
