package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lakb2_000 on 2014/8/26.
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>() ;
        Stack<TreeNode> stack = new Stack<TreeNode>() ;
        if(root == null)
            return list ;
        TreeNode node = root ;
        stack.push(node) ;
        while(stack.size() != 0){
            node = stack.pop() ;
            list.add(node.val) ;
            if(node.right != null)
                stack.push(node.right) ;
            if(node.left != null) {
                stack.push(node.left) ;
            }
        }
        return list ;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
