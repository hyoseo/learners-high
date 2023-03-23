import java.util.ArrayList;
import java.util.List;

public class LeetCode101 {
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

    private static void traverseLeftFirst(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(null);
            return;
        }
        list.add(root.val);
        traverseLeftFirst(root.left, list);
        traverseLeftFirst(root.right, list);
    }

    private static void traverseRightFirst(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(null);
            return;
        }
        list.add(root.val);
        traverseRightFirst(root.right, list);
        traverseRightFirst(root.left, list);        
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1, new TreeNode(2), new TreeNode(2));
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        traverseLeftFirst(a.left, leftList);
        traverseRightFirst(a.right, rightList);

        System.out.println(leftList.equals(rightList));
    }
}


