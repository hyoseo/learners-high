public class LeetCode997 {

    private static int findJudge(int n, int[][] trust) {
        // I should find the node whose indegree is n-1 and outdegree is 0
        // The Time Complexity is O(trust.length) and Space Complexity is O(n)

        int[] indegrees = new int[n + 1];
        int[] outdegrees = new int[n + 1];

        for (int[] r : trust) {
            ++outdegrees[r[0]];
            ++indegrees[r[1]];
        }

        for (int i = 1; i <= n; ++i) {
            if (outdegrees[i] == 0 && indegrees[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findJudge(3, new int[][]{new int[]{1, 3}, new int[]{2, 3}}));
    }
}


