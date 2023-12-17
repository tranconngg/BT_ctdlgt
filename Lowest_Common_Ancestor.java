package BTtuan10;

import BTtuan9.TreeNode;

public class Lowest_Common_Ancestor {
    public static TreeNode lca(TreeNode root, int v1, int v2) {
        // Write your code here.
        if (root == null) {
            return null;
        }

        if (root.val == v1 || root.val == v2) {
            return root;
        }

        TreeNode leftLCA = lca(root.left, v1, v2);
        TreeNode rightLCA = lca(root.right, v1, v2);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        if (leftLCA != null) {
            return leftLCA;
        }

        return rightLCA;
    }
}
