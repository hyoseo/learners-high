import java.util.ArrayList;
import java.util.List;

public class LeetCode872 {
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

    private static void postOrderTraversal(TreeNode root, List<Integer> leafList) {
        if (root == null) {
            return;
        }

        postOrderTraversal(root.left, leafList);
        postOrderTraversal(root.right, leafList);
        if (root.left == null && root.right == null) {
            leafList.add(root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode b = new TreeNode(1, new TreeNode(3), new TreeNode(2));

        List<Integer> root1LeafList = new ArrayList<>();
        List<Integer> root2LeafList = new ArrayList<>();

        postOrderTraversal(a, root1LeafList);
        postOrderTraversal(b, root2LeafList);

        System.out.println(root1LeafList.equals(root2LeafList));
    }
}


