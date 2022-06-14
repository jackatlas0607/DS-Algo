public class _34Recursion {
    public static void main(String[] args) {

        System.out.println(rs(2));
    }

    public static int rs(int n) {

        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 10;
        } else {
            return rs(n - 1) + 15;
        }

    }
}
