import java.util.ArrayList;
import java.util.List;

public class LeetCode1305 {
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

    private static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = inorderTraversal(root1);
        List<Integer> list2 = inorderTraversal(root2);
        List<Integer> result = new ArrayList<>();

        int i = 0, j = 0;
        while(i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                result.add(list1.get(i));
                ++i;
            } else {
                result.add(list2.get(j));
                ++j;
            }
        }

        while (i < list1.size()) {
            result.add(list1.get(i));
            ++i;
        }

        while (j < list2.size()) {
            result.add(list2.get(j));
            ++j;
        }

        return result;
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);
        
        left.add(root.val);
        left.addAll(right);
        
        return left;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5, new TreeNode(2), new TreeNode(8, new TreeNode(6), null));
        TreeNode root2 = new TreeNode(3, new TreeNode(1), new TreeNode(5, new TreeNode(4), null));

        System.out.println(getAllElements(root1, root2));
    }
}


