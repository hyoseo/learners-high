import java.util.Stack;

public class LeetCode100 {
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

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> ps = new Stack<>();
        Stack<TreeNode> qs = new Stack<>();

        ps.push(p);
        qs.push(q);        
        while (!ps.empty() && !qs.empty()) {
            p = ps.pop();
            q = qs.pop();
            if (p != null && q == null) {
                return false;
            } else if (p == null && q != null) {
                return false;
            } else if (p != null && q != null) {
                if (p.val != q.val) {
                    return false;
                }

                ps.push(p.left);
                ps.push(p.right);

                qs.push(q.left);
                qs.push(q.right);
            }
        }

        return ps.empty() && qs.empty();
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode b = new TreeNode(1, new TreeNode(3), new TreeNode(2));

        System.out.println(isSameTree(a, b));
    }
}


