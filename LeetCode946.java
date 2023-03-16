import java.util.Stack;

public class LeetCode946 {
    private static boolean validateStackSequences(int[] pushed, int[] popped) {
        // I make the stack and I have to push in the number in pushed until the number is equal to the number in popped.
        // So I have two case
        // If stack.peek() == popped[j], I pop from the stack
        // If not, stack.push(pushed[i++])
        // If i reaches end of pushed return false
        // If j reaches end of popped return true
        // Time and Space complexity is O(n)

        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;

        while (j < popped.length) {
            if (!stack.empty() && stack.peek() == popped[j]) {
                stack.pop();
                ++j;
            } else {
                if (i >= pushed.length) {
                    return false;
                }
                stack.push(pushed[i++]);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[] {1,2,3,4,5}, new int[] {4,5,3,2,1}));
    }
}


