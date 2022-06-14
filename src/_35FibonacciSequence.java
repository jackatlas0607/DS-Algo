public class _35FibonacciSequence {
    public static void main(String[] args) {

        for (int i = 0; i <= 8; i++) {
            System.out.print(fs(i)+"\t");
        }
        
    }

    public static int fs(int n) {
        //F(0)= 0  , F(1)=1 , F(n) = F(n - 1) + F(n - 2)
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fs(n - 1) + fs(n - 2);
        }
    }
}
