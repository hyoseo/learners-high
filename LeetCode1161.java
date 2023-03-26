import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1161 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static int maxLevelSum(TreeNode root) {
        // I will use BFS for finding the level
        // Every time I will visit each level, I sum all of the values at the level
        // after that, I compare the previous max sum in the stored level
        // If It is bigger, change it

        // The Time and Space Complexity is O(n)

        int maxLevel = 1;
        int maxLevelSum = root.val;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int curLevel = 1;
        while (!queue.isEmpty()) {
            int curSum = 0;
            int curLength = queue.size();

            for (int i = 0; i < curLength; ++i) {
                TreeNode node = queue.remove();
                curSum += node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (curSum > maxLevelSum) {
                maxLevel = curLevel;
                maxLevelSum = curSum;
            }
            ++curLevel;
        }

        return maxLevel;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(2, new TreeNode(3), null));

        System.out.println(maxLevelSum(root));
    }
}


