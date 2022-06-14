public class _27Palindrome {
    public static void main(String[] args) {

        System.out.println(palindrome("tacocat"));  //true
        System.out.println(palindrome("amanaplanacanalpanama"));  //true
        System.out.println(palindrome("asdfsafeaw"));  //false
    }

    public static boolean palindrome(String a) {

        char[] chars = a.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (right >= left) {
            if (chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }
}
