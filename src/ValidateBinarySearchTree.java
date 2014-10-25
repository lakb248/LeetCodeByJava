package solution;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by lakb2_000 on 2014/8/27.
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>() ;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if(root == null){
            return true ;
        }

        TreeNode node = root ;
        TreeNode right = null ;
        while(node != null || stack.size() != 0){
            while(node != null){
                stack.push(node) ;
                node = node.left ;
            }

            node = stack.pop() ;
            list.add(node.val) ;
            node = node.right ;
        }
        int length = list.size() ;
        for(int i = 1 ; i < length ; i ++){
            if(list.get(i) <= list.get(i - 1))
                return false ;
        }
        return true ;
    }

}
