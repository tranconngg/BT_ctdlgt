package BTtuan10;

import BTtuan9.TreeNode;

public class Check_BST {
    boolean checkBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isBST(TreeNode node, int minVal, int maxVal) {
        if (node == null) {
            return true;
        }

        if (node.val < minVal || node.val > maxVal) {
            return false;
        }

        return isBST(node.left, minVal, node.val - 1) && isBST(node.right, node.val + 1, maxVal);
    }
}
