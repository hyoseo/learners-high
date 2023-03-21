import java.util.Stack;

public class LeetCode1673 {
    private static int[] mostCompetitive(int[] nums, int k) {
        // I will use monotonic increasing stack
        // I push the num If the stack is empty or the top of the stack is lower
        // I also pop until the top of the stack is lower than the num
        // If the num is higher than the top of the stack and the stack's size is k, I don't push the num
        // The Time Complexity is O(n) and The Space Complexity is O(n)

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[k];
        for (int i = 0; i < nums.length; ++i) {
            int leftoverCount = nums.length - i - 1;
            while (!stack.empty() && stack.peek() > nums[i] && (stack.size() + leftoverCount >= k)) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }

        for (int i = k - 1; i >= 0; --i) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(mostCompetitive(new int[] {3, 5, 2, 6}, 2));
    }
}


