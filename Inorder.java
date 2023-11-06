package BTtuan9;

public class Inorder {
    public static void preOrder(TreeNode root) {
        if( root == null) return;

        preOrder(root.left);
        System.out.print(root.val + " ");
        preOrder(root.right);

    }
}
