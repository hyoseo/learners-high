import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode1376 {

    private static int dfs(int parent, Map<Integer, List<Integer>> tree, int[] informTime) {
        int maxChildRet = 0;
        if (tree.containsKey(parent)) {
            for (Integer child : tree.get(parent)) {
                maxChildRet = Math.max(maxChildRet, dfs(child, tree, informTime));
            }
        }
        
        return informTime[parent] + maxChildRet;
    }

    public static void main(String[] args) {
        // First thing I should do is to make tree structure using hashMap
        // the key is parent and the child is List composed of it's childs.
        // After that, I use dfs
        // the dfs function is to add informTime of the parent to ret and call with it's childs and pick the max child return value and add it to ret and return the ret
        // The Time Complexity is O(N), The Space Complexity is O(N)

        int n = 6, headID = 2;
        int[] manager = {2,2,-1,2,2,2};
        int[] informTime = {0,0,1,0,0,0};

        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < manager.length; ++i) {
            if (manager[i] != -1) {
                tree.putIfAbsent(manager[i], new ArrayList<>());
                tree.get(manager[i]).add(i);
            }
        }

        System.out.println(dfs(headID, tree, informTime));
    }
}


