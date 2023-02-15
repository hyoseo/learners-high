public class LeetCode2270 {
    public static void main(String[] args) {
        // Arrays and Strings > Prefix
        // 2270. Number of Ways to Split Array
        int[] inputs = new int[] { 10, 4, -8, 7 };
        int[] prefixSum = new int[inputs.length];

        prefixSum[0] = inputs[0];
        for (int i = 1; i < inputs.length; ++i) {
            prefixSum[i] = prefixSum[i - 1] + inputs[i];
        }

        int ways = 0;
        for (int i = 0; i < inputs.length - 1; ++i) {
            if (prefixSum[i] >= prefixSum[inputs.length - 1] - prefixSum[i]) {
                ++ways;
            }
        }

        System.out.println(ways);
    }
}