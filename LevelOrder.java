package BTtuan9;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    public static void levelOrder(TreeNode root) {
        if(root == null ) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            System.out.print(cur.val +" ");

            if (cur.left != null) {
                q.add(cur.left);
            }


            if (cur.right != null) {
                q.add(cur.right);
            }
        }

    }
}
