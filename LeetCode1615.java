import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode1615 {

    private static int maximalNetworkRank(int n, int[][] roads) {
        // Time Complexity is O(N^2), Space Complexity is O(N+E)

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            graph.put(i, new HashSet<>());
        }

        for (int[] road: roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        int maxNetRank = 0;
        for (int i = 0; i < n; ++i) {
            Set<Integer> set = graph.get(i);
            for (int j = i + 1; j < n; ++j) {
                maxNetRank = Math.max(maxNetRank, set.size() + graph.get(j).size() - (set.contains(j) ? 1 : 0));
            }
        }

        return maxNetRank;
    }

    public static void main(String[] args) {
        // [[0,1],[0,3],[1,2],[1,3]]
        System.out.println(maximalNetworkRank(4, new int[][]{new int[]{0, 1}, new int[]{0, 3}, new int[]{1, 2}, new int[] {1, 3}}));
    }
}


