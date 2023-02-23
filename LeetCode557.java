public class LeetCode557 {
    public static void main(String[] args) {
        // Arrays and Strings
        // 557. Reverse Words in a String III (https://leetcode.com/problems/reverse-words-in-a-string-iii/)

        /*
         * 
         * Constraints:
            1 <= s.length <= 5 * 104
            s contains printable ASCII characters.
            s does not contain any leading or trailing spaces.
            There is at least one word in s.
            All the words in s are separated by a single space.
         */

         solution2();
    }

    public static void solution2() {
        String s = "Let's take LeetCode contest";
        String output = "s'teL ekat edoCteeL tsetnoc";

        // I can improve the space complexity O(n) to constant time by using two pointer strategy.
        // I make two pointer and one pointer moves until meeting white space.
        // When it meet, it saves the next position 
        // and move backward with adding the character to StringBuffer until it meet another pointer.
        // Sorry I need to save the result so the space complexity is O(n)

        int left = 0;
        int right = 0;
        int nextRight = 0;

        StringBuffer result = new StringBuffer();
        while (right < s.length()) {
            if (s.charAt(right) == ' ') {
                nextRight = right;
                --right;
                while (left <= right) {
                    result.append(s.charAt(right));
                    --right;
                }
                result.append(" ");
                left = nextRight + 1;
                right = nextRight;
            }

            ++right;
        }

        --right;
        while (left <= right) {
            result.append(s.charAt(right));
            --right;
        }

        if (output.equals(result.toString())) {
            System.out.println("Succeeded");
        }
    }

    public static void solution1() {
        String s = "Let's take LeetCode contest";
        String output = "s'teL ekat edoCteeL tsetnoc";

        // I think the simple solution is to split the input 's' with whitespace 
        // and reverse those substring and rejoin with whitespace.
        // It can be time complexity O(n) and space complexity O(n)
        // This solution is enough?

        StringBuffer result = new StringBuffer();
        for (String subString : s.split(" ")) {
            result.append(new StringBuffer(subString).reverse().append(" "));
        }

        result.deleteCharAt(result.length() - 1);

        if (output.equals(result.toString())) {
            System.out.println("Succeeded");
        }
    }
}