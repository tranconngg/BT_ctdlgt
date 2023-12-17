package BTtuan10;

import BTtuan9.TreeNode;

public class Height_of_a_BinaryTree {
    public static int height(TreeNode root) {
        if(root == null) return -1;

        int chieucaoLeft=height(root.left);
        int chieucaoRight=height(root.right);

        int result = Math.max(chieucaoLeft,chieucaoRight)+1;
        return result ;
    }
}
