package BTtuan10;

import BTtuan9.TreeNode;

public class Insertion_bts {
    public TreeNode insertIntoBST(TreeNode rootNode, int val){
        if(rootNode == null){
            TreeNode newNode = new TreeNode(val);
            return newNode;
        }
        else {
            if(val < rootNode.val){
                if(rootNode.left==null){
                    rootNode.left= new TreeNode(val);
                }
                else {
                    insertIntoBST(rootNode.left, val);
                }
            }
            else {
                if(rootNode.right==null){
                    rootNode.right= new TreeNode(val);
                }
                else {
                    insertIntoBST(rootNode.right, val);
                }
            }
        }
        return rootNode;
    }
}
