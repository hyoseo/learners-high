import java.util.Stack;

public class LeetCode1475 {
    private static int[] finalPrices(int[] prices) {
        // I will use monotonic increasing stack
        // when I find lower price than top of the stack, I will pop every until higher price in the stack and I write output as the value - new value
        // when I find higher price than top of the stack, I just push the price

        // The Time Complexity is O(n) and the Space Complexity is O(n)
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; ++i) {
            while (!stack.empty() && prices[i] <= prices[stack.peek()]) {
                int saved = stack.pop();
                prices[saved] = prices[saved] - prices[i];
            }

            stack.push(i);
        }

        return prices;
    }

    public static void main(String[] args) {
        System.out.println(finalPrices(new int[] {8, 4, 6, 2, 3}));
    }
}


