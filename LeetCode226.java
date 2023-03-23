public class LeetCode226 {
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

    private static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        invertTree(root.left);
        invertTree(root.right);

        TreeNode save = root.left;
        root.left = root.right;
        root.right = save;

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        invertTree(root);
    }
}


