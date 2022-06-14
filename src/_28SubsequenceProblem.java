public class _28SubsequenceProblem {
    public static void main(String[] args) {
        System.out.println(isSubsequence("hello", "hello Dear"));
        System.out.println(isSubsequence("book", "brooklyn"));
        System.out.println(isSubsequence("abc", "bac"));
        System.out.println(isSubsequence("", "abc"));
    }

    public static boolean isSubsequence(String str1, String str2) {
        if (str1.length() == 0) {
            return true;
        }

        int pointer1 = 0;
        int pointer2 = 0;

        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();

        while (pointer2 < char2.length) {
            if (char1[pointer1] == char2[pointer2]) {
                pointer1++;
            }

            if (pointer1 >= char1.length) {
                return true;
            }

            pointer2++;
        }


        return false;
    }
}
