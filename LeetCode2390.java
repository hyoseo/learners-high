import java.util.Stack;

public class LeetCode2390 {
    private static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '*') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (Character c : stack) {
            builder.append(c);
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
    }
}


